package graphics.jmeplanet;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.app.Application;
import com.jme3.app.DebugKeysAppState;
import com.jme3.app.SimpleApplication;
import com.jme3.app.StatsAppState;
import com.jme3.asset.TextureKey;
import com.jme3.bullet.BulletAppState;
import com.jme3.bullet.PhysicsSpace;
import com.jme3.bullet.collision.shapes.SphereCollisionShape;
import com.jme3.bullet.control.BetterCharacterControl;
import com.jme3.bullet.control.RigidBodyControl;
import com.jme3.input.KeyInput;
import com.jme3.input.MouseInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.input.controls.MouseButtonTrigger;
import com.jme3.light.DirectionalLight;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;
import com.jme3.renderer.queue.RenderQueue;
import com.jme3.scene.CameraNode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.CameraControl;
import com.jme3.scene.shape.Sphere;
import com.jme3.system.AppSettings;
import com.jme3.texture.Texture;
import com.jme3.util.SkyFactory;
import graphics.jmeplanet.cloud.AbstractPointCloudGraphGenerator;
import graphics.jmeplanet.cloud.RawPointCloudGraphGenerator;
import jme3utilities.MyAsset;
import jme3utilities.sky.CloudLayer;
import jme3utilities.sky.SkyControl;
import jme3utilities.sky.StarsOption;
import jme3utilities.sky.Updater;

import java.util.Random;

public class MyNoNamePlanetBotMasterZzz extends SimpleApplication implements ActionListener {

    private SkyControl skyControl;
    protected Planet planet;
    private BulletAppState bulletAppState;
    private PlanetAppState planetAppState;
    private CameraNode cameraNode;
    private RigidBodyControl cameraNodePhysicsControl;
    private boolean walkMode = true;
    private BetterCharacterControl characterControl;
    private Node characterNode;
    private AnimControl animationControl;
    private AnimChannel animationChannel;
    private Vector3f walkDirection = new Vector3f(0, 0, 0);
    private Vector3f viewDirection = new Vector3f(0, 0, 1);
    private boolean leftStrafe = false, rightStrafe = false, forward = false, backward = false,
            leftRotate = false, rightRotate = false;

    private float linearSpeed = 7000f;
    private float angularSpeed = 50f;


    private AnalogListener analogListener = new AnalogListener() {
        public void onAnalog(String name, float value, float tpf) {

            if (!walkMode) {

                if (name.equals("Move Left"))
                    cameraNodePhysicsControl.applyCentralForce(getCamera().getLeft().mult(linearSpeed));
                if (name.equals("Move Right"))
                    cameraNodePhysicsControl.applyCentralForce(getCamera().getLeft().mult(-linearSpeed));
                if (name.equals("Move Forward"))
                    cameraNodePhysicsControl.applyCentralForce(getCamera().getDirection().mult(linearSpeed));
                if (name.equals("Move Backward"))
                    cameraNodePhysicsControl.applyCentralForce(getCamera().getDirection().mult(-linearSpeed));

                Vector3f xRotation = cameraNodePhysicsControl.getPhysicsRotation().getRotationColumn(0).normalize();
                Vector3f yRotation = cameraNodePhysicsControl.getPhysicsRotation().getRotationColumn(1).normalize();
                Vector3f zRotation = cameraNodePhysicsControl.getPhysicsRotation().getRotationColumn(2).normalize();

                if (name.equals("Rotate Left"))
                    cameraNodePhysicsControl.applyTorque(yRotation.mult(angularSpeed));
                if (name.equals("Rotate Right"))
                    cameraNodePhysicsControl.applyTorque(yRotation.mult(-angularSpeed));
                if (name.equals("Rotate Up"))
                    cameraNodePhysicsControl.applyTorque(xRotation.mult(angularSpeed));
                if (name.equals("Rotate Down"))
                    cameraNodePhysicsControl.applyTorque(xRotation.mult(-angularSpeed));
                if (name.equals("Spin Left"))
                    cameraNodePhysicsControl.applyTorque(zRotation.mult(-angularSpeed));
                if (name.equals("Spin Right"))
                    cameraNodePhysicsControl.applyTorque(zRotation.mult(angularSpeed));
            }

        }
    };

    public MyNoNamePlanetBotMasterZzz() {
        super(new StatsAppState(), new DebugKeysAppState());
    }

    public static void main(String[] args) {

        AppSettings settings = new AppSettings(true);
        settings.setResolution(1024, 768);
        settings.setTitle("Офигенный космос на JAVA > a.akhunov@yourapi.ru");


        MyNoNamePlanetBotMasterZzz application = new MyNoNamePlanetBotMasterZzz();
        application.setSettings(settings);
        application.setShowSettings(true);
        application.start();
    }

    @Override
    public void simpleInitApp() {

        setDisplayFps(false);
        setDisplayStatView(true);

        // Only show severe errors in log
        // java.util.logging.Logger.getLogger("com.jme3").setLevel(java.util.logging.Level.SEVERE);

        bulletAppState = new BulletAppState();
        stateManager.attach(bulletAppState);
        bulletAppState.getPhysicsSpace().setGravity(Vector3f.ZERO);

        // bulletAppState.setDebugEnabled(true);

        //createBallShooter(this, rootNode, bulletAppState.getPhysicsSpace());

        setupInput();
        initializeSky();
        createScene();

        createCharacter();

        setupCamera();

    }

    @Override
    public void simpleUpdate(float tpf) {

        characterControl.setGravity(planetAppState.getGravity());

//        Planet planet = planetAppState.getNearestPlanet();
        if (planet != null && planet.getPlanetToCamera() != null) {
            planet.rotate(tpf/50, 0, 0);
            cameraNodePhysicsControl.setGravity(planet.getPlanetToCamera().normalize().mult(-100f));
        }
        // Get current forward and left vectors of model by using its rotation
        // to rotate the unit vectors
        Vector3f modelForwardDir = characterNode.getWorldRotation().mult(Vector3f.UNIT_Z);
        Vector3f modelLeftDir = characterNode.getWorldRotation().mult(Vector3f.UNIT_X);

        // WalkDirection is global!
        // You *can* make your character fly with this.
        walkDirection.set(0, 0, 0);
        if (leftStrafe) {
            walkDirection.addLocal(modelLeftDir.mult(5));
        } else if (rightStrafe) {
            walkDirection.addLocal(modelLeftDir.negate().multLocal(5));
        }
        if (forward) {
            walkDirection.addLocal(modelForwardDir.mult(5));
        } else if (backward) {
            walkDirection.addLocal(modelForwardDir.negate().multLocal(5));
        }
        characterControl.setWalkDirection(walkDirection);

        // ViewDirection is local to characters physics system!
        // The final world rotation depends on the gravity and on the state of
        // setApplyPhysicsLocal()
        if (leftRotate) {
            Quaternion rotateL = new Quaternion().fromAngleAxis(FastMath.PI * tpf, Vector3f.UNIT_Y);
            rotateL.multLocal(viewDirection);
        } else if (rightRotate) {
            Quaternion rotateR = new Quaternion().fromAngleAxis(-FastMath.PI * tpf, Vector3f.UNIT_Y);
            rotateR.multLocal(viewDirection);
        }
        characterControl.setViewDirection(viewDirection);

        if (walkDirection.length() == 0) {
            if (!"Idle".equals(animationChannel.getAnimationName())) {
                animationChannel.setAnim("Idle", 1f);
            }
        } else {
            if (!"Walk".equals(animationChannel.getAnimationName())) {
                animationChannel.setAnim("Walk", 0.7f);
            }
        }
    }

    private void createScene() {
//
        DirectionalLight sun = new DirectionalLight();
        sun.setColor(new ColorRGBA(0.75f,0.75f,0.65f,1.0f));
        sun.setDirection(new Vector3f(0f, -1f, -1f));

        rootNode.addLight(sun);
        // Add sun
//        DirectionalLight sun = new DirectionalLight();
//        sun.setColor(new ColorRGBA(0.75f, 0.75f, 0.65f, 1.0f));
//        sun.setDirection(new Vector3f(0f, -1f, -1f));
//        rootNode.addLight(sun);


        // Add sky
        Node sceneNode = new Node("Scene");
        sceneNode.attachChild(Utility.createSkyBox(this.getAssetManager(), "Textures/blue-glow-1024.dds"));
        rootNode.attachChild(Utility.createCloud(this.getAssetManager(), rootNode));
        rootNode.attachChild(sceneNode);


/*
Camera Position: (-40850.56, 41807.656, -29497.348)
Camera Rotation: (-0.13657795, 0.07435199, 0.27499357, 0.94878703)
Camera Direction: (0.0659723, 0.3000594, 0.9516365)
cam.setLocation(new Vector3f(-40850.56f, 41807.656f, -29497.348f));
cam.setRotation(new Quaternion(-0.13657795f, 0.07435199f, 0.27499357f, 0.94878703f));
 */
        // Add planet app state
        planetAppState = new PlanetAppState(rootNode, sun);
        planetAppState.setShadowsEnabled(true);
        stateManager.attach(planetAppState);

        // Add planet
        FractalDataSource planetDataSource = new FractalDataSource(4);
        planetDataSource.setHeightScale(800f);
        planet = Utility.createEarthLikePlanet(getAssetManager(), 63710.0f, null, planetDataSource);
        planet.addControl(new RigidBodyControl(new PlanetCollisionShape(planet.getLocalTranslation(), planet.getRadius(), planetDataSource), 0f));
        planetAppState.addPlanet(planet);
        rootNode.attachChild(planet);
        bulletAppState.getPhysicsSpace().add(planet);



        // Add moon
        FractalDataSource moonDataSource = new FractalDataSource(5);
        moonDataSource.setHeightScale(300f);
        Planet moon = Utility.createMoonLikePlanet(getAssetManager(), 10000, moonDataSource);
        moon.setLocalTranslation(-100000f, 0f, 0f);
        RigidBodyControl moonPhysicsControl = new RigidBodyControl(new PlanetCollisionShape(moon.getLocalTranslation(), moon.getRadius(), moonDataSource), 0f);
        moon.addControl(moonPhysicsControl);
        planetAppState.addPlanet(moon);
        rootNode.attachChild(moon);
        bulletAppState.getPhysicsSpace().add(moon);

        // Add moon 2
//        FractalDataSource moonDataSource2 = new FractalDataSource(300);
//        moonDataSource2.setHeightScale(450f);
//        Planet moon2 = Utility.createMoonLikePlanet(getAssetManager(), 19000, moonDataSource2);
//        moon2.setLocalTranslation(-130000f, 50000f, 8000f);
//        RigidBodyControl moonPhysicsControl2 = new RigidBodyControl(new PlanetCollisionShape(moon2.getLocalTranslation(), moon2.getRadius(), moonDataSource2), 0f);
//        moon2.addControl(moonPhysicsControl2);
//        planetAppState.addPlanet(moon2);
//        rootNode.attachChild(moon2);
//        bulletAppState.getPhysicsSpace().add(moon2);
    }

    private void createCharacter() {
        characterNode = (Node) assetManager.loadModel("Models/Jaime/Jaime.j3o");
        characterNode.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
        characterNode.setLocalScale(1.50f);
        //this.getCamera().setLocation(new Vector3f(0f, 0f, 180000f));
        characterNode.setLocalTranslation(new Vector3f(-40823.504f, 37438.297f, -31889.91f));
        characterControl = new BetterCharacterControl(1f, 4f, 8f);
        characterNode.addControl(characterControl);
        rootNode.attachChild(characterNode);
        bulletAppState.getPhysicsSpace().add(characterControl);

        animationControl = characterNode.getControl(AnimControl.class);
        //animationControl.addListener(this);
        animationChannel = animationControl.createChannel();
    }

    private void setupCamera() {
        CameraControl cameraControl = new CameraControl(this.getCamera(), CameraControl.ControlDirection.SpatialToCamera);
        cameraNode = new CameraNode("Camera", cameraControl);

        cameraNodePhysicsControl = new RigidBodyControl(new SphereCollisionShape(2.5f), 1f);
        cameraNodePhysicsControl.setAngularFactor(0);
        cameraNodePhysicsControl.setLinearDamping(0.8f);
        cameraNodePhysicsControl.setAngularDamping(0.99f);
        cameraNode.addControl(cameraNodePhysicsControl);
        bulletAppState.getPhysicsSpace().add(cameraNode);

        setWalkMode();
    }

    private void initializeSky() {
        Spatial starMap = MyAsset.createStarMapSphere(assetManager,
                "purple-nebula-complex", 50000f);
        rootNode.attachChild(starMap);

//        skyControl.getCloudLayer(1).clearTexture();
//        Spatial skyFactory = Factory.createSky(getAssetManager(), "Textures/Sky/Bright/BrightSky.dds", SkyFactory.EnvMapType.CubeSkyMap);
//        rootNode.attachChild(skyFactory);


        /*
         * Create a SkyControl to animate the sky.
         */
//
//        if (parameters.singleDome()) {
//            cloudFlattening = 0f; // single dome implies clouds on top dome
//            starsOption = StarsOption.TopDome;  // stars on top dome
//            bottomDome = false; // single dome implies exposed background
//        } else if (parameters.cubes()) {
//
//        } else {
//            cloudFlattening = 0.9f; // overhead clouds 10x closer than horizon
//            starsOption = StarsOption.TwoDomes; // allows stars to move
//            bottomDome = true; // helpful when the scene has a low horizon
//        }


//        try {
//            /*
//             * Set up a globe renderer for the Moon.
//             */
//            boolean mipmaps = false;
//            Texture moonTexture = MyAsset.loadTexture(assetManager,
//                    "Textures/skies/moon/clementine.png", mipmaps);
//            Material moonMaterial = MyAsset.createShadedMaterial(assetManager,
//                    moonTexture);
//            int equatorSamples = 12;
//            int meridianSamples = 24;
//            int resolution = 512;
//            GlobeRenderer moonRenderer = new GlobeRenderer(moonMaterial,
//                    Image.Format.Luminance8Alpha8, equatorSamples, meridianSamples,
//                    resolution);
//            stateManager.attach(moonRenderer);
//            skyControl.setMoonRenderer(moonRenderer);
//        } catch (AssetNotFoundException exception) {
//
//        }

//        AmbientLight ambientLight = new AmbientLight();
//        ambientLight.setColor(ColorRGBA.White.mult(0.2f));
//        ambientLight.setName("ambient");
//        rootNode.addLight(ambientLight);
        /*
         * Put SkyControl in charge of updating both lights plus the
         * viewport background. (all optional)
         */
//        Updater updater = skyControl.getUpdater();
//        updater.addViewPort(viewPort);
//        updater.setAmbientLight(ambientLight);
        //updater.setMainLight(mainLight);
        //        Spatial skyFactory = new SkyControl();
//        Spatial skyFactory = SkyFactory.createSky(getAssetManager(), "Textures/Sky/Bright/BrightSky.dds", SkyFactory.EnvMapType.CubeMap);
//        rootNode.attachChild(skyFactory);
    }

    private Texture loadSplatTexture(String fileName) {
        assert fileName != null;

        String path = String.format("Textures/Terrain/splat/%s", fileName);
        Texture result = assetManager.loadTexture(path);
        result.setWrap(Texture.WrapMode.Repeat);

        return result;
    }

    private void setWalkMode() {

        if (!walkMode)
            characterControl.warp(cameraNode.getLocalTranslation());

        cameraNode.removeControl(cameraNodePhysicsControl);

        rootNode.detachChild(cameraNode);
        characterNode.attachChild(cameraNode);
        cameraNode.setLocalTranslation(new Vector3f(0f, 3f, -5.0f));
        cameraNode.lookAt(characterNode.getLocalTranslation(), planetAppState.getGravity().negate());
        cameraNode.rotate(-.25f, 0, 0);

        walkMode = true;
    }

    private void setFlyMode() {

        Vector3f position = cameraNode.getWorldTranslation();
        characterNode.detachChild(cameraNode);
        rootNode.attachChild(cameraNode);
        cameraNode.setLocalTranslation(position);
        cameraNode.lookAt(characterNode.getLocalTranslation(), planetAppState.getGravity().negate());
        cameraNode.rotate(-.25f, 0, 0);
        cameraNode.addControl(cameraNodePhysicsControl);

        walkMode = false;
    }

    private void setupInput() {
        inputManager.addMapping("Move Left",
                new KeyTrigger(KeyInput.KEY_A));
        inputManager.addMapping("Move Right",
                new KeyTrigger(KeyInput.KEY_D));
        inputManager.addMapping("Rotate Left",
                new KeyTrigger(KeyInput.KEY_LEFT));
        inputManager.addMapping("Rotate Right",
                new KeyTrigger(KeyInput.KEY_RIGHT));
        inputManager.addMapping("Rotate Up",
                new KeyTrigger(KeyInput.KEY_DOWN));
        inputManager.addMapping("Rotate Down",
                new KeyTrigger(KeyInput.KEY_UP));
        inputManager.addMapping("Move Forward",
                new KeyTrigger(KeyInput.KEY_W));
        inputManager.addMapping("Move Backward",
                new KeyTrigger(KeyInput.KEY_S));
        inputManager.addMapping("Jump",
                new KeyTrigger(KeyInput.KEY_F),
                new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addMapping("Duck",
                new KeyTrigger(KeyInput.KEY_G),
                new KeyTrigger(KeyInput.KEY_LSHIFT),
                new KeyTrigger(KeyInput.KEY_RSHIFT));
        inputManager.addMapping("Spin Left", new KeyTrigger(KeyInput.KEY_Q));
        inputManager.addMapping("Spin Right", new KeyTrigger(KeyInput.KEY_E));
        // Linear speed
        inputManager.addMapping("Speed Up", new KeyTrigger(KeyInput.KEY_PGUP));
        inputManager.addMapping("Speed Down", new KeyTrigger(KeyInput.KEY_PGDN));

        inputManager.addMapping("Toogle Walk Fly",
                new KeyTrigger(KeyInput.KEY_RETURN));

        inputManager.addListener(this, "Move Left", "Move Right");
        inputManager.addListener(this, "Rotate Left", "Rotate Right", "Rotate Down", "Rotate Up");
        inputManager.addListener(this, "Move Forward", "Move Backward");
        inputManager.addListener(this, "Jump", "Duck", "Toogle Walk Fly", "Speed Up", "Speed Down");

        inputManager.addListener(analogListener, "Move Left", "Move Right", "Move Forward", "Move Backward", "Rotate Left", "Rotate Right", "Rotate Up", "Rotate Down", "Spin Left", "Spin Right");
    }

    public void onAction(String binding, boolean value, float tpf) {

        if (binding.equals("Toogle Walk Fly") && value) {
            if (walkMode) {
                setFlyMode();
            } else {
                setWalkMode();
            }
        }

        if (walkMode) {
            if (binding.equals("Move Left")) {
                if (value) {
                    leftStrafe = true;
                } else {
                    leftStrafe = false;
                }
            } else if (binding.equals("Move Right")) {
                if (value) {
                    rightStrafe = true;
                } else {
                    rightStrafe = false;
                }
            } else if (binding.equals("Rotate Left")) {
                if (value) {
                    leftRotate = true;
                } else {
                    leftRotate = false;
                }
            } else if (binding.equals("Rotate Right")) {
                if (value) {
                    rightRotate = true;
                } else {
                    rightRotate = false;
                }
            } else if (binding.equals("Move Forward")) {
                if (value) {
                    forward = true;
                } else {
                    forward = false;
                }
            } else if (binding.equals("Move Backward")) {
                if (value) {
                    backward = true;
                } else {
                    backward = false;
                }
            } else if (binding.equals("Jump")) {
                characterControl.jump();
            } else if (binding.equals("Duck")) {
                if (value) {
                    characterControl.setDucked(true);
                } else {
                    characterControl.setDucked(false);
                }
            }
        }

        if (!walkMode) {
            if (binding.equals("Speed Up") && value) {
                if (linearSpeed >= 1000) {
                    linearSpeed += 1000;
                } else {
                    linearSpeed += 100;
                }
                if (linearSpeed > 50000) {
                    linearSpeed = 50000;
                }
                System.out.println("Speed:" + linearSpeed);
            }
            if (binding.equals("Speed Down") && value) {
                if (linearSpeed <= 1000) {
                    linearSpeed -= 100;
                } else {
                    linearSpeed -= 1000;
                }
                if (linearSpeed < 100) {
                    linearSpeed = 100;
                }
                System.out.println("Speed:" + linearSpeed);
            }
        }

    }

    private void createBallShooter(final Application app, final Node rootNode, final PhysicsSpace space) {
        ActionListener actionListener = new ActionListener() {

            public void onAction(String name, boolean keyPressed, float tpf) {
                Sphere bullet = new Sphere(32, 32, 0.4f, true, false);
                bullet.setTextureMode(Sphere.TextureMode.Projected);
                Material mat2 = new Material(app.getAssetManager(), "Common/MatDefs/Light/Lighting.j3md");
                //mat2.setBoolean("LogarithmicDepthBuffer", true);
                TextureKey key2 = new TextureKey("Textures/rock.jpg");
                key2.setGenerateMips(true);
                Texture tex2 = app.getAssetManager().loadTexture(key2);
                mat2.setTexture("DiffuseMap", tex2);
                if (name.equals("shoot") && !keyPressed) {
                    Geometry bulletg = new Geometry("bullet", bullet);
                    bulletg.setMaterial(mat2);
                    bulletg.setShadowMode(RenderQueue.ShadowMode.CastAndReceive);
                    bulletg.setLocalTranslation(app.getCamera().getLocation());
                    RigidBodyControl bulletControl = new RigidBodyControl(10);
                    bulletg.addControl(bulletControl);
                    bulletControl.setLinearDamping(.1f);
                    bulletControl.setLinearVelocity(app.getCamera().getDirection().mult(15));
                    bulletg.addControl(bulletControl);
                    rootNode.attachChild(bulletg);
                    space.add(bulletControl);

                    Planet planet = planetAppState.getNearestPlanet();
                    if (planet != null && planet.getPlanetToCamera() != null) {
                        bulletControl.setGravity(planet.getPlanetToCamera().normalize().mult(-9.81f));
                    }

                }
            }
        };
        app.getInputManager().addMapping("shoot", new MouseButtonTrigger(MouseInput.BUTTON_LEFT));
        app.getInputManager().addListener(actionListener, "shoot");
    }

}

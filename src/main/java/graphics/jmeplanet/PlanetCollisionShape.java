package graphics.jmeplanet;

import com.bulletphysics.collision.shapes.ConcaveShape;
import com.jme3.bullet.collision.shapes.CollisionShape;
import com.jme3.export.InputCapsule;
import com.jme3.export.JmeExporter;
import com.jme3.export.JmeImporter;
import com.jme3.export.OutputCapsule;
import com.jme3.math.Vector3f;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PlanetCollisionShape extends CollisionShape {

//    protected ConcaveShape cShape;
    protected Vector3f center;
    protected float radius;
    protected HeightDataSource dataSource;
    
    public PlanetCollisionShape(Vector3f center, float radius, HeightDataSource dataSource) {
        this.center = center;
        this.radius = radius;
        this.dataSource = dataSource;
        createShape();
    }

    protected PlanetCollisionShape() {
    }

    protected void createShape() {
//        cShape = new PlanetShape(center, radius, dataSource);
       // cShape.setLocalScaling(Converter.convert(getScale()));
//        cShape.setMargin(margin);
//        cShape = new PlanetShape(center, radius, dataSource);
//        cShape.setLocalScaling(Converter.convert(new Vector3f(1.0F, 1.0F, 1.0F)));
//        cShape.setMargin(0.04F);
//        if (NativeLibraryLoader.isUsingNativeBullet()) {
//            NativeLibraryLoader.loadNativeLibrary("bulletjme", true);
//
//        }
//        System.loadLibrary("bulletjme");
//        System.load("bulletjme");
        objectId = createShape(radius);
        Logger.getLogger(this.getClass().getName()).log(Level.FINE, "Created Shape {0}", Long.toHexString(objectId));
        setScale(scale); // Set the scale to 1
        setMargin(margin);

    }

    private native long createShape(float radius);
    
}

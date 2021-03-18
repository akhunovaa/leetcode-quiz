package graphics.jmonkey;

import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer.Type;
import com.jme3.util.BufferUtils;
import com.jme3.math.FastMath;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class PlanetMeshGen {

    // Radius of planet
    protected float planetRadius;
    // Width of heightmap
    protected int heightmapWidth;
    // Stores heightmap data
    protected float heightmapData[];

    public PlanetMeshGen() {

    }

    public Mesh generateMesh() {
        return generateMesh(250);
    }

    public Mesh generateMesh(float radius) {
        planetRadius = radius;

        Mesh mesh = new Mesh();

        int gammaSamples = heightmapWidth;
        int thetaSamples = (heightmapWidth - 1) * 2;

        List<Vector3f> vertexList = new ArrayList<Vector3f>();
        List<Vector3f> normalList = new ArrayList<Vector3f>();
        List<Integer> indexList = new ArrayList<Integer>();
        List<Float> colorList = new ArrayList<Float>();

        // Horizontal points
        float gammaStep = 2 * FastMath.PI / thetaSamples;

        // Vertical points
        float thetaStep = FastMath.PI / (gammaSamples - 1);

        // Generate vertices
        for (int i = 0; i < thetaSamples; i++) {
            float gamma = i * gammaStep;
            for (int j = 0; j < gammaSamples; j++) {
                float theta = j * thetaStep;

                Vector3f pt = new Vector3f();
                pt.x = planetRadius * FastMath.sin(theta) * FastMath.cos(gamma);
                pt.y = planetRadius * FastMath.cos(theta);
                pt.z = planetRadius * FastMath.sin(theta) * FastMath.sin(gamma);

                float height = getHeight(i, j);

                vertexList.add(pt.normalize().mult(planetRadius + height));

                // Set vertex colors
                if (height <= 1f) {
                    colorList.add(0.0f);
                    colorList.add(0.4f);
                    colorList.add(0.8f);
                    colorList.add(1.0f); // Ocean
                } else if (height <= 1.5f) {
                    colorList.add(0.83f);
                    colorList.add(0.72f);
                    colorList.add(0.34f);
                    colorList.add(1.0f); // Sand
                } else if (height <= 10f) {
                    colorList.add(0.2f);
                    colorList.add(0.6f);
                    colorList.add(0.1f);
                    colorList.add(1.0f); // Grass
                } else {
                    colorList.add(0.5f);
                    colorList.add(0.5f);
                    colorList.add(0.5f);
                    colorList.add(1.0f); // Mountains
                }
            }
        }

        // Generate normals
        for (int i = 0; i < thetaSamples; i++) {
            for (int j = 0; j < gammaSamples; j++) {
                int i1 = i * gammaSamples + j;
                int i2 = ((i + 1) % thetaSamples) * gammaSamples + j;
                int i3 = ((i + 1) % thetaSamples) * gammaSamples + j + 1;
                int i4 = i * gammaSamples + j + 1;

                if (j >= gammaSamples - 1) {
                    i3 = gammaSamples + j + 1;
                    i4 = j + 1;
                }

                Vector3f v1 = vertexList.get(i1);
                Vector3f v2 = vertexList.get(i2);
                Vector3f v3 = vertexList.get(i3);
                Vector3f v4 = vertexList.get(i4);

                Vector3f normal;
                Vector3f t1, t2, t3, t4;
                Vector3f n1, n2, n3, n4;

                t1 = v1.subtract(v1);
                t2 = v2.subtract(v3);
                t3 = v3.subtract(v4);
                t4 = v4.subtract(v1);

                n1 = t1.cross(t2).normalize();
                n2 = t2.cross(t3).normalize();
                n3 = t3.cross(t4).normalize();
                n4 = t4.cross(t1).normalize();

                normal = n1.add(n2).add(n3).add(n4).normalize();
                normalList.add(normal);
            }
        }

        // Generate indices
        for (int i = 0; i < thetaSamples; i++) {
            for (int j = 0; j < gammaSamples - 1; j++) {
                Integer i1 = i * gammaSamples + j;
                Integer i2 = ((i + 1) % thetaSamples) * gammaSamples + j;
                Integer i3 = ((i + 1) % thetaSamples) * gammaSamples + j + 1;
                Integer i4 = i * gammaSamples + j + 1;

                indexList.add(i1);
                indexList.add(i2);
                indexList.add(i3);

                indexList.add(i1);
                indexList.add(i3);
                indexList.add(i4);
            }
        }

        // Set buffers
        mesh.setBuffer(Type.Position, 3, BufferUtils.createFloatBuffer(vertexList.toArray(new Vector3f[0])));
        mesh.setBuffer(Type.Normal, 3, BufferUtils.createFloatBuffer(normalList.toArray(new Vector3f[0])));
        mesh.setBuffer(Type.Index, 1, BufferUtils.createIntBuffer(toIntArray(indexList)));
        mesh.setBuffer(Type.Color, 4, BufferUtils.createFloatBuffer(toFloatArray(colorList)));
        mesh.updateBound();

        return mesh;
    }


    /**
     * Create the heightmap for the planet with default values.
     */
    public void generateHeightmap() {
        generateHeightmap(750, 19580427, 30, 90, 25000, .8f, .3f);
    }


    /**
     * Create the heightmap for the planet.
     *
     * @param width        The width of the heightmap. Larger values mean more complex mesh
     * @param seed         The random seed for generating the heightmap
     * @param numIslands   Total number of land masses
     * @param islandRadius How big each land mass is
     * @param iterations   More interation equals more complex features
     * @param smoothing    Lower numbers mean smoother land features
     */
    public void generateHeightmap(int width, int seed, int numIslands, float islandRadius, int iterations, float displacement, float smoothing) {
        heightmapWidth = width;
        heightmapData = new float[heightmapWidth * heightmapWidth];

        Random rGenerator = new Random(seed);

        for (int j = 0; j < numIslands; j++) {

            // Find a random spot to grow an island
            int sx = rGenerator.nextInt(heightmapWidth);
            int sy = rGenerator.nextInt(heightmapWidth);
            int x = sx, y = sy;
            for (int i = 0; i < iterations; i++) {
                float d = getData(x, y);
                // Check neighbors
                if (getData(x - 1, y) < d) {
                    setData(x - 1, y, getData(x - 1, y) + displacement);
                } else if (getData(x + 1, y) < d) {
                    setData(x + 1, y, getData(x + 1, y) + displacement);
                } else if (this.getData(x, y - 1) < d) {
                    setData(x, y - 1, getData(x, y - 1) + displacement);
                } else if (this.getData(x, y + 1) < d) {
                    setData(x, y + 1, getData(x, y + 1) + displacement);
                } else {
                    setData(x, y, d + displacement);
                }

                switch (rGenerator.nextInt(4)) {
                    case 0:
                        y++;
                        if (inCircle(sx, sy, x, y, islandRadius) &&
                                y > 0 && y < heightmapWidth) {
                            break;
                        } else {
                            y--;
                        }
                    case 1:
                        y--;
                        if (inCircle(sx, sy, x, y, islandRadius) &&
                                y > 0 && y < heightmapWidth) {
                            break;
                        } else {
                            y++;
                        }
                    case 2:
                        x++;
                        if (inCircle(sx, sy, x, y, islandRadius) &&
                                x > 0 && x < heightmapWidth) {
                            break;
                        } else {
                            x--;
                        }
                    case 3:
                        x--;
                        if (inCircle(sx, sy, x, y, islandRadius) &&
                                x > 0 && x < heightmapWidth) {
                            break;
                        } else {
                            x++;
                        }
                }
            }
        }

        smooth(smoothing);
    }

    protected void smooth(float k) {
        for (int x = 1; x < heightmapWidth; x++) {
            for (int z = 0; z < heightmapWidth; z++) {
                heightmapData[x * heightmapWidth + z] =
                        heightmapData[(x - 1) * heightmapWidth + z] * (1 - k) +
                                heightmapData[x * heightmapWidth + z] * k;
            }
        }

        for (int x = heightmapWidth - 2; x >= 0; x--) {
            for (int z = 0; z < heightmapWidth; z++) {
                heightmapData[x * heightmapWidth + z] =
                        heightmapData[(x + 1) * heightmapWidth + z] * (1 - k) +
                                heightmapData[x * heightmapWidth + z] * k;
            }
        }

        for (int x = 0; x < heightmapWidth; x++) {
            for (int z = heightmapWidth - 2; z >= 0; z--) {
                heightmapData[x * heightmapWidth + z] =
                        heightmapData[x * heightmapWidth + (z + 1)] * (1 - k) +
                                heightmapData[x * heightmapWidth + z] * k;
            }
        }

        for (int x = 0; x < heightmapWidth; x++) {
            for (int z = 1; z < heightmapWidth; z++) {
                heightmapData[x * heightmapWidth + z] =
                        heightmapData[x * heightmapWidth + (z - 1)] * (1 - k) +
                                heightmapData[x * heightmapWidth + z] * k;
            }
        }
    }

    protected float getHeight(int i, int j) {
        float offset;
        if (i >= heightmapWidth) {
            offset = heightmapData[((2 * heightmapWidth - 1) - i) * heightmapWidth + j];
        } else {
            offset = heightmapData[i * heightmapWidth + j];
        }

        return offset;
    }

    protected float getData(int x, int y) {
        int index = x * heightmapWidth + y;
        if (index < heightmapData.length && index >= 0)
            return heightmapData[index];
        else
            return 0f;
    }

    protected void setData(int x, int y, float val) {
        int index = x * heightmapWidth + y;
        if (index < heightmapData.length)
            heightmapData[index] = val;
    }

    protected boolean inCircle(int sx, int sy, int x, int y, float r) {
        return (FastMath.pow(x - sx, 2) + FastMath.pow(y - sy, 2)) < FastMath.pow(r, 2);
    }

    protected int[] toIntArray(List<Integer> list) {
        int[] ret = new int[list.size()];
        int i = 0;
        for (Integer e : list)
            ret[i++] = e.intValue();
        return ret;
    }

    protected float[] toFloatArray(List<Float> list) {
        float[] ret = new float[list.size()];
        int i = 0;
        for (Float e : list)
            ret[i++] = e.floatValue();
        return ret;
    }
}

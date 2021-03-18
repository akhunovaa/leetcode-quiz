package graphics.jmeplanet;

import com.jme3.math.Vector3f;

/**
 * HeightDataSource
 * 
 */
public interface HeightDataSource {
    
    public void setHeightScale(float heightScale);
    
    public float getHeightScale();
    
    public float getValue(Vector3f position);
    
}

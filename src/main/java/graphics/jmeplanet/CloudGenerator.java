package graphics.jmeplanet;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.nio.ByteBuffer;

public class CloudGenerator {

    private double lerp(double start, double end, double blend){
        return start==end ? start : ((1 - blend) * start) + (blend * end);
    }

    private double cerp(double start, double end, double blend){
        double cos_blend = (1 - Math.cos(blend * Math.PI)) * .5;
        return lerp(start,end,cos_blend);
    }

    private int r1 = 15731;
    private int r2 = 789221;
    private int r3 = 1376312589;

    private double noise(int x, int y, int z){
        int n = z + x * 57 + y * 57 * 57;
        n = (n<<13) ^ n;

        return ( 1.0 - ( (n * (n * n * r1 + r2) + r3) & 0x7fffffff) / 1073741824.0);
    }

    private double smooth_noise(double x, double y, double z){
        double n1 = noise((int)x, (int)y, (int)z);
        double n2 = noise((int)x + 1, (int)y, (int)z);
        double n3 = noise((int)x, (int)y + 1, (int)z);
        double n4 = noise((int)x + 1, (int)y + 1, (int)z);

        double zn1 = noise((int)x, (int)y, (int)z + 1);
        double zn2 = noise((int)x + 1, (int)y, (int)z + 1);
        double zn3 = noise((int)x, (int)y + 1, (int)z + 1);
        double zn4 = noise((int)x + 1, (int)y + 1, (int)z + 1);

        double i1 = cerp(n1, n2, x - (int)x);
        double i2 = cerp(n3, n4, x - (int)x);

        double i3 = cerp(i1, i2, y - (int)y);

        double zi1 = cerp(zn1, zn2, x - (int)x);
        double zi2 = cerp(zn3, zn4, x - (int)x);

        double zi3 = cerp(zi1, zi2, y - (int)y);

        return cerp(i3,zi3,z - (int)z);
    }

    private double clamp(double d){
        return d > 1.0 ? 1.0 : (d < 0.0 ? 0.0 : d);
    }

    private double curve(double d){
        double c = d - (1.0 - density);
        if (c < 0) c = 0.0;

        c = clamp(Math.pow(smoothness,c));

        return 1.0 - c;
    }

    private double frequency = 0.01;
    private double detail = 0.65;
    private double smoothness = 0.2; //0.4
    private double density = 1.0;

    private double func(double x, double z, double time, double freq) {
        double r = 0;

        double a = 1.0;
        double f = freq;

        for (int i = 0; i < 8; i++){
            r += smooth_noise(x * f, z * f, time) * a;
            //r += ImprovedNoise.noise(x * f,z * f, time) * a;

            f *= 2;
            a *= detail;
        }

        //double cloudCoverage = 0;   // USER ADJUSTABLE
        //double cloudDensity = 1;    // USER ADJUSTABLE

        //r = (r + cloudCoverage) * cloudDensity * fade;

        r = curve(clamp(r));

        return r;
    }

    private byte double2byte (double d){
        return (byte)(((int)(d * 255)) & 0xFF);
    }

    private short double2short (double d){
        return (short)(d * 32768.0);
    }


    public void setDensity(float density){
        this.density=density;
    }

    public ByteBuffer generate(int width, int height, double time, ByteBuffer store){
        if (store==null){
            store = ByteBuffer.allocateDirect(width*height*2);
        }

        store.rewind();
        double size = (frequency / width) * 1024;

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                double noise = func(x,y,time,size);
                byte b = double2byte(noise);
                //store.put((byte)0xFF).put(b);
                //store.put((byte)0xFF).put((byte)0xFF);
                store.put(b).put((byte)0xFF);
            }
        }

        return store;
    }

    public BufferedImage generate(int width, int height, double time){
        BufferedImage img = new BufferedImage(width,height,BufferedImage.TYPE_BYTE_GRAY);
        WritableRaster wr = img.getRaster();

        double size = (frequency / width) * 1024;

        for (int x = 0; x < width; x++){
            for (int y = 0; y < height; y++){
                //short s = double2short(func(x,y,time,size));
                //wr.setSample(x,y,0,s);
                double noise = func(x,y,time,size);
                byte b = double2byte(noise);
                wr.setSample(x,y,0, b );
            }
        }

        return img;
    }
}

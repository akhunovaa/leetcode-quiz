package mandelbrot;

import javax.swing.*;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Mandelbrot extends Canvas {

    // size of fractal in pixels (HEIGHT X HEIGHT)
    private static final int HEIGHT = 1024;
    // how long to test for orbit divergence
    private static final int NUM_ITERATIONS = 50;
    // maximum grid size to process sequentially
    private static final int SEQ_CUTOFF = 64;

    private int colorscheme[];

    // 2-dimensional array of colors stored in packed ARGB format
    private int[] fractal;

    private int height;
    private boolean optDrawGrid;
    private Image img;
    private String msg;

    private ForkJoinPool fjPool = new ForkJoinPool();

    /**
     * Construct a new Mandelbrot canvas.
     * The constructor will calculate the fractal (either sequentially
     * or in parallel), then store the result in an {@link java.awt.Image}
     * for faster drawing in its {@link #paint(Graphics)} method.
     *
     * @param height the size of the fractal (height x height pixels).
     * @param optParallel if true, render in parallel
     * @param optDrawGrid if true, render the grid of leaf task pixel areas
     */
    public Mandelbrot(int height, boolean optParallel, boolean optDrawGrid) {
        this.optDrawGrid = optDrawGrid;

        this.colorscheme = new int[NUM_ITERATIONS+1];
        // fill array with color palette going from Red over Green to Blue
        int scale = (255 * 2) / NUM_ITERATIONS;

        // going from Red to Green
        for (int i = 0; i < (NUM_ITERATIONS/2); i++)
            //               Alpha=255  | Red                   | Green       | Blue=0
            colorscheme[i] = 0xFF << 24 | (255 - i*scale) << 16 | i*scale << 8;

        // going from Green to Blue
        for (int i = 0; i < (NUM_ITERATIONS/2); i++)
            //                         Alpha=255 | Red=0 | Green              | Blue
            colorscheme[i+NUM_ITERATIONS/2] = 0xFF000000 | (255-i*scale) << 8 | i*scale;

        // convergence color
        colorscheme[NUM_ITERATIONS] = 0xFF0000FF; // Blue

        this.height = height;
        // fractal[x][y] = fractal[x + height*y]
        this.fractal = new int[height*height];

        long start = System.currentTimeMillis();
        if (optParallel) {
            // parallel calculation through Fork/Join
            fjPool.invoke(new FractalTask(0, 0, height));
        } else {
            // sequential calculation by the main Thread
            calcMandelBrot(0, 0, height, height);
        }
        long end = System.currentTimeMillis();
        msg = (optParallel ? "parallel" : "sequential") +
                " done in " + (end - start) + "ms.";

        this.img = getImageFromArray(fractal, height, height);
    }

    /**
     * Draws part of the mandelbrot fractal.
     *
     * This method calculates the colors of pixels in the square:
     *
     * (srcx, srcy)           (srcx+size, srcy)
     *      +--------------------------+
     *      |                          |
     *      |                          |
     *      |                          |
     *      +--------------------------+
     * (srcx, srcy+size)      (srcx+size, srcy + size)
     */
    private void calcMandelBrot(int srcx, int srcy, int size, int height) {
        double x, y, t, cx, cy;
        int k;

        // loop over specified rectangle grid
        for (int px = srcx; px < srcx + size; px++) {
            for (int py = srcy; py < srcy + size; py++) {
                x=0; y=0;
                // convert pixels into complex coordinates between (-2, 2)
                cx = (px * 4.0) / height - 2;
                cy = 2 - (py * 4.0) / height;
                // test for divergence
                for (k = 0; k < NUM_ITERATIONS; k++) {
                    t = x*x-y*y+cx;
                    y = 2*x*y+cy;
                    x = t;
                    if (x*x+y*y > 4) break;
                }

                fractal[px + height * py] = colorscheme[k];
            }
        }

        // paint grid boundaries
        if (optDrawGrid) {
            drawGrid(srcx, srcy, size, Color.BLACK.getRGB());
        }
    }

    /**
     * Draw the rectangular outline of the grid to show the
     * subdivision of the canvas into grids processed in parallel.
     */
    private void drawGrid(int x, int y, int size, int color) {
        for (int i = 0; i < size; i++) {
            fractal[x+i + height * (y       )] = color;
            fractal[x+i + height * (y+size-1)] = color;
        }
        for (int j = 0; j < size; j++) {
            fractal[x          + height * (y+j)] = color;
            fractal[x + size-1 + height * (y+j)] = color;
        }
    }

    /**
     * Divide the grid into four equally-sized subgrids until they
     * are small enough to be drawn sequentially.
     */
    private class FractalTask extends RecursiveAction {
        final int srcx;
        final int srcy;
        final int size;
        public FractalTask(int sx, int sy, int siz) {
            srcx = sx; srcy = sy; size = siz;
        }
        @Override
        protected void compute() {
            if (size < SEQ_CUTOFF) {
                calcMandelBrot(srcx, srcy, size, height);
            } else {
                FractalTask ul = new FractalTask(srcx,        srcy,        size/2);
                FractalTask ur = new FractalTask(srcx+size/2, srcy,        size/2);
                FractalTask ll = new FractalTask(srcx,        srcy+size/2, size/2);
                FractalTask lr = new FractalTask(srcx+size/2, srcy+size/2, size/2);
                // forks and immediately joins the four subtasks
                invokeAll(ul, ur, ll, lr);
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        // draw the fractal from the stored image
        g.drawImage(this.img, 0, 0, null);
        // draw the message text in the lower-right-hand corner
        byte[] data = this.msg.getBytes();
        g.drawBytes(
                data,
                0,
                data.length,
                getWidth() - (data.length)*8,
                getHeight() - 20);
    }

    /**
     * Auxiliary function that converts an array of pixels into a BufferedImage.
     * This is used to be able to quickly draw the fractal onto the canvas using
     * native code, instead of us having to manually plot each pixel to the canvas.
     */
    private static Image getImageFromArray(int[] pixels, int width, int height) {
        // RGBdefault expects 0x__RRGGBB packed pixels
        ColorModel cm = DirectColorModel.getRGBdefault();
        SampleModel sampleModel = cm.createCompatibleSampleModel(width, height);
        DataBuffer db = new DataBufferInt(pixels, height, 0);
        WritableRaster raster = Raster.createWritableRaster(sampleModel, db, null);
        BufferedImage image = new BufferedImage(cm, raster, false, null);
        return image;
    }

    /**
     * Supported command-line options:
     *  -p : render in parallel (default: sequential)
     *  -g : draw grid of pixels drawn by leaf tasks (default: off)
     */
    public static void main(String args[]) {
        boolean optParallel = false;
        boolean optDrawGrid = false;
        for (int i = 0; i < args.length; i++) {
        if (args[i].equals("-g")) {
                optDrawGrid = true;
            } else {
                System.err.println("unknown option: " + args[i]);
            }
        }
        JPanel panel = new JPanel();
        JScrollPane jScrollPane = new JScrollPane(panel);
// only a configuration to the jScrollPane...
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

// Then, add the jScrollPane to your frame

        JFrame f = new JFrame();
        f.getContentPane().add(jScrollPane);
        Mandelbrot canvas = new Mandelbrot(HEIGHT, optParallel, optDrawGrid);
        f.setSize(HEIGHT, HEIGHT);
        f.add(canvas);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }
}

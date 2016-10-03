package isometric;

import isometric.display.Display;
import isometric.gfx.Draw;
import isometric.input.KeyManager;
import isometric.playground.Playground;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

/**
 *
 * @author AMAUROTE
 */
public class Core implements Runnable {
    ////////////////////////////////////////////////////////////////////////////
    // CONFIG

    // frame
    public final String FRAME_TITLE = "Isometric";
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 600;

    public static final int VERTICAL_OFFSET = 200;

    // tiles
    public static final int TILE_WIDTH = 40;
    public static final int TILE_HEIGHT = TILE_WIDTH / 2;

    public static final int TILE_COUNT = 10;

    public static final int TILE_MAX_ELEVATION = 1000;

    ////////////////////////////////////////////////////////////////////////////
    // OBJECTS
    // display
    private final Display display;

    // game cycle
    private Thread thread;
    private boolean running;

    // graphics
    private BufferStrategy bs;
    private Graphics g;

    // interface
    private static KeyManager keyManager;

    // random / seed
    public static Random rand;
    public long seed = 123456;

    ////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTOR
    public Core() {
        running = false;

        display = new Display(FRAME_TITLE, FRAME_WIDTH, FRAME_HEIGHT);
        keyManager = new KeyManager();

        display.getFrame().addKeyListener(keyManager);

        rand = new Random(seed);

        Playground.init();
        Draw.init();
    }

    ////////////////////////////////////////////////////////////////////////////
    // CORE
    public synchronized void start() {
        if (!running) {
            thread = new Thread(this, FRAME_TITLE);
            thread.start();
            running = true;
        }
    }

    public synchronized void stop() {
        if (running) {
            try {
                thread.join();
                running = false;
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0; // fps
        double delta = 0;
        int frames = 0;
        int updates = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1.0) {
                delta = 0;
                update();
                updates++;
            }

            render();
            frames++;

            // timer 1000ms
            if (System.currentTimeMillis() - timer > 1000) {
                timer = System.currentTimeMillis();
                display.getFrame().setTitle(FRAME_TITLE + "  |  " + updates + " ups, " + frames + " fps");
                updates = 0;
                frames = 0;

                onTime();
            }

            // sleep
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        stop();
    }

    ////////////////////////////////////////////////////////////////////////////
    // TIME
    private void update() {
        keyManager.update();

        Playground.update();
        Draw.update();
    }

    private void onTime() {

    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        // clear
        g.clearRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
        g.setColor(Color.white);
        g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);

        // Draw Here
        Draw.draw(g);
        // end drawing
        bs.show();
        g.dispose();
    }

    ////////////////////////////////////////////////////////////////////////////
    // GETTERS / SETTERS
    public static KeyManager getKeyManager() {
        return keyManager;
    }
}

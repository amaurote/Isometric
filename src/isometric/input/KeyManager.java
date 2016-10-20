package isometric.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author AMAUROTE
 */
public class KeyManager implements KeyListener {

    private final boolean keys[];
    public boolean up, down, left, right, upleft, upright, downleft, downright;
    public boolean uparrow, downarrow, leftarrow, rightarrow;

    public KeyManager() {
        keys = new boolean[256];
    }

    public void update() {
        up = keys[KeyEvent.VK_NUMPAD8];
        down = keys[KeyEvent.VK_NUMPAD2];
        left = keys[KeyEvent.VK_NUMPAD4];
        right = keys[KeyEvent.VK_NUMPAD6];

        upleft = keys[KeyEvent.VK_NUMPAD7];
        upright = keys[KeyEvent.VK_NUMPAD9];
        downleft = keys[KeyEvent.VK_NUMPAD1];
        downright = keys[KeyEvent.VK_NUMPAD3];

        uparrow = keys[KeyEvent.VK_UP];
        downarrow = keys[KeyEvent.VK_DOWN];
        leftarrow = keys[KeyEvent.VK_LEFT];
        rightarrow = keys[KeyEvent.VK_RIGHT];
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() <= 256) {
            keys[e.getKeyCode()] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() <= 256) {
            keys[e.getKeyCode()] = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}

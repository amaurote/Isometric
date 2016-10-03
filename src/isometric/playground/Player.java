package isometric.playground;

/**
 *
 * @author AMAUROTE
 */
public class Player {

    private int x;
    private int y;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveX() {
        if (x > 0) {
            x--;
        }
    }

    public void moveY() {
        if (y > 0) {
            y--;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

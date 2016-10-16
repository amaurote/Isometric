package isometric.playground;

import isometric.Core;

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

    public void moveX(int dir) {
        if (dir == 1) {
            if (x < Core.TILE_COUNT) {
                x++;
            }
        } else {
            if (x > 0) {
                x--;
            }
        }
    }

    public void moveY(int dir) {
        if (dir == 1) {
            if (y < Core.TILE_COUNT) {
                y++;
            }
        } else {
            if (y > 0) {
                y--;
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

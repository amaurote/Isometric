package isometric.playground;

import isometric.Core;

/**
 *
 * @author AMAUROTE
 */
public class Brick {

    private float height;
    private boolean direction;

    private int type;

    public Brick(int level, int type) {
        height = level * Core.TILE_ELEV;
        this.type = type;
    }

    @Deprecated
    public Brick(int height, boolean direction) {
        this.height = height;
        this.direction = direction;
    }

    public float move() {

        // up
        if (direction) {
            if (height >= Core.TILE_MAX_ELEVATION) {
                direction = false;
            } else {
                height += 0.5f;
            }
            // down
        } else if (height <= 0) {
            direction = true;
        } else {
            height -= 0.5f;
        }

        return height;
    }

    public float getHeight() {
        return height;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }
}

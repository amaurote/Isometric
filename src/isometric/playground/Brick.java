package isometric.playground;

import isometric.Core;

/**
 *
 * @author AMAUROTE
 */
public class Brick {

    private float height;
    private boolean direction;

    private boolean changed;
    
    private int type;

    public Brick(int level, int type) {
        this.height = level * Core.TILE_ELEV;
        this.type = type;
        this.changed = true;
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
    
    public boolean wasChanged() {
        if(changed) {
            changed = false;
            return true;
        } else {
            return false;
        }
    }
}

package isometric.playground;

import isometric.Core;

/**
 *
 * @author AMAUROTE
 */
public class Brick {

    private float height;
    private boolean direction;

    private int groundType;

    private final int GT_EMPTY = 0;
    private final int GT_DIRT  = 1;
    private final int GT_GRASS = 2;
    private final int GT_WATER = 9;

    public Brick(int level, int groundType) {
        this.height = level * Core.TILE_ELEV;
        this.groundType = groundType;

        if (this.groundType == GT_WATER) {
            height /= 2;
        }
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
    
    public int getGroundType() {
        return groundType;
    }

    public void setDirection(boolean direction) {
        this.direction = direction;
    }
}

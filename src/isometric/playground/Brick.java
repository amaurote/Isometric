package isometric.playground;

import isometric.Core;

/**
 *
 * @author AMAUROTE
 */
public class Brick {

    private int height;
    private boolean direction;
    private float pause;

    public Brick(int height, boolean direction) {
        this.height = height;
        this.direction = direction;

        this.pause = 0;
    }

    public int move() {
        if (pause > 0) {
            pause--;
            return height;
        }

        if (direction) {
            height++;
            if (height >= Core.TILE_MAX_ELEVATION) {
                direction = false;
            }
        } else {
            height--;
            if (height <= 0) {
                direction = true;
            }
        }

        if (height < 40) {
            pause = (40 - height) / 6;
        }

        if (Core.TILE_MAX_ELEVATION - height < 40) {
            pause = (40 - (Core.TILE_MAX_ELEVATION - height)) / 6;
        }

        return height;
    }

    public int getHeight() {
        return height;
    }
}

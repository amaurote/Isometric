package isometric.playground;

import isometric.Core;

/**
 *
 * @author AMAUROTE
 */
public class Brick {

    private int height;
    private boolean direction;
    private float fade;

    public Brick(int height, boolean direction) {
        this.height = height;
        this.direction = direction;

        this.fade = 0;
    }

    public int move() {
        if (fade > 0) {
            fade--;
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
            fade = (40 - height) / 7;
        }

        if (Core.TILE_MAX_ELEVATION - height < 40) {
            fade = (40 - (Core.TILE_MAX_ELEVATION - height)) / 7;
        }

        return height;
    }

    public int getHeight() {
        return height;
    }
}

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

    private float fade;
    private final int FADE_LIMIT = 40;
    private final int FADE_CORASE = 11;

    public Brick(int level, int type) {
        height = level * Core.TILE_ELEV;
        this.type = type;
    }

    @Deprecated
    public Brick(int height, boolean direction) {
        this.height = height;
        this.direction = direction;

        this.fade = 0;
    }

    public float move() {
        if (fade > 0) {
            fade = fade - 0.5f;
            return height;
        }

        if (direction) {
            height += 0.5f;
            if (height >= Core.TILE_MAX_ELEVATION) {
                direction = false;
            }
        } else {
            height -= 0.5f;
            if (height <= 0) {
                direction = true;
            }
        }

        if (height < FADE_LIMIT) {
            fade = (FADE_LIMIT - height) / FADE_CORASE;
        }

        if (Core.TILE_MAX_ELEVATION - height < FADE_LIMIT) {
            fade = (FADE_LIMIT - (Core.TILE_MAX_ELEVATION - height)) / FADE_CORASE;
        }

        return height;
    }

    public float getHeight() {
        return height;
    }
}

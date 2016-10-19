package isometric.gfx.sprites;

import java.awt.image.BufferedImage;

/**
 * Sprite Sheet BluePrint v1.0
 *
 * @author AMAUROTE
 */
public class SpriteSheet {

    ////////////////////////////////////////////////////////////////////////////
    // OBJECTS
    private final BufferedImage img;

    private final int spriteCountH;
    private final int spriteCountV;

    private final int spriteWidth;
    private final int spriteHeight;

    ////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    public SpriteSheet(BufferedImage img, int spriteCountH, int spriteCountV,
            int spriteWidth, int spriteHeight) {
        this.img = img;
        this.spriteCountH = spriteCountH;
        this.spriteCountV = spriteCountV;
        this.spriteWidth = spriteWidth;
        this.spriteHeight = spriteHeight;
    }

    public SpriteSheet(String imgPath, int spriteCountH, int spriteCountV,
            int spriteWidth, int spriteHeight) {
        this(ImageLoader.loadImage(imgPath), spriteCountH, spriteCountV,
                spriteWidth, spriteHeight);
    }

    ////////////////////////////////////////////////////////////////////////////
    // GETTERS
    public BufferedImage cropSprite(int index) {
        return cropSprite(index % spriteCountH, index / spriteCountH);
    }

    public BufferedImage cropSprite(int indexX, int indexY) {
        if (indexX >= spriteCountH || indexY >= spriteCountV
                || indexX < 0 || indexY < 0) {
            return null;
        } else {
            return img.getSubimage(indexX * spriteWidth, indexY * spriteHeight,
                    spriteWidth, spriteHeight);
        }
    }

}

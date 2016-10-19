package isometric.gfx.sprites;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 * Static Sprite Manager v1.0
 * 
 * @author AMAUROTE
 */
public class SpriteManager {
    private static List<SpriteSheet> spriteSheetList;
    
    public static void init() {
        spriteSheetList = new ArrayList<>();
    }
    
    public static void addSpriteSheet(SpriteSheet spriteSheet) {
        spriteSheetList.add(spriteSheet);
    }
    
    public static BufferedImage getSprite(int spriteSheetIndex, int spriteIndex) {
        return spriteSheetList.get(spriteSheetIndex).cropSprite(spriteIndex);
    }
    
    public static BufferedImage getSprite(int spriteSheetIndex, int spriteIndexX, int spriteIndexY) {
        return spriteSheetList.get(spriteSheetIndex).cropSprite(spriteIndexX, spriteIndexY);
    }
}

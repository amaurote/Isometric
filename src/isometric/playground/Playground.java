package isometric.playground;

import isometric.Core;

/**
 *
 * @author AMAUROTE
 */
public class Playground {

    private static Brick[][] bricks;
    private static Player player;

    private static int keyDelay;

    public static void init() {
        bricks = new Brick[Core.TILE_COUNT][Core.TILE_COUNT];
        player = new Player(Core.TILE_COUNT - 1, Core.TILE_COUNT - 1);

        keyDelay = 0;

        generate();
    }
    
    public static void update() {
        keyInput();
    }
    
    private static void generate() {
        for (int x = 0; x < Core.TILE_COUNT; x++) {
            for (int y = 0; y < Core.TILE_COUNT; y++) {
                bricks[x][y] = new Brick(Core.rand.nextInt(Core.TILE_MAX_ELEVATION),
                        Core.rand.nextBoolean());
            }
        }
    }
    
    private static void keyInput() {
        if (keyDelay <= 0) {
            
            // left
            if (Core.getKeyManager().left) {
                if (player.getX() > 0) {
                    if (bricks[player.getX()][player.getY()].getHeight()
                            >= bricks[player.getX() - 1][player.getY()].getHeight()) {
                        player.moveX();
                        keyDelay = 15;
                    }
                }
            }
            
            // right
            if (Core.getKeyManager().right) {
                if (player.getY() > 0) {
                    if (bricks[player.getX()][player.getY()].getHeight()
                            >= bricks[player.getX()][player.getY() - 1].getHeight()) {
                        player.moveY();
                        keyDelay = 15;
                    }
                }
            }
            
            // up
            if (Core.getKeyManager().up) {
                if (player.getX() > 0 && player.getY() > 0) {
                    if (bricks[player.getX()][player.getY()].getHeight()
                            >= bricks[player.getX() - 1][player.getY() - 1].getHeight()) {
                        player.moveX();
                        player.moveY();
                        keyDelay = 15;
                    }
                }
            }
            
        } else {
            keyDelay--;
        }
    }
    
    public static int getPlayerX() {
        return player.getX();
    }
    
    public static int getPlayerY() {
        return player.getY();
    }
    
    public static Brick getBrick(int x, int y) {
        return bricks[x][y];
    }
    
}

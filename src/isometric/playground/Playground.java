package isometric.playground;

import isometric.Core;

/**
 *
 * @author AMAUROTE
 */
public class Playground {

    private static Brick[][] bricks;
    private static Player player;

    private static final int MAX_KEY_DELAY = 15;
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
                bricks[x][y] = new Brick(1, 1);
            }
        }
    }

    private static void keyInput() {
        if (Core.getKeyManager().uparrow) {
            bricks[player.getX()][player.getY()].setDirection(true);
            bricks[player.getX()][player.getY()].move();
        }
        
        if (Core.getKeyManager().downarrow) {
            bricks[player.getX()][player.getY()].setDirection(false);
            bricks[player.getX()][player.getY()].move();
        }
        
        if (keyDelay <= 0) {
            
            //TODO nech sa 2 4 8 6 na okrajoch spravaju ako 1 3 7 9
            
            // up left
            if (Core.getKeyManager().upleft) {
                if (player.getX() > 0) {
                    player.moveX(0);
                    keyDelay = MAX_KEY_DELAY;
                }
            }

            // up right
            if (Core.getKeyManager().upright) {
                if (player.getY() > 0) {
                    player.moveY(0);
                    keyDelay = MAX_KEY_DELAY;
                }
            }

            // down left
            if (Core.getKeyManager().downleft) {
                if (player.getX() < Core.TILE_COUNT && player.getY() < Core.TILE_COUNT - 1) {
                    player.moveY(1);
                    keyDelay = MAX_KEY_DELAY;
                }
            }

            // down right
            if (Core.getKeyManager().downright) {
                if (player.getY() < Core.TILE_COUNT && player.getX() < Core.TILE_COUNT - 1) {
                    player.moveX(1);
                    keyDelay = MAX_KEY_DELAY;
                }
            }

            // up
            if (Core.getKeyManager().up) {
                if (player.getX() > 0 && player.getY() > 0) {
                    player.moveX(0);
                    player.moveY(0);
                    keyDelay = MAX_KEY_DELAY;
                }
            }

            // down
            if (Core.getKeyManager().down) {
                if (player.getX() < Core.TILE_COUNT - 1 && player.getY() < Core.TILE_COUNT - 1) {
                    player.moveX(1);
                    player.moveY(1);
                    keyDelay = MAX_KEY_DELAY;
                }
            }

            // left
            if (Core.getKeyManager().left) {
                if (player.getX() > 0 && player.getY() < Core.TILE_COUNT - 1) {
                    player.moveX(0);
                    player.moveY(1);
                    keyDelay = MAX_KEY_DELAY;
                }
            }

            // right
            if (Core.getKeyManager().right) {
                if (player.getY() > 0 && player.getX() < Core.TILE_COUNT - 1) {
                    player.moveY(0);
                    player.moveX(1);
                    keyDelay = MAX_KEY_DELAY;
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

package isometric.playground;

import isometric.Core;
import isometric.input.KeyManager;

/**
 *
 * @author AMAUROTE
 */
public class Playground {

    private static Brick[][] bricks;
    private static Player player;

    private static final int MAX_KEY_DELAY = 15;
    private static int keyDelay;

    private static boolean changed;

    public static void init() {
        bricks = new Brick[Core.TILE_COUNT][Core.TILE_COUNT];
        player = new Player(Core.TILE_COUNT - 1, Core.TILE_COUNT - 1);

        keyDelay = 0;

        generate();

        boolean changed = true;
    }

    public static void update() {
        keyInput();
    }

    public static void onTime() {
        change();
    }

    public static void change() {
        changed = true;
    }

    private static void generate() {
        for (int x = 0; x < Core.TILE_COUNT; x++) {
            for (int y = 0; y < Core.TILE_COUNT; y++) {
                if(x == 14 || x == 15) {
                bricks[x][y] = new Brick(1, 9);
                } else if (x == 0 || x == 1 || x == 2){
                    bricks[x][y] = new Brick(1, 1);
                } else {
                    bricks[x][y] = new Brick(1, 2);
                }
            }
        }
    }

    private static void keyInput() {
        KeyManager keyManager = Core.getKeyManager();

        if (keyDelay <= 0) {
            if (player.getX() > 0) {
                if (keyManager.upleft || keyManager.up || keyManager.left || keyManager.leftarrow) {
                    player.moveX(0);
                    keyDelay = MAX_KEY_DELAY;
                }
            }
            if (player.getY() > 0) {
                if (keyManager.upright || keyManager.up || keyManager.right || keyManager.uparrow) {
                    player.moveY(0);
                    keyDelay = MAX_KEY_DELAY;
                }
            }
            if (player.getX() < Core.TILE_COUNT - 1) {
                if (keyManager.downright || keyManager.down || keyManager.right || keyManager.rightarrow) {
                    player.moveX(1);
                    keyDelay = MAX_KEY_DELAY;
                }
            }
            if (player.getY() < Core.TILE_COUNT - 1) {
                if (keyManager.downleft || keyManager.down || keyManager.left || keyManager.downarrow) {
                    player.moveY(1);
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

    public static boolean isChanged() {
        if (changed) {
            changed = false;
            return true;
        } else {
            return false;
        }
    }
}

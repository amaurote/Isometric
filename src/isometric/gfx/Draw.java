package isometric.gfx;

import isometric.Core;
import isometric.playground.Playground;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;

/**
 *
 * @author AMAUROTE
 */
public class Draw {

    private static int tileWidth = Core.TILE_WIDTH;
    private static int tileHeight = Core.TILE_HEIGHT;

    private static final boolean OUTLINE = false;

    public static void init() {
    
    }

    public static void update() {

    }

    public static void onTime() {
        
    }

    public static void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // coordinates translate: horizontal: to center; vertical: offset;
        g2.translate(Core.FRAME_WIDTH / 2, Core.VERTICAL_OFFSET);

        // draw
        for (int x = 0; x < Core.TILE_COUNT; x++) {
            for (int y = 0; y < Core.TILE_COUNT; y++) {
                drawBlock(g2, x, y, Playground.getBrick(x, y).move());
            }
        }
    }

    private static void drawBlock(Graphics2D g2, int x, int y, float z) {
        // translate
        int xOffset = (x - y) * tileWidth / 2;
        int yOffset = (x + y) * tileHeight / 2;
        g2.translate(xOffset, yOffset);
        
        // corase
        z = z / 100.0f;

        // set colors
        Color c_top = new Color(238, 238, 238);
        Color c_left = new Color(153, 153, 153);
        Color c_right = new Color(204, 204, 204);
        Color c_outline = new Color(221, 221, 221);

        // new paths
        GeneralPath p_top = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 4);
        GeneralPath p_left = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 4);
        GeneralPath p_right = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 4);

        // top path
        p_top.moveTo(0, -z * tileHeight);
        p_top.lineTo(tileWidth / 2, tileHeight / 2 - z * tileHeight);
        p_top.lineTo(0, tileHeight - z * tileHeight);
        p_top.lineTo(-tileWidth / 2, tileHeight / 2 - z * tileHeight);
        p_top.closePath();

        // left path
        p_left.moveTo(-tileWidth / 2, tileHeight / 2 - z * tileHeight);
        p_left.lineTo(0, tileHeight - z * tileHeight);
        p_left.lineTo(0, tileHeight);
        p_left.lineTo(-tileWidth / 2, tileHeight / 2);
        p_left.closePath();

        // right path
        p_right.moveTo(tileWidth / 2, tileHeight / 2 - z * tileHeight);
        p_right.lineTo(0, tileHeight - z * tileHeight);
        p_right.lineTo(0, tileHeight);
        p_right.lineTo(tileWidth / 2, tileHeight / 2);
        p_right.closePath();

        // fill paths
        if (Playground.getPlayerX() >= x && Playground.getPlayerY() >= y) {
            if (Playground.getPlayerX() == x && Playground.getPlayerY() == y) {
                g2.setPaint(Color.red);
            } else {
                g2.setPaint(c_top);
            }
            g2.fill(p_top);
            g2.setPaint(c_left);
            g2.fill(p_left);
            g2.setPaint(c_right);
            g2.fill(p_right);
        }

        // draw outline
        if (OUTLINE) {
            g2.setPaint(c_outline);
            g2.draw(p_top);
            g2.draw(p_left);
            g2.draw(p_right);
        }

        // re-set translation (VERY IMPORTANT)
        g2.translate(-xOffset, -yOffset);
    }

    @Deprecated
    private static void drawTile(Graphics2D g2, int x, int y) {
        // translate
        int xOffset = (x - y) * tileWidth / 2;
        int yOffset = (x + y) * tileHeight / 2;
        g2.translate(xOffset, yOffset);

        // new path
        GeneralPath path = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 4);

        path.moveTo(0, 0);
        path.lineTo(tileWidth / 2, tileHeight / 2);
        path.lineTo(0, tileHeight);
        path.lineTo(-tileWidth / 2, tileHeight / 2);
        path.closePath();

        // fill path
        g2.setPaint(Color.white);
        g2.fill(path);

        // draw outline
        if (OUTLINE) {
            g2.setPaint(Color.black);
            g2.draw(path);
        }

        // re-set translation (VERY IMPORTANT)
        g2.translate(-xOffset, -yOffset);
    }
}

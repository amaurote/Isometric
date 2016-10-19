package isometric.gfx.sprites;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Static Image Loader Class v1.0
 *
 * @author AMAUROTE
 */
public class ImageLoader {

    ////////////////////////////////////////////////////////////////////////////
    // LOAD IMAGE
    public static BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            System.out.println("File: " + path + "not found");
            e.printStackTrace();
        }
        return null;
    }
}

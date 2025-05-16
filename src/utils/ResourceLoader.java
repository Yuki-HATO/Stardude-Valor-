package utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ResourceLoader {
    public static BufferedImage loadImage(String path) {
        try {
            InputStream is = ResourceLoader.class.getResourceAsStream(path);
            if (is == null) throw new IOException("Resource not found: " + path);
            return ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}


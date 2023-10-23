package com.NeoSlither.Utilities;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Logo {
    public BufferedImage logo;

    public Logo() {
        try {
            logo = ImageIO.read(new File("src/main/resources/logo.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

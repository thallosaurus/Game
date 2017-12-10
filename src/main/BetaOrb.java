package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

class BetaOrb {
    BufferedImage orbSprite = null;
    int x;
    int y;
    public int h = 32;
    public int w = 32;
    public BetaOrb(int xp, int yp) {
        x = xp*32;
        y = yp*32;
        loadOrbAsset();
    }

    public void loadOrbAsset() {
		File f = new File("BetaOrb.png");
		if (f.exists()) {
			try {
				orbSprite = ImageIO.read(f);	
				System.out.print("Loaded Orb");
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} else {
			System.out.println("Orb is missing");
		}
	}
}
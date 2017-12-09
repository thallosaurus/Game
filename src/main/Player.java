package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class Player {
	
	final int DOWN = 0;
	final int LEFT = 1;
	final int UP = 2;
	final int RIGHT = 3;
	
	public ArrayList<BufferedImage> files = new ArrayList<BufferedImage>();
	public int degree = 0;
	
	public int x = 0;
	public int y = x;
	
	public boolean moveable = true;
	
	public Player() {
		loadPlayerAssets();
	}
	
	public void loadPlayerAssets() {
		for (int i=0; i<=3; i++) {
			File f = new File("player"+i+".png");
			if (f.exists()) {
				try {
					BufferedImage __buf = ImageIO.read(f);	
					files.add(__buf);
					System.out.print("Loaded " + i);
				} catch (IOException ioe) {
					ioe.printStackTrace();
				}
			} else {
				System.out.println(i+" is missing");
			}
		}
	}
	
	public int changeDegree(String deg) {
		System.out.println(deg);
		switch (deg) {
		case "down":
			degree = 0;
			if ((this.y + 96 < 640)) {
				this.y = this.y + 32;
			}
			break;
			
		case "left":
			degree = 1;
			if ((this.x > 0)) {
				this.x = this.x - 32;
			}
			break;
			
		case "up":
			degree = 2;	
			if ((this.y > 0)) {
				this.y = this.y - 32;
			} else {
				//do nothing
			}
			break;
		
		case "right":
			degree = 3;
			if ((this.x + 64 < 800)) {
				this.x = this.x + 32;
			}
			break;
		}
		return degree;
	}
	
	public String toString() {
		return files.toString();
	}
}
/*
degrees:
 - 0: 0 degrees
 - 1: 90 degrees
 - 2: 180 degrees
 - 3: 270 degrees
*/
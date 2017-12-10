package main;

import java.awt.Color;
import java.awt.Rectangle;

public class Wall extends Rectangle {
	public int w;
	public int h;
	public int x;
	public int y;
	Color c = null;
	
	public int up;
	public int down;
	public int left;
	public int right;
	
	public Wall(int xpos, int ypos) {
		w = 32;
		h = 32;
		x = xpos*32;
		y = ypos*32;
		c = Color.WHITE;
		calcDimension();
	}
	
	public void calcDimension() {
		up = y;
		down = y+h;
		left = x;
		right = x+w;
	}
}

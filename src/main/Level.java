package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import main.Wall;
import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import main.MapHandler;

public class Level {
	ArrayList<Wall> walls = null;
	int[] startpoint = {0, 0};
	
	public final int maxParserWidth = 24;
	public final int  maxParserHeight = 18;
	
	public Level(int lvl) {
		//walls = new ArrayList<Wall>();
		//init(lvl);
		MapHandler map = new MapHandler();
		walls = map.init(lvl);
	}
	
	public int checkCollision(int x, int y) {
		for (int i = 0; i < walls.size(); i++) {
			if (y + 32> walls.get(i).y && y < walls.get(i).y+walls.get(i).h && x + 32 > walls.get(i).x && x < walls.get(i).x + walls.get(i).w) {
				//x > walls.get(i).left && walls.get(i).right > x
					System.out.println("Collision with " + i + "at " + walls.get(i).x + ":" + walls.get(i).y);
					System.out.println("Own Position: " + x+":"+y);
					return i;
			}
		}
		return -1;
	}
}
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

public class Level {
	public ArrayList<Wall> walls;
	int[] startpoint = {0, 0};
	
	public final int maxParserWidth = 24;
	public final int  maxParserHeight = 18;
	
	public Level(int lvl) {
		walls = new ArrayList<Wall>();
		init(lvl);
	}
	private void init(int lvl) {
		ArrayList<String> WallBuffer = new ArrayList<String>();
		File level = new File("level"+lvl);
		LineIterator it;
		
		try {
			it = FileUtils.lineIterator(level, "UTF-8");
			try {
				while (it.hasNext()) {
					WallBuffer.add(it.nextLine());
				}
			} finally {
				it.close();
				paintLevel(WallBuffer);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int checkCollision(int x, int y) {
		for (int i = 0; i < walls.size(); i++) {
			if (y + 17 > walls.get(i).up && walls.get(i).down > y) {
				System.out.println("Collision with " + i);
				return i;
			}
			/* if (x + 16> walls.get(i).x) {
				if (walls.get(i).x + walls.get(i).w < x) {
					if (y + 16> walls.get(i).y) {
						if (walls.get(i).y + walls.get(i).h < y) {
							System.out.println("Coll with " +i);
							return i;
						}
						return i;
					}
				} */
		}
		return -1;
	}
	
	public void paintLevel(ArrayList<String> lvl) {
		/* for (int vertical = 0; vertical<lvl.size(); vertical++) {
			System.out.println(lvl.get(vertical));
		} */
		
		for (int index = 0; index<lvl.size(); index++) {
			for (int indexOfChar = 0; indexOfChar < lvl.get(index).length(); indexOfChar++) {
				int s = lvl.get(index).codePointAt(indexOfChar);
				if (s == 49) {
					walls.add(new Wall(indexOfChar, index));
					System.out.println("Found Wall at ("+index+"/"+indexOfChar+")");
					
				}
			}
		}
	}
}

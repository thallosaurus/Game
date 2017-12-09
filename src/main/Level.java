package main;

import java.util.ArrayList;
import main.Wall;

public class Level {
	public ArrayList<Wall> walls;
	int[] startpoint = {0, 0};
	
	public Level() {
		walls = new ArrayList<Wall>();
		init();
	}
	private void init() {
		// TODO Auto-generated method stub
		walls.add(new Wall(4, 4));
		walls.add(new Wall(5, 5));
		walls.add(new Wall(6, 6));
		walls.add(new Wall(4, 5));
		walls.add(new Wall(4, 6));
		System.out.println(walls.size());
	}
	
	public int checkCollision(int x, int y) {
		for (int i = 0; i < walls.size(); i++) {
			if (x+32 > walls.get(i).x && x - 16 < walls.get(i).x+walls.get(i).w) {
				if (y+32 > walls.get(i).y && y-16 < walls.get(i).y+walls.get(i).w) {
					System.out.println("Collision with " + i);
					return i;
				} else {
					return -1;
				}
			}
		}
		return -1;
	}
}

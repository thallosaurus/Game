package main;

import java.awt.Color;
import java.awt.Graphics;
import main.Player;
import javax.swing.JPanel;
import main.Level;

public class Sheet extends JPanel {


	Player p;
	
	int maxHeight = 500;
	int maxWidth = 500;
	
	Level lvl;
	public Sheet(Player pl) {
		p = pl;
		lvl = new Level(1);
	}
	
	@Override
	public void paint(Graphics g) {
		//add drawing functions here
		this.repaint();
		checkCollision();
		drawBackground(g);
		drawLevel(g);
		g.drawImage(p.files.get(p.degree), p.x, p.y, null);
	}
	
	private void drawBackground(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 600);
	}
	
	private void drawLevel(Graphics g) {
		for(int i = 0; i < lvl.walls.size(); i++) {
			g.setColor(lvl.walls.get(i).c);
			g.fillRect(lvl.walls.get(i).x, lvl.walls.get(i).y, lvl.walls.get(i).w, lvl.walls.get(i).h);
		}
	}
	
	private void checkCollision() {
		if (!(lvl.checkCollision(p.x, p.y) == -1)) {
			p.x = lvl.startpoint[0];
			p.y = lvl.startpoint[1];
		}
	}

	public void changeDegree(String deg) {
		p.changeDegree(deg);
		}
	}

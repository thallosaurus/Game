package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import main.Player;

public class main extends JFrame implements KeyListener {

	Sheet s = null;
	public main(String title) {
		super(title);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(800, 640);
		setLocationRelativeTo(null);
		s = new Sheet(new Player());
		
		add(s);
		
		addKeyListener(this);
		setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main("Zeichnen");
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getKeyCode()) {
		case 38:
			s.changeDegree("up");
			break;
		case 40:
			s.changeDegree("down");
			break;
		case 37:
			s.changeDegree("left");
			break;
		case 39:
			s.changeDegree("right");
			break;
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
}

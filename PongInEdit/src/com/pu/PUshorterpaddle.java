package com.pu;

import java.awt.*;
import java.util.*;

import com.brocode.GamePanel;

public class PUshorterpaddle extends PowerUp{

//	Random random;
//	int xVelocity;
//	int yVelocity;
//	int initialSpeed = 4;
	
	public PUshorterpaddle(GamePanel panel, int x, int y, int width, int height){
		super(panel, x, y, width, height);
//		random = new Random();
//		int randomXDirection = random.nextInt(2);
//		if(randomXDirection == 0)
//			randomXDirection--;
//		setXDirection(randomXDirection*initialSpeed);
		
	}
//	
//	public void setXDirection(int randomXDirection) {
//		xVelocity = randomXDirection;
//	}
//
//	public void move() {
//		x += xVelocity;
//		y += yVelocity;
//	}
	public void draw(Graphics g) {
//		g.setColor(Color.WHITE);
//		g.fillRect(x, y, width, height);
//		g.drawImage(panel.pushorter, x, y, panel);
		g.drawImage(panel.pushorter, x, y, width, height, panel);
	}
}
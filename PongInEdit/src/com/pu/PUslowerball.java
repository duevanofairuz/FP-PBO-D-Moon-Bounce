package com.pu;

import java.awt.*;
import java.util.*;

import com.brocode.GamePanel;

public class PUslowerball extends PowerUp{

//	Random random;
//	int xVelocity;
//	int yVelocity;
//	int initialSpeed = 4;
	
	public PUslowerball(GamePanel panel, int x, int y, int width, int height){
		super(panel, x, y, width, height);
//		random = new Random();
//		int randomXDirection = random.nextInt(2);
//		if(randomXDirection == 0)
//			randomXDirection--;
//		setXDirection(randomXDirection*initialSpeed);
		
//		int randomYDirection = random.nextInt(2);
//		if(randomYDirection == 0)
//			randomYDirection--;
//		setYDirection(randomYDirection*initialSpeed);
		
	}
	
//	public void setXDirection(int randomXDirection) {
//		xVelocity = randomXDirection;
//	}
//	public void setYDirection(int randomYDirection) {
//		yVelocity = randomYDirection;
//	}
//	public void move() {
//		x += xVelocity;
//		y += yVelocity;
//	}
	public void draw(Graphics g) {
//		g.setColor(Color.ORANGE);
//		g.fillRect(x, y, width, height);
		g.drawImage(panel.puslower, x, y, width, height, panel);
	}
}

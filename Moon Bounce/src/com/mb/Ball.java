package com.mb;

import java.awt.*;
import java.util.*;

public class Ball extends Rectangle{

	GamePanel panel;
	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 2;
	
	Ball(GamePanel panel, int x, int y, int width, int height){
		super(x,y,width,height);
		this.panel = panel;
		random = new Random();
		int randomXDirection = random.nextInt(2);
		if(randomXDirection == 0)
			randomXDirection--;
		setXDirection(randomXDirection*initialSpeed);
		
		int randomYDirection = random.nextInt(2);
		if(randomYDirection == 0)
			randomYDirection--;
		setYDirection(randomYDirection*initialSpeed);
		
	}
	
	public void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection;
	}
	public void setYDirection(int randomYDirection) {
		yVelocity = randomYDirection;
	}
	public void move() {
		x += xVelocity;
		y += yVelocity;
	}
	
	public void draw(Graphics g) {
		if(panel.skinState == 0) {
			g.drawImage(panel.ball1, x, y, width, height, panel);
		}
		else if(panel.skinState == 1) {
			g.drawImage(panel.ball2, x, y, width, height, panel);
		}
		else if(panel.skinState == 2) {
			g.drawImage(panel.ball3, x, y, width, height, panel);
		}
	}
}

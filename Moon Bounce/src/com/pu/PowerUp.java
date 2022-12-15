package com.pu;

import java.awt.*;
import java.util.*;

import com.mb.GamePanel;

public abstract class PowerUp extends Rectangle{

	GamePanel panel;
	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 4;
	
	public PowerUp(GamePanel panel, int x, int y, int width, int height){
		super(x, y, width, height);
		this.panel = panel;
		random = new Random();
		int randomXDirection = random.nextInt(2);
		if(randomXDirection == 0)
			randomXDirection--;
		setXDirection(randomXDirection*initialSpeed);
		
	}
	
	public void setXDirection(int randomXDirection) {
		xVelocity = randomXDirection;
	}

	public void move() {
		x += xVelocity;
		y += yVelocity;
	}
	public abstract void draw(Graphics g);
}

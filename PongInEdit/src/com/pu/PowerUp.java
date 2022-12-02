package com.pu;

import java.awt.*;
import java.util.*;

public abstract class PowerUp extends Rectangle{

	Random random;
	int xVelocity;
	int yVelocity;
	int initialSpeed = 4;
	
	public PowerUp(int x, int y, int width, int height){
		super(x,y,width,height);
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

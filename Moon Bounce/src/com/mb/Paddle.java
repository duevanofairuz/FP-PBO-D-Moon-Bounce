package com.mb;

import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle{

	GamePanel panel;
	int id;
	int yVelocity;
	int speed = 10;
	
	Paddle(GamePanel panel, int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
		super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
		this.panel = panel;
		this.id=id;
	}
	
	public void keyPressed(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(-speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(speed);
			}
			break;
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(-speed);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(speed);
			}
			break;
		}
	}
	public void keyReleased(KeyEvent e) {
		switch(id) {
		case 1:
			if(e.getKeyCode()==KeyEvent.VK_W) {
				setYDirection(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_S) {
				setYDirection(0);
			}
			break;
		case 2:
			if(e.getKeyCode()==KeyEvent.VK_UP) {
				setYDirection(0);
			}
			if(e.getKeyCode()==KeyEvent.VK_DOWN) {
				setYDirection(0);
			}
			break;
		}
	}
	public void setYDirection(int yDirection) {
		yVelocity = yDirection;
	}
	public void move() {
		y= y + yVelocity;
	}
	public void draw(Graphics g) {
		if(id==1) {
			if(panel.skinState == 0) {
				g.drawImage(panel.paddle1s1, x, y, width, height, panel);
			}
			else if(panel.skinState == 1) {
				g.drawImage(panel.paddle1s2, x, y, width, height, panel);
			}
			else if(panel.skinState == 2) {
				g.drawImage(panel.paddle1s3, x, y, width, height, panel);
			}
		}
		else
			if(panel.skinState == 0) {
			g.drawImage(panel.paddle2s1, x, y, width, height, panel);
		}
		else if(panel.skinState == 1) {
			g.drawImage(panel.paddle2s2, x, y, width, height, panel);
		}
		else if(panel.skinState == 2) {
			g.drawImage(panel.paddle2s3, x, y, width, height, panel);
		}
	}
}

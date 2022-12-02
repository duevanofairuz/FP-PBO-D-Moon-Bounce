package com.brocode;

public class Collision {
	GamePanel panel;
	
	public Collision(GamePanel panel) {
		this.panel = panel;
	}
	@SuppressWarnings("static-access")
	public void checkCollision() {
		
		//bounce ball off top & bottom window edges
		if(panel.ball.y <=0) {
			panel.ball.setYDirection(-panel.ball.yVelocity);
		}
		if(panel.ball.y >= panel.GAME_HEIGHT-panel.BALL_DIAMETER) {
			panel.ball.setYDirection(-panel.ball.yVelocity);
		}
		
		
		//bounce ball off paddles
		if(panel.ball.intersects(panel.paddle1)) {
			panel.ball.xVelocity = Math.abs(panel.ball.xVelocity);
			panel.ball.xVelocity++; //optional for more difficulty
			if(panel.ball.yVelocity>0)
				panel.ball.yVelocity++; //optional for more difficulty
			else
				panel.ball.yVelocity--;
			panel.ball.setXDirection(panel.ball.xVelocity);
			panel.ball.setYDirection(panel.ball.yVelocity);
		}
		if(panel.ball.intersects(panel.paddle2)) {
			panel.ball.xVelocity = Math.abs(panel.ball.xVelocity);
			panel.ball.xVelocity++; //optional for more difficulty
			if(panel.ball.yVelocity>0)
				panel.ball.yVelocity++; //optional for more difficulty
			else
				panel.ball.yVelocity--;
			panel.ball.setXDirection(-panel.ball.xVelocity);
			panel.ball.setYDirection(panel.ball.yVelocity);
		}
		//stops paddles at window edges
		if(panel.paddle1.y<=0)
			panel.paddle1.y=0;
		if(panel.paddle1.y >= (panel.GAME_HEIGHT-panel.paddle1.height))
			panel.paddle1.y = panel.GAME_HEIGHT-panel.paddle1.height;
		if(panel.paddle2.y<=0)
			panel.paddle2.y=0;
		if(panel.paddle2.y >= (panel.GAME_HEIGHT-panel.paddle2.height))
			panel.paddle2.y = panel.GAME_HEIGHT-panel.paddle2.height;
		//give a player 1 point and creates new paddles & ball
		if(panel.ball.x <=0) {
			panel.score.player2++;
			panel.newPaddles();
			
			panel.BALL_DIAMETER=40;
			panel.ball.setSize(panel.BALL_DIAMETER, panel.BALL_DIAMETER);
			
			panel.newBall();
			panel.newPowerUp();
			System.out.println("Player 2: "+panel.score.player2);
		}
		if(panel.ball.x >= panel.GAME_WIDTH-panel.BALL_DIAMETER) {
			panel.score.player1++;
			panel.newPaddles();
			
			panel.BALL_DIAMETER=40;
			panel.ball.setSize(panel.BALL_DIAMETER, panel.BALL_DIAMETER);
			
			panel.newBall();
			panel.newPowerUp();
			System.out.println("Player 1: "+panel.score.player1);
		}
		
		/*kolisi pubigger*/
		if(panel.powerup[0].intersects(panel.paddle1)) {
			
			panel.ball.setSize(panel.BALL_BIG, panel.BALL_BIG);
			panel.BALL_DIAMETER=panel.BALL_BIG;
			panel.powerup[0].setSize(0, 0);
		}
		if(panel.powerup[0].intersects(panel.paddle2)) {
			
			panel.ball.setSize(panel.BALL_BIG, panel.BALL_BIG);
			panel.BALL_DIAMETER=panel.BALL_BIG;
			panel.powerup[0].setSize(0, 0);
		}
		
		/*kolisi pusmaller*/
		if(panel.powerup[1].intersects(panel.paddle1)) {
			
			panel.ball.setSize(panel.BALL_SMALL, panel.BALL_SMALL);
			panel.BALL_DIAMETER=panel.BALL_SMALL;
			panel.powerup[1].setSize(0, 0);
		}
		if(panel.powerup[1].intersects(panel.paddle2)) {
			
			panel.ball.setSize(panel.BALL_SMALL, panel.BALL_SMALL);
			panel.BALL_DIAMETER=panel.BALL_SMALL;
			panel.powerup[1].setSize(0, 0);
		}
		
		/*kolisi fasterball*/
		if(panel.powerup[2].intersects(panel.paddle1)) {
			
			panel.ball.xVelocity = panel.ball.xVelocity*4;
			panel.ball.yVelocity = panel.ball.yVelocity*4;
			panel.powerup[2].setSize(0, 0);
		}
		if(panel.powerup[2].intersects(panel.paddle2)) {
			
			panel.ball.xVelocity = panel.ball.xVelocity*4;
			panel.ball.yVelocity = panel.ball.yVelocity*4;
			panel.powerup[2].setSize(0, 0);
		}
		
		/*kolisi slowerball*/
		if(panel.powerup[3].intersects(panel.paddle1)) {
			
			panel.ball.xVelocity = panel.ball.xVelocity/2;
			panel.ball.yVelocity = panel.ball.yVelocity/2;
			panel.powerup[3].setSize(0, 0);
		}
		if(panel.powerup[3].intersects(panel.paddle2)) {
			
			panel.ball.xVelocity = panel.ball.xVelocity/2;
			panel.ball.yVelocity = panel.ball.yVelocity/2;
			panel.powerup[3].setSize(0, 0);
		}
		
		/*kolisi longerpaddle*/
		if(panel.powerup[4].intersects(panel.paddle1)) {
			panel.paddle1.height=200;
			panel.powerup[4].setSize(0, 0);
		}
		if(panel.powerup[4].intersects(panel.paddle2)) {
			panel.paddle2.height=200;
			panel.powerup[4].setSize(0, 0);
		}
		
		/*kolisi shorterpaddle*/
		if(panel.powerup[5].intersects(panel.paddle1)) {
			panel.paddle1.height=50;
			panel.powerup[5].setSize(0, 0);
		}
		if(panel.powerup[5].intersects(panel.paddle2)) {
			panel.paddle2.height=50;
			panel.powerup[5].setSize(0, 0);
		}
		
	}
}

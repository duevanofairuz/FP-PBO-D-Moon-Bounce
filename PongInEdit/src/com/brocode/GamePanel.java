package com.brocode;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;

import javax.swing.*;

import com.pu.PUbiggerball;
import com.pu.PUfasterball;
import com.pu.PUlongerpaddle;
import com.pu.PUshorterpaddle;
import com.pu.PUslowerball;
import com.pu.PUsmallerball;
import com.pu.PowerUp;

public class GamePanel extends JPanel implements Runnable{

	static final int GAME_WIDTH = 1280;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
	static final int PADDLE_WIDTH = 25;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	int BALL_DIAMETER = 40;
	int PADDLE_HEIGHT = 100;
	int BALL_BIG = 100;
	int BALL_SMALL = 20;
	
	// GAME STATE
	public int gameState;
	public final int titleState = 0;
	public final int playState = 1;
	public final int pauseState = 2;
	
	// GAME SYSTEM
	Collision collision = new Collision(this);
	UI ui = new UI(this, GAME_WIDTH, GAME_HEIGHT);
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	
	// GAME OBJECT
	Paddle paddle1;
	Paddle paddle2;
	Ball ball;
	Score score;
	
	// GAME ASSET
	Image background;
	Image logo;
	public Image pufaster;
	public Image puslower;
	public Image pulonger;
	public Image pushorter;
	public Image pubigger;
	public Image pusmaller;
	
	// GAME POWERUP
	PowerUp[] powerup;
	PUbiggerball pubiggerball;
	PUsmallerball pusmallerball;
	PUfasterball pufasterball;
	PUslowerball puslowerball;
	PUlongerpaddle pulongerpaddle;
	PUshorterpaddle pushorterpaddle;
	
	
	GamePanel(){
		newPaddles();
		newBall();
//		Timer timer = new Timer();
//		TimerTask taskpubig = new TimerTask() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				newPUbiggerball();
//			}
//			
//		};
//		timer.schedule(taskpubig, 0, 5000);
		
		/**/
//		newPUbiggerball();
//		newPUsmallerball();
//		newPUfasterball();
//		newPUslowerball();
//		newPUlongerpaddle();
//		newPUshorterpaddle();
		newPowerUp();
		
		score = new Score(GAME_WIDTH,GAME_HEIGHT);
		this.setFocusable(true);
		this.addKeyListener(new AL());
		this.setPreferredSize(SCREEN_SIZE);
		
		loadImage();
		gameState = titleState;
		
		gameThread = new Thread(this);
//		gameThread.start();
	}
	
	public void newBall() {
		random = new Random();
		ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
	}
	
	
	/**/
	public void newPowerUp() {
		random = new Random();
		powerup = new PowerUp[6];
		powerup[0] = new PUbiggerball(this, (GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG),PADDLE_WIDTH,BALL_BIG);
		powerup[1] = new PUsmallerball(this, (GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG),PADDLE_WIDTH,BALL_BIG);
		powerup[2] = new PUfasterball(this, (GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG),PADDLE_WIDTH,BALL_BIG);
		powerup[3] = new PUslowerball(this, (GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG),PADDLE_WIDTH,BALL_BIG);
		powerup[4] = new PUlongerpaddle(this, (GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG),PADDLE_WIDTH,BALL_BIG);
		powerup[5] = new PUshorterpaddle(this, (GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG),PADDLE_WIDTH,BALL_BIG);
	}
//	public void newPUbiggerball() {
//		random = new Random();
//		pubiggerball = new PUbiggerball((GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG),BALL_BIG,BALL_BIG);
//	}
//	public void newPUsmallerball() {
//		random = new Random();
//		pusmallerball = new PUsmallerball((GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG),BALL_BIG,BALL_BIG);
//	}
//	public void newPUfasterball() {
//		random = new Random();
//		pufasterball = new PUfasterball((GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG),BALL_BIG,BALL_BIG);
//	}
//	public void newPUslowerball() {
//		random = new Random();
//		puslowerball = new PUslowerball((GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG),BALL_BIG,BALL_BIG);
//	}
//	public void newPUlongerpaddle() {
//		random = new Random();
//		pulongerpaddle = new PUlongerpaddle((GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG),BALL_BIG,BALL_BIG);
//	}
//	public void newPUshorterpaddle() {
//		random = new Random();
//		pushorterpaddle = new PUshorterpaddle((GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG),BALL_BIG,BALL_BIG);
//	}
	
	
	public void newPaddles() {
		paddle1 = new Paddle(50,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
		paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH-50,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
	}
	
	public void paint(Graphics g) {
		
		image = createImage(getWidth(),getHeight());
		
		graphics = image.getGraphics();
		draw(graphics);
		g.drawImage(image,0,0,this);
	}
	
	public void loadImage() {
		ImageIcon bg = new ImageIcon("assets/bgspace1gelap.jpg");
		background = bg.getImage();
		ImageIcon lg = new ImageIcon("assets/moonbouncelogofix.png");
		logo = lg.getImage();
		ImageIcon fs = new ImageIcon("assets/fasterpaddle.png");
		pufaster = fs.getImage();
		ImageIcon sw = new ImageIcon("assets/slowerpaddle.png");
		puslower = sw.getImage();
		ImageIcon ln = new ImageIcon("assets/longerpaddle.png");
		pulonger = ln.getImage();
		ImageIcon sr = new ImageIcon("assets/shorterpaddle.png");
		pushorter = sr.getImage();
		ImageIcon br = new ImageIcon("assets/biggerpaddle.png");
		pubigger = br.getImage();
		ImageIcon sm = new ImageIcon("assets/smallerpaddle.png");
		pusmaller = sm.getImage();
	}
	
	public void draw(Graphics g) {
		if(gameState == titleState) {
			ui.gameOver(g);
		}else {
			g.drawImage(background, 1, 1, this);
			paddle1.draw(g);
			paddle2.draw(g);
			ball.draw(g);
			
			/**/
//			pubiggerball.draw(g);
//			pusmallerball.draw(g);
//			pufasterball.draw(g);
//			puslowerball.draw(g);
//			pulongerpaddle.draw(g);
//			pushorterpaddle.draw(g);
//			for(PowerUp pu : this.powerup) {
//				pu.draw(g);
//			}
			powerup[0].draw(g);
			
			score.draw(g);
			
			
			Toolkit.getDefaultToolkit().sync();
		}

	}
	public void move() {
		paddle1.move();
		paddle2.move();
		ball.move();
		
		/**/
//		pubiggerball.move();
//		pusmallerball.move();
//		pufasterball.move();
//		puslowerball.move();
//		pulongerpaddle.move();
//		pushorterpaddle.move();
//		for (PowerUp powerUp2 : powerup) {
//			powerUp2.move();
//		}
		powerup[0].move();
	}
//	public void checkCollision() {
//		
//		//bounce ball off top & bottom window edges
//		if(ball.y <=0) {
//			ball.setYDirection(-ball.yVelocity);
//		}
//		if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) {
//			ball.setYDirection(-ball.yVelocity);
//		}
//		
//		
//		//bounce ball off paddles
//		if(ball.intersects(paddle1)) {
//			ball.xVelocity = Math.abs(ball.xVelocity);
//			ball.xVelocity++; //optional for more difficulty
//			if(ball.yVelocity>0)
//				ball.yVelocity++; //optional for more difficulty
//			else
//				ball.yVelocity--;
//			ball.setXDirection(ball.xVelocity);
//			ball.setYDirection(ball.yVelocity);
//		}
//		if(ball.intersects(paddle2)) {
//			ball.xVelocity = Math.abs(ball.xVelocity);
//			ball.xVelocity++; //optional for more difficulty
//			if(ball.yVelocity>0)
//				ball.yVelocity++; //optional for more difficulty
//			else
//				ball.yVelocity--;
//			ball.setXDirection(-ball.xVelocity);
//			ball.setYDirection(ball.yVelocity);
//		}
//		//stops paddles at window edges
//		if(paddle1.y<=0)
//			paddle1.y=0;
//		if(paddle1.y >= (GAME_HEIGHT-paddle1.height))
//			paddle1.y = GAME_HEIGHT-paddle1.height;
//		if(paddle2.y<=0)
//			paddle2.y=0;
//		if(paddle2.y >= (GAME_HEIGHT-paddle2.height))
//			paddle2.y = GAME_HEIGHT-paddle2.height;
//		//give a player 1 point and creates new paddles & ball
//		if(ball.x <=0) {
//			score.player2++;
//			newPaddles();
//			
//			BALL_DIAMETER=40;
//			ball.setSize(BALL_DIAMETER, BALL_DIAMETER);
//			
//			newBall();
//			/**/
////			newPUbiggerball();
////			newPUsmallerball();
////			newPUfasterball();
////			newPUslowerball();
////			newPUlongerpaddle();
////			newPUshorterpaddle();
//			newPowerUp();
//			System.out.println("Player 2: "+score.player2);
//		}
//		if(ball.x >= GAME_WIDTH-BALL_DIAMETER) {
//			score.player1++;
//			newPaddles();
//			
//			BALL_DIAMETER=40;
//			ball.setSize(BALL_DIAMETER, BALL_DIAMETER);
//			
//			newBall();
//			/**/
////			newPUbiggerball();
////			newPUsmallerball();
////			newPUfasterball();
////			newPUslowerball();
////			newPUlongerpaddle();
////			newPUshorterpaddle();
//			newPowerUp();
//			System.out.println("Player 1: "+score.player1);
//		}
//		
//		/*kolisi pubigger*/
//		if(powerup[0].intersects(paddle1)) {
//			
//			ball.setSize(BALL_BIG, BALL_BIG);
//			BALL_DIAMETER=BALL_BIG;
//			powerup[0].setSize(0, 0);
//		}
//		if(powerup[0].intersects(paddle2)) {
//			
//			ball.setSize(BALL_BIG, BALL_BIG);
//			BALL_DIAMETER=BALL_BIG;
//			powerup[0].setSize(0, 0);
//		}
//		
//		/*kolisi pusmaller*/
//		if(powerup[1].intersects(paddle1)) {
//			
//			ball.setSize(BALL_SMALL, BALL_SMALL);
//			BALL_DIAMETER=BALL_SMALL;
//			powerup[1].setSize(0, 0);
//		}
//		if(powerup[1].intersects(paddle2)) {
//			
//			ball.setSize(BALL_SMALL, BALL_SMALL);
//			BALL_DIAMETER=BALL_SMALL;
//			powerup[1].setSize(0, 0);
//		}
//		
//		/*kolisi fasterball*/
//		if(powerup[2].intersects(paddle1)) {
//			
//			ball.xVelocity = ball.xVelocity*4;
//			ball.yVelocity = ball.yVelocity*4;
//			powerup[2].setSize(0, 0);
//		}
//		if(powerup[2].intersects(paddle2)) {
//			
//			ball.xVelocity = ball.xVelocity*4;
//			ball.yVelocity = ball.yVelocity*4;
//			powerup[2].setSize(0, 0);
//		}
//		
//		/*kolisi slowerball*/
//		if(powerup[3].intersects(paddle1)) {
//			
//			ball.xVelocity = ball.xVelocity/2;
//			ball.yVelocity = ball.yVelocity/2;
//			powerup[3].setSize(0, 0);
//		}
//		if(powerup[3].intersects(paddle2)) {
//			
//			ball.xVelocity = ball.xVelocity/2;
//			ball.yVelocity = ball.yVelocity/2;
//			powerup[3].setSize(0, 0);
//		}
//		
//		/*kolisi longerpaddle*/
//		if(powerup[4].intersects(paddle1)) {
//			paddle1.height=200;
//			powerup[4].setSize(0, 0);
//		}
//		if(powerup[4].intersects(paddle2)) {
//			paddle2.height=200;
//			powerup[4].setSize(0, 0);
//		}
//		
//		/*kolisi shorterpaddle*/
//		if(powerup[5].intersects(paddle1)) {
//			paddle1.height=50;
//			powerup[5].setSize(0, 0);
//		}
//		if(powerup[5].intersects(paddle2)) {
//			paddle2.height=50;
//			powerup[5].setSize(0, 0);
//		}
//		
//	}
	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks =60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(true) {
			long now = System.nanoTime();
			delta += (now -lastTime)/ns;
			lastTime = now;
			if(delta >=1) {
				move();
				collision.checkCollision();
				repaint();
				delta--;
			}
		}
	}
	public class AL extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			paddle1.keyPressed(e);
			paddle2.keyPressed(e);
			if(e.getKeyChar()=='\n') {
				gameState = playState;
				gameThread.start();
			}
		}
		public void keyReleased(KeyEvent e) {
			paddle1.keyReleased(e);
			paddle2.keyReleased(e);
		}
	}
}

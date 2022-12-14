package com.mb;

import java.awt.*;
import java.util.*;
//import java.util.Timer;

import javax.swing.*;

import com.pu.PUbiggerball;
import com.pu.PUfasterball;
import com.pu.PUlongerpaddle;
import com.pu.PUshorterpaddle;
import com.pu.PUslowerball;
import com.pu.PUsmallerball;
import com.pu.PowerUp;

public class GamePanel extends JPanel implements Runnable{

	// STATIC SIZE
	static final int GAME_WIDTH = 1280;
	static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555));
	static final int PADDLE_WIDTH = 25;
	static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
	
	// VARIABLE SIZE
	int BALL_DIAMETER = 40;
	int PADDLE_HEIGHT = 100;
	int BALL_BIG = 100;
	int BALL_SMALL = 20;
	int SCORE_WIDTH = 400;
	int SCORE_HEIGHT = 15;
	int SCORE_MIN = 80;
	
	// GAME STATE
	public int gameState;
	public int skinState;
	public int playerWon;
	public int pwrupIndx;
	public int optionNum = 0;
	public final int titleState = 0;
	public final int gPlayState = 1;
	public final int pauseState = 2;
	public final int guideState = 3;
	public final int alterState = 4;
	public final int gOverState = 5;

	// GAME SYSTEM
	Collision collision = new Collision(this);
	UI ui = new UI(this, GAME_WIDTH, GAME_HEIGHT);
	MusicPanel music = new MusicPanel();
	MusicPanel sfx = new MusicPanel();
	ImageLoader imgloader = new ImageLoader(this);
	Thread gameThread;
	Image image;
	Graphics graphics;
	Random random;
	
	// GAME OBJECT
	Paddle paddle1;
	Paddle paddle2;
	Score score1;
	Score score2;
	Ball ball;
	
	// GAME ASSET
	Image titlebg;
	Image gameover;
	Image guidescreen;
	Image themescreen;
	Image paddle1s1, paddle1s2, paddle1s3;
	Image paddle2s1, paddle2s2, paddle2s3;
	Image ball1, ball2, ball3;
	Image bgplay1, bgplay2, bgplay3;
	public Image pufaster;
	public Image puslower;
	public Image pulonger;
	public Image pushorter;
	public Image pubigger;
	public Image pusmaller;
	
	// GAME BUTTON
	Image menubutt;
	Image retrybutt;
	Image skinbutt;
	Image startbutt;
	Image infobutt;
	Image exitbutt;
	Image resumebutt;
	
	// GAME POWERUP
	PowerUp[] powerup;
	
	GamePanel(){
		newPaddles();
		newBall();
		newPowerUp();
		newScore();
		
		this.setFocusable(true);
		this.addKeyListener(new KeyPanel(this));
		this.setPreferredSize(SCREEN_SIZE);
		
		imgloader.loadImage();
		gameState = titleState;
		
		random = new Random();
		pwrupIndx = random.nextInt(6);
		
		playSound(0);
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	public void newBall() {
		random = new Random();
		ball = new Ball(this, (GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
	}
	
	/**/
	public void newPowerUp() {
		random = new Random();
		powerup = new PowerUp[6];
		powerup[0] = new PUbiggerball(this, (GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG), BALL_BIG, PADDLE_WIDTH);
		powerup[1] = new PUsmallerball(this, (GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG), BALL_BIG, PADDLE_WIDTH);
		powerup[2] = new PUfasterball(this, (GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG), BALL_BIG, PADDLE_WIDTH);
		powerup[3] = new PUslowerball(this, (GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG), BALL_BIG, PADDLE_WIDTH);
		powerup[4] = new PUlongerpaddle(this, (GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG), BALL_BIG, PADDLE_WIDTH);
		powerup[5] = new PUshorterpaddle(this, (GAME_WIDTH/2)-(BALL_BIG/2),random.nextInt(GAME_HEIGHT-BALL_BIG), BALL_BIG, PADDLE_WIDTH);
	}
		
	public void newPaddles() {
		paddle1 = new Paddle(this, 117,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
		paddle2 = new Paddle(this, GAME_WIDTH-PADDLE_WIDTH-120,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
	}
	
	public void newScore() {
		score1 = new Score(50+PADDLE_WIDTH*2, 10, SCORE_WIDTH, SCORE_HEIGHT, Color.white, 1, 0);
		score2 = new Score(GAME_WIDTH-PADDLE_WIDTH*4-SCORE_WIDTH, 10, SCORE_WIDTH, SCORE_HEIGHT, Color.white, 2, SCORE_WIDTH-90);
	}
	
	public void paint(Graphics g) {		
			image = createImage(getWidth(),getHeight());
			
			graphics = image.getGraphics();
			draw(graphics);
			g.drawImage(image,0,0,this);

	}
	
	public void draw(Graphics g) {
		if(gameState == titleState) {
			ui.titleScreen(g);
		}
		else if(gameState == guideState) {
			ui.guideScreen(g);
		}
		else if(gameState == alterState) {
			ui.alterScreen(g);
		}
		else if(gameState == pauseState) {
			ui.pauseScreen(g);
		}
		else if(gameState == gOverState) {
			ui.gOverScreen(g);
		}
		else {
			if(skinState == 0) {
				g.drawImage(bgplay1, 0, 0, this);
			}
			else if(skinState == 1) {
				g.drawImage(bgplay2, 0, 0, this);
			}
			else if(skinState == 2) {
				g.drawImage(bgplay3, 0, 0, this);
			}
			paddle1.draw(g);
			paddle2.draw(g);
			ball.draw(g);
			
			powerup[pwrupIndx].draw(g);			
			
			score1.draw(g);
			score2.draw(g);
//			for(PowerUp pu : this.powerup) {
//				pu.draw(g);
//			}
			Toolkit.getDefaultToolkit().sync();
		}

	}
	
	public void move() {
		if(gameState == gPlayState) {
			paddle1.move();
			paddle2.move();
			ball.move();
		
			powerup[pwrupIndx].move();
		}
		else if(gameState == pauseState) {
			
		}
	}
	
	public void playSound(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}
	public void playSFX(int i) {
		sfx.setFile(i);
		sfx.play();
	}
	public void stopSound() {
		music.stop();
	}

	public void run() {
		//game loop
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
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

}

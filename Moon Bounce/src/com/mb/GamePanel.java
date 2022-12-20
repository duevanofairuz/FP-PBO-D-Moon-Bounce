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
	Image logo;
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
	
	int n = 0;
	
	GamePanel(){
		newPaddles();
		newBall();
//		Timer timer = new Timer();
//		TimerTask taskpubig = new TimerTask() {
//			@Override
//			public void run() {
//				newPUbiggerball();
//			}
//		};
//		timer.schedule(taskpubig, 0, 5000);

		newPowerUp();
		newScore();
		
		this.setFocusable(true);
		this.addKeyListener(new KeyPanel(this));
		this.setPreferredSize(SCREEN_SIZE);
		
		loadImage();
		gameState = titleState;
		
		playSound(0);
		gameThread = new Thread(this);
		gameThread.start();
	}
	
//	public void setupGame() {
//		playSound(0);
//	}
	
	public void newBall() {
		random = new Random();
		ball = new Ball(this, (GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
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
	
	public void loadImage() {
		ImageIcon tb = new ImageIcon("assets/img/mainscreen.png");
		titlebg = tb.getImage();
		ImageIcon lg = new ImageIcon("assets/img/moonbouncelogofix.png");
		logo = lg.getImage();
		ImageIcon fs = new ImageIcon("assets/img/fasterpaddle.png");
		pufaster = fs.getImage();
		ImageIcon sw = new ImageIcon("assets/img/slowerpaddle.png");
		puslower = sw.getImage();
		ImageIcon ln = new ImageIcon("assets/img/longerpaddle.png");
		pulonger = ln.getImage();
		ImageIcon sr = new ImageIcon("assets/img/shorterpaddle.png");
		pushorter = sr.getImage();
		ImageIcon br = new ImageIcon("assets/img/biggerpaddle.png");
		pubigger = br.getImage();
		ImageIcon sm = new ImageIcon("assets/img/smallerpaddle.png");
		pusmaller = sm.getImage();
		ImageIcon gs = new ImageIcon("assets/img/menuinfoscreen.png");
		guidescreen = gs.getImage();
		ImageIcon go = new ImageIcon("assets/img/gameover.png");
		gameover = go.getImage();
		ImageIcon mn = new ImageIcon("assets/img/menubutt.png");
		menubutt = mn.getImage();
		ImageIcon rt = new ImageIcon("assets/img/retrybutt.png");
		retrybutt = rt.getImage();
		ImageIcon st = new ImageIcon("assets/img/startbutt.png");
		startbutt = st.getImage();
		ImageIcon in = new ImageIcon("assets/img/infobutt.png");
		infobutt = in.getImage();
		ImageIcon ex = new ImageIcon("assets/img/exitbutt.png");
		exitbutt = ex.getImage();
		ImageIcon rs = new ImageIcon("assets/img/resumebutt.png");
		resumebutt = rs.getImage();
		ImageIcon p1 = new ImageIcon("assets/img/paddle11.png");
		paddle1s1 = p1.getImage();
		ImageIcon p2 = new ImageIcon("assets/img/paddle21.png");
		paddle2s1 = p2.getImage();
		ImageIcon p3 = new ImageIcon("assets/img/paddle12.png");
		paddle1s2 = p3.getImage();
		ImageIcon p4 = new ImageIcon("assets/img/paddle22.png");
		paddle2s2 = p4.getImage();
		ImageIcon p5 = new ImageIcon("assets/img/paddle13.png");
		paddle1s3 = p5.getImage();
		ImageIcon p6 = new ImageIcon("assets/img/paddle23.png");
		paddle2s3 = p6.getImage();
		ImageIcon b1 = new ImageIcon("assets/img/moon10fps3.0.gif");
		ball1 = b1.getImage();
		ImageIcon b2 = new ImageIcon("assets/img/moonskin23.gif");
		ball2 = b2.getImage();
		ImageIcon b3 = new ImageIcon("assets/img/moonskin33.gif");
		ball3 = b3.getImage();
		ImageIcon g1 = new ImageIcon("assets/img/bgskin1+esc.png");
		bgplay1 = g1.getImage();
		ImageIcon g2 = new ImageIcon("assets/img/bgskin2+esc.png");
		bgplay2 = g2.getImage();
		ImageIcon g3 = new ImageIcon("assets/img/bgskin3+esc.png");
		bgplay3 = g3.getImage();
		ImageIcon th = new ImageIcon("assets/img/themescreen.png");
		themescreen = th.getImage();
		
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
			
			powerup[0].draw(g);			
			
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
		
			powerup[0].move();
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

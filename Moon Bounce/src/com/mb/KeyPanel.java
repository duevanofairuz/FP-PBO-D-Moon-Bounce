package com.mb;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class KeyPanel extends KeyAdapter {

	GamePanel panel;
	Random random;
	
	public KeyPanel(GamePanel panel) {
		this.panel = panel;
	}
	
	public void keyPressed(KeyEvent e) {
		
		// TITLE KEY
		if(panel.gameState == panel.titleState) {
			if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN) {
				panel.playSFX(5);
				panel.optionNum++;
				panel.repaint();
				if(panel.optionNum > 2) panel.optionNum = 0;
			}
			if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_UP) {
				panel.playSFX(5);
				panel.optionNum--;
				panel.repaint();
				if(panel.optionNum < 0) panel.optionNum = 2;
			}
			if(e.getKeyChar() == '\n') {
				panel.playSFX(1);
				if(panel.optionNum == 0) {
					panel.gameState = panel.alterState;
					panel.repaint();
				}
				if(panel.optionNum == 1) {
					panel.gameState = panel.guideState;
					panel.repaint();
				}
				if(panel.optionNum == 2) {
					System.exit(0);
				}
			}
		}
		
		// SKIN KEY
		else if(panel.gameState == panel.alterState) {
			if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN) {
				panel.playSFX(5);
				panel.optionNum++;
				panel.repaint();
				if(panel.optionNum > 2) panel.optionNum = 0;
			}
			if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_UP) {
				panel.playSFX(5);
				panel.optionNum--;
				panel.repaint();
				if(panel.optionNum < 0) panel.optionNum = 2;
			}
			if(e.getKeyChar() == '\n') {
				panel.playSFX(1);
				if(panel.optionNum == 0) {
					panel.skinState = 0;
					panel.gameState = panel.gPlayState;
					panel.repaint(); 
				}
				if(panel.optionNum == 1) {
					panel.skinState = 1;
					panel.gameState = panel.gPlayState;
					panel.repaint(); 
				}
				if(panel.optionNum == 2) {
					panel.skinState = 2;
					panel.gameState = panel.gPlayState;
					panel.repaint(); 
				}
			}
		}
		
		else if(panel.gameState == panel.guideState) {
			if(e.getKeyChar() == KeyEvent.VK_ESCAPE) {
				panel.gameState = panel.titleState;
				panel.repaint();
			}
		}
		
		else if(panel.gameState == panel.gPlayState) {
			if(e.getKeyChar() == KeyEvent.VK_ESCAPE) {
				panel.gameState = panel.pauseState;
				panel.repaint();
			}
			panel.paddle1.keyPressed(e);
			panel.paddle2.keyPressed(e);
		}
		
		else if(panel.gameState == panel.pauseState) {
			if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN) {
				panel.playSFX(5);
				panel.optionNum++;
				panel.repaint();
				if(panel.optionNum > 2) panel.optionNum = 0;
			}
			if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_UP) {
				panel.playSFX(5);
				panel.optionNum--;
				panel.repaint();
				if(panel.optionNum < 0) panel.optionNum = 2;
			}
			if(e.getKeyChar() == '\n') {
				panel.playSFX(1);
				if(panel.optionNum == 0) {
					panel.gameState = panel.gPlayState;
					panel.repaint();
				}
				if(panel.optionNum == 1) {
					panel.gameState = panel.gPlayState;
					panel.BALL_DIAMETER=40;
					panel.newBall();
					panel.newPaddles();
					panel.newPowerUp();
					panel.newScore();
					
					random = new Random();
					panel.pwrupIndx = random.nextInt(6);
					
					panel.repaint();
				}
				if(panel.optionNum == 2) {
					panel.gameState = panel.titleState;
					panel.BALL_DIAMETER=40;
					panel.newBall();
					panel.newPaddles();
					panel.newPowerUp();
					panel.newScore();
					
					random = new Random();
					panel.pwrupIndx = random.nextInt(6);
					
					panel.repaint();
				}
			}
		}
		
		else if(panel.gameState == panel.gOverState) {
			if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN) {
				panel.playSFX(5);
				panel.optionNum++;
				panel.repaint();
				if(panel.optionNum > 1) panel.optionNum = 0;
			}
			if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_UP) {
				panel.playSFX(5);
				panel.optionNum--;
				panel.repaint();
				if(panel.optionNum < 0) panel.optionNum = 1;
			}
			if(e.getKeyChar() == '\n') {
				panel.playSFX(1);
				if(panel.optionNum == 0) {
					panel.gameState = panel.gPlayState;
					panel.BALL_DIAMETER=40;
					panel.newBall();
					panel.newPaddles();
					panel.newPowerUp();
					panel.newScore();
					
					random = new Random();
					panel.pwrupIndx = random.nextInt(6);
					
					panel.repaint();
				}
				if(panel.optionNum == 1) {
					panel.gameState = panel.titleState;
					panel.BALL_DIAMETER=40;
					panel.newBall();
					panel.newPaddles();
					panel.newPowerUp();
					panel.newScore();
					
					random = new Random();
					panel.pwrupIndx = random.nextInt(6);
					
					panel.repaint();
				}

			}
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		panel.paddle1.keyReleased(e);
		panel.paddle2.keyReleased(e);
	}
}

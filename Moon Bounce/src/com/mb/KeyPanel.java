package com.mb;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyPanel extends KeyAdapter {

	GamePanel panel;
	
	public KeyPanel(GamePanel panel) {
		this.panel = panel;
	}
	
	public void keyPressed(KeyEvent e) {
		
		if(panel.gameState == panel.titleState) {
			if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN) {
				panel.optionNum++;
				panel.repaint();
				if(panel.optionNum > 2) panel.optionNum = 0;
			}
			if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_UP) {
				panel.optionNum--;
				panel.repaint();
				if(panel.optionNum < 0) panel.optionNum = 2;
			}
			if(e.getKeyChar() == '\n') {
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
		
		else if(panel.gameState == panel.alterState) {
			if(e.getKeyCode()==KeyEvent.VK_S || e.getKeyCode()==KeyEvent.VK_DOWN) {
				panel.optionNum++;
				panel.repaint();
				if(panel.optionNum > 1) panel.optionNum = 0;
			}
			if(e.getKeyCode()==KeyEvent.VK_W || e.getKeyCode()==KeyEvent.VK_UP) {
				panel.optionNum--;
				panel.repaint();
				if(panel.optionNum < 0) panel.optionNum = 1;
			}
			if(e.getKeyChar() == '\n') {
				if(panel.optionNum == 0) {
					panel.gameState = panel.playState;
					panel.gameThread.start();
				}
				if(panel.optionNum == 1) {
					panel.gameState = panel.titleState;
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
		
		else if(panel.gameState == panel.playState) {
			if(e.getKeyChar() == KeyEvent.VK_ESCAPE) {
//				panel.gameState = panel.titleState;
//				panel.repaint();
				System.exit(0);
			}
			if(e.getKeyChar() == KeyEvent.VK_SPACE) {
				panel.gameState = panel.pauseState;
			}
			panel.paddle1.keyPressed(e);
			panel.paddle2.keyPressed(e);
		}
		
		else if(panel.gameState == panel.pauseState) {
			if(e.getKeyChar() == KeyEvent.VK_SPACE) {
				panel.gameState = panel.playState;
			}
		}
		
	}
	
	public void keyReleased(KeyEvent e) {
		panel.paddle1.keyReleased(e);
		panel.paddle2.keyReleased(e);
	}
}

package com.mb;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class UI {
    GamePanel panel;
	int gWidth, gHeight;
	int y;
	
	public UI(GamePanel panel, int gWidth, int gHeight) {
		this.panel = panel;
		this.gWidth = gWidth;
		this.gHeight = gHeight;
	}
	
	public void titleScreen(Graphics g) {
        
		g.drawImage(panel.titlebg, 0, 0, panel);
//		g.drawImage(panel.logo, gWidth/2-100, gHeight/2-150, panel);

//		g.drawImage(panel.moonBounce, gWidth/2-50, gHeight/2-50, panel);		
//      String msg = "Player " + won + " Won!";
		
//        String msg = "Moon Bounce";
//        Font mfont = new Font("Eras Demi ITC", Font.BOLD, 35);
//        FontMetrics metr1 = g.getFontMetrics(mfont);
//
//        g.setFont(mfont);
//        g.setColor(Color.GRAY);
//        g.drawString(msg, ((gWidth - metr1.stringWidth(msg)) / 2) + 3, 155);
//        g.setColor(Color.WHITE);        
//        g.drawString(msg, (gWidth - metr1.stringWidth(msg)) / 2, 153);

		g.drawImage(panel.startbutt, (gWidth / 2) - (162 / 2), 325, 162, 90, panel);
		g.drawImage(panel.infobutt, (gWidth / 2) - (158 / 2), 405, 158, 90, panel);
		g.drawImage(panel.exitbutt, (gWidth / 2) - (158 / 2), 485, 158, 90, panel);
		
        String score = "Press 'Enter' to select!";
        Font sfont = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr2 = g.getFontMetrics(sfont);

        g.setFont(sfont);
        g.setColor(Color.GRAY);
        g.drawString(score, ((gWidth - metr2.stringWidth(score)) / 2) + 2, gHeight - 29);
        g.setColor(Color.WHITE);        
        g.drawString(score, (gWidth - metr2.stringWidth(score)) / 2, gHeight - 30);
        
        // draw selection
        g.setColor(Color.WHITE);
        if(panel.optionNum == 0) {
        	g.drawRoundRect(((gWidth / 2) - (162 / 2)) - 5, 325, 172, 76, 20, 20);
        }
        else if(panel.optionNum == 1) {
        	g.drawRoundRect(((gWidth / 2) - (158 / 2)) - 5, 405, 168, 76, 20, 20);
        }
        else if(panel.optionNum == 2) {
        	g.drawRoundRect(((gWidth / 2) - (158 / 2)) - 5, 485, 168, 76, 20, 20);
        }
        
    }
	
	public void guideScreen(Graphics g) {
		g.drawImage(panel.guidescreen, 0, 0, gWidth, gHeight, panel);
	}

	public void alterScreen(Graphics g) {
        
		g.drawImage(panel.titlebg, 0, 0, panel);
		
        String msg = "Skin Selection";
        Font mfont = new Font("Eras Demi ITC", Font.BOLD, 35);
        FontMetrics metr1 = g.getFontMetrics(mfont);

        g.setFont(mfont);
        g.setColor(Color.GRAY);
        g.drawString(msg, ((gWidth - metr1.stringWidth(msg)) / 2) + 3, 155);
        g.setColor(Color.WHITE);        
        g.drawString(msg, (gWidth - metr1.stringWidth(msg)) / 2, 153);

        String score = "Press 'Enter' to select!";
        Font sfont = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr2 = g.getFontMetrics(sfont);

        g.setFont(sfont);
        g.setColor(Color.GRAY);
        g.drawString(score, ((gWidth - metr2.stringWidth(score)) / 2) + 2, gHeight - 29);
        g.setColor(Color.WHITE);        
        g.drawString(score, (gWidth - metr2.stringWidth(score)) / 2, gHeight - 30);
        
        // draw option
        g.setColor(Color.GREEN);
        g.fillRoundRect((gWidth / 2) - 75, gHeight - 280, 150, 40, 20, 20);
        g.setColor(Color.RED);
        g.fillRoundRect((gWidth / 2) - 75, gHeight - 160, 150, 40, 20, 20);
        
        // draw selection
        g.setColor(Color.WHITE);
        if(panel.optionNum == 0) {
        	g.drawRoundRect((gWidth / 2) - 80, gHeight - 285, 160, 50, 20, 20);
        }
        else if(panel.optionNum == 1) {
        	g.drawRoundRect((gWidth / 2) - 80, gHeight - 165, 160, 50, 20, 20);
        }
        
    }
	
	public void pauseScreen(Graphics g) {
		
		g.setColor(new Color(0, 0, 0, 10));
		g.fillRect(0, 0, gWidth, gHeight);
		
        String msg = "Pause";
        Font mfont = new Font("Eras Demi ITC", Font.BOLD, 55);
        FontMetrics metr1 = g.getFontMetrics(mfont);

        g.setFont(mfont);
        g.setColor(Color.GRAY);
        g.drawString(msg, ((gWidth - metr1.stringWidth(msg)) / 2) + 3, 155);
        g.setColor(Color.WHITE);        
        g.drawString(msg, (gWidth - metr1.stringWidth(msg)) / 2, 153);

        String score = "Press 'Enter' to select!";
        Font sfont = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr2 = g.getFontMetrics(sfont);

        g.setFont(sfont);
        g.setColor(Color.GRAY);
        g.drawString(score, ((gWidth - metr2.stringWidth(score)) / 2) + 2, gHeight - 29);
        g.setColor(Color.WHITE);        
        g.drawString(score, (gWidth - metr2.stringWidth(score)) / 2, gHeight - 30);
        
        // draw option
        g.setColor(Color.GREEN);
        g.fillRoundRect((gWidth / 2) - 75, gHeight - 300, 150, 40, 20, 20);
        g.setColor(Color.YELLOW);
        g.fillRoundRect((gWidth / 2) - 75, gHeight - 240, 150, 40, 20, 20);
        g.setColor(Color.RED);
        g.fillRoundRect((gWidth / 2) - 75, gHeight - 180, 150, 40, 20, 20);
        
        // draw selection
        g.setColor(Color.WHITE);
        if(panel.optionNum == 0) {
        	g.drawRoundRect((gWidth / 2) - 80, gHeight - 305, 160, 50, 20, 20);
        }
        else if(panel.optionNum == 1) {
        	g.drawRoundRect((gWidth / 2) - 80, gHeight - 245, 160, 50, 20, 20);
        }
        else if(panel.optionNum == 2) {
        	g.drawRoundRect((gWidth / 2) - 80, gHeight - 185, 160, 50, 20, 20);
        }
        
    }
	
	public void gOverScreen(Graphics g) {
		
		g.drawImage(panel.gameover, 0, 0, panel);
		
		String msg = "Player " + panel.playerWon + " Won!";
        Font mfont = new Font("Eras Demi ITC", Font.BOLD, 55);
        FontMetrics metr1 = g.getFontMetrics(mfont);

        g.setFont(mfont);
        g.setColor(Color.GRAY);
        g.drawString(msg, ((gWidth - metr1.stringWidth(msg)) / 2) + 3, 155);
        g.setColor(Color.WHITE);        
        g.drawString(msg, (gWidth - metr1.stringWidth(msg)) / 2, 153);

        String score = "Press 'Enter' to select!";
        Font sfont = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr2 = g.getFontMetrics(sfont);

        g.setFont(sfont);
        g.setColor(Color.GRAY);
        g.drawString(score, ((gWidth - metr2.stringWidth(score)) / 2) + 2, gHeight - 29);
        g.setColor(Color.WHITE);        
        g.drawString(score, (gWidth - metr2.stringWidth(score)) / 2, gHeight - 30);
        
        // draw option
        g.drawImage(panel.menubutt, (gWidth / 2) - 75, gHeight - 300, 150, 40, panel);
        g.drawImage(panel.menubutt, (gWidth / 2) - 75, gHeight - 240, 150, 40, panel);
        
        // draw selection
        g.setColor(Color.WHITE);
        if(panel.optionNum == 0) {
        	g.drawRoundRect((gWidth / 2) - 80, gHeight - 305, 160, 50, 20, 20);
        }
        else if(panel.optionNum == 1) {
        	g.drawRoundRect((gWidth / 2) - 80, gHeight - 245, 160, 50, 20, 20);
        }
        
    }

}

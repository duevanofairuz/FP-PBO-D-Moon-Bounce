package com.mb;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class UI {
    GamePanel panel;
	int gWidth, gHeight;
	
	public UI(GamePanel panel, int gWidth, int gHeight) {
		this.panel = panel;
		this.gWidth = gWidth;
		this.gHeight = gHeight;
	}
	
	public void gameOver(Graphics g) {
        
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, gWidth, gHeight);
		

		g.drawImage(panel.logo, gWidth/2-100, gHeight/2-100, panel);

		//g.drawImage(panel.moonBounce, gWidth/2-50, gHeight/2-50, panel);

		
//      String msg = "Player " + won + " Won!";
		
        String msg = "Moon Bounce";
        Font mfont = new Font("Eras Demi ITC", Font.BOLD, 35);
        FontMetrics metr1 = g.getFontMetrics(mfont);

        g.setFont(mfont);
        g.setColor(Color.GRAY);
        g.drawString(msg, ((gWidth - metr1.stringWidth(msg)) / 2) + 3, 205);
        g.setColor(Color.WHITE);        
        g.drawString(msg, (gWidth - metr1.stringWidth(msg)) / 2, 203);

        String score = "Press 'Enter' to enter the game!";
        Font sfont = new Font("Helvetica", Font.BOLD, 14);
        FontMetrics metr2 = g.getFontMetrics(sfont);

        g.setFont(sfont);
        g.setColor(Color.GRAY);
        g.drawString(score, ((gWidth - metr2.stringWidth(score)) / 2) + 2, gHeight - 29);
        g.setColor(Color.white);        
        g.drawString(score, (gWidth - metr2.stringWidth(score)) / 2, gHeight - 30);
    }

}



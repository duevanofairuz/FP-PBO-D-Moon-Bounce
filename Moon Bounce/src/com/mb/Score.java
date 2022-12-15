package com.mb;

import java.awt.*;

public class Score extends Rectangle{

//	static int GAME_WIDTH;
//	static int GAME_HEIGHT;
//	int player1;
//	int player2;
//	
//	Score(int GAME_WIDTH, int GAME_HEIGHT){
//		Score.GAME_WIDTH = GAME_WIDTH;
//		Score.GAME_HEIGHT = GAME_HEIGHT;
//	}
//	public void draw(Graphics g) {
//		g.setColor(Color.white);
//		g.setFont(new Font("Consolas",Font.PLAIN,60));
//		
////		g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
//		
//		g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), (GAME_WIDTH/2)-85, 50);
//		g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), (GAME_WIDTH/2)+20, 50);
//	}
	
	int x, y, xstring; //posisi
	int xfill, yfill; //posisi untuk geser kanan score yg kanan(berkurang ke kanan) 
	int barRWidth, barRHeight; //border dari healthbar
	int barWidth, barHeight; //isi healthbar
	int player;
	Color color;
	
	public Score(int x, int y, int barWidth, int barHeight, Color color, int player, int xstring) {
		this.x=x;
		this.y=y;
		this.xfill=x;
		this.yfill=y;
		this.barRWidth=barWidth;
		this.barRHeight=barHeight;
		this.barWidth=barWidth;
		this.barHeight=barHeight;
		this.color=color;
		this.player=player;
		this.xstring=xstring;
	}
	public void draw(Graphics g) {
		g.setColor(color);
		g.setFont(new Font("Consolas",Font.PLAIN,20));
		g.drawString("Player "+String.valueOf(player), x+xstring, 50);
		g.drawRect(x, y, barRWidth, barRHeight);
		g.setColor(Color.red);
		g.fillRect(xfill+3, yfill+3, barWidth-5, barHeight-5);
	}
}

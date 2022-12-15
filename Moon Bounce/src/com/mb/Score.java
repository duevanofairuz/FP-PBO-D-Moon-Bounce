package com.mb;

import java.awt.*;

public class Score extends Rectangle{

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

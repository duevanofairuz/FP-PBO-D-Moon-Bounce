package com.pu;

import java.awt.*;

import com.mb.GamePanel;

public class PUsmallerball extends PowerUp{

	public PUsmallerball(GamePanel panel, int x, int y, int width, int height){
		super(panel, x, y, width, height);	
	}
	
	public void draw(Graphics g) {
		g.drawImage(panel.pusmaller, x, y, width, height, panel);
	}
}
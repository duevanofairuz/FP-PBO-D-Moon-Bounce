package com.pu;

import java.awt.*;

import com.mb.GamePanel;

public class PUbiggerball extends PowerUp{
	
	public PUbiggerball(GamePanel panel, int x, int y, int width, int height){
		super(panel, x, y, width, height);
	}

	public void draw(Graphics g) {
		g.drawImage(panel.pubigger, x, y, width, height, panel);
	}
}

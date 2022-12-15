package com.pu;

import java.awt.*;

import com.mb.GamePanel;

public class PUlongerpaddle extends PowerUp{
	
	public PUlongerpaddle(GamePanel panel, int x, int y, int width, int height){
		super(panel, x, y, width, height);
	}
	
	public void draw(Graphics g) {
		g.drawImage(panel.pulonger, x, y, width, height, panel);
	}
}

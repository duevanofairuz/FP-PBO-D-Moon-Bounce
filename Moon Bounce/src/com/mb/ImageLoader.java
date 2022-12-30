package com.mb;

import javax.swing.ImageIcon;

public class ImageLoader {

	GamePanel panel;
	
	public ImageLoader(GamePanel panel) {
		this.panel = panel;
	}
	
	public void loadImage() {
		ImageIcon tb = new ImageIcon("assets/img/mainscreen.png");
		panel.titlebg = tb.getImage();
		ImageIcon fs = new ImageIcon("assets/img/fasterpaddle.png");
		panel.pufaster = fs.getImage();
		ImageIcon sw = new ImageIcon("assets/img/slowerpaddle.png");
		panel.puslower = sw.getImage();
		ImageIcon ln = new ImageIcon("assets/img/longerpaddle.png");
		panel.pulonger = ln.getImage();
		ImageIcon sr = new ImageIcon("assets/img/shorterpaddle.png");
		panel.pushorter = sr.getImage();
		ImageIcon br = new ImageIcon("assets/img/biggerball.png");
		panel.pubigger = br.getImage();
		ImageIcon sm = new ImageIcon("assets/img/smallerball.png");
		panel.pusmaller = sm.getImage();
		ImageIcon gs = new ImageIcon("assets/img/menuinfoscreen.png");
		panel.guidescreen = gs.getImage();
		ImageIcon go = new ImageIcon("assets/img/gameover.png");
		panel.gameover = go.getImage();
		ImageIcon mn = new ImageIcon("assets/img/menubutt.png");
		panel.menubutt = mn.getImage();
		ImageIcon rt = new ImageIcon("assets/img/retrybutt.png");
		panel.retrybutt = rt.getImage();
		ImageIcon st = new ImageIcon("assets/img/startbutt.png");
		panel.startbutt = st.getImage();
		ImageIcon in = new ImageIcon("assets/img/infobutt.png");
		panel.infobutt = in.getImage();
		ImageIcon ex = new ImageIcon("assets/img/exitbutt.png");
		panel.exitbutt = ex.getImage();
		ImageIcon rs = new ImageIcon("assets/img/resumebutt.png");
		panel.resumebutt = rs.getImage();
		ImageIcon p1 = new ImageIcon("assets/img/paddle11.png");
		panel.paddle1s1 = p1.getImage();
		ImageIcon p2 = new ImageIcon("assets/img/paddle21.png");
		panel.paddle2s1 = p2.getImage();
		ImageIcon p3 = new ImageIcon("assets/img/paddle12.png");
		panel.paddle1s2 = p3.getImage();
		ImageIcon p4 = new ImageIcon("assets/img/paddle22.png");
		panel.paddle2s2 = p4.getImage();
		ImageIcon p5 = new ImageIcon("assets/img/paddle13.png");
		panel.paddle1s3 = p5.getImage();
		ImageIcon p6 = new ImageIcon("assets/img/paddle23.png");
		panel.paddle2s3 = p6.getImage();
		ImageIcon b1 = new ImageIcon("assets/img/moon10fps3.0.gif");
		panel.ball1 = b1.getImage();
		ImageIcon b2 = new ImageIcon("assets/img/moonskin23.gif");
		panel.ball2 = b2.getImage();
		ImageIcon b3 = new ImageIcon("assets/img/moonskin33.gif");
		panel.ball3 = b3.getImage();
		ImageIcon g1 = new ImageIcon("assets/img/bgskin1+esc.png");
		panel.bgplay1 = g1.getImage();
		ImageIcon g2 = new ImageIcon("assets/img/bgskin2+esc.png");
		panel.bgplay2 = g2.getImage();
		ImageIcon g3 = new ImageIcon("assets/img/bgskin3+esc.png");
		panel.bgplay3 = g3.getImage();
		ImageIcon th = new ImageIcon("assets/img/themescreen.png");
		panel.themescreen = th.getImage();
		
	}
}

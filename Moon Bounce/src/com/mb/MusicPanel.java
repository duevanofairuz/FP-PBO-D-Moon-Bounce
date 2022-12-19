package com.mb;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPanel {
	Clip clip;
	URL musicURL[] = new URL[31];
	
	public MusicPanel() {
		
//		musicURL[0] = getClass().getResource("/music/dark tides 8 bit.wav");
//		musicURL[1] = getClass().getResource("/music/cyberangel 8 bit.wav");
//		
//		musicURL[2] = getClass().getResource("/SE/Kiana1.wav");
//		musicURL[3] = getClass().getResource("/SE/Kiana7.wav");
//		musicURL[4] = getClass().getResource("/SE/Kiana8.wav");
//		musicURL[5] = getClass().getResource("/SE/Kiana3.wav");
//		musicURL[6] = getClass().getResource("/SE/Kiana2.wav");
//		musicURL[7] = getClass().getResource("/SE/Kiana4.wav");
//		musicURL[8] = getClass().getResource("/SE/Kiana6.wav");
//		musicURL[9] = getClass().getResource("/SE/Kiana5.wav");
//		musicURL[10] = getClass().getResource("/SE/Kiana9.wav");
//		
//		musicURL[11] = getClass().getResource("/SE/Mei1.wav");
//		musicURL[12] = getClass().getResource("/SE/Mei2.wav");
//		musicURL[13] = getClass().getResource("/SE/Mei3.wav");
//		musicURL[14] = getClass().getResource("/SE/Mei4.wav");
//		musicURL[15] = getClass().getResource("/SE/Mei5.wav");
//		musicURL[16] = getClass().getResource("/SE/Mei6.wav");
//		musicURL[17] = getClass().getResource("/SE/Mei7.wav");
//		musicURL[18] = getClass().getResource("/SE/Mei8.wav");
//		
//		musicURL[19] = getClass().getResource("/SE/Bronya1.wav");
//		musicURL[20] = getClass().getResource("/SE/Bronya2.wav");
//		musicURL[21] = getClass().getResource("/SE/Bronya3.wav");
//		musicURL[22] = getClass().getResource("/SE/Bronya4.wav");
//		musicURL[23] = getClass().getResource("/SE/Bronya5.wav");
//		musicURL[24] = getClass().getResource("/SE/Bronya6.wav");
//		musicURL[25] = getClass().getResource("/SE/Bronya7.wav");
//		musicURL[26] = getClass().getResource("/SE/Bronya8.wav");
//		
//		musicURL[27] = getClass().getResource("/SE/Button1.wav");
//		musicURL[28] = getClass().getResource("/SE/Button2.wav");
//		musicURL[29] = getClass().getResource("/SE/Select.wav");
//		
//		musicURL[30] = getClass().getResource("/SE/Heal.wav");
	}
	
	public void setFile(int i) {
	
		try {
			
			AudioInputStream ais = AudioSystem.getAudioInputStream(musicURL[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		}catch(Exception e) {
			
		}
	}
	
	public void play() {
		
		clip.start();
	}
	
	public void loop() {
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	
	public void stop() {
		
		clip.stop();
	}
}

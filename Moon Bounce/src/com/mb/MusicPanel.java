package com.mb;

import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class MusicPanel {
	Clip clip;
	URL musicURL[] = new URL[30];
	
	public MusicPanel() {
		
		musicURL[0] = getClass().getResource("assets/sound/bgmusicloop.wav");
		musicURL[1] = getClass().getResource("assets/sound/clickbutton.wav");
		musicURL[2] = getClass().getResource("assets/sound/moonbounc.wav");
		musicURL[3] = getClass().getResource("assets/sound/moondestroyed.wav");
		musicURL[4] = getClass().getResource("assets/sound/powerupsound.wav");
		musicURL[5] = getClass().getResource("assets/sound/switchbutton.wav");
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

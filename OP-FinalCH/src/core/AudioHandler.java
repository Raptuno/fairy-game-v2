package core;

import javafx.embed.swt.FXCanvas;
import javafx.scene.media.*;

public class AudioHandler {
	
	AudioClip ac;
	MediaPlayer mp;
	MediaView mv;
	Media battle;
	
	public void audioPlayer(String mediaMode, String gameMode, FXCanvas fxc) {
		switch(mediaMode) {
			case "MediaPlayer":
				if(fxc.isEnabled()) {
					battle=new Media(getClass().getClassLoader().getResource("media/battleLoop.mp3").toString());
					mp=new MediaPlayer(battle);
					mp.setCycleCount(MediaPlayer.INDEFINITE);
					mv=new MediaView(mp);
				}
				break;
			case "AudioClip":
				break;
		}
	}
}

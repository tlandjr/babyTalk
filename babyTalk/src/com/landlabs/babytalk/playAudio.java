package com.landlabs.babytalk;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;

public class playAudio {
	
	MediaPlayer mp;
	
	public void playSound(Context context,Uri fn){
		mp = MediaPlayer.create(context, fn);
		mp.start();
	}

}

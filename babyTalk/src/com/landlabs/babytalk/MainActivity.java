package com.landlabs.babytalk;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	private TTSManager tts;
	private STTManager stt;
	private playAudio audio;
	int flag;
	Handler mHandler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		stt = new STTManager(this);
		tts = new TTSManager(this);
		tts.initOrInstallTTS();
		audio = new playAudio();
		Uri phoneRing = Uri.parse("android.resource://com.landlabs.babytalk/"+R.raw.phone_ring);
		audio.playSound(this,phoneRing);
		mHandler = new Handler();
		
		answerPhone();
		getAnswer();
		getName();
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void answerPhone(){
		mHandler.postDelayed(new Runnable() {
	        public void run() 
	        {
	            tts.speak("Hello?");
	        }}, 3000);
		
		
		
	}
	
	public void getAnswer(){
		 
		mHandler.postDelayed(new Runnable() {
	        public void run() 
	        {					
				tts.speak("Who is this?");
		    }}, 1000);       
		
		mHandler.postDelayed(new Runnable() {
	        public void run() 
	        {
	            stt.start();
	            
	        }}, 1000);
				    	
	}
	
	public void getName(){
		mHandler.postDelayed(new Runnable() {
	        public void run() 
	        {
				String name = "";
				if (stt.resultAvailable()){
					name = stt.getResult();
						tts.speak("Hi "+ name + " How are you doing today?");
						stt.stop();
					} 
				
				else					
				     getName(); 
	        }}, 1000);       
	}
	

}
	

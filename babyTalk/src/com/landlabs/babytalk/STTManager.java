package com.landlabs.babytalk;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;

public class STTManager implements RecognitionListener{

SpeechRecognizer speech;
ArrayList<String> data = null;
Intent intent;
private boolean dataReady;

public STTManager(Context con)
{
    
    speech = SpeechRecognizer.createSpeechRecognizer(con);
    speech.setRecognitionListener(this);
    intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
    intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
    intent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,con.getPackageName());
    intent.putExtra(RecognizerIntent.EXTRA_SPEECH_INPUT_COMPLETE_SILENCE_LENGTH_MILLIS,2000);
}

public void start()
{
    data = null;
    //final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
    //tg.startTone(ToneGenerator.TONE_PROP_BEEP);
    speech.startListening(intent);
}

public void stop()
{
    speech.stopListening();
}


public ArrayList<String> getresult()
{
    return data;
}

public void onResults(Bundle hasil) {
    data = hasil.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
    //final ToneGenerator tg = new ToneGenerator(AudioManager.STREAM_NOTIFICATION, 100);
    //tg.startTone(ToneGenerator.TONE_PROP_BEEP2);
    
}

public boolean resultAvailable() {
    if(data == null) {
        return false;
    }
    else {
        return true;
    }
}
public String getResult(){

		return data.get(0).toString();
	
}

public void clearResult(){
	data = null;
}

@Override
public void onBeginningOfSpeech() {
	// TODO Auto-generated method stub
	
}

@Override
public void onBufferReceived(byte[] buffer) {
	// TODO Auto-generated method stub
	
}

@Override
public void onEndOfSpeech() {
	// TODO Auto-generated method stub
	
}

@Override
public void onError(int error) {
	// TODO Auto-generated method stub
	
}

@Override
public void onEvent(int eventType, Bundle params) {
	// TODO Auto-generated method stub
	
}

@Override
public void onPartialResults(Bundle partialResults) {
	// TODO Auto-generated method stub
	
}

@Override
public void onReadyForSpeech(Bundle params) {
	// TODO Auto-generated method stub
	
}

@Override
public void onRmsChanged(float rmsdB) {
	// TODO Auto-generated method stub
	
}

}
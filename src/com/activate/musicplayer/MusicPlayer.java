package com.activate.musicplayer;

import org.appcelerator.kroll.KrollInvocation;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;
import org.appcelerator.titanium.TiContext;
import org.appcelerator.titanium.TiApplication;
import org.appcelerator.titanium.util.Log;
import java.util.HashMap;
import org.appcelerator.kroll.KrollFunction;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.app.Activity;
import android.view.Menu;
import android.content.Context;
import android.media.*;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.*;
import java.io.*;

import org.json.JSONArray;

@Kroll.module(name="Musicplayer", id="com.activate.musicplayer")
public class MusicPlayer extends KrollModule 
{
	private MediaPlayer mMediaPlayer = new MediaPlayer();
	
	private static MusicPlayer _THIS;
	private static String debugLog = "";
	private static final String LCAT = "MusicPlayer";
    
    
	private ArrayList<Object> musicPath = new ArrayList<Object>();
    private int currentTrackIndex = 0;
	
	private KrollFunction successCallback;
	private KrollFunction errorCallback;
	private KrollFunction messageCallback;
    private KrollFunction stateChangeCallback;

	
	public MusicPlayer()
	{
		super();
		_THIS = this;
	}
	
	
	@Kroll.method
	public void registerMusicPlayer(HashMap options)
	{
		Log.d(LCAT, "registerMusicPlayer called");
		
		successCallback = (KrollFunction)options.get("success");
		errorCallback = (KrollFunction)options.get("error");
		messageCallback = (KrollFunction)options.get("callback");
		
		sendMessage("registerMusicPlayer called");
	}
	
    @Kroll.method
    public void searchTrackList(String path) {
    	
		Log.d(LCAT, "searchTrackList");
		sendMessage("searchTrackList > " + path);
    	
    	startSearchingFile(path, 0);
    }
	
	@Kroll.method
	public void play(String path)
    {
		Log.d(LCAT, "play");
		sendMessage("play > " + path);
    	
		if(path != null)
			playMusic(path, 0);
    }
    
    @Kroll.method
    public void play()
    {
        Log.d(LCAT, "play");
        
        if(!musicPath.isEmpty())
            playMusic(((HashMap)musicPath.get(currentTrackIndex)).get("path").toString(), 0);
    }
	
	@Kroll.method
	public void pause(String path)
    {
		Log.d(LCAT, "pause");
		sendMessage("pause > " + path);
    	
		if(path != null)
			playMusic(path, 1);
    }
    
    @Kroll.method
    public void pause()
    {
        Log.d(LCAT, "pause");
        
        if(!musicPath.isEmpty())
            playMusic(((HashMap)musicPath.get(currentTrackIndex)).get("path").toString(), 1);
    }
	
	@Kroll.method
	public void stop(String path)
    {
		Log.d(LCAT, "stop");
		sendMessage("stop > " + path);
    	
		if(path != null)
			playMusic(path, 2);
    }
    
    @Kroll.method
    public void stop()
    {
        Log.d(LCAT, "stop");
        
        if(!musicPath.isEmpty())
            playMusic(((HashMap)musicPath.get(currentTrackIndex)).get("path").toString(), 2);
    }
    
    @Kroll.method
    public void setQueue(HashMap queueList)
    {
        Object[] queue = (Object[])queueList.get("items");
        
        musicPath.clear();
        for(int i = 0; i < queue.length; i++)
        {
            musicPath.add(queue[i]);
        }
        
        /*for(int i = 0; i < queue.length; i++)
        {
            sendMessage(((HashMap)queue[i]).get("path").toString());
            sendMessage(((HashMap)queue[i]).get("filename").toString());
        }*/
    }
    
    @Kroll.method
    public void skipToPrevious()
    {
        if(musicPath.isEmpty()) return;
        
        stop();
        
        --currentTrackIndex;
        if(currentTrackIndex < 0)
            currentTrackIndex = musicPath.size() - 1;
        
        mMediaPlayer.reset();
        play();
    }
    
    @Kroll.method
    public void skipToNext()
    {
        if(musicPath.isEmpty()) return;
        
        stop();
        
        ++currentTrackIndex;
        if(currentTrackIndex > musicPath.size() - 1)
            currentTrackIndex = 0;
        
        mMediaPlayer.reset();
        play();
    }
    
    @Kroll.method
    public String getNowPlayingTitle()
    {
        return ((HashMap)musicPath.get(currentTrackIndex)).get("name").toString();
    }
    
    @Kroll.method
    public void setVolume(int volume)
    {
        AudioManager audio;
        audio = (AudioManager) TiApplication.getInstance().getSystemService(Context.AUDIO_SERVICE);
        
        audio.setStreamVolume(AudioManager.STREAM_MUSIC, volume, AudioManager.FLAG_SHOW_UI);
    }
    
    @Kroll.method
    public int getVolume()
    {
        AudioManager audio;
        audio = (AudioManager) TiApplication.getInstance().getSystemService(Context.AUDIO_SERVICE);
        
        return audio.getStreamVolume(AudioManager.STREAM_MUSIC);
    }
    
    @Kroll.method
    public void setMute(boolean state)
    {
        AudioManager audio;
        audio = (AudioManager) TiApplication.getInstance().getSystemService(Context.AUDIO_SERVICE);
        
        audio.setStreamMute(AudioManager.STREAM_MUSIC, state);
    }
    
    @Kroll.method
    public void setMusicPlayerOnCompleteListener(HashMap options)
    {
        stateChangeCallback = (KrollFunction)options.get("stateChange");
        
        if(stateChangeCallback != null)
        {
            mMediaPlayer.setOnCompletionListener
            (
                new MediaPlayer.OnCompletionListener()
                {
                    public void onCompletion(MediaPlayer mp)
                    {
                        stop();
                        
                        ++currentTrackIndex;
                        if(currentTrackIndex > musicPath.size() - 1)
                            currentTrackIndex = 0;
                            
                        mMediaPlayer.reset();
                        play();
                        
                        
                        HashMap data = new HashMap();
                        data.put("title", getNowPlayingTitle());
                        stateChangeCallback.callAsync(getKrollObject(), data);
                        
                    }
                }
            );
        }
    }
    
    private void startSearchingFile(final String path, int postSeconds)
    {
		Log.d(LCAT, "startSearchingFile");
		sendMessage("startSearchingFile > " + path + " , " + postSeconds);
		
		final Handler h = new Handler()
		{
			@Override 
			public void handleMessage(Message msg){
				
				sendSuccess(musicPath);
			}
		};

    	new Thread(new Runnable() { 
	        public void run(){
	
	        	debugLog = "";
	        	musicPath.clear();
	        	mMediaPlayer.reset();
	        	
	        	File directory = new File(path);
	        	visitAllDirs(directory, true);
		    	
		    	Message myMsg = h.obtainMessage();

                // Set the data into our handler message.
                //myMsg.obj = "my obj";

                // Send the handler message to the UI thread.
                h.sendMessage(myMsg);
	        }
    	}).start();
    }
    
    private void playMusic(String path, int key)
    {
		Log.d(LCAT, "playMusic");
		sendMessage("playMusic > " + path + " , " + key);
		
        FileInputStream fileStream = null;
        
        try {
            //fileStream = new FileInputStream("/sdcard/Samsung/Music/Over the horizon.mp3");
            fileStream = new FileInputStream(path);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }

        try {
        	if(fileStream != null)
        	{
        		mMediaPlayer.setDataSource(fileStream.getFD());
        	}
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            mMediaPlayer.prepare();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        switch (key) 
        {
	        case 0: //Play
	            if (mMediaPlayer.isPlaying()){
	                break;
	            }
	            else
	                mMediaPlayer.start();
	            break;
	        case 1: //Pause
	            if(mMediaPlayer.isPlaying())
	                mMediaPlayer.pause();
	            break;
	        case 2: //Stop
	            if(mMediaPlayer.isPlaying()){
	                mMediaPlayer.pause();
	                mMediaPlayer.seekTo(0);
	            }
	            break;
	        default:
	            break;
        }
    }
    
    
    // Process all files and directories under dir
    public void visitAllDirsAndFiles(File dir, boolean hiddenFilter) {
        process(dir);

        if (dir.isDirectory()) {
            String[] children = dir.list();
            if(children != null)
            {
	            for (int i=0; i<children.length; i++) {
	            	if(dir.isHidden() && hiddenFilter) continue;
	                visitAllDirsAndFiles(new File(dir, children[i]), hiddenFilter);
	            }
            }
        }
    }
    
    // Process only directories under dir
    public void visitAllDirs(File dir, boolean hiddenFilter) {
        if (dir.isDirectory()) {
            process(dir);

            String[] children = dir.list();
            if(children != null)
            {
	            for (int i=0; i<children.length; i++) {
	            	if(dir.isHidden() && hiddenFilter) continue;
	                visitAllDirs(new File(dir, children[i]), hiddenFilter);
	            }
            }
        }
    }

    // Process only files under dir
    public void visitAllFiles(File dir, boolean hiddenFilter) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            if(children != null)
            {
	            for (int i=0; i<children.length; i++) {
	            	if(dir.isHidden() && hiddenFilter) continue;
	            	
	                visitAllFiles(new File(dir, children[i]), hiddenFilter);
	            }
            }
        } else {
            process(dir);
        }
    }
    
    public void process(File dir) {
    	
    	FilenameFilter filter = new FilenameFilter() 
    	{
    		public boolean accept(File directory, String fileName) 
    		{
    		    return (fileName.endsWith(".mp3") || fileName.endsWith(".wav") || fileName.endsWith(".wma"));
    		}
    	};
    	
    	String[] result = dir.list(filter);
        File[] name = dir.listFiles(filter);
    	
    	if(result != null)
    	{
    		for (int i = 0; i < result.length; ++i) 
            {
                HashMap tempObj = new HashMap();
                tempObj.put("path", dir.getAbsolutePath() + "/" + result[i]);
                tempObj.put("filename", result[i]);
                tempObj.put("name", name[i].getName());
                
    			musicPath.add(tempObj);
    			
    			Log.d("Matched:", dir.toString());
    			debugLog += result[i] + "\n";
    			//debugLog += dir.getAbsolutePath() + "/" + result[i] + "\n";
	    	}
    	}
    }
	
	public void sendMessage(String message)
	{
		Log.d(LCAT, "sendMessage");
		
		if(messageCallback != null)
		{
			HashMap data = new HashMap();
			data.put("message", message);
			
			messageCallback.callAsync(getKrollObject(), data);
		}
	}
	
	public void sendSuccess(ArrayList<Object> musicPath)
	{
		Log.d(LCAT, "sendSuccess");
		
		sendMessage("sendSuccess > " + musicPath.toArray());
		
		if(successCallback != null)
		{
			HashMap data = new HashMap();
			data.put("list", musicPath.toArray());
			
			successCallback.callAsync(getKrollObject(), data);
		}
	}
	
	public void sendError(String error)
	{
		Log.d(LCAT, "sendError");
		sendMessage("sendError > " + error);
		
		if(errorCallback != null)
		{
			HashMap data = new HashMap();
			data.put("error", error);
			
			errorCallback.callAsync(getKrollObject(), data);
		}
	}
}

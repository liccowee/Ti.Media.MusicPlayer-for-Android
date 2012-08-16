/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011-2012 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

package com.activate.musicplayer;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.IdFunctionObject;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;

import org.appcelerator.kroll.KrollDict;
import org.appcelerator.kroll.KrollInvocation;
import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.KrollProxy;
import org.appcelerator.kroll.KrollProxySupport;
import org.appcelerator.kroll.KrollRuntime;

import org.appcelerator.kroll.common.TiConfig;

import org.appcelerator.kroll.runtime.rhino.KrollBindings;
import org.appcelerator.kroll.runtime.rhino.KrollGeneratedBindings;
import org.appcelerator.kroll.runtime.rhino.Proxy;
import org.appcelerator.kroll.runtime.rhino.ProxyFactory;
import org.appcelerator.kroll.runtime.rhino.RhinoRuntime;
import org.appcelerator.kroll.runtime.rhino.TypeConverter;
import org.appcelerator.kroll.common.Log;

import java.util.HashMap;

import com.activate.musicplayer.MusicPlayer;

import org.appcelerator.kroll.KrollModulePrototype;


public class MusicPlayerPrototype extends KrollModulePrototype
{
	// GENERATE_SUID

	private static final boolean DBG = TiConfig.LOGD;
	private static final String TAG = "MusicPlayerPrototype";
	private static final String CLASS_TAG = "MusicPlayer";
	private static MusicPlayerPrototype musicPlayerPrototype;


	public static MusicPlayerPrototype getProxyPrototype()
	{
		return musicPlayerPrototype;
	}

	public static void dispose()
	{
		if (DBG) {
			Log.d(TAG, "dispose()");
		}
		musicPlayerPrototype = null;
	}

	public MusicPlayerPrototype()
	{
		if (musicPlayerPrototype == null && getClass().equals(MusicPlayerPrototype.class)) {
			musicPlayerPrototype = this;
			KrollGeneratedBindings.registerUsedPrototypeClass(getClass());
		}

		isModule = true;
	}

	public Scriptable getPrototype()
	{
		if (this == musicPlayerPrototype) {
			return KrollModulePrototype.getProxyPrototype();
		}
		return musicPlayerPrototype;
	}

	protected Class<? extends Proxy> getParent()
	{
		return KrollModulePrototype.class;
	}

	protected KrollProxySupport createProxy(String creationUrl, Object[] args)
	{
		return KrollProxy.createProxy(MusicPlayer.class, getRhinoObject(), args, creationUrl);
	}

	// Methods
	public void searchTrackList(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "searchTrackList()");
		}

		try {
		MusicPlayer proxy = (MusicPlayer) ((Proxy) thisObj).getProxy();
		if (args.length < 1) {
			throw new IllegalArgumentException("searchTrackList: Invalid number of arguments. Expected 1 but got " + args.length);
		}
		java.lang.String arg0;
		arg0 = (java.lang.String) TypeConverter.jsObjectToJavaString(args[0], thisObj) ;

		proxy.searchTrackList(arg0);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void setMute(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "setMute()");
		}

		try {
		MusicPlayer proxy = (MusicPlayer) ((Proxy) thisObj).getProxy();
		if (args.length < 1) {
			throw new IllegalArgumentException("setMute: Invalid number of arguments. Expected 1 but got " + args.length);
		}
		if (!(args[0] instanceof Boolean)) {
			String error = "Invalid value, expected type Boolean, got: " + args[0];
			Log.e(TAG, error);
			throw new IllegalArgumentException(error);
		}
		boolean arg0;
		arg0 = (boolean) TypeConverter.jsObjectToJavaBoolean(args[0], thisObj) ;

		proxy.setMute(arg0);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public Object getVolume(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "getVolume()");
		}

		try {
		MusicPlayer proxy = (MusicPlayer) ((Proxy) thisObj).getProxy();

		int javaResult = proxy.getVolume();

		Number rhinoResult = (Number) javaResult;
	
			return rhinoResult;

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			return Undefined.instance;
		}
	}

	public void stop(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "stop()");
		}

		try {
		MusicPlayer proxy = (MusicPlayer) ((Proxy) thisObj).getProxy();

		proxy.stop();
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void skipToPrevious(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "skipToPrevious()");
		}

		try {
		MusicPlayer proxy = (MusicPlayer) ((Proxy) thisObj).getProxy();

		proxy.skipToPrevious();
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public Object getNowPlayingTitle(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "getNowPlayingTitle()");
		}

		try {
		MusicPlayer proxy = (MusicPlayer) ((Proxy) thisObj).getProxy();

		java.lang.String javaResult = proxy.getNowPlayingTitle();

		String rhinoResult = (String) javaResult;
	
			return rhinoResult;

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			return Undefined.instance;
		}
	}

	public void setQueue(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "setQueue()");
		}

		try {
		MusicPlayer proxy = (MusicPlayer) ((Proxy) thisObj).getProxy();
		if (args.length < 1) {
			throw new IllegalArgumentException("setQueue: Invalid number of arguments. Expected 1 but got " + args.length);
		}
		java.util.HashMap arg0;
		arg0 = (java.util.HashMap) TypeConverter.jsObjectToJavaObject(args[0], thisObj) ;

		proxy.setQueue(arg0);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void setVolume(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "setVolume()");
		}

		try {
		MusicPlayer proxy = (MusicPlayer) ((Proxy) thisObj).getProxy();
		if (args.length < 1) {
			throw new IllegalArgumentException("setVolume: Invalid number of arguments. Expected 1 but got " + args.length);
		}
		int arg0;
		arg0 = (int) TypeConverter.jsObjectToJavaInt(args[0], thisObj) ;

		proxy.setVolume(arg0);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void play(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "play()");
		}

		try {
		MusicPlayer proxy = (MusicPlayer) ((Proxy) thisObj).getProxy();

		proxy.play();
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void pause(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "pause()");
		}

		try {
		MusicPlayer proxy = (MusicPlayer) ((Proxy) thisObj).getProxy();

		proxy.pause();
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void setMusicPlayerOnCompleteListener(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "setMusicPlayerOnCompleteListener()");
		}

		try {
		MusicPlayer proxy = (MusicPlayer) ((Proxy) thisObj).getProxy();
		if (args.length < 1) {
			throw new IllegalArgumentException("setMusicPlayerOnCompleteListener: Invalid number of arguments. Expected 1 but got " + args.length);
		}
		java.util.HashMap arg0;
		arg0 = (java.util.HashMap) TypeConverter.jsObjectToJavaObject(args[0], thisObj) ;

		proxy.setMusicPlayerOnCompleteListener(arg0);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void skipToNext(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "skipToNext()");
		}

		try {
		MusicPlayer proxy = (MusicPlayer) ((Proxy) thisObj).getProxy();

		proxy.skipToNext();
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}

	public void registerMusicPlayer(Context context, Scriptable thisObj, Object[] args)
	{
		if (DBG) {
			Log.d(TAG, "registerMusicPlayer()");
		}

		try {
		MusicPlayer proxy = (MusicPlayer) ((Proxy) thisObj).getProxy();
		if (args.length < 1) {
			throw new IllegalArgumentException("registerMusicPlayer: Invalid number of arguments. Expected 1 but got " + args.length);
		}
		java.util.HashMap arg0;
		arg0 = (java.util.HashMap) TypeConverter.jsObjectToJavaObject(args[0], thisObj) ;

		proxy.registerMusicPlayer(arg0);
	

		} catch (Throwable throwable) {
			Context.throwAsScriptRuntimeEx(throwable);
			
		}
	}


	// Dynamic properties

// #string_id_map#

	// Prototype IDs
	private static final int
		Id_constructor = 1
,		// Property IDs
		// Method IDs
		Id_searchTrackList = 2,
		Id_setMute = 3,
		Id_getVolume = 4,
		Id_stop = 5,
		Id_skipToPrevious = 6,
		Id_getNowPlayingTitle = 7,
		Id_setQueue = 8,
		Id_setVolume = 9,
		Id_play = 10,
		Id_pause = 11,
		Id_setMusicPlayerOnCompleteListener = 12,
		Id_skipToNext = 13,
		Id_registerMusicPlayer = 14
;
		

	public static final int MAX_PROTOTYPE_ID = 14;

	protected int getMaxPrototypeId()
	{
		return MAX_PROTOTYPE_ID;
	}

	@Override
	protected int findPrototypeId(String s)
	{
		int id = 0;
// #generated# Last update: 2012-08-16 14:03:13 GMT+08:00
        L0: { id = 0; String X = null; int c;
            L: switch (s.length()) {
            case 4: c=s.charAt(0);
                if (c=='p') { X="play";id=Id_play; }
                else if (c=='s') { X="stop";id=Id_stop; }
                break L;
            case 5: X="pause";id=Id_pause; break L;
            case 7: X="setMute";id=Id_setMute; break L;
            case 8: X="setQueue";id=Id_setQueue; break L;
            case 9: c=s.charAt(0);
                if (c=='g') { X="getVolume";id=Id_getVolume; }
                else if (c=='s') { X="setVolume";id=Id_setVolume; }
                break L;
            case 10: X="skipToNext";id=Id_skipToNext; break L;
            case 11: X="constructor";id=Id_constructor; break L;
            case 14: X="skipToPrevious";id=Id_skipToPrevious; break L;
            case 15: X="searchTrackList";id=Id_searchTrackList; break L;
            case 18: X="getNowPlayingTitle";id=Id_getNowPlayingTitle; break L;
            case 19: X="registerMusicPlayer";id=Id_registerMusicPlayer; break L;
            case 32: X="setMusicPlayerOnCompleteListener";id=Id_setMusicPlayerOnCompleteListener; break L;
            }
            if (X!=null && X!=s && !X.equals(s)) id = 0;
            break L0;
        }
// #/generated#
		return id;
	}

// #/string_id_map#

	@Override
	protected void initPrototypeId(int id)
	{
		String name;
		int arity;
		switch (id) {
			case Id_constructor:
				arity = 0;
				name = "constructor";
				break;
			case Id_searchTrackList:
				arity = 1;
				name = "searchTrackList";
				break;
			case Id_setMute:
				arity = 1;
				name = "setMute";
				break;
			case Id_getVolume:
				arity = 0;
				name = "getVolume";
				break;
			case Id_stop:
				arity = 0;
				name = "stop";
				break;
			case Id_skipToPrevious:
				arity = 0;
				name = "skipToPrevious";
				break;
			case Id_getNowPlayingTitle:
				arity = 0;
				name = "getNowPlayingTitle";
				break;
			case Id_setQueue:
				arity = 1;
				name = "setQueue";
				break;
			case Id_setVolume:
				arity = 1;
				name = "setVolume";
				break;
			case Id_play:
				arity = 0;
				name = "play";
				break;
			case Id_pause:
				arity = 0;
				name = "pause";
				break;
			case Id_setMusicPlayerOnCompleteListener:
				arity = 1;
				name = "setMusicPlayerOnCompleteListener";
				break;
			case Id_skipToNext:
				arity = 0;
				name = "skipToNext";
				break;
			case Id_registerMusicPlayer:
				arity = 1;
				name = "registerMusicPlayer";
				break;
			default:
				super.initPrototypeId(id);
				return;
		}
		initPrototypeMethod(CLASS_TAG, id, name, arity);
	}

	@Override
	public Object execIdCall(IdFunctionObject f,
		Context cx, Scriptable scope, Scriptable thisObj, Object[] args)
	{
		if (!f.hasTag(CLASS_TAG)) {
			return super.execIdCall(f, cx, scope, thisObj, args);
		}

		while (thisObj != null && !(thisObj instanceof MusicPlayerPrototype)) {
			thisObj = thisObj.getPrototype();
		}

		MusicPlayerPrototype proxy = (MusicPlayerPrototype) thisObj;
		int id = f.methodId();
		switch (id) {
			case Id_constructor:
				return jsConstructor(scope, args);
			case Id_searchTrackList:
				 searchTrackList(cx, thisObj, args);
				return Undefined.instance;
			case Id_setMute:
				 setMute(cx, thisObj, args);
				return Undefined.instance;
			case Id_getVolume:
				return getVolume(cx, thisObj, args);
				
			case Id_stop:
				 stop(cx, thisObj, args);
				return Undefined.instance;
			case Id_skipToPrevious:
				 skipToPrevious(cx, thisObj, args);
				return Undefined.instance;
			case Id_getNowPlayingTitle:
				return getNowPlayingTitle(cx, thisObj, args);
				
			case Id_setQueue:
				 setQueue(cx, thisObj, args);
				return Undefined.instance;
			case Id_setVolume:
				 setVolume(cx, thisObj, args);
				return Undefined.instance;
			case Id_play:
				 play(cx, thisObj, args);
				return Undefined.instance;
			case Id_pause:
				 pause(cx, thisObj, args);
				return Undefined.instance;
			case Id_setMusicPlayerOnCompleteListener:
				 setMusicPlayerOnCompleteListener(cx, thisObj, args);
				return Undefined.instance;
			case Id_skipToNext:
				 skipToNext(cx, thisObj, args);
				return Undefined.instance;
			case Id_registerMusicPlayer:
				 registerMusicPlayer(cx, thisObj, args);
				return Undefined.instance;
			default:
				throw new IllegalArgumentException(String.valueOf(id));
		}
	}



	public static final int MAX_INSTANCE_ID = -1;


	@Override
	public String getClassName()
	{
		return CLASS_TAG;
	}
}

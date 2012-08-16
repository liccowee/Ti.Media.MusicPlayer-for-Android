/**
 * Appcelerator Titanium Mobile
 * Copyright (c) 2011 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 */

/** This is generated, do not edit by hand. **/

#include <jni.h>

#include "Proxy.h"

		namespace com {
		namespace activate {
		namespace musicplayer {


class MusicPlayer : public titanium::Proxy
{
public:
	explicit MusicPlayer(jobject javaObject);

	static void bindProxy(v8::Handle<v8::Object> exports);
	static v8::Handle<v8::FunctionTemplate> getProxyTemplate();
	static void dispose();

	static v8::Persistent<v8::FunctionTemplate> proxyTemplate;
	static jclass javaClass;

private:
	// Methods -----------------------------------------------------------
	static v8::Handle<v8::Value> searchTrackList(const v8::Arguments&);
	static v8::Handle<v8::Value> setMute(const v8::Arguments&);
	static v8::Handle<v8::Value> getVolume(const v8::Arguments&);
	static v8::Handle<v8::Value> stop(const v8::Arguments&);
	static v8::Handle<v8::Value> skipToPrevious(const v8::Arguments&);
	static v8::Handle<v8::Value> getNowPlayingTitle(const v8::Arguments&);
	static v8::Handle<v8::Value> setQueue(const v8::Arguments&);
	static v8::Handle<v8::Value> setVolume(const v8::Arguments&);
	static v8::Handle<v8::Value> play(const v8::Arguments&);
	static v8::Handle<v8::Value> pause(const v8::Arguments&);
	static v8::Handle<v8::Value> setMusicPlayerOnCompleteListener(const v8::Arguments&);
	static v8::Handle<v8::Value> skipToNext(const v8::Arguments&);
	static v8::Handle<v8::Value> registerMusicPlayer(const v8::Arguments&);

	// Dynamic property accessors ----------------------------------------

};

		} // musicplayer
		} // activate
		} // com

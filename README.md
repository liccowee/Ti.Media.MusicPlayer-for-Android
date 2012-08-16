Ti.Media.MusicPlayer-for-Android
=================================
Custom module music player for android, which work similar with Ti.Media.MusicPlayer(iOS)


Topic Covered
-------------
1. How to use this music player module at titanium.
2. Module function prototype and parameter description.



How to use this music player module at titanium.
-------------------------------------------------
1. Copy the .zip into your titanium project at root level. You may use my zip module as well, inside /dist/com.activate.musicplayer-0.1.zip. Double click on the zip file, the zip should be unzip inside the folder name "module".

2. Be sure you have include the module statement in your tiapp.xml, so you only can use this module at your project.

3. After that, you also can refer to the /example/Main.js and /example/MusicLibraryView.js as reference how to use music player android in titanium. I have provided example into it.



Module function prototype and parameter description.
-------------------------------------------------
1. MusicPlayer.registerMusicPlayer(HashMap options):void - For register music player with your callback. 3 callback are accepted such as "success", "error" and "callback".

2. MusicPlayer.searchTrackList(String path):void - Searching the local path track list. For example [path = "/sdcard"]

3. MusicPlayer.play(String path):void - Play the music of the given media path. For example [path="/sdcard/Music/CNBLUE.mp3"]

4. MusicPlayer.play():void - Start play the music by given the queue list. The queue list can be set by method MusicPlayer.setQueue()

5. MusicPlayer.pause(String path):void - Pause the music of the given media path.

6. MusicPlayer.pause():void - Pause the music played of the queue list.

7. MusicPlayer.stop(String path):void - Stop the music of the given media path.

8. MusicPlayer.stop():void - Stop playing the music of the queue list.

9. MusicPlayer.setQueue(HashMap queueList):void - Set the queue list for music player to play. For example please go /example/Main.js onEnter(), see how to use setQueue function.

10. MusicPlayer.skipToPrevious():void - Play previous song of the queue list.

11. MusicPlayer.skipToNext():void - Play next song of the queue list.

12. MusicPlayer.getNowPlayingTitle():String - Get the now playing title;

13. MusicPlayer.setMute(boolean state):void - Set the music player mute state.

14. MusicPlayer.setMusicPlayerOnCompleteListener(HashMap options):void - Set the callback eventlistener when play next song. For example please go /example/Main.js onEnter(), see how to use setMusicPlayerOnCompleteListener function.

15. MusicPlayer.setVolume(int volume):void - set volume.

16. MusicPlayer.getVolume():int - get volume.




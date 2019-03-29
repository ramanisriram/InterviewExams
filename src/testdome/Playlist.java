package testdome;

import java.util.HashSet;
import java.util.Set;

public class Playlist {

    public static class Song {
    	
    	public static Set playList = new HashSet();
    	
        private String name;
        private Song nextSong;
 
        public Song(String name) {
            this.name = name;
        }
    
        public void setNextSong(Song nextSong) {
            this.nextSong = nextSong;
        }
        public boolean isRepeatingPlaylist() {
            if(this.nextSong != null) {
            	playList.add(this.nextSong.name);
            } else {
            	return true;
            }
            return false;
        }
    }
    
    public static boolean isRepeatingPlaylist() {
        return false;
    }
    
    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");
        Song third = new Song("Eye the tiger");
    
        first.setNextSong(second);
        second.setNextSong(third);
        third.setNextSong(first);
    
        System.out.println(first.isRepeatingPlaylist());
    }
}
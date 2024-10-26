package ece325.labs.lab3;

import java.util.ArrayList;

/** 
 * Finish this class.
 */
public class SongCollection {
	private ArrayList<Song> songs;

	public SongCollection() {
		//initialize the songs ArrayList
		songs = new ArrayList<Song>();
	}

	/**
	 * Add the song if it is not in the list yet, otherwise update the average
	 * rating of the song.
	 * 
	 * @param s
	 */
	public void add(Song s) {
		for(int i=0; i<songs.size(); i++) {
			if(songs.get(i).equals(s)) {
				//update average rating
				songs.get(i).addRating(s.getRating().getAvgRating());
				return;
			}
		}
		songs.add(s);
	}

	/**
	 * Remove the song if it is in the list
	 * 
	 * @param s
	 */
	public void remove(Song s) {
		for(int i=0; i<songs.size(); i++) {
			if(songs.get(i).equals(s)) {
				songs.remove(i);
				return;
			}
		}
	}

	public boolean contains(Song s) {
		for(Song s1: songs) {
			if (s.equals(s1)) return true;
		}
		return false;
	}

	public Song getSong(int index) {
		Song gs = songs.get(index);
		return new Song(gs.getTitle(),gs.getInstruments(),gs.getRating());
	}

	public int getNumberOfSongs() {
		return songs.size();
	}

	public ArrayList<Song> getSongs() {
		return new ArrayList<Song>(songs);
	}

	public String toString() {
		String toRet = "[SongCollection: ";
		for (Song s : songs)
			toRet += "\n\t" + s + "; ";
		return toRet + "\n]";
	}
	
}

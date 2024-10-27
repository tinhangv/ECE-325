package ece325.labs.lab3;

import java.util.ArrayList;

/** 
 * Finish this class.
 */
public class SongCollection {
	private ArrayList<Song> songs;
	
	/** 
	 * Create a SongCollection object by initializing the songs ArrayList.
	 */
	public SongCollection() {
		//initialize the songs ArrayList
		songs = new ArrayList<Song>();
	}

	/**
	 * Add the song if it is not in the list yet, otherwise update the average
	 * rating of the song.
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
	
	/**
	 * Returns true if the SongCollection contains Song s, false otherwise.
	 * The SongCollection contains the Song if there exists a Song with 
	 * the same title and instruments in the SongCollection.
	 * @param s
	 * @return true if SongCollection contains s, false otherwise
	 */
	public boolean contains(Song s) {
		for(Song s1: songs) {
			if (s.equals(s1)) return true;
		}
		return false;
	}
	
	/**
	 * Returns a copy of the song at index in the songs list.
	 * @param index
	 * @return a copy of the Song object
	 */
	public Song getSong(int index) {
		Song gs = songs.get(index);
		return new Song(gs.getTitle(),gs.getInstruments(),gs.getRating());
	}
	
	/**
	 * Returns the number of songs stored in the list. A distinct song is defined as 
	 * a song with a unique title and set of instruments. This means the same song can 
	 * be counted twice if it's performed with a different instrument set.
	 * @return the number of songs
	 */
	public int getNumberOfSongs() {
		return songs.size();
	}
	
	/**
	 * @return a copy of the songs list
	 */
	public ArrayList<Song> getSongs() {
		return new ArrayList<Song>(songs);
	}
	
	/**
	 * @return the string representation of the SongCollection object
	 */
	@Override
	public String toString() {
		String toRet = "[SongCollection: ";
		for (Song s : songs)
			toRet += "\n\t" + s + "; ";
		return toRet + "\n]";
	}
	
}

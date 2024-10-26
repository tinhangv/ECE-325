package ece325.labs.lab3;

import java.util.ArrayList;
import java.util.Collections;

/** 
 * Finish this class.
 */
public class Song {
	private String title;
	private ArrayList<String> instruments;
	private AverageRating averageRating;
	
	public Song(String title, ArrayList<String> instruments, AverageRating rating) {
		this.title = title;
		this.instruments = instruments;
		this.averageRating = rating;
	}
	
	/**
	 * Returns true if the title of and instruments used in the Songs are the same.
	 * Note that you don't have to include the AverageRating in this comparison (as it is not really related to the equality of the Song). 
	 * @Override
	 */
	public boolean equals(Object o) {
		if(!(o instanceof Song)) return false;
		
		Song song_o = (Song) o;
		return this.equals(song_o);
	}
	
	/**
	 * Returns true if the title of and instruments used in the Songs are the same.
	 * Note that you don't have to include the AverageRating in this comparison (as it is not really related to the equality of the Song). 
	 * @Override
	 */
	public boolean equals(Song s) {
		//true if the title and instruments are the same
		ArrayList<String> sIns = s.getInstruments();
		ArrayList<String> thisIns = this.getInstruments();
		
		Collections.sort(sIns);
		Collections.sort(thisIns);
	
		return (s.title.equals(title) && sIns.equals(thisIns));
		
	}
	
	public ArrayList<String> getInstruments(){
		return new ArrayList<String>(instruments);
	}
	
	public void addRating(float rating) {
		averageRating.addRating(rating);
	}
	
	public AverageRating getRating() {
		return new AverageRating(averageRating.getAvgRating());
	}
	
	public String getTitle() {
		return title;
	}
	
	public String toString() {
		return "[Song: " + title + ", instruments: " + instruments + ", avg. rating: " + averageRating + "]"; 
	}
}

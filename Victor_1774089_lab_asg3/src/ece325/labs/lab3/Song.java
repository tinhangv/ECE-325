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
	
	/** 
	 * Create a Song object by initializing the title String, and instruments, averageRating objects.
	 * @param title
	 * @param instrument
	 * @param rating
	 */
	public Song(String title, ArrayList<String> instruments, AverageRating rating) {
		this.title = title;
		this.instruments = instruments;
		this.averageRating = rating;
	}
	
	/**
	 * Returns true if the title of and instruments used in the Songs are the same.
	 * Note that you don't have to include the AverageRating in this comparison (as it is not really related to the equality of the Song). 
	 * @param o the object being compared to
	 * @return true if titles and instruments same, and o is an instanceof Song, false otherwise
	 */
	@Override
	public boolean equals(Object o) {
		//Comparison returns false if o is not a Song 
		if(!(o instanceof Song)) return false;
		
		//type cast the object into a Song if it's an instance of Song
		Song song_o = (Song) o;
		return this.equals(song_o);
	}
	
	/**
	 * Returns true if the title of and instruments used in the Songs are the same.
	 * Note that you don't have to include the AverageRating in this comparison (as it is not really related to the equality of the Song). 
	 * @param s the Song being compared to
	 * @return true if titles and instruments same, false otherwise
	 */
	public boolean equals(Song s) {
		//get the instruments lists of both Songs
		ArrayList<String> sIns = s.getInstruments();
		ArrayList<String> thisIns = this.getInstruments();
		//order doesn't matter, so sort the lists alphabetically and compare
		Collections.sort(sIns);
		Collections.sort(thisIns);
	
		return (s.title.equals(title) && sIns.equals(thisIns));	
	}
	
	/**
	 * @return a copy of the instruments ArrayList
	 */
	public ArrayList<String> getInstruments(){
		return new ArrayList<String>(instruments);
	}
	
	/**
	 * Adds the new rating to the AverageRating object, which calculates and updates
	 * the new average rating.
	 * @param rating
	 */
	public void addRating(float rating) {
		averageRating.addRating(rating);
	}
	
	/**
	 * Returns a copy of the averageRating object s
	 * @return 
	 */
	public AverageRating getRating() {
		return new AverageRating(averageRating.getAvgRating());
	}
	
	/**
	 * @return the title of the song
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * @return the string representation of the Song object
	 */
	@Override
	public String toString() {
		return "[Song: " + title + ", instruments: " + instruments + ", avg. rating: " + averageRating + "]"; 
	}
}

package ece325.labs.lab4;

import java.util.Comparator;

// finish this

/**
 * An implementation of Comparator for the Song class that compares two Songs by average ratings (high to low).
 * If average ratings are equal, compare the two Songs by votes (high to low).
 * 
 * @author Victor Kwok
 *
 */
public class SongComparator implements Comparator<Song>{
	@Override
	public int compare(Song s1, Song s2) {
		//order by average rating from high to low
		int i = Float.compare(s2.getAverageRating().getAvgRating(), s1.getAverageRating().getAvgRating());
		if(i!=0) return i;
		//order by votes from high to low if average ratings are equal
		return Integer.compare(s2.getAverageRating().getVotes(), s1.getAverageRating().getVotes());
	}
}
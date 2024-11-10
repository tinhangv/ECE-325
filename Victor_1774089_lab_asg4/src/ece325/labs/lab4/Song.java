package ece325.labs.lab4;

/**
 * This class represents a Song. A Song has a title and an average rating.
 * You are not allowed to change the code that is in between the indications, but you are allowed to add
 * code before and after the indicated lines.
 * 
 * @author Cor-Paul Bezemer
 *
 */
public class Song implements Comparable<Song> {
	// not allowed to change anything after this (until the next marker which says you can add code again)
	private String title;
	private AverageRating rating;
	
	public Song(String title, AverageRating rating) {
		this.title = title;
		this.rating = rating;
	}

	public String getTitle() {
		return this.title;
	}

	public AverageRating getAverageRating() {
		return this.rating;
	}
	
	public void setTitle(String s) {
		title = s;
	}
	
	public void setAverageRating(AverageRating rating) {
		this.rating = rating;
	}
	
	public String toString() {
		return "[Song: " + title + ", average rating: " + rating + "]";
	}
	
	// You are allowed to make changes or add code after this line
	
	
	//implement comparable interface
	/**
	 * Compares two Songs based on their titles, ordered lexicographically (A-Z).
	 * 
	 * @param s - the Song that this Song is being compared to
	 * @return a negative integer if the title of this Song is lexicographically less than the title of s
	 * 		   positive if greater, and zero if equal.
	 */
	@Override
	public int compareTo(Song s) {
		//natural ordering: order by title from A-Z
		return this.title.compareTo(s.getTitle());
	}
	
	//override equals() and hashcode() to allow storing in HashSet
	
	/**
	 * Indicates if an object is equal to this Song
	 * @param o - the object to be compared
	 * @return true if the object is a Song with the same title as this Song
	 */
	@Override 
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || o.getClass()!= this.getClass()) return false;
		
		Song s = (Song) o;
		return this.title.equals(s.getTitle());
	}
	
	/**
	 * Returns a hash code value of the Song using the hashCode of its title
	 * @return the hashCode of the title of this Song
	 */
	@Override 
	public int hashCode() {
		return title.hashCode();
	}
	
	
}

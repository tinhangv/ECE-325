package ece325.labs.lab3;

/** 
 * Finish this class.
 */
public class AverageRating {
	private float avgRating;
	private int count;
	
	/** 
	 * Create an AverageRating object by initializing the avgRating float and count int.
	 * @param rating
	 */
	public AverageRating(float rating) {
		avgRating = rating;
		count = 1;
	}
	
	/**
	 * Recomputes the average rating taking the new rating r into account.
	 * @param rating 
	 */
	public void addRating(float r) {
		avgRating = (avgRating*count + r)/(count+1);
		count ++;
	}
	
	/**
	 * @return the avgRating
	 */
	public float getAvgRating() {
		return avgRating;
	}
	
	/**
	 * @return the string representation of the AverageRating object
	 */
	@Override
	public String toString() {
		return "[AverageRating: " + avgRating + "]";
	}
	
	//test the class
//	public static void main(String[] args) {
//		AverageRating ar = new AverageRating(2);
//		System.out.println(ar);
//		System.out.println(ar.getAvgRating());
//		ar.addRating(0);
//		System.out.println(ar);
//		ar.addRating(1);
//		System.out.println(ar);
//		ar.addRating(13);
//		System.out.println(ar);
//	}
}

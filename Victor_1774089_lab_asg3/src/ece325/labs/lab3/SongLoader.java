package ece325.labs.lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

/** 
 * Finish this class.
 */
public class SongLoader {
	/**
	 * Load a SongCollection from a file. Uses one or more Scanners to read the
	 * file, create Song objects and insert them into a SongCollection.
	 * 
	 * The input is of the format: Songtitle; Instruments; Rating 
	 * Contribution;Guitar,Guitar,Drums;4.5
	 * 
	 * (see songratings.txt for the full input)
	 * 
	 * @param file
	 * @return the loaded SongCollection
	 */
	public static SongCollection loadSongs(String file) {
		SongCollection sc = new SongCollection();
		//read the lines
		try {
			Scanner s = new Scanner(new BufferedReader(new FileReader("songratings.txt")));
			while (s.hasNextLine()) {
				//create song object
				Song song = parseSong(s.nextLine());
				//add the song to the SongCollection
				sc.add(song);
			}
			s.close();
		}
		catch(IOException e) {
			e.printStackTrace();	
		}
		catch(InvalidSongFormatException ife) {
			System.err.println("InvalidSongFormatException");
		}

		return sc;
	}

	/**
	 * Parse a Song object from the String and return it. If the String cannot be
	 * parsed into a Song, throw an InvalidSongFormatException.
	 * 
	 * @param songString
	 * @return the Song object
	 * @throws InvalidSongFormatException
	 */
	public static Song parseSong(String songString) throws InvalidSongFormatException {
		try {
			Scanner s = new Scanner(songString);
			s.useDelimiter(";");
			String songName = s.next();
			String instruments = s.next();
			ArrayList<String> instrumentsList = parseInstrumentsList(instruments);
		    AverageRating rating = new AverageRating(s.nextFloat());
		    
		    Song song = new Song(songName, instrumentsList, rating);
		    s.close();
		    return song;
		}catch(NoSuchElementException | NumberFormatException e) {
			//these errors will occur if the format is incorrect
			throw new InvalidSongFormatException("Invalid song format");
		}
	    
	}

	/**
	 * Uses a scanner to parse the instruments string into an ArrayList of String
	 * objects. You can assume that the string comes in CSV (comma-separated-value)
	 * format, and that it is valid CSV (so no need to do error checking or account
	 * for issues with the data).
	 * 
	 * @param instruments
	 * @return an ArrayList with one String per parsed instrument
	 */
	public static ArrayList<String> parseInstrumentsList(String instruments) {
		ArrayList<String> instrumentsList = new ArrayList<String>();
	    Scanner s = new Scanner(instruments);
	    s.useDelimiter(",");
	    while(s.hasNext()) instrumentsList.add(s.next());
	    s.close();
	    Collections.sort(instrumentsList);
	    return instrumentsList;
	}

	public static void main(String[] args) {
		String file = "songratings.txt";
		System.out.println(SongLoader.loadSongs(file));
		
		//tests
		
//		SongCollection sc = SongLoader.loadSongs(file);
//		Song s1 = new Song("Contribution",new ArrayList<String>(Arrays.asList("Guitar", "Guitar","Drums")),new AverageRating(100));
		
		//contains
//		System.out.println(sc.contains(s1));
//		//remove
//		sc.remove(s1);
//		System.out.println(sc);
//		//contains
//		System.out.println(sc.contains(s1));
//		//getSongs
//		System.out.println(sc.getSongs());
		
		//equals
//			Song s1 = new Song("Contribution",new ArrayList<String>(Arrays.asList("Guitar", "Guitar","Drums")),new AverageRating(100));
//			Object song_obj = new Song("Contribution",new ArrayList<String>(Arrays.asList("Guitar", "Guitar","Drums")),new AverageRating(100));
//			System.out.println(s1.equals(song_obj));
//			System.out.println(song_obj.equals(s1));
//			Song s2 = null;
//			System.out.println(s1.equals(s2));
		
//		//encapsulation (getters should not be able to change private fields)
//		//getSong
//			Song gs = sc.getSong(0);
//			System.out.println(gs);
//			gs.addRating(100000);
//			System.out.println(sc.getSong(0));
//		//get title
//			String title = s1.getTitle();
//			title = "test";
//			System.out.println(s1.getTitle());
//		//get rating
//			AverageRating rating = s1.getRating();
//			System.out.println(rating);
//			rating.addRating(100000);
//			System.out.println(s1.getRating());
	}
}

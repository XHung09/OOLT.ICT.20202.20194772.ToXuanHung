package hust.soict.globalict.test.media;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;

public class TestMediaCompareTo {

	public static void main(String[] args) throws Exception {
		Collection collection = new ArrayList();
		
		Track track1 = new Track("B", 3);	
		Track track2 = new Track("A", 3);	
		
		List<Track> trackList = new ArrayList<>();
		trackList.add(track1);
		trackList.add(track2);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		CompactDisc cd1 = new CompactDisc("AAAA", "cccc", "cccc", "Hung", trackList, 4.3f);
	
		dvd3.play();
		dvd2.play();
		dvd1.play();
		cd1.play();
	
		// Add the DVD objects to the ArrayList
		collection.add(dvd3);
		collection.add(dvd2);
		collection.add(dvd1);
		
		// Iterate through the ArrayList and output their titles
		// (unsorted order)
		Iterator iterator = collection.iterator();
		
		System.out.println("-----------------------------------");
		System.out.println("The DVDs currently in the order are");

		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		
		// Sort the collection of DVDs - based on the compareTo()
		// method
		Collections.sort((List)collection);
		
		// Iterate through the ArrayList and output their titles -
		// in sorted order
		iterator = collection.iterator();
	
		System.out.println("-----------------------------------");
		System.out.println("The DVDs currently in the order are");
		
		while (iterator.hasNext()) {
			System.out.println(((DigitalVideoDisc)iterator.next()).getTitle());
		}
		
		System.out.println("-----------------------------------");
	}

}

package hust.soict.globalict.aims;
import java.util.Scanner;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class StoreTest {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);

		// Create a new cart
		Store anItem = new Store();
		
		// Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anItem.addDVD(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anItem.addDVD(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anItem.addDVD(dvd3);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		DigitalVideoDisc dvd6 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		DigitalVideoDisc dvd7 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 5.6f);
		DigitalVideoDisc dvd8 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		anItem.addDVD(new DigitalVideoDisc[] {dvd4, dvd5, dvd6, dvd7, dvd8});

		// search for a dvd
		System.out.print("Search for ID: ");
		int id = keyboard.nextInt();
		anItem.searchIdDVD(id);
		
		// remove a dvd
		anItem.removeDVD(dvd5);
		anItem.printStore();
		
		keyboard.close();
	}
	
}

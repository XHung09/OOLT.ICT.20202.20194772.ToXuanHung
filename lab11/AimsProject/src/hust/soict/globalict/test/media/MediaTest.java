package hust.soict.globalict.test.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

public class MediaTest {

	public static void main(String[] args) throws Exception {
		List<Media> mediae = new ArrayList<Media>();
		List<String> authors = new ArrayList<String>();
		authors.add("Hiroshi Fujimoto");
		authors.add("Motoo Abiko");
		
		Book b1 = new Book("Doraemon", "Comic", 1.99f, authors);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		DigitalVideoDisc dvd3 = null;
		mediae.add(dvd1);
		mediae.add(dvd2);
		mediae.add(b1);
		
		try {
			if (mediae.get(0).equals(dvd3)) {
				System.out.println("equal");
			} else {
				System.out.println("not equal");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			if (mediae.get(0).compareTo(dvd3) < 0) {
				System.out.println("smaller");
			} else if (mediae.get(0).compareTo(dvd3) > 0) {
				System.out.println("bigger");
			} else {
				System.out.println("equal");
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		for (Media m : mediae) {
//			m.toString();
			System.out.println(m);
		}
	}
	
}

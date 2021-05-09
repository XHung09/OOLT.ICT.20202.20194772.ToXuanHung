package hust.soict.globalict.test.book;

import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.media.Book;

public class BookTest {
	
	public static void main(String[] args) {
		List<String> authors = new ArrayList<String>();
		authors.add("Hiroshi Fujimoto");
		authors.add("Motoo Abiko");
		
		Book b1 = new Book("Doraemon", "Comic", 1.99f, authors);
		
		b1.addContent();
		b1.processContent();
		System.out.println(b1.toString());
	}
	
}

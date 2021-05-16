package hust.soict.globalict.aims.screen;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.store.Store;

public class AddBookToStoreScreen extends AddItemToStoreScreen {

	public AddBookToStoreScreen(Store store) {
		super();
		Book book;
		String title  = JOptionPane.showInputDialog("Book title");
		
		String category = JOptionPane.showInputDialog("Book Category");
		
		String author = JOptionPane.showInputDialog("Book authors");
		String temp[] = author.split(",");
		
		String cost = JOptionPane.showInputDialog("Book Cost");
		float floatCost = Float.parseFloat(cost);
		
		book = new Book(title, category, floatCost);
		
		for (int i = 0; i < temp.length; i++) {
			book.addAuthor(temp[i]);
		}
	
		store.addMedia(book);
	}

}

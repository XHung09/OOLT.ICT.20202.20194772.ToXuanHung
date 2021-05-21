package hust.soict.globalict.aims.screen;

import javax.naming.LimitExceededException;
import javax.swing.JOptionPane;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	
	public AddDigitalVideoDiscToStoreScreen(Store store) throws LimitExceededException {
		super();
		DigitalVideoDisc dvd;
		String title  = JOptionPane.showInputDialog("DVD title");
		
		String category = JOptionPane.showInputDialog("DVD Category");
		
		String director = JOptionPane.showInputDialog("DVD Director");
		
		String length = JOptionPane.showInputDialog("DVD Length");
		int intLength = Integer.parseInt(length);
		
		String cost = JOptionPane.showInputDialog("DVD Cost");
		float floatCost = Float.parseFloat(cost);
		
		dvd = new DigitalVideoDisc(title, category, director, intLength, floatCost);
		store.addMedia(dvd);
	}
	
}

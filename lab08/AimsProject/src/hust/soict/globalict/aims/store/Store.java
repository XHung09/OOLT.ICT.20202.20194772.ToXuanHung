package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;

import java.util.ArrayList;

public class Store {
	public static final int MAX_ITEM_NUMBER = 100;
	private ArrayList<Media> itemsInStore= new ArrayList<Media>();
	
	public Media discList(int id) {
		if ((id < 0) || (id > itemsInStore.size() - 1)) {
			System.out.println("This ID does not exist!");
			return null;
		} else {
			return itemsInStore.get(id);
		}
	}
	
	// Add media
	public void addMedia(Media item) {
		if ((itemsInStore.contains(item) == false) && (itemsInStore.size() < MAX_ITEM_NUMBER)) {
			itemsInStore.add(item);
			System.out.println("Succeed!");
		} 
	}
	
	// Add a media list by passing an arbitrary number of arguments
	public void addMedia(Media ... itemList) {
		for(Media item : itemList) {
			if ((itemsInStore.contains(item) == false) && (itemsInStore.size() < MAX_ITEM_NUMBER)) {
				this.addMedia(item);
				System.out.println("Succeed!");
			} 
		}
	} 
	
	// Remove media
	public void removeMedia(Media item) {
		if(itemsInStore.size() <= 0) {
			System.out.println("Your cart is empty!");
		} else {
			if (itemsInStore.contains(item) == true) {
				itemsInStore.add(item);
				System.out.println("Succeed!");
			} 
		}	
	}
	
	// Print store
	public void printStore() {
		System.out.println();
		System.out.println("***********************************Order***********************************");
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (itemsInStore.get(i) instanceof DigitalVideoDisc) {
				DigitalVideoDisc dvd = (DigitalVideoDisc)itemsInStore.get(i);
				System.out.println("ID: " + dvd.getId() + " - #" + (i+1) + ". " + dvd.toString());		
			} else if (itemsInStore.get(i) instanceof Book) {
				Book book = (Book)itemsInStore.get(i);
				System.out.println("ID: " + book.getId() + " - #" + (i+1) + ". " + book.toString());
			} else if (itemsInStore.get(i) instanceof CompactDisc) {
				CompactDisc cd = (CompactDisc)itemsInStore.get(i);
				System.out.println("ID: " + cd.getId() + " - #" + (i+1) + ". " + cd.toString());
				cd.play();
			}
		}
		System.out.println("***************************************************************************");
	}
	
	// search media by id
	public boolean searchId(int id) {
		boolean flag = false;
			
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (id == itemsInStore.get(i).getId()) {
				flag = true;
			} 
		}
		
		if (flag == false) {
			System.out.println("ID not found!");
		}	
		
		return flag;
	}
	
	// remove media by id
	public void removeIdMedia(int id) {
		if (id < itemsInStore.size()) {
			itemsInStore.remove(id);
			System.out.println("Succeed!");
		} else if (itemsInStore.size() == 0) { 
			System.out.println("Your store is empty!");
		} else {
			System.out.println("This ID does not exist!");
		}
	}
	
	// play
	public void play(int id) {
		if (itemsInStore.get(id) instanceof DigitalVideoDisc) {
			DigitalVideoDisc dvd = (DigitalVideoDisc)itemsInStore.get(id);
			dvd.play();
		} else if (itemsInStore.get(id) instanceof CompactDisc) {
			CompactDisc cd = (CompactDisc)itemsInStore.get(id);
			cd.play();
		} else {
			System.out.println("Fail to play book!");
		}
	}
}
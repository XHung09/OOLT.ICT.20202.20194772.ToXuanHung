package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.media.Book;
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
		} else {
			System.out.println("Fail!");
		}
	}
	
	// Add a media list by passing an arbitrary number of arguments
	public void addMedia(Media ... itemList) {
		for(Media item : itemList) {
			if ((itemsInStore.contains(item) == false) && (itemsInStore.size() < MAX_ITEM_NUMBER)) {
				this.addMedia(item);
				System.out.println("Succeed!");
			} else {
				System.out.println("Fail!");
			}
		}
	}
	
	// Remove media
	public void removeMedia(Media item) {
		if(itemsInStore.size() <= 0) {
			System.out.println("Your cart is empty!");
		}
		else {
			if (itemsInStore.contains(item) == true) {
				itemsInStore.add(item);
				System.out.println("Succeed!");
			} else {
				System.out.println("Fail!");
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
				System.out.print("ID: " + dvd.getId() + " - #" + (i+1) + ". DVD - ");
				System.out.print(dvd.getTitle() + " - ");
				System.out.print(dvd.getCategory() + " - ");
				System.out.print(dvd.getDirector() + " - ");
				System.out.print(dvd.getLength() + ": ");
				System.out.println(dvd.getCost() + "$");
			} else if (itemsInStore.get(i) instanceof Book) {
				Book book = (Book)itemsInStore.get(i);
				System.out.print("ID: " + book.getId() + " - #" + (i+1) + ". BOOK - ");
				System.out.print(book.getTitle() + " - ");
				System.out.print(book.getCategory() + " - ");
				System.out.print(book.getAuthors() + " - ");
				System.out.println(book.getCost() + "$");
			}
		}
		System.out.println("***************************************************************************");
		System.out.println();
	}
	
	// search media by id
	public void searchIdMedia(int id) {
		boolean flag = false;
			
		for (int i = 0; i < itemsInStore.size(); i++) {
			if (id == itemsInStore.get(i).getId()) {
				System.out.println(itemsInStore.get(i).getDetail());
				flag = true;
			} 
		}
		if (flag == false) {
			System.out.println("ID not found!");
		}	
	}
	
	// remove media by id
	public void removeIdMedia(int id) {
		if (itemsInStore.contains(itemsInStore.get(id))) {
			itemsInStore.remove(id);
			System.out.println("Succeed!");
		} else {
			System.out.println("Fail!");
		}
	}
}
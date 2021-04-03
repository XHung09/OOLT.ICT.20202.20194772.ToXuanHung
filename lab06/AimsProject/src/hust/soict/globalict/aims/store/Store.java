package hust.soict.globalict.aims.store;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import java.util.ArrayList;

public class Store {
	public static final int MAX_ITEM_NUMBER = 100;
	private ArrayList<Media> itemsInStore= new ArrayList<Media>();
	private int qtyItems = 0;
	
	public Media discList(int id) {
		return itemsInStore.get(id);
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
	
	// Add a dvd list by passing an arbitrary number of arguments
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
		System.out.println("***********************Store***********************");
		if (qtyItems == 0) {
			System.out.println("Store is empty!");
		} else {
			for (int i = 0; i < itemsInStore.size(); i++) {
				System.out.print("ID: " + itemsInStore.get(i).getId() + " - No." + (i+1) + ". DVD - ");
				System.out.print(itemsInStore.get(i).getTitle() + " - ");
				System.out.print(itemsInStore.get(i).getCategory() + " - ");
//				System.out.print(itemsInStore.get(i).getDirector() + " - ");
//				System.out.print(itemsInStore.get(i).getLength() + ": ");
				System.out.println(itemsInStore.get(i).getCost() + "$");
			}
		}
		System.out.println("***************************************************");
		System.out.println();
	}
}
package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.MediaLengthComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	// Add media
	public void addMedia(Media item) {
		if ((itemsOrdered.contains(item) == false) && (itemsOrdered.size() < MAX_NUMBERS_ORDERED)) {
			itemsOrdered.add(item);
			System.out.println("Succeed!");
		} 
	}
	
	// Add a dvd list by passing an arbitrary number of arguments
	public void addMedia(Media ... itemList) {
		for(Media item : itemList) {
			if ((itemsOrdered.contains(item) == false) && (itemsOrdered.size() < MAX_NUMBERS_ORDERED)) {
				this.addMedia(item);
			} 
		}
	}
	
	// Remove media
	public void removeMedia(Media item) {
		if(itemsOrdered.size() <= 0) {
			System.out.println("Your cart is empty!");
		}
		else {
			if (itemsOrdered.contains(item) == true) {
				itemsOrdered.add(item);
				System.out.println("Succeed!");
			} 
		}	
	}
	
	// remove media by id
	public void removeIdMedia(int id) {
		if (itemsOrdered.contains(itemsOrdered.get(id))) {
			itemsOrdered.remove(id);
			System.out.println("Succeed!");
		} 
	}
	
	// Total cost
	public float totalCost() {
		float sum = 0.0f;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	
	// Sort the cart	
	public void sortCartByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}
	
	public void sortCartByTitleCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}
	
	public void sortCartByLength() {
		Collections.sort(itemsOrdered, new MediaLengthComparator());
	}
	
	public void sortCartByTitleCategory() {
		Collections.sort(itemsOrdered);
	}
	
	// search dvd by id
	public void searchIdMedia() {
		boolean flag = false;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Search for ID: ");
		int id = keyboard.nextInt();
		
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (id == itemsOrdered.get(i).getId()) {
				System.out.println(itemsOrdered.get(i).getDetail());
				flag = true;
			} 
		}
		if (flag == false) {
			System.out.println("ID not found!");
		}
		
		keyboard.close();
	}

	// search media by id
	public boolean searchId(int id) {
		boolean flag = false;
			
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (id == itemsOrdered.get(i).getId()) {
				flag = true;
			} 
		}
		
		if (flag == false) {
			System.out.println("ID not found!");
		}	
		return flag;
	}
	
	// search dvd by title
	public void searchTitleMedia() {
		boolean flag = false;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Search for Title: ");
		String title = keyboard.nextLine();
		
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i).search(title) == true) {
				System.out.println(itemsOrdered.get(i).getDetail());
				flag = true;
			} 
		}
		
		if (flag == false) {
			System.out.println("Title not found!");
		}
		
		keyboard.close();
	}
	
	// get detail
	public void printCart() {
		System.out.println();
		System.out.println("***********************************Order***********************************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i) instanceof DigitalVideoDisc) {
				DigitalVideoDisc dvd = (DigitalVideoDisc)itemsOrdered.get(i);
				System.out.println("ID: " + dvd.getId() + " - #" + (i+1) + ". " + dvd.getDetail());		
			} else if (itemsOrdered.get(i) instanceof Book) {
				Book book = (Book)itemsOrdered.get(i);
				System.out.println("ID: " + book.getId() + " - #" + (i+1) + ". " + book.getDetail());
			} else if (itemsOrdered.get(i) instanceof CompactDisc) {
				CompactDisc cd = (CompactDisc)itemsOrdered.get(i);
				System.out.println("ID: " + cd.getId() + " - #" + (i+1) + ". " + cd.getDetail());
				cd.play();
			}
		}
		System.out.print("Total cost: ");
		System.out.printf("%.2f$\n", totalCost());
		System.out.println("***************************************************************************");
		System.out.println();
	}
	
	// get a lucky item
	public void getALuckyItem() {
        int rand = (int)(Math.random() * itemsOrdered.size()) + 0;
        itemsOrdered.get(rand).freeCost();
    }
	
	// play
	public void play(int id) {
		if (itemsOrdered.get(id) instanceof DigitalVideoDisc) {
			DigitalVideoDisc dvd = (DigitalVideoDisc)itemsOrdered.get(id);
			dvd.play();
		} else if (itemsOrdered.get(id) instanceof CompactDisc) {
			CompactDisc cd = (CompactDisc)itemsOrdered.get(id);
			cd.play();
		} else {
			System.out.println("Fail to play book!");
		}
	}
	
}
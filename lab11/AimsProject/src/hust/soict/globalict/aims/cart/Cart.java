package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.exception.LuckyItemException;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.MediaLengthComparator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Collections;
import java.util.Scanner;

import javax.naming.LimitExceededException;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	// Add media
	public void addMedia(Media item) throws LimitExceededException {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			if (itemsOrdered.contains(item) == false) {
				itemsOrdered.add(item);
				System.out.println("Succeed!");
			}
		} else {
			throw new LimitExceededException("ERROR: The number of "
					+ "media has reached its limmit");
		}
	}
	
	// Add a dvd list by passing an arbitrary number of arguments
	public void addMedia(Media ... itemList) throws LimitExceededException {
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
		} else {
			if (itemsOrdered.contains(item) == true) {
				itemsOrdered.remove(item);
				System.out.println("Succeed!");
			} 
		}	
	}
	
	// remove media by id
	public void removeIdMedia(int id) {
		if (id < itemsOrdered.size()) {
			itemsOrdered.remove(id);
		} else if (itemsOrdered.size() <= 0) { 
			System.out.println("Your cart is empty!");
		} else {
			System.out.println("This ID does not exist!");
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
				System.out.println(itemsOrdered.get(i).toString());
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
				System.out.println(itemsOrdered.get(i).toString());
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
		System.out.println("********************************Order********************************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			if (itemsOrdered.get(i) instanceof DigitalVideoDisc) {
				DigitalVideoDisc dvd = (DigitalVideoDisc)itemsOrdered.get(i);
				System.out.println("ID: " + dvd.getId() + " - #" + (i+1) + ". " + dvd.toString());		
			} else if (itemsOrdered.get(i) instanceof Book) {
				Book book = (Book)itemsOrdered.get(i);
				System.out.println("ID: " + book.getId() + " - #" + (i+1) + ". " + book.toString());
			} else if (itemsOrdered.get(i) instanceof CompactDisc) {
				CompactDisc cd = (CompactDisc)itemsOrdered.get(i);
				System.out.println("ID: " + cd.getId() + " - #" + (i+1) + ". " + cd.toString());
				cd.displayTracksDetails();
			}
		}
		System.out.print("Total cost: ");
		System.out.printf("%.2f$\n", totalCost());
		System.out.println("*********************************************************************");
	}
	
	// get a lucky item
	// threshold for the number of items is 3
	// threshold for the price is 150$
	// threshold for the price of the lucky item is 
	public void getALuckyItem() throws LuckyItemException {
		if (this.itemsOrdered.size() < 3) {
			throw new LuckyItemException("Do not meet our lucky item policy!");
		} else if (this.totalCost() < 150) {
			throw new LuckyItemException("Do not meet our lucky item policy!");
		} else {
			System.out.println("You will get a random free lucky item. Hooray!");
			System.out.println("Please check the lucky item in your cart");
			float threshold;
			
			if (this.totalCost() < 350) {
				threshold = 50;
			} else {
				threshold = 100;
			}
			
			int luckyItemId = 0;
			for (int i = 0; i < this.itemsOrdered.size(); i++) {
				float luckyItemCost = this.itemsOrdered.get(i).getCost();
				if (luckyItemCost < threshold && luckyItemId == -1) {
					luckyItemId = i;
					continue;
				}
				
				if (itemsOrdered.get(luckyItemId).getCost() < luckyItemCost && luckyItemCost < threshold) {
					luckyItemId = i;
				}
			}
			
	        itemsOrdered.get(luckyItemId).freeCost();
		}
    }
	
	// play
	public void play(int id) throws PlayerException {
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
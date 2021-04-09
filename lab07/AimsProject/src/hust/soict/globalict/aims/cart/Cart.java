package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.MediaCostComparator;
import hust.soict.globalict.aims.media.MediaLengthComparator;
import hust.soict.globalict.aims.media.MediaTitleComparator;

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
		} else if (item == null) {
			System.out.println("Fail!");
		} else {
			System.out.println("Fail!");
		}
	}
	
	// Add a dvd list by passing an arbitrary number of arguments
	public void addMedia(Media ... itemList) {
		for(Media item : itemList) {
			if ((itemsOrdered.contains(item) == false) && (itemsOrdered.size() < MAX_NUMBERS_ORDERED)) {
				this.addMedia(item);
				System.out.println("Succeed!");
			} else {
				System.out.println("Fail!");
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
			} else {
				System.out.println("Fail!");
			}
		}	
	}
	
	// remove media by id
	public void removeIdMedia(int id) {
		if (itemsOrdered.contains(itemsOrdered.get(id))) {
			itemsOrdered.remove(id);
			System.out.println("Succeed!");
		} else {
			System.out.println("Fail!");
		}
	}
	
	// Total cost
	public double totalCost() {
		double sum = 0.0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			sum += itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	
	// Sort the cart	
	public void sortCartByCost() {
		Collections.sort(itemsOrdered, new MediaCostComparator());
	}
	
	public void sortCartByTitle() {
		Collections.sort(itemsOrdered, new MediaTitleComparator());
	}
	
	public void sortCartByLength() {
		Collections.sort(itemsOrdered, new MediaLengthComparator());
	}
	
	// search dvd by id
	public void searchIdDigitalVideoDisc() {
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
	
	// search dvd by title
	public void searchTitleDigitalVideoDisc() {
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
				System.out.print("ID: " + dvd.getId() + " - #" + (i+1) + ". DVD - ");
				System.out.print(dvd.getTitle() + " - ");
				System.out.print(dvd.getCategory() + " - ");
				System.out.print(dvd.getDirector() + " - ");
				System.out.print(dvd.getLength() + ": ");
				System.out.println(dvd.getCost() + "$");
			} else if (itemsOrdered.get(i) instanceof Book) {
				Book book = (Book)itemsOrdered.get(i);
				System.out.print("ID: " + book.getId() + " - #" + (i+1) + ". BOOK - ");
				System.out.print(book.getTitle() + " - ");
				System.out.print(book.getCategory() + " - ");
				System.out.print(book.getAuthors() + " - ");
				System.out.println(book.getCost() + "$");
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
        itemsOrdered.get(rand).setCost(0);
    }
}
package hust.soict.globalict.aims.store;

import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Store {
	public static final int MAX_ITEM_NUMBER = 100;
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[MAX_ITEM_NUMBER];
	private int qtyItems = 0;
	
	public DigitalVideoDisc discList(int id) {
		return itemsInStore[id];
	}
	
	// Add a dvd
	public void addDVD(DigitalVideoDisc disc) {
		if (qtyItems < MAX_ITEM_NUMBER) {
			itemsInStore[qtyItems] = disc;
			this.qtyItems += 1;
			System.out.println("The disc " + disc.getTitle() + " has been added");
		} else {
			System.out.println("The store is almost full");
		}
	}

	// Add a dvd list
	public void addDVD(DigitalVideoDisc ... disc) {
		if (qtyItems + disc.length <= MAX_ITEM_NUMBER) {
			for (int i = 0; i < disc.length; i++) {
				itemsInStore[qtyItems + i] = disc[i];
				System.out.println("The disc " + disc[i].getTitle() + " has been added");
			}
			this.qtyItems += disc.length;
		} else {
			System.out.println("The store is almost full");
		}
	}
	
	// Remove a dvd
	public void removeDVD(DigitalVideoDisc disc) {
		DigitalVideoDisc copyItemsOrdered[] = new DigitalVideoDisc[MAX_ITEM_NUMBER - 1];
		
		if (qtyItems > 0) {
			System.out.println("\nChecking disc's title: " + disc.getTitle());
			
			for (int i = 0, j = 0; i < qtyItems; i++) {
				if (copyItemsOrdered[i] != disc) {
					copyItemsOrdered[j++] = itemsInStore[i]; 
				}	
			}
			
			itemsInStore = copyItemsOrdered;
			this.qtyItems -= 1;
			System.out.println("The disc " + disc.getTitle() + " has been removed");
		} else {
			System.out.println("The store is empty now!");
		}
	}
	
	// Print store
	public void printStore() {
		System.out.println();
		System.out.println("***********************Store***********************");
		if (qtyItems == 0) {
			System.out.println("Store is empty!");
		} else {
			for (int i = 0; i < qtyItems; i++) {
				System.out.print("ID: " + itemsInStore[i].getId() + " - No." + (i+1) + ". DVD - ");
				System.out.print(itemsInStore[i].getTitle() + " - ");
				System.out.print(itemsInStore[i].getCategory() + " - ");
				System.out.print(itemsInStore[i].getDirector() + " - ");
				System.out.print(itemsInStore[i].getLength() + ": ");
				System.out.println(itemsInStore[i].getCost() + "$");
			}
		}
		System.out.println("***************************************************");
		System.out.println();
	}
	
	// search dvd by id
	public void searchIdDVD(int id) {
		boolean flag = false;
			
		for (int i = 0; i < qtyItems; i++) {
			if (id == itemsInStore[i].getId()) {
				System.out.println(itemsInStore[i].getDetail());
				flag = true;
			} 
		}
		if (flag == false) {
			System.out.println("ID not found!");
		}
		
	}
	
	// remove dvd by id
	public void removeIdDVD(DigitalVideoDisc disc) {
		DigitalVideoDisc copyItemsOrdered[] = new DigitalVideoDisc[MAX_ITEM_NUMBER - 1];
		
		if (qtyItems > 0) {
			System.out.println("\nChecking disc's title: " + disc.getTitle());
			
			for (int i = 0, j = 0; i < qtyItems; i++) {
				if (copyItemsOrdered[i] != disc) {
					copyItemsOrdered[j++] = itemsInStore[i]; 
				}	
			}
			
			itemsInStore = copyItemsOrdered;
			this.qtyItems -= 1;
			System.out.println("The disc " + disc.getTitle() + " has been removed");
		} else {
			System.out.println("The store is empty now!");
		}
	}
}

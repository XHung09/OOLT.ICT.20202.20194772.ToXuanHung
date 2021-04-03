package hust.soict.globalict.aims;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.disc.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;

import java.awt.event.ItemEvent;
import java.util.Scanner;

public class Aims {

	public static void main(String[] args) {
		int choice = 0;
		Cart anOrder = new Cart();
		Store anItem = new Store();
		Scanner keyboard = new Scanner(System.in);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anItem.addDVD(dvd1);
		
		do {
			showMenu();
			choice = keyboard.nextInt();
			
			switch (choice) {
			// choice 0
				case 0: 
					break;
			
			// choice 1
				case 1: 	
					int subChoice = 0;
					anItem.printStore();
					storeMenu();
					subChoice = keyboard.nextInt();
					
					switch (subChoice) {
						case 1:
							System.out.print("Search for ID: ");
							int id = keyboard.nextInt();
							anItem.searchIdDVD(id);
							System.out.println("Do you want to add this to your cart? \nChoice: 1 for Yes - 2 for No");
							subChoice = keyboard.nextInt();
							if (subChoice == 1) {
								anOrder.addDigitalVideoDisc(anItem.discList(id));
							}
							break;
							
						case 2:
							System.out.println("Enter the ID of DVD that you want to add to your cart:");
							anItem.printStore();
							id = keyboard.nextInt();
							anItem.searchIdDVD(id);
							anOrder.addDigitalVideoDisc(anItem.discList(id));
							break;
							
						case 3:
							anOrder.printCart();
							
						case 0:
							break;
							
						default:
							System.out.println("Wrong choice!");
							break;
					}
					break;
					
			// choice 2
				case 2:												
					System.out.println("Add or Remove a DVD: \nchoose a number: 1-2");
					choice = keyboard.nextInt();
					if (choice == 1) {
						keyboard.nextLine();
						System.out.print("Title: ");
				    	String title = keyboard.nextLine();
				    	System.out.print("Category: ");
				    	String category = keyboard.nextLine();
				    	System.out.print("Director: ");
				    	String director = keyboard.nextLine();
				    	System.out.print("Length: ");
				    	int length = keyboard.nextInt();
				    	 
				    	while (length <= 0) {
				    		System.out.println("Length must be positive");
					    	length = keyboard.nextInt();
				    	}
				    	 
				    	System.out.print("Cost: ");
				    	float cost = (float) keyboard.nextDouble();
				    	 
				    	while (cost <= 0) {
				    		System.out.println("Cost must be positive!");
				    		cost = (float) keyboard.nextDouble();
				    	}
				    	 
				    	DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
				    	anItem.addDVD(dvd);
					} else if (choice == 2) {
						System.out.println("Remove DVD ID:");
						int id = keyboard.nextInt();
						anItem.removeDVD(null);
					}
					break;
					
			// choice 3
				case 3:	
					anOrder.printCart();
					cartMenu();
					choice = keyboard.nextInt();
					switch (choice) {
						case 1:
							System.out.println("Filter by ID or by Title: \nchoose a number: 1-2");
							choice = keyboard.nextInt();
							if (choice == 1) {
								anOrder.searchIdDigitalVideoDisc();
							} else if (choice == 2) {
								anOrder.searchTitleDigitalVideoDisc();
							}
							break;
						
						case 2:
							System.out.println("Sort by Title or by Cost: \nchoose a number: 1-2");
							choice = keyboard.nextInt();
							if (choice == 1) {
								anOrder.sortCartByTitle();;
							} else if (choice == 2) {
								anOrder.sortCartByCost();
							}
							break;
							
						case 3:
							anOrder.printCart();
							break;
							
						case 0:
							break;
							
						default:
							System.out.println("Wrong choice!");
							break;
					}
				
			// choice 4
				case 4:												
					System.out.println("An order has been created\n");
					break;
					
				default:
					System.out.println("Wrong choice!");
					break;
			}
			
		} while (choice != 0);
	
		keyboard.close();
	}

	// Show menu
	public static void showMenu() {
		System.out.println("\nAIMS: ");
		System.out.println("----------------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. exit");
		System.out.println("----------------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	// Store menu
	public static void storeMenu() {
		System.out.println("\nOptions: ");
		System.out.println("----------------------------------------");
		System.out.println("1. See a DVD's details");
		System.out.println("2. Add a DVD to current cart");
		System.out.println("3. See crrent cart");
		System.out.println("0. Exit");
		System.out.println("----------------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	// Cart menu
	public static void cartMenu() {
		System.out.println("\nOptions: ");
		System.out.println("----------------------------------------");
		System.out.println("1. Filter DVDs in cart");
		System.out.println("2. Sort DVDs in cart");
		System.out.println("3. Remove DVD from cart");
		System.out.println("4. Place order");
		System.out.println("0. Exit");
		System.out.println("----------------------------------------");
	}
}
package hust.soict.globalict.aims;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.store.Store;
import java.util.Scanner;

public class Aims {

	public static void main(String[] args) {
		int choice = 0;
		int subChoice = 0;
		int mediaChoice = 0;
		Cart anOrder = new Cart();
		Store anItem = new Store();
		Scanner keyboard = new Scanner(System.in);
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anItem.addMedia(dvd1);
		
		do {
			showMenu();
			choice = keyboard.nextInt();
			
			switch (choice) {
			// choice 0
				case 0:
					System.out.println("Exit");
					break;
					
			// choice 1
				case 1: 	
					anItem.printStore();
					storeMenu();
					subChoice = keyboard.nextInt();
					
					switch (subChoice) {
						case 0:
							System.out.println("Exit");
							break;
							
						case 1:
							System.out.print("Search for ID: ");
							int id = keyboard.nextInt();
							anItem.searchIdMedia(id);
							System.out.println("Do you want to add this to your cart? \nChoice: 1 for Yes - 2 for No");
							subChoice = keyboard.nextInt();
							if (subChoice == 1) {
								anOrder.addMedia(anItem.discList(id));
							}
							break;
							
						case 2:
							System.out.println("Enter the ID of DVD that you want to add to your cart:");
							anItem.printStore();
							id = keyboard.nextInt();
							anItem.searchIdMedia(id);
							anOrder.addMedia(anItem.discList(id));
							break;
							
						case 3:
							anOrder.printCart();
							break;
							
						default:
							keyboard.nextLine();
							System.out.println("Wrong choice!");
							break;
					}
					break;
					
			// choice 2
				case 2:												
					System.out.println("Add or Remove a media: \n1. Add a media \n2. Remove a media");
					subChoice = keyboard.nextInt();
					System.out.println("1. DVD\n2. Book");
					if (subChoice == 1) {
						mediaChoice = keyboard.nextInt();
						if (mediaChoice == 1) {												// add a dvd										
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
				    		anItem.addMedia(dvd);
				    	} else if (mediaChoice == 2) {										// add a book
				    		keyboard.nextLine();
				    		System.out.print("Book title: ");
							String title = keyboard.nextLine();
							
							System.out.print("Category: ");
							String category = keyboard.nextLine();
							
							System.out.print("Author: ");
							String temp = keyboard.nextLine();
							String authors[] = temp.split(",");
							
							System.out.print("Cost: ");
							Float cost = keyboard.nextFloat();
							
							Book book = new Book(title, category);
							for (int i = 0; i < authors.length; i++) {
								book.addAuthor(authors[i]);
							}
							book.setCost(cost);
							anItem.addMedia(book);
				    	} else {
							System.out.println("Wrong choice!");
				    	}
					} else if (subChoice == 2) {
						anItem.printStore();
						System.out.println("Remove DVD ID:");
						int id = keyboard.nextInt();
						anItem.removeIdMedia(id);
					} else {
						System.out.println("Wrong choice!");
					}
					break;
					
			// choice 3
				case 3:	
					anOrder.printCart();
					cartMenu();
					subChoice = keyboard.nextInt();
					switch (subChoice) {
						case 0:
							System.out.println("Exit");
							break;
							
						case 1:
							System.out.println("Filter by ID or by Title: \nchoose a number: 1-2");
							subChoice = keyboard.nextInt();
							if (subChoice == 1) {
								anOrder.searchIdDigitalVideoDisc();
							} else if (subChoice == 2) {
								anOrder.searchTitleDigitalVideoDisc();
							}
							break;
						
						case 2:
							System.out.println("Sort by Title or by Cost: \nchoose a number: 1-2");
							subChoice = keyboard.nextInt();
							if (subChoice == 1) {
								anOrder.sortCartByTitle();
							} else if (subChoice == 2) {
								anOrder.sortCartByCost();
							}
							break;
							
						case 3:
							anOrder.printCart();
							System.out.println("Remove DVD ID:");
							int id = keyboard.nextInt();
							anOrder.removeIdMedia(id);
							break;
							
						case 4:
							anOrder.getALuckyItem();
							System.out.println("You will get a random free item. Hooray!");
							break;
							
						case 5:												
							System.out.println("An order has been created\n");
							break;
							
						default:
							System.out.println("Wrong choice!");
							break;
					}
					break;
					
			// default		
				default:
					System.out.println("Wrong choice!");
					break;
			}
			
		} while (choice != 0);
	
		System.out.print("Goodbye");
		keyboard.close();
	}

	// Show menu
	public static void showMenu() {
		System.out.println("\nAIMS: ");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. exit");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	// Store menu
	public static void storeMenu() {
		System.out.println("\nOptions: ");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to current cart");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	// Cart menu
	public static void cartMenu() {
		System.out.println("\nOptions: ");
		System.out.println("----------------------------------------------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Get a lucky item in cart");
		System.out.println("5. Place order");
		System.out.println("0. Exit");
		System.out.println("----------------------------------------------------------------------");
	}
	
}
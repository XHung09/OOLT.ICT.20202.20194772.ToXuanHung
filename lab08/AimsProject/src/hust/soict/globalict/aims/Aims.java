package hust.soict.globalict.aims;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Aims {

	public static void main(String[] args) {
		int choice = 0;
		int subChoice = 0;
		int mediaChoice = 0;
		Cart anOrder = new Cart();
		Store anItem = new Store();
		List<Track> trackList = new ArrayList<Track>();
		Scanner keyboard = new Scanner(System.in);

//		Using threads here

//		MemoryDaemon daemon = new MemoryDaemon();
//		Thread someThread = new Thread(daemon);
//		someThread.setDaemon(true);
//		someThread.start();
		
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
							
							if (anItem.searchId(id)) {
								System.out.println("Do you want to add this to your cart? \nChoice: 1 for Yes - 2 for No");
								subChoice = keyboard.nextInt();
								
								if (subChoice == 1) {
									anOrder.addMedia(anItem.discList(id));
								}
								
							}

							break;
							
						case 2:
							System.out.println("Enter the ID of the DVD that you want to add to your cart:");
							anItem.printStore();
							id = keyboard.nextInt();
							
							if (anItem.searchId(id)) {
								anOrder.addMedia(anItem.discList(id));
							}

							break;
							
						case 3:
							keyboard.nextLine();
							System.out.println("Enter the ID of the media that you want to play (only disc allowed):");
							anItem.printStore();
							id = keyboard.nextInt();
							
							if (anItem.searchId(id)) {
								anItem.play(id);
							}
							
							break;
							
						case 4:
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
					
					if (subChoice == 1) {
						System.out.println("1. DVD \n2. Book \n3. CD");
						mediaChoice = keyboard.nextInt();
						if (mediaChoice == 1) {												// add a DVD										
							keyboard.nextLine();
							System.out.print("DVD title: ");
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
				    		float cost = keyboard.nextFloat();				    	 
				    		
				    		while (cost <= 0) {
				    			System.out.println("Cost must be positive!");
				    			cost = keyboard.nextFloat();
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
							
				    		while (cost <= 0) {
				    			System.out.println("Cost must be positive!");
				    			cost = keyboard.nextFloat();
				    		}
				    		
							Book book = new Book(title, category, cost);
							
							for (int i = 0; i < authors.length; i++) {
								book.addAuthor(authors[i]);
							}			
							
							book.addContent();
							book.processContent();
							anItem.addMedia(book);
				    	} else if (mediaChoice == 3) {										// add a CD
				      		keyboard.nextLine();
				    		System.out.print("CD title: ");
							String title = keyboard.nextLine();
							
							System.out.print("Category: ");
							String category = keyboard.nextLine();
							
							System.out.print("Director: ");
							String director = keyboard.nextLine();
							
							System.out.print("Artist: ");
							String artist = keyboard.nextLine();
							
							System.out.print("Cost: ");
							Float cost = keyboard.nextFloat();
				    	
							while (cost <= 0) {
				    			System.out.println("Cost must be positive!");
				    			cost = keyboard.nextFloat();
				    		}
				    		
							CompactDisc cd = new CompactDisc(title, category, director, artist, cost);
							System.out.print("Number of tracks: ");
							int n = keyboard.nextInt();
							
							for (int i = 0; i < n; i++) {
					      		keyboard.nextLine();
								System.out.print("Track's title: ");
								String trackTitle = keyboard.nextLine();
								
								System.out.print("Track's length: ");
								int trackLength = keyboard.nextInt();
								
								trackList.add(i, new Track(trackTitle, trackLength));
								cd.addTrack(trackList.get(i));
								anItem.addMedia(cd);
							}
				    	} else {
							System.out.println("Wrong choice!");
				    	}
					} else if (subChoice == 2) {
						anItem.printStore();
						System.out.println("Remove Media ID:");
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
								anOrder.searchIdMedia();
							} else if (subChoice == 2) {
								anOrder.searchTitleMedia();
							}
							
							break;
						
						case 2:
							System.out.println("Sort by: "
									+ "\n1. TitleCost "
									+ "\n2.CostTitle "
									+ "\n3. TitleCategory: "
									+ "\nchoose a number: 1-2-3");
							subChoice = keyboard.nextInt();
							
							if (subChoice == 1) {
								anOrder.sortCartByTitleCost();
							} else if (subChoice == 2) {
								anOrder.sortCartByCostTitle();
							} else if (subChoice == 3) {
								anOrder.sortCartByTitleCategory();
							}
							
							break;
							
						case 3:
							anOrder.printCart();
							System.out.println("Remove DVD ID:");
							int id = keyboard.nextInt();
							anOrder.removeIdMedia(id);
							break;
							
						case 4:
							keyboard.nextLine();
							System.out.println("Enter the ID of the media that you want to play (only disc allowed):");
							anOrder.printCart();
							id = keyboard.nextInt();
							
							if (anOrder.searchId(id)) {
								anOrder.play(id);
							}
							
							break;
							
						case 5:
							anOrder.getALuckyItem();
							System.out.println("You will get a random free item. Hooray!");
							break;
							
						case 6:												
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
	
		System.out.print("Goodbye\n");
		keyboard.close();
	}

	// Show menu
	public static void showMenu() {
		System.out.println("\nAIMS: ");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. exit");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	// Store menu
	public static void storeMenu() {
		System.out.println("\nOptions: ");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to current cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Exit");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
	}
	
	// Cart menu
	public static void cartMenu() {
		System.out.println("\nOptions: ");
		System.out.println("---------------------------------------------------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Get a lucky item in cart");
		System.out.println("6. Place order");
		System.out.println("0. Exit");
		System.out.println("---------------------------------------------------------------------------");
	}
}
package hust.soict.globalict.aims.cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import java.util.ArrayList;
import java.util.Scanner;


public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered= new ArrayList<Media>();
	
	// Add media
	public void addMedia(Media item) {
		if ((itemsOrdered.contains(item) == false) && (itemsOrdered.size() < MAX_NUMBERS_ORDERED)) {
			itemsOrdered.add(item);
			System.out.println("Succeed!");
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
		sortByCost(qtyOrdered, itemsOrdered);
		System.out.println("sort by cost: ");
	}
	
	public void sortCartByTitle() {
		sortByTitle(qtyOrdered, itemsOrdered);
		System.out.println("sort by Title: ");
	}
	
	public void sortCartByLength() {
		sortByLength(qtyOrdered, itemsOrdered);
		System.out.println("sort by Length: ");
	}
	
	// search dvd by id
	public void searchIdDigitalVideoDisc() {
		boolean flag = false;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Search for ID: ");
		int id = keyboard.nextInt();
		
		for (int i = 0; i < qtyOrdered; i++) {
			if (id == itemsOrdered[i].getId()) {
				System.out.println(itemsOrdered[i].getDetail());
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
		
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i].search(title) == true) {
				System.out.println(itemsOrdered[i].getDetail());
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
		System.out.println("***********************Order***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			System.out.print(i + 1 + ". DVD - ");
			System.out.print(itemsOrdered.get(i).getTitle() + " - ");
			System.out.print(itemsOrdered.get(i).getCategory() + " - ");
//			System.out.print(itemsOrdered.get(i).getDirector() + " - ");
//			System.out.print(itemsOrdered.get(i).getLength() + ": ");
			System.out.println(itemsOrdered.get(i).getCost() + "$");
		}
		System.out.print("Total cost: ");
		System.out.printf("%.2f$\n", totalCost());
		System.out.println("***************************************************");
		System.out.println();
	}
	
	// sort a number of dvds by Cost
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc ... DVDs) {
		quickSortByCost(DVDs, 0, DVDs.length-1);
		return DVDs;
	}
	
	public static DigitalVideoDisc[] sortByCost(int length, DigitalVideoDisc ... DVDs) {
		quickSortByCost(DVDs, 0, length-1);
		return DVDs;
	}
	
	public static int partitionByCost(DigitalVideoDisc arr[], int left, int right)
	{
	      int i = left, j = right;
	      DigitalVideoDisc tmp;
	      float pivot = arr[(left + right) / 2].getCost();
	      while (i <= j) {
	            while (arr[i].getCost() < pivot)
	                  i++;
	            while (arr[j].getCost() > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };     
	      return i;
	}
	
	public static void quickSortByCost(DigitalVideoDisc arr[], int left, int right) {
      int index = partitionByCost(arr, left, right);
	      if (left < index - 1)
	            quickSortByCost(arr, left, index - 1);
	      if (index < right)
	            quickSortByCost(arr, index, right);
	}
	
	// sort a number of dvds by Title
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc ... DVDs) {
		quickSortByTitle(DVDs, 0, DVDs.length - 1);
		return DVDs;
	}
	
	public static DigitalVideoDisc[] sortByTitle(int length, DigitalVideoDisc ... DVDs) {
		quickSortByTitle(DVDs, 0, length-1);
		return DVDs;
	}
	
	public static int partitionByTitle(DigitalVideoDisc arr[], int left, int right)
	{
	      int i = left, j = right;
	      DigitalVideoDisc tmp;
	      String pivot = arr[(left + right) / 2].getTitle();
	      while (i <= j) {
	            while (arr[i].getTitle().compareTo(pivot) < 0)
	                  i++;
	            while (arr[j].getTitle().compareTo(pivot) > 0)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };     
	      return i;
	}
	
	public static void quickSortByTitle(DigitalVideoDisc arr[], int left, int right) {
      int index = partitionByTitle(arr, left, right);
	      if (left < index - 1)
	            quickSortByTitle(arr, left, index - 1);
	      if (index < right)
	            quickSortByTitle(arr, index, right);
	}
	
	// sort a number of dvds by Length
	public static DigitalVideoDisc[] sortByLength(DigitalVideoDisc ... DVDs) {
		quickSortByLength(DVDs, 0, DVDs.length - 1);
		return DVDs;
	}
	
	public static DigitalVideoDisc[] sortByLength(int length, DigitalVideoDisc ... DVDs) {
		quickSortByLength(DVDs, 0, length-1);
		return DVDs;
	}
	
	public static int partitionByLength(DigitalVideoDisc arr[], int left, int right)
	{
	      int i = left, j = right;
	      DigitalVideoDisc tmp;
	      float pivot = arr[(left + right) / 2].getLength();
	      while (i <= j) {
	            while (arr[i].getLength() < pivot)
	                  i++;
	            while (arr[j].getLength() > pivot)
	                  j--;
	            if (i <= j) {
	                  tmp = arr[i];
	                  arr[i] = arr[j];
	                  arr[j] = tmp;
	                  i++;
	                  j--;
	            }
	      };     
	      return i;
	}
	
	public static void quickSortByLength(DigitalVideoDisc arr[], int left, int right) {
	      int index = partitionByLength(arr, left, right);
		      if (left < index - 1)
		            quickSortByLength(arr, left, index - 1);
		      if (index < right)
		            quickSortByLength(arr, index, right);
		}
}
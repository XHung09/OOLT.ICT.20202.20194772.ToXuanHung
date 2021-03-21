import java.util.Scanner;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	// Quantity ordered
	public int getQtyOrdered() {
		return qtyOrdered;
	}

	public void setQtyOrdered(int qtyOrdered) {
		this.qtyOrdered = qtyOrdered;
	}
	
	public DigitalVideoDisc[] getItemsOrdered() {
		return itemsOrdered;
	}

	public void setItemsOrdered(DigitalVideoDisc[] itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}
	
	// Add a dvd
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			setQtyOrdered(qtyOrdered + 1);
			System.out.println("The disc " + disc.getTitle() + " has been added");
		} else {
			System.out.println("The cart is almost full");
		}
	}
	
	// Add a dvd list

/*	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		if (qtyOrdered + dvdList.length < MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < dvdList.length; i++) {
				itemsOrdered[qtyOrdered + i] = dvdList[i];
				System.out.println("The disc " + dvdList[i].getTitle() + " has been added");
			}
			setQtyOrdered(qtyOrdered += dvdList.length);
		} else {
			System.out.println("The cart is almost full");
		}
	}
*/
	
	// Add a dvd list by passing an arbitrary number of arguments (this method is more preferred)
	public void addDigitalVideoDisc(DigitalVideoDisc ... disc) {
		if (qtyOrdered + disc.length <= MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < disc.length; i++) {
				itemsOrdered[qtyOrdered + i] = disc[i];
				System.out.println("The disc " + disc[i].getTitle() + " has been added");
			}
			setQtyOrdered(qtyOrdered += disc.length);
		} else {
			System.out.println("The cart is almost full");
		}
	}
	
	//
	
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if (qtyOrdered + 1 < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd1;
			setQtyOrdered(qtyOrdered + 1);
			System.out.println("The disc " + dvd1.getTitle() + " has been added");
			itemsOrdered[qtyOrdered] = dvd2;
			setQtyOrdered(qtyOrdered + 1);
			System.out.println("The disc " + dvd2.getTitle() + " has been added");
		} else {
			System.out.println("The cart is almost full");
		}
	}
	
	// Remove
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		DigitalVideoDisc copyItemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED - 1];
		
		if (qtyOrdered > 0) {
			System.out.println("\nChecking disc's title: " + disc.getTitle());
			
			for (int i = 0, j = 0; i < qtyOrdered; i++) {
				if (copyItemsOrdered[i] != disc) {
					copyItemsOrdered[j++] = itemsOrdered[i]; 
				}	
			}
			
			itemsOrdered = copyItemsOrdered;
			setQtyOrdered(qtyOrdered - 1);
			System.out.println("The disc " + disc.getTitle() + " has been removed");
		} else {
			System.out.println("The cart is empty now!");
		}
		
	}
	
	// Total cost
	public double totalCost() {
		double sum = 0.0;
		for (int i = 0; i < qtyOrdered; i++) {
			sum += itemsOrdered[i].getCost();
		}
		return sum;
	}
	
	// Sort the cart	
	public void sortCartByCost() {
		sortByCost(qtyOrdered, itemsOrdered);
		System.out.println("sort by cost: ");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(itemsOrdered[i].getDetail());
		} 
	}
	
	public void sortCartByTitle() {
		sortByTitle(qtyOrdered, itemsOrdered);
		System.out.println("sort by Title: ");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(itemsOrdered[i].getDetail());
		} 
	}
	
	public void sortCartByLength() {
		sortByLength(qtyOrdered, itemsOrdered);
		System.out.println("sort by Length: ");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(itemsOrdered[i].getDetail());
		} 
	}
	
	public void sortCart() {
		sortByTitle(qtyOrdered, itemsOrdered);
		sortByCost(qtyOrdered, itemsOrdered);
		sortByLength(qtyOrdered, itemsOrdered);
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.println(itemsOrdered[i].getDetail());
		} 
	}
	
	// search dvd
	public void searchDigitalVideoDisc() {
		boolean flag = false;
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Search for ID: ");
		int id = keyboard.nextInt();
		
		for (int i = 0; i < qtyOrdered; i++) {
			if (id == itemsOrdered[i].getId()) {
				System.out.println("DVD - " + itemsOrdered[i].getTitle() + " - " + itemsOrdered[i].getCategory() 
						+ " - " + itemsOrdered[i].getDirector() + " - " + itemsOrdered[i].getLength() 
						+ ": " + itemsOrdered[i].getCost() + "$");
				flag = true;
			} 
		}
		if (flag == false) {
			System.out.println("ID not found!");
		}
		
		keyboard.close();
	}
	
	// get detail
	public void printCart() {
		System.out.println();
		System.out.println("***********************Order***********************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			System.out.print(i + 1 + ". DVD - ");
			System.out.print(itemsOrdered[i].getTitle() + " - ");
			System.out.print(itemsOrdered[i].getCategory() + " - ");
			System.out.print(itemsOrdered[i].getDirector() + " - ");
			System.out.print(itemsOrdered[i].getLength() + ": ");
			System.out.println(itemsOrdered[i].getCost() + "$");
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

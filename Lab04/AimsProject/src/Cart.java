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
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
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
	
}

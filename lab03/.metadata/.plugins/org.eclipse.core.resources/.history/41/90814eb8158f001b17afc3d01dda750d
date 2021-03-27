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

	// Add
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc;
			setQtyOrdered(qtyOrdered + 1);
			System.out.println("The disc " + disc.getTitle() + " has been added");
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

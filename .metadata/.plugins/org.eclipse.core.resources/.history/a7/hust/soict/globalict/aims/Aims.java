package hust.soict.globalict.aims;
<<<<<<< HEAD:.metadata/.plugins/org.eclipse.core.resources/.history/a7/0050250c118f001b1891cac767f65d12
import Cart;
=======
import hust.soict.globalict.aims.cart.Cart;
>>>>>>> parent of d17d0b1 (Revert "Merge pull request #1 from XHung09/refractor"):.metadata/.plugins/org.eclipse.core.resources/.history/a7/hust/soict/globalict/aims/Aims.java
import hust.soict.globalict.aims.disc.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {
	
		// Create a new cart
		Cart anOrder = new Cart();
		
		// Create new DVD objects and add them to the cart
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		
		// Print total cost of the items in the cart
		System.out.print("Total Cost is: ");
		System.out.println(anOrder.totalCost());

		// Remove a disc in the cart
		anOrder.removeDigitalVideoDisc(dvd3);
		System.out.print("Total Cost is: ");
		System.out.println(anOrder.totalCost());
	}

}

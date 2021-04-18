package hust.soict.globalict.test.cart;
import java.util.ArrayList;
import java.util.List;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) {

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 5.6f);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		
		Cart anOrder = new Cart();
		anOrder.addMedia(new DigitalVideoDisc[] {dvd3, dvd2, dvd4, dvd1, dvd5});

		anOrder.printCart();

		// sort the current cart by Cost
		anOrder.sortCartByCostTitle();
		System.out.println("Sorted by cost title");
		anOrder.printCart();
		
		// sort the current cart by Title
		anOrder.sortCartByTitleCost();
		System.out.println("Sorted by title cost");
		anOrder.printCart();
		
		//sort the current cart by Length
		anOrder.sortCartByLength();
		System.out.println("Sorted by length");
		anOrder.printCart();
	}
}
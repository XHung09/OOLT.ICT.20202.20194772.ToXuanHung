package hust.soict.globalict.test.cart;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartTest {
	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 5.6f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		
		Cart anOrder = new Cart();
		anOrder.addMedia(new DigitalVideoDisc[] {dvd1, dvd2, dvd3, dvd4, dvd5});
		anOrder.printCart();
		
		// sort the current cart by Cost
		anOrder.sortCartByCost();
		anOrder.printCart();
		
		// sort the current cart by Title
		anOrder.sortCartByTitle();
		anOrder.printCart();
		
		//sort the current cart by Length
		anOrder.sortCartByLength();
		anOrder.printCart();
	}
}
package hust.soict.globalict.aims.screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {

	protected static Cart cart = new Cart();
	
	@SuppressWarnings("static-access")
	public CartScreen(Cart cart) {
		super();
		this.cart = cart;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		this.setSize(1024, 768);
	
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource("Cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}		
			}
		});
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main (String[] args) {
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 5.6f);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		
		Cart anOrder = new Cart();
		anOrder.addMedia(new DigitalVideoDisc[] {dvd3, dvd2, dvd4, dvd1, dvd5});
		List<String> authors = new ArrayList<String>();
		authors.add("Hiroshi Fujimoto");
		authors.add("Motoo Abiko");
		
		Book b1 = new Book("Doraemon", "Comic", 1.99f, authors);
		anOrder.addMedia(b1);
		anOrder.printCart();

		new CartScreen(anOrder);
	}
	
}

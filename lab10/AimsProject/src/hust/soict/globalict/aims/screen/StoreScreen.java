package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Book;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

public class StoreScreen extends JFrame implements ActionListener {
	
	protected static Store store;
	
	@SuppressWarnings("static-access")
	public StoreScreen(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.cyan);
		
		JButton cart = new JButton("View cart");
		cart.addActionListener(this);
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add((title));
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}

	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		JMenuItem addBook = new JMenuItem("Add Book");
		JMenuItem addCD = new JMenuItem("Add CD");
		JMenuItem addDVD = new JMenuItem("Add DVD");
		JMenuItem viewCart = new JMenuItem("View cart");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add(addBook);
		addBook.addActionListener(this);
		smUpdateStore.add(addCD);
		addCD.addActionListener(this);
		smUpdateStore.add(addDVD);
		addDVD.addActionListener(this);
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("View cart"));
		viewCart.addActionListener(this);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < mediaInStore.size() ; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			String str = ae.getActionCommand();
			
			if (str.equals("Add Book")) {
				dispose();
				new AddBookToStoreScreen(store);
			} else if (str.equals("Add CD")) {
				dispose();
				new AddCompactDiscToStoreScreen(store);
			} else if (str.equals("Add DVD")) {
				dispose();
				new AddDigitalVideoDiscToStoreScreen(store);			
			} else if (str.equals("View cart")) {
				new CartScreen(CartScreen.cart);
			} else {
				System.out.println(str + "Error!");
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// testing GUI
	public static void main (String[] args) {
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("CCCC", "cccc", "cccc", 3, 5f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("BBBB", "bbbb", "bbbb", 2, 5.3f);
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("DDDD", "dddd", "dddd", 4, 5.6f);
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("AAAA", "aaaa", "aaaa", 1, 5.6f);
		DigitalVideoDisc dvd5 = new DigitalVideoDisc("EEEE", "eeee", "eeee", 5, 3.3f);
		
		Store anOrder = new Store();
		anOrder.addMedia(new DigitalVideoDisc[] {dvd3, dvd2, dvd4, dvd1, dvd5});
		List<String> authors = new ArrayList<String>();
		authors.add("Hiroshi Fujimoto");
		authors.add("Motoo Abiko");
		
		Book b1 = new Book("Doraemon", "Comic", 1.99f, authors);
		anOrder.addMedia(b1);
		anOrder.printStore();
		new StoreScreen(anOrder);
	}
	
}

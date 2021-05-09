package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.globalict.aims.store.Store;

public class AddItemToStoreScreen extends JFrame implements ActionListener {
	
	public AddItemToStoreScreen() {
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		
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
		
		JMenu smUpdateStore = new JMenu("Update Store");
		smUpdateStore.add(addBook);
		addBook.addActionListener(this);
		smUpdateStore.add(addCD);
		addCD.addActionListener(this);
		smUpdateStore.add(addDVD);
		addDVD.addActionListener(this);
		
		menu.add(smUpdateStore);
		JMenuItem viewStore = new JMenuItem("View store");
		menu.add(viewStore);
		viewStore.addActionListener(this);
		
		JMenuItem viewCart = new JMenuItem("View cart");
		menu.add(viewCart);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
			String str = ae.getActionCommand();
			
			if (str.equals("Add Book")) {
				AddBookToStoreScreen addBook = new AddBookToStoreScreen(StoreScreen.store);
				System.out.println();
			} else if (str.equals("Add CD")) {
				AddCompactDiscToStoreScreen addCD = new AddCompactDiscToStoreScreen(StoreScreen.store);
			} else if (str.equals("Add DVD")) {
				AddDigitalVideoDiscToStoreScreen addDVD = new AddDigitalVideoDiscToStoreScreen(StoreScreen.store);
			} else if (str.equals("View store")) {
				dispose();
				StoreScreen sc = new StoreScreen(StoreScreen.store);
			} else {
				System.out.println(str + " error!");
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

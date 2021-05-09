package hust.soict.globalict.aims.screen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
	
	private DigitalVideoDisc dvd;
	private Container cp = getContentPane();
	
	private JLabel title = new JLabel("Title: ");
	private JTextField tfTitle = new JTextField();

	private JLabel category = new JLabel("Category: ");
	private JTextField tfCategory = new JTextField();
	
	private JLabel director = new JLabel("Director: ");
	private JTextField tfDirector = new JTextField();
	
	private JLabel length = new JLabel("Length: ");
	private JTextField tfLength = new JTextField();

	private JLabel cost = new JLabel("Cost: ");
	private JTextField tfCost = new JTextField();
	
	int intLength = Integer.parseInt(tfLength.getText());
	float floatCost = Float.parseFloat(tfCost.getText());
	
	public AddDigitalVideoDiscToStoreScreen(Store store) {
		super();
		cp.setLayout(new FlowLayout());
		addComponents();
		
		setVisible(true);
		setTitle("Add DVD");
		setSize(1024, 768);
		// TODO Auto-generated constructor stub
		dvd = new DigitalVideoDisc(title.getText(), category.getText(), director.getText(), intLength, floatCost);
	}

	public void addComponents() {
		cp.add(title);
		this.tfTitle.setEditable(true);
		cp.add(category);
		this.tfCategory.setEditable(true);
		cp.add(director);
		this.tfDirector.setEditable(true);
		cp.add(length);
		this.tfLength.setEditable(true);
		cp.add(cost);
		this.tfCost.setEditable(true);
	}
	
	// title enter
	public void tfTitleKeyPressed(KeyEvent ke) {
		int key = ke.getKeyCode();
		
		if (key == 10) {
			tfCategory.requestFocus();
		}
	}
	
	// category enter
	public void tfCategoryKeyPressed(KeyEvent ke) {
		int key = ke.getKeyCode();
		
		if (key == 10) {
			tfDirector.requestFocus();
		}
	}
	
	// director enter
	public void tfDirectorKeyPressed(KeyEvent ke) {
		int key = ke.getKeyCode();
		
		if (key == 10) {
			tfLength.requestFocus();
		}
	}
	
	// length enter
	public void tfLengthKeyPressed(KeyEvent ke) {
		int key = ke.getKeyCode();
		
		if (key == 10) {
			tfCost.requestFocus();
		}
	}
	
	// cost enter
	public void tfCostKeyPressed(KeyEvent ke) {
		int key = ke.getKeyCode();
		
		if (key == 10) {
			
			JOptionPane.showMessageDialog(this, "Successfully added!");
		}
	}

	class MyKeyListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Enter");
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Enter");
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Enter");
		}
	}

}

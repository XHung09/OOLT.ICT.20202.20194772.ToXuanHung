package hust.soict.globalict.aims.screen;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import javafx.beans.property.SimpleFloatProperty;

public class MediaStore extends JPanel implements ActionListener {

	private Media media;
	public MediaStore(Media media) {
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + "$");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addToCart = new JButton("Add to cart");
		container.add(addToCart);
	
		addToCart.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent ae) {				
					CartScreen.cart.addMedia(media);
					
					if (ae.getSource() == addToCart) {
						JOptionPane.showMessageDialog(null, media.getTitle() + " is added!",
														"Add media" , JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		
		if (media instanceof Playable) {
			JButton play = new JButton("Play");
			container.add(play);
			play.addActionListener(this);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand() == "Play") {
			if (this.media instanceof DigitalVideoDisc) {
				DigitalVideoDisc dvd = (DigitalVideoDisc)this.media;
				String str = "Playing DVD: " + dvd.getTitle()
							+ "\nLength: " + dvd.getLength(); 
				JOptionPane.showMessageDialog(null, str, "Play " , JOptionPane.INFORMATION_MESSAGE);
			} else if (this.media instanceof CompactDisc) {
				CompactDisc cd = (CompactDisc)this.media;
				String str = "Playing CD: " + cd.getTitle()
							+ "\nARTIST: " + cd.getArtist();
				
				for (int i = 0; i < cd.getNbTrack(); i++) {
					str = str + "\n" + cd.playGUI();
				}
			
				JOptionPane.showMessageDialog(null, str, "Play " , JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

}

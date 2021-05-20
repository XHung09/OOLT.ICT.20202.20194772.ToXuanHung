package hust.soict.globalict.aims.screen;

import javax.swing.JOptionPane;

import hust.soict.globalict.aims.media.CompactDisc;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
	
	public AddCompactDiscToStoreScreen (Store store) {
		CompactDisc cd;
		String title  = JOptionPane.showInputDialog("CD title");
		
		String category = JOptionPane.showInputDialog("CD Category");
		
		String director = JOptionPane.showInputDialog("CD Director");
		
		String artist = JOptionPane.showInputDialog("CD Artist");
		
		String cost = JOptionPane.showInputDialog("CD Cost");
		float floatCost = Float.parseFloat(cost);
		
		cd = new CompactDisc(title, category, director, artist, floatCost);
		
		String length = JOptionPane.showInputDialog("Number of Tracks");
		int intLength = Integer.parseInt(length);
		
		for (int i = 0; i < intLength; i++) {
			String trackTitle  = JOptionPane.showInputDialog("Track no." + (i+1) + " title");
			
			String trackLength = JOptionPane.showInputDialog("Track no." + (i+1) + " Length");
			int intTrackLength = Integer.parseInt(trackLength);
			
			Track track = new Track(trackTitle, intTrackLength);
			cd.addTrack(track);
		}
		
		store.addMedia(cd);
	}

}

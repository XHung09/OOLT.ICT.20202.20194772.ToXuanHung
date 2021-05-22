package hust.soict.globalict.aims.media;

import hust.soict.globalict.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {

	public DigitalVideoDisc(String title) {
		super(title);
	}

	public DigitalVideoDisc(String title, String category, float cost) throws Exception {
		super(title, category, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) throws Exception {
		super(title, category, director, cost);
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) throws Exception {
		super(title, category, director, length, cost);
	}
	
	// get detail
	public String toString() {
		return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() 
				+ " - " + getLength() + ": " + getCost() + "$";
	}
	
	// play
	public void play() throws PlayerException {	
		if (this.getLength() > 0) {
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength() + "\n");
		} else {		
			System.err.println("Cannot play this DVD");
			throw new PlayerException("ERORR: DVD length is non-positive");
		}
	}
	
	// search
	public boolean search(String title) {
		boolean flag = true ;
		int count = 0;
		String str = this.title.toLowerCase();
		title = title.toLowerCase();
		
		String[] part = title.split(" ") ;
		for(int i = 0; i < part.length; i++) {
			if(str.contains(part[i])) {
				count += 1;
			}
		}
		if (count == 0) {
			flag = false;
		}
		return flag;
	}
	
}
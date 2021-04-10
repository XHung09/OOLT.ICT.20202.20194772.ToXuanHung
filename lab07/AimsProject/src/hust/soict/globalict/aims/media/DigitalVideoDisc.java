package hust.soict.globalict.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

	public DigitalVideoDisc(String title) {
		super(title);
		++nbMedia;
		this.id = nbMedia;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		++nbMedia;
		this.id = nbMedia;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
		++nbMedia;
		this.id = nbMedia;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		++nbMedia;
		this.id = nbMedia;
	}
	
	// get detail
	public String getDetail() {
		String dvd = "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " 
					+ getLength() + ": " + getCost() + "$";
		
		return dvd;
	}
	
	// play
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
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
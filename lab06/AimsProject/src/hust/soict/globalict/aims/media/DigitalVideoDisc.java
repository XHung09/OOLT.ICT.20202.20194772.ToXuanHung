package hust.soict.globalict.aims.media;
import java.time.LocalDate;

public class DigitalVideoDisc extends Media {
	private String director;
	private int length;
	public String getDirector() {
		return director;
	}
	
	public int getLength() {
		return length;
	}
	
	// Constructors
	public DigitalVideoDisc(String title) {
		super(title);
		this.id = nbMedia;
		++nbMedia;
		super.dateAdded = LocalDate.now();
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category);
		this.id = nbMedia;
		++nbMedia;
		super.dateAdded = LocalDate.now();
		this.cost = cost;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.id = nbMedia;
		++nbMedia;
		super.dateAdded = LocalDate.now();
		this.director = director;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.id = nbMedia;
		++nbMedia;
		this.dateAdded = LocalDate.now();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	
	// get detail
	public String getDetail() {
		String dvd = "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " 
					+ getLength() + ": " + getCost() + "$";
		
		return dvd;
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
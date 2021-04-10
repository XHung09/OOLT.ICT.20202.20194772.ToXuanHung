package hust.soict.globalict.aims.media;

import java.time.LocalDate;

public abstract class Media {

	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	protected LocalDate dateAdded;
	protected static int nbMedia = 0;
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}
	
	public float getCost() {
		return cost;
	}
	
	public void freeCost() {
		this.cost = 0;
	}
	
	// Constructors
	public Media(String title, String category, float cost) {
		super();
		this.id = nbMedia;
		++nbMedia;
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
	}
	
	public Media(String title, String category) {
		super();
		this.id = nbMedia;
		++nbMedia;
		this.title = title;
		this.category = category;	
		this.dateAdded = LocalDate.now();
	}
	
	public Media(String title) {
		super();
		this.id = nbMedia;
		++nbMedia;
		this.title = title;	
		this.dateAdded = LocalDate.now();
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

	// get detail
	public String getDetail() {
		String item = "ID: " + getId() + " " + getTitle() + " - " + getCategory() + " - " + ": " + getCost() + "$";
		return item;
	}
}

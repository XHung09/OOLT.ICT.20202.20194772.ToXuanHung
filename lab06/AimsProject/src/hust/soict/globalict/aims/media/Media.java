package hust.soict.globalict.aims.media;

import java.time.LocalDate;

public class Media {

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
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}
	
	public float getCost() {
		return cost;
	}
	
	public void setCost(float cost) {
		this.cost = cost;
	}
	
	// Constructors
	public Media(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.dateAdded = LocalDate.now();
	}
	
	public Media(String title, String category) {
		super();
		this.title = title;
		this.category = category;	
		this.dateAdded = LocalDate.now();
	}
	
	public Media(String title) {
		super();
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

}

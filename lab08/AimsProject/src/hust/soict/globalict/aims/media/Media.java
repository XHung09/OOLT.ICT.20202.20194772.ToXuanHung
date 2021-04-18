package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

public abstract class Media implements Comparable<Media> {

	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	protected LocalDate dateAdded;
	protected static int nbMedia = 0;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
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
		String media = "ID: " + getId() + " " + getTitle() + " - " + getCategory() + " - " + ": " + getCost() + "$";
		return media;
	}
	
	// override equals() method
	@Override
	public boolean equals(Object obj) {	
		if (obj instanceof Media) {
			Media tempMedia = (Media) obj;
			return tempMedia.id == this.id;
 		} else {
 			return false;
 		}
	}
	
	// override compareTo() method
	@Override
	public int compareTo(Media obj) {
		int cmp = this.title.compareTo(obj.title);
		
		if (cmp == 0) {
			cmp = this.category.compareTo(obj.category);
		}
		
		return cmp;
	}
	
	
}

package hust.soict.globalict.aims.media;

import java.time.LocalDate;
import java.util.Comparator;

import com.sun.javafx.css.CascadingStyle;

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
	public Media(String title, String category, float cost) throws Exception {
		super();
		this.id = nbMedia;
		this.title = title;
		this.category = category;
		
		if (cost > 0) {
			this.cost = cost;
		} else {
			throw new Exception("ERROR: Invalid cost");
		}
		
		this.cost = cost;
		this.dateAdded = LocalDate.now();
		++nbMedia;
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

	// override equals() method
	@Override
	public boolean equals(Object obj) throws NullPointerException, ClassCastException {	
        
        if (obj == null) {
			throw new NullPointerException("ERROR: This object is null");
		}
        
		try {
			Media media = (Media) obj;
			
			if (this.getTitle().equals(media.getTitle()) && this.getCost() == media.getCost()) {
				return true;
			}
			
			return false;
		} catch (ClassCastException e) {
			System.err.println("ERROR: Can't cast this object");
			throw e;
		}

	}
	
	// override compareTo() method
	@Override
	public int compareTo(Media obj) {
		int cmp;
		
		if (obj == null) {
			throw new NullPointerException("ERROR: This object is null");
		} else {
			cmp = this.title.compareTo(obj.title);
			
			if (cmp == 0) {
				cmp = this.category.compareTo(obj.category);
			}
		}
		
		return cmp;
	}
	
	
}

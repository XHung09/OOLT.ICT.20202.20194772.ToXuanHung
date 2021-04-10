package hust.soict.globalict.aims.media;

import java.time.LocalDate;

public class Disc extends Media {
	
	private String director;
	private int length;
	
	public String getDirector() {
		return director;
	}
	
	public int getLength() {
		return length;
	}
	
	// Constructors
	public Disc(String title) {
		super(title);
		this.id = nbMedia;
		++nbMedia;
		super.dateAdded = LocalDate.now();
	}

	public Disc(String title, String category, float cost) {
		super(title, category);
		this.id = nbMedia;
		++nbMedia;
		super.dateAdded = LocalDate.now();
		this.cost = cost;
	}

	public Disc(String title, String category, String director, float cost) {
		super(title, category, cost);
		this.id = nbMedia;
		++nbMedia;
		super.dateAdded = LocalDate.now();
		this.director = director;
	}

	public Disc(String title, String category, String director, int length, float cost) {
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
	
}

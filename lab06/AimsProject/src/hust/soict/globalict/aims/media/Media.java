package hust.soict.globalict.aims.media;

import java.time.LocalDate;

public class Media {

	protected int id;
	protected String title;
	protected String category;
	protected float cost;
	private LocalDate dateAdded;
	private static int nbMedia = 0;
	
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
	
	public Media() {
		// TODO Auto-generated constructor stub
	}

}

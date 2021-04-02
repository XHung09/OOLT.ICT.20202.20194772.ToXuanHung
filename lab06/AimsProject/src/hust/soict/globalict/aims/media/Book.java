package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private int id;
	private String title;
	private String category;
	private float cost;
	private List<String> authors = new ArrayList<String>();
	
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


	private List<String> getAuthors() {
		return authors;
	}

	addAuthor(String authorName) {
		
	}
	
	removeAuthor(String authorName) {
		
	}
	public Book() {
		// TODO
		
	}
	
}

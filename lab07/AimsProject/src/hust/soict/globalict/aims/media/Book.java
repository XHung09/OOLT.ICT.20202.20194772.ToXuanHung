package hust.soict.globalict.aims.media;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	
	public List<String> getAuthors() {
		return authors;
	}

	// Constructors
	public Book(String title, String category, float cost, List<String> authors) {
		super(title, category, cost);
		this.id = nbMedia;
		++nbMedia;
		this.authors = authors;
		super.dateAdded = LocalDate.now();
	}
	
	public Book(String title, String category) {
		super(title, category);
		this.id = nbMedia;
		++nbMedia;
		super.dateAdded = LocalDate.now();
	}
	
	public Book(String title, String category, List<String> authors) {
		super(title, category);
		this.id = nbMedia;
		++nbMedia;
		this.authors = authors;
		super.dateAdded = LocalDate.now();
	}
	
	public Book(String title, List<String> authors) {
		super(title);
		this.id = nbMedia;
		++nbMedia;
		this.authors = authors;
		super.dateAdded = LocalDate.now();
	}

	// add author
	public void addAuthor(String authorName) {
		if (authors.contains(authorName) == false) {
			authors.add(authorName);
			System.out.println("Succeed!");
		} else {
			System.out.println("This author has already existed!");
		}
	}
	
	// remove author
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName) == true) {
			authors.remove(authorName);
			System.out.println("Succeed!");
		} else {
			System.out.println("This author does not exist!");
		}
	}
	
	// get detail
	public String getDetail() {
		String book = "Book - " + getTitle() + " - " + getCategory() + " - " 
						+ getAuthors()  + ": " + getCost() + "$";
		
		return book;
	}
	
}

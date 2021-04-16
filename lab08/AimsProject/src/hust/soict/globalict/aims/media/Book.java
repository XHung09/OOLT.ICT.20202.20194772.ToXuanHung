package hust.soict.globalict.aims.media;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.HashMap;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	private int contentLength;
	private String tokenList[];
	private int tokenLength[];
	
	public List<String> getAuthors() {
		return authors;
	}

	// Constructors
	public Book(String title, String category, float cost, List<String> authors) {
		super(title, category, cost);
		this.authors = authors;
		super.dateAdded = LocalDate.now();
	}
	
	public Book(String title, String category, float cost) {
		super(title, category, cost);
		super.dateAdded = LocalDate.now();
	}
	
	public Book(String title, String category, List<String> authors) {
		super(title, category);
		this.authors = authors;
		super.dateAdded = LocalDate.now();
	}
	
	public Book(String title, List<String> authors) {
		super(title);
		this.authors = authors;
		super.dateAdded = LocalDate.now();
	}
	
	// add content and check token
	public void addContent() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the content of this book: ");
		String content = keyboard.nextLine();
		
		String contentSplit[] = content.split(" ");
		HashMap<String, Integer> freqMap = new HashMap<String, Integer>(); 

		for (int i = 0; i < contentSplit.length; i++) {
			String token = contentSplit[i];
			int freq = freqMap.getOrDefault(token, 0);
			freqMap.put(token, ++freq);
		}
		
        for (Entry<String, Integer> result : freqMap.entrySet()) {
            System.out.println(result.getKey() + " " + result.getValue());
            
        }
		
		keyboard.close();
	}
	
	// add author
	public void addAuthor(String authorName) {
		if (authors.contains(authorName) == false) {
			authors.add(authorName);
		} else {
			System.out.println("This author has already existed!");
		}
	}
	
	// remove author
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName) == true) {
			authors.remove(authorName);
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

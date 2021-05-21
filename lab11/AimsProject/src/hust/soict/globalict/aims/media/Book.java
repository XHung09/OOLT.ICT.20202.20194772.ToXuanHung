package hust.soict.globalict.aims.media;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap; 

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	private int contentLength;
	private List<String> contentTokens = new ArrayList<String>();
	private TreeMap<String, Integer> wordFrequency;
	private String content;
	
	// Getters
	public List<String> getAuthors() {
		return authors;
	}

	public int getContentLength() {
		return contentLength;
	}
	
	// Constructors
	public Book(String title, String category, float cost, List<String> authors) throws Exception {
		super(title, category, cost);
		this.authors = authors;
		super.dateAdded = LocalDate.now();
	}
	
	public Book(String title, String category, float cost) throws Exception {
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
	
	// add content and check content tokens
	public void addContent() {
		@SuppressWarnings("resource")
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter the content of this book: ");
		this.content = keyboard.nextLine();
	}
	
	public void processContent() {
		this.wordFrequency = new TreeMap<String, Integer>();
		String contentSplit[] = this.content.split("[\\p{Punct}\\s]+");
		
		for (String s : contentSplit) {
			Integer count = wordFrequency.get(s);
			if (count != null) {
				wordFrequency.put(s, ++count);
			} else {
				wordFrequency.put(s, 1);
			}
		}
		
		Set<Entry<String, Integer>> entries = wordFrequency.entrySet();
		for (Entry<String, Integer> entryElement : entries) {
			if (entryElement.getKey() != null) {
				contentTokens.add(entryElement.getKey());
				this.contentLength++;
			}

			System.out.println(entryElement.getKey() + ": " + entryElement.getValue());
		}
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
	
	// override toString()
	public String toString() {
		return "BOOK - " + getTitle() + " - " + getCategory() + " - " 
				+ getAuthors()  + " - Content length: " + getContentLength() 
				+ ": " + getCost() + "$\n" 
				+ "Content: " + this.content + "\n"
				+ "Token list: " + this.wordFrequency;
	}
	
}

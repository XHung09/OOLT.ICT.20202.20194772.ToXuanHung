package hust.soict.globalict.aims.media;
import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

	private List<String> authors = new ArrayList<String>();
	
	public List<String> getAuthors() {
		return authors;
	}

	public void addAuthor(String authorName) {
		if (authors.contains(authorName) == false) {
			authors.add(authorName);
			System.out.println("Succeed!");
		} else {
			System.out.println("This author has already existed!");
		}
	}
	
	public void removeAuthor(String authorName) {
		if (authors.contains(authorName) == true) {
			authors.remove(authorName);
			System.out.println("Succeed!");
		} else {
			System.out.println("This author does not exist!");
		}
	}
	public Book() {
		// TODO
		
	}
	
}

package hust.soict.globalict.aims.disc;
import java.time.LocalDate;
public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private LocalDate dateAdded;
	private int id;
	private static int nbDigitalVideoDiscs = 0;
	
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
	
	public String getDirector() {
		return director;
	}
	
	public int getLength() {
		return length;
	}
	
	public float getCost() {
		return cost;
	}
	
	public DigitalVideoDisc(String title) {
		super();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.dateAdded = LocalDate.now();
		this.title = title;
	}

	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.dateAdded = LocalDate.now();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}

	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.dateAdded = LocalDate.now();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		nbDigitalVideoDiscs++;
		this.id = nbDigitalVideoDiscs;
		this.dateAdded = LocalDate.now();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	
	// get detail
	public String getDetail() {
		String dvd = "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " 
					+ getLength() + ": " + getCost() + "$";
		
		return dvd;
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
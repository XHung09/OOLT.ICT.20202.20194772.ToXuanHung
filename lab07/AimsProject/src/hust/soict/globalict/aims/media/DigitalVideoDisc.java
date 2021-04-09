package hust.soict.globalict.aims.media;
import java.time.LocalDate;

public class DigitalVideoDisc extends Disc {
	
	public DigitalVideoDisc() {
		super();
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
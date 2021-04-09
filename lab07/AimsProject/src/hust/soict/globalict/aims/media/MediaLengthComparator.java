package hust.soict.globalict.aims.media;
import java.util.Comparator;

public class MediaLengthComparator implements Comparator<Media> {

	@Override
	public int compare(Media item1, Media item2) {
		DigitalVideoDisc dvd1 = (DigitalVideoDisc)item1;
		DigitalVideoDisc dvd2 = (DigitalVideoDisc)item2;
		if (dvd1.getLength() < dvd2.getLength()) {
			return 1;
		} else if (dvd1.getLength() > dvd2.getLength()) {
			return -1;
		} else {
       	 return item1.getTitle().compareTo(item2.getTitle());
		}
	}

}

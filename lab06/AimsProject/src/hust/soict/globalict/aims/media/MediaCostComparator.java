package hust.soict.globalict.aims.media;
import java.util.Comparator;

public class MediaCostComparator implements Comparator<Media> {

	@Override
	public int compare(Media item1, Media item2) {
		if (item1.getCost() < item2.getCost()) {
			return 1;
		} else if (item1.getCost() > item2.getCost()) {
			return -1;
		} else {
       	 return item1.getTitle().compareTo(item2.getTitle());
		}
	}

}

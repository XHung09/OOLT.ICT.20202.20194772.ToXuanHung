package hust.soict.globalict.aims.media;
import java.util.Comparator;

public class MediaTitleComparator implements Comparator<Media> {
	
	@Override
	public int compare(Media item1, Media item2) {
		return item1.getTitle().compareTo(item2.getTitle());
	}

}

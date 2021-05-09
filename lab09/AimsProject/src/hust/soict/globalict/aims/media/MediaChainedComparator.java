package hust.soict.globalict.aims.media;
import java.util.Comparator;
import java.util.ArrayList;


public class MediaChainedComparator implements Comparator<Media> {

    private ArrayList<Comparator<Media>> listComparators;
    
	@Override
	public int compare(Media item1, Media item2) {
        for (Comparator<Media> comparator : listComparators) {
            int result = comparator.compare(item1, item2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
	}

}

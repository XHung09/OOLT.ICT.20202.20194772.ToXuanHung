package hust.soict.globalict.aims.utils;
import java.util.Arrays;
import java.util.Comparator;

import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class DVDUtils {
	static private Comparator<DigitalVideoDisc> ascCost;
	static private Comparator<DigitalVideoDisc> ascTitle;
	
	public static float compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		return dvd1.getCost() - dvd2.getCost();
	}
	
	public static int compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		return dvd1.getTitle().compareTo(dvd2.getTitle());
	}
	
	static {
        ascTitle = new Comparator<DigitalVideoDisc>() {
            public int compare(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
                return dvd1.getTitle().compareTo(dvd2.getTitle());
            }
        };

        ascCost = new Comparator<DigitalVideoDisc>() {
            public int compare(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
                return Float.compare(dvd1.getCost(), dvd2.getCost());
            }
        };
	}
	
	// sort by cost
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc... disc) {
		Arrays.sort(disc, ascCost);
		return disc;
	}
	
	// sort by title
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc... disc) {
		Arrays.sort(disc, ascTitle);
		return disc;
	}
}
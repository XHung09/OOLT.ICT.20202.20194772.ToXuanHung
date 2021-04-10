package hust.soict.globalict.test.disc;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
	
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		Wrapper dw1 = new Wrapper(jungleDVD);
		Wrapper dw2 = new Wrapper(cinderellaDVD);
		
		swap(dw1, dw2);
		System.out.println("jungle dvd title: " + dw1.dvd.getTitle());
		System.out.println("cinderella dvd title: " + dw2.dvd.getTitle());
		
//		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
//	public static void swap(Object o1, Object o2) {
//		Object tmp = o1;
//		o1 = o2;
//		o2 = tmp;
//	}
	
	public static void swap(Wrapper dvd1, Wrapper dvd2) {
		DigitalVideoDisc temp = dvd1.dvd;
		dvd1.dvd = dvd2.dvd;
		dvd2.dvd = temp;
	}
	
//	public static void changeTitle(DigitalVideoDisc dvd, String title) {
//		String oldTitle = dvd.getTitle();
//		dvd.setTitle(title);
//		dvd = new DigitalVideoDisc(oldTitle);
//	}
}
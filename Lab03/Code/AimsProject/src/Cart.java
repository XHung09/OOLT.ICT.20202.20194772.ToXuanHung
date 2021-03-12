
public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	public int qtyOrdered = 0;
	public double Cost = 0.0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		
	}
	
	public double totalCost() {
		
		return Cost;
	}
	
}

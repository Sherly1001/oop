package AimsProject;

public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
			System.out.println("The order is almost full");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			++qtyOrdered;
			System.out.println("The disc has been added");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == 0) {
			System.out.println("The order is empty");
		} else {
			for (int i = 0; i < qtyOrdered; ++i) {
				if (itemsOrdered[i] == disc) {
					for (int j = i; j < qtyOrdered - 1; ++j) {
						itemsOrdered[j] = itemsOrdered[j + 1];
					}
					--qtyOrdered;
					System.out.println("The disc has been removed");
					break;
				}
			}
		}
	}
	public float totalCost() {
		float t = 0;
		for (int i = 0; i < qtyOrdered; ++i) {
			t += itemsOrdered[i].getCost();
		}
		return t;
	}
}

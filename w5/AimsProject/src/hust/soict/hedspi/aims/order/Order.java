package hust.soict.hedspi.aims.order;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITTED_ORDERS = 5;
	
	private static int nbOrders = 0;
	
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	private MyDate dateOrdered; 
	
	private Order() {
		dateOrdered = new MyDate();
	}
	
	public static Order getInstanceOrder() {
		if(nbOrders < MAX_LIMITTED_ORDERS) {
			++nbOrders;
			Order newOrder = new Order();
			return newOrder;
		} else {
			System.out.println("The numbers of orders is almost max.");
			return null;
		}
			
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == MAX_NUMBERS_ORDERED - 1) {
			System.out.println("The order is almost full");
		} else {
			itemsOrdered[qtyOrdered] = disc;
			++qtyOrdered;
			System.out.println("The disc has been added");
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvds) {
		for (DigitalVideoDisc i: dvds) {
			addDigitalVideoDisc(i);
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == 0) {
			System.out.println("The order is empty");
			return;
		}
		
		for (int i = 0; i < qtyOrdered; ++i) {
			if (itemsOrdered[i] != disc) continue;
			for (int j = i; j < qtyOrdered - 1; ++j) {
				itemsOrdered[j] = itemsOrdered[j + 1];
			}
			--qtyOrdered;
			System.out.println("The disc has been removed");
			break;
		}
	}
	public float totalCost() {
		float t = 0;
		for (int i = 0; i < qtyOrdered; ++i) {
			t += itemsOrdered[i].getCost();
		}
		return t;
	}
	public void printOrdered() {
		System.out.println("***********************Order***********************");
		System.out.print("Date: ");
		dateOrdered.print();
		System.out.print("\nOrdered Items:\n");
		
		for(int i=0;i<qtyOrdered;i++) {
			System.out.printf("%d. DVD - " + itemsOrdered[i].getTitle()
					+ " - " + itemsOrdered[i].getCategory() + " - "
					+ itemsOrdered[i].getDirector() +
					" - %d: %.2f $\n", i, itemsOrdered[i].getLength(),
					itemsOrdered[i].getCost());
		}
		System.out.printf("Total cost: %.2f\n", totalCost());
		System.out.println("***************************************************");
	}
}

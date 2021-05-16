package hust.soict.hedspi.aims.order;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.utils.MyDate;

public class Order {
	public static final int MAX_NUMBERS_ORDERED = 10;
	public static final int MAX_LIMITTED_ORDERS = 5;

	private static int nbOrders = 0;
	private static int luckynumber = 0;
	private MyDate dateOrdered;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

	private Order() {
		dateOrdered = new MyDate();
	}

	public static Order getInstanceOrder() {
		if (nbOrders < MAX_LIMITTED_ORDERS) {
			++nbOrders;
			Order newOrder = new Order();
			return newOrder;
		} else {
			System.out.println("The numbers of orders is almost max.");
			return null;
		}

	}

	public void addMedia(Media m) {
		itemsOrdered.add(m);
	}

	public void removeMedia(Media m) {
		itemsOrdered.remove(m);
	}
	
	public void removeMedia(int id) {
		itemsOrdered.remove(id);
	}

	public float totalCost() {
		float sum = 0;
		for (Media i : itemsOrdered) {
			sum += i.getCost();
		}
		return sum;
	}

	public void printOrdered() {
		System.out.println("***********************Order***********************");
		System.out.print("Date: ");
		dateOrdered.print();
		System.out.print("\nOrdered Items:\n");
		int id = 0;
		for (Media i : itemsOrdered) {
			System.out.println(id++ + ": " + i.getTitle() + " - " + i.getCategory()
			  + " - " + i.getCost());
		}
		System.out.printf("Total cost: %.2f\n", totalCost());
		System.out.println("***************************************************");
	}

	public Media getALuckyItem() {
		// System.out.print(qtyOrdered+ "\n");
		luckynumber = (int) (Math.random() * itemsOrdered.size());
		String s = itemsOrdered.get(luckynumber).getTitle();
		System.out.printf("The lucky item is : " + s + "\n");
		return itemsOrdered.get(luckynumber);
	}

	public Media search(String title) {
		for (Media i : itemsOrdered) {
			if (i.search(title))
				return i;
		}
		return null;
	}
}

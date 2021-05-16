package hust.soict.hedspi.gui.aimsproject.order;

import java.util.ArrayList;
import java.util.Formatter;

import javax.naming.LimitExceededException;

import hust.soict.hedspi.gui.aimsproject.utils.MyDate;
import hust.soict.hedspi.gui.aimsproject.media.Media;

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

	public static Order getInstanceOrder() throws LimitExceededException {
		if (nbOrders < MAX_LIMITTED_ORDERS) {
			++nbOrders;
			return new Order();
		} else {
			throw new LimitExceededException("Error: The numbers of orders is almost max.");
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
		System.out.println(toString());
	}

	public String toString() {
		String str = "***********************Order***********************\nDate: ";
		str += dateOrdered.toString();
		str += "\nOrdered Items:\n";
		int id = 0;
		for (Media i : itemsOrdered) {
			str += (id++ + ": " + i.getTitle() + " - " + i.getCategory() + " - " + i.getCost()) + "\n";
		}
		str += String.format("Total cost: %.2f\n", totalCost()).toString();
		str += "***************************************************";

		return str;
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

package hust.soict.hedspi.aims;

import java.util.Scanner;

import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.Order;

public class Aims {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Order order = null;

		while (true) {
			showMenu();
			int choice = scanner.nextInt();
			if (choice < 0 || choice > 4) {
				System.out.println("Invalid choice");
				continue;
			}

			switch (choice) {
			case 1:
				order = Order.getInstanceOrder();
				break;
			case 2:
				System.out.print("Enter title: ");
				String tit = scanner.next();
				System.out.print("Enter category: ");
				String cat = scanner.next();
				System.out.print("Enter cost: ");
				float co = scanner.nextFloat();
				order.addMedia(new Media(tit, cat, co));
				break;
			case 3:
				System.out.print("Enter item's id: ");
				order.removeMedia(scanner.nextInt());
				break;
			case 4:
				if (order != null) order.printOrdered();
				break;
			case 0:
				scanner.close();
				System.exit(0);
			}
		}
	}

	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.print("Please choose a number: ");
	}
}

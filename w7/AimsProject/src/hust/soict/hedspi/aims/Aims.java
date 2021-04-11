package hust.soict.hedspi.aims;

import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.order.Order;

public class Aims {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Order order = null;
		boolean makedOrder = false;

		while (true) {
			showMenu();
			int choice = scanner.nextInt();
			if (choice < 0 || choice > 4) {
				System.out.println("Invalid choice");
				continue;
			}
			
			if (!makedOrder && choice != 1 && choice != 0) {
				System.out.println("Please make an order!");
				continue;
			}

			switch (choice) {
			case 1:
				order = Order.getInstanceOrder();
				makedOrder = true;
				break;
			case 2:
				int type = 0;
				while (true) {
					System.out.println("Enter type of media:\n1. Book\n2. Compact Disc\n3. Digital Video Disc");
					type = scanner.nextInt();
					if (type < 1 || type > 3) {
						System.out.println("Rechoice!");
					} else {
						break;
					}
				}
				Media media;
				String tit, cat;
				float cost;
				switch (type) {
				case 1:
					System.out.print("Enter book's title: ");
					tit = scanner.next();
					System.out.print("Enter book's category: ");
					cat = scanner.next();
					System.out.print("Enter book's cost: ");
					cost = scanner.nextFloat();
					media = new Book(tit, cat, cost);
					break;
				case 2:
					
				}
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

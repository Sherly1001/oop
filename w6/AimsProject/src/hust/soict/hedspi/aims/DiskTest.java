package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class DiskTest {
	public static void main(String[] args) {
		Order anOrder = Order.getInstanceOrder();

		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animatin");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		anOrder.addMedia(dvd1);

		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		anOrder.addMedia(dvd2);

		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin");
		dvd3.setCategory("Animatin");
		dvd3.setCost(18.99f);
		dvd3.setDirector("Jonh Musker");
		dvd3.setLength(90);
		anOrder.addMedia(dvd3);

		String pattern = "Wars Star";
		if (anOrder.search(pattern) == null) {
			System.out.println("Can't find video with string: " + pattern);
		} else {
			System.out.println("Found a video with string: " + pattern);
		}

		pattern = "Lion";
		if (anOrder.search(pattern) == null) {
			System.out.println("Can't find video with string: " + pattern);
		} else {
			System.out.println("Found a video with string: " + pattern);
		}

		pattern = "Sherly1001";
		if (anOrder.search(pattern) == null) {
			System.out.println("Can't find video with string: " + pattern);
		} else {
			System.out.println("Found a video with string: " + pattern);
		}
	}
}

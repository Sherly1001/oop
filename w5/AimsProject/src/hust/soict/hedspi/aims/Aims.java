package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class Aims {
	public static void main(String[] args) {
		Order anOrder = Order.getInstanceOrder();
		Order twoOrder = Order.getInstanceOrder();
		Order threeOrder = Order.getInstanceOrder();
		Order fourOrder = Order.getInstanceOrder();
		Order fiveOrder = Order.getInstanceOrder();
		Order sixOrder = Order.getInstanceOrder();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animatin");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		anOrder.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Start Wars");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		anOrder.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin");
		dvd3.setCategory("Animatin");
		dvd3.setCost(18.99f);
		dvd3.setDirector("Jonh Musker");
		dvd3.setLength(90);
		anOrder.addDigitalVideoDisc(dvd3);
		
		System.out.print("Total cost is: ");
		System.out.println(anOrder.totalCost());
		
		// check remove disc
		anOrder.removeDigitalVideoDisc(dvd2);
		System.out.println(anOrder.totalCost());
		
		anOrder.printOrdered();
		twoOrder.printOrdered();
		threeOrder.printOrdered();
		fourOrder.printOrdered();
		fiveOrder.printOrdered();
	}
}

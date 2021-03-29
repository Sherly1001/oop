package hust.soict.hedspi.test.utils;

import hust.soict.hedspi.aims.utils.DateUtils;
import hust.soict.hedspi.aims.utils.MyDate;
import junit.framework.TestCase;

public class DateTest extends TestCase {
	public static void main(String[] args) {
		// MyDate date1 = new MyDate();
		// testGetDay(14, date1);
		// testGetMonth(3, date1);
		// testGetYear(2021, date1);
		// testSetYear(-2001, date1);
		// testAccept(13, 11, 2020, date1);

		MyDate aDate = new MyDate("first", "February", "twenty nineteen");
		MyDate bDate = new MyDate("first", "February", "twenty twenty");
		MyDate[] dateList = {bDate, aDate};
		aDate.print();
		bDate.print();
		System.out.printf("aDate vs bDate is: %d\n",
				DateUtils.compareMyDate(aDate, bDate));
		System.out.println("Before sorting");
		DateUtils.print(dateList);
		DateUtils.sortMyDate(dateList);
		System.out.println("After sorting");
		DateUtils.print(dateList);
	}
	public static void testGetDay(int day, MyDate d) {
		assertEquals(day, d.getDay());
	}
	public static void testGetMonth(int month, MyDate d) {
		assertEquals(month, d.getMonth());
	}
	public static void testGetYear(int year, MyDate d) {
		assertEquals(year, d.getYear());
	}
	public static void testSetYear(int year, MyDate d) {
		d.setYear(year);
		assertEquals("Invalid Year", year, d.getYear());
	}
	public static void testAccept(int day, int month, int year, MyDate d) {
		d.accept();
		assertTrue(d.getDay() == day && d.getMonth() == month
				&& d.getYear() == year);
	}
}

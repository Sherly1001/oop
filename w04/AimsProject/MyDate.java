package AimsProject;

import java.util.Arrays;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;

public class MyDate {
	private int day;
	private int month;
	private int year;

	private static String[] strDay = {"zero", "first", "second", "third",
			"fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth",
			"eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth",
			"sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentieth",
			"twenty-first", "twenty-second", "twenty-third", "twenty-fourth",
			"twenty-fifth", "twenty-sixth", "twenty-seventh", "twenty-eighth",
			"twenty-ninth", "thirtieth", "thirty-first"};
	private static String[] strMonth = {"January", "February", "March", "April",
			"May", "June", "July", "August", "September", "October", "November",
			"December"};
	private static String unitsArray[] = {"zero", "one", "two", "three", "four",
			"five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
			"thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
			"eighteen", "nineteen"};
	private static String tensArray[] = {"zero", "ten", "twenty", "thirty",
			"forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

	public MyDate() {
		this.day = LocalDate.now().getDayOfMonth();
		this.month = LocalDate.now().getMonthValue();
		this.year = LocalDate.now().getYear();
	}
	public MyDate(int day, int month, int year) {
		if ((day >= 1 && day <= 31) || (month >= 1 && month <= 12)
				|| (year >= 0)) {
			this.day = day;
			this.month = month;
			this.year = year;
		} else {
			if (!(day >= 1 && day <= 31))
				System.out.println("Error : Invalid day");
			if (!(month >= 1 && month <= 12))
				System.out.println("Error : Invalid month");
			if (year < 0)
				System.out.println("Error : Invalid year");
		}
	}
	public MyDate(String date) {
		int[] Date = validDate(date);
		if (Date != null) {
			month = Date[0];
			day = Date[1];
			year = Date[2];
		}
	}
	public MyDate(String day, String month, String year) {
		for (int i = 0; i <= 31; i++) {
			if (strDay[i].equals(day))
				this.day = i;
		}
		for (int i = 0; i < 12; i++) {
			if (strMonth[i].equals(month))
				this.month = i;
		}

		String[] yearList = year.split("\\s|-");
		int yNumber = 0;
		switch (yearList.length) {
			case 4 :
				for (int i = 0; i < 10; i++)
					if (tensArray[i].equals(yearList[0]))
						yNumber += i * 1000;
				for (int i = 0; i < 20; i++)
					if (unitsArray[i].equals(yearList[1]))
						yNumber += i * 100;
				for (int i = 0; i < 10; i++)
					if (tensArray[i].equals(yearList[2]))
						yNumber += i * 10;
				for (int i = 0; i < 20; i++)
					if (unitsArray[i].equals(yearList[3]))
						yNumber += i;
				break;
			case 3 :
				for (int i = 0; i < 10; i++)
					if (tensArray[i].equals(yearList[0]))
						yNumber += i * 1000;
				for (int i = 0; i < 20; i++)
					if (unitsArray[i].equals(yearList[0]))
						yNumber += i * 100;
				for (int i = 0; i < 10; i++)
					if (tensArray[i].equals(yearList[1]))
						yNumber += i * 10;
				for (int i = 0; i < 20; i++)
					if (unitsArray[i].equals(yearList[1]))
						yNumber += i * 100;
				for (int i = 0; i < 10; i++)
					if (tensArray[i].equals(yearList[2]))
						yNumber += i * 10;
				for (int i = 0; i < 20; i++)
					if (unitsArray[i].equals(yearList[2]))
						yNumber += i;
				break;
			case 2 :
				for (int i = 0; i < 10; i++)
					if (tensArray[i].equals(yearList[0]))
						yNumber += i * 1000;
				for (int i = 0; i < 20; i++)
					if (unitsArray[i].equals(yearList[0]))
						yNumber += i * 100;
				for (int i = 0; i < 10; i++)
					if (tensArray[i].equals(yearList[1]))
						yNumber += i * 10;
				for (int i = 0; i < 20; i++)
					if (unitsArray[i].equals(yearList[1]))
						yNumber += i;
				break;
			default :
				break;
		}

		this.year = yNumber;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if (day >= 1 && day <= getDaysOfMonth(month, year))
			this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if (month >= 1 && month <= 12)
			this.month = month;
		else {
			System.out.println("Error: Invalid Month.");
		}
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if (year >= 0)
			this.year = year;
		else {
			System.out.println("Error: Invalid Year.");
		}
	}

	public void print() {
		System.out.println(strMonth[month - 1] + " " + day
				+ (day == 1
						? "st "
						: day == 2 ? "nd " : day == 3 ? "rd " : "th ")
				+ year);
	}
	public void printFormat() {
		Calendar fDate = Calendar.getInstance();
		fDate.set(year, month, day);
		String dateFormat;
		int opt;
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Please choose the optional date format; ");
		System.out.println("1. yyyy-MM-dd");
		System.out.println("2. d/M/yyyy");
		System.out.println("3. dd-MMM-yyyy");
		System.out.println("4. MMM d yyyy");
		System.out.println("5. mm-dd-yyyy");
		opt = keyboard.nextInt();

		switch (opt) {
			case 1 :
				dateFormat = "yyyy-MM-dd";
				break;
			case 2 :
				dateFormat = "d/M/yyyy";
				break;
			case 3 :
				dateFormat = "dd-MMM-yyyy";
				break;
			case 4 :
				dateFormat = "MMM d yyyy";
				break;
			case 5 :
				dateFormat = "mm-dd-yyyy";
				break;
			default :
				dateFormat = "MMMMM dd yyyy";
				break;
		}

		SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);
		System.out.println(formatter.format(fDate.getTime()));

	}

	public void accept() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the date : ");
		String date = sc.nextLine();
		int[] Date = validDate(date);
		if (Date != null) {
			month = Date[0];
			day = Date[1];
			year = Date[2];
		}
	}

	private int[] validDate(String date) {
		int error = 0;
		String[] itemsD = date.split("\\s");
		String month = itemsD[0], day = itemsD[1], year = itemsD[2];
		int m = checkValidMonth(month, validMonth);
		if (m == 0) {
			System.out.println("Syntax of Error ! (Month)");
			error = 1;
		}
		int d = checkValidDay(day);
		if (d == 0) {
			System.out.println("Syntax of Error !(Day) ");
			error = 1;
		}
		int y = 0;
		if (isNumeric(year)) {
			y = Integer.parseInt(year);
			if (y < 0) {
				System.out.println("Syntax of Error ! (Year)");
				error = 1;
			}
		} else {
			System.out.println("Syntax of Error ! (Year)");
			error = 1;
		}
		if (error == 0) {
			if (d < getDaysOfMonth(m, y)) {
				int[] Date = {m, d, y};
				return Date;
			} else {
				System.out.println("Error Invalid day");
				return null;
			}
		} else {
			return null;
		}
	}

	private List<String> validMonth = Arrays.asList("January", "February",
			"March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December", "Jan.", "Feb.", "Mar.", "Apr.",
			"Aug.", "Sept.", "Oct.", "Nov.", "Dec.", "Jan", "Feb", "Mar", "Apr",
			"Jul", "Aug", "Aug", "Sep", "Oct", "Nov", "Dec");
	private int checkLeadYear(int year) {
		if (year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0))
			return 1;
		return 0;
	}
	private int checkValidMonth(String month, List<String> validMonth) {
		if (isNumeric(month) && Integer.parseInt(month) >= 1
				&& Integer.parseInt(month) <= 12)
			return Integer.parseInt(month);
		if (validMonth.stream()
				.filter(o -> o.toLowerCase().equals(month.toLowerCase()))
				.findFirst() != null) {
			String m = month.toLowerCase();
			if (m.equals("january") || m.equals("jan.") || m.equals("jan"))
				return 1;
			else if (m.equals("february") || m.equals("feb.")
					|| m.equals("feb"))
				return 2;
			else if (m.equals("march") || m.equals("mar.") || m.equals("mar"))
				return 3;
			else if (m.equals("april") || m.equals("apr.") || m.equals("apr"))
				return 4;
			else if (m.equals("may"))
				return 5;
			else if (m.equals("june") || m.equals("jun"))
				return 6;
			else if (m.equals("july") || m.equals("jul"))
				return 7;
			else if (m.equals("august") || m.equals("aug.") || m.equals("aug"))
				return 8;
			else if (m.equals("september") || m.equals("sep.")
					|| m.equals("sep"))
				return 9;
			else if (m.equals("october") || m.equals("oct.") || m.equals("oct"))
				return 10;
			else if (m.equals("november") || m.equals("nov.")
					|| m.equals("nov"))
				return 11;
			else if (m.equals("december") || m.equals("dec.")
					|| m.equals("dec"))
				return 12;
		}
		return 0;
	}
	private boolean isNumeric(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	private int checkValidDay(String date) {
		int d;
		if (isNumeric(date))
			d = Integer.parseInt(date);
		else {
			String lod = date.substring(date.length() - 2).toLowerCase();
			if (lod.equals("st") || lod.equals("nd") || lod.equals("rd")
					|| lod.equals("th")) {
				date = date.substring(0, date.length() - 2);
			}
			if (isNumeric(date))
				d = Integer.parseInt(date);
			else
				return 0;
		}
		if (d >= 1 && d <= 31)
			return d;
		else
			return 0;
	}
	private int getDaysOfMonth(int month, int year) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12)
			return 31;
		else if (month == 2 && checkLeadYear(year) == 1) {
			return 29;
		} else if (month == 2 && checkLeadYear(year) == 0)
			return 28;
		else
			return 30;
	}
}

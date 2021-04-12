package hust.soict.hedspi.garbage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GarbageCreator {
	public static void main(String[] args) {
		String myStr = "";
		try {
			File myText = new File(
					"/run/media/vuaphapthuat410/HDD/BK courses/OOP/OOLT.20192/Hands-on labs/Lab05_code/OtherProjects/src/hust/soict/hedspi/garbage/testfile.txt");
			Scanner myScanner = new Scanner(myText);
			while (myScanner.hasNext())
				myStr += myScanner.next();
			System.out.println(myStr);
			myScanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found or can't read");
			e.printStackTrace();
		}
	}
}

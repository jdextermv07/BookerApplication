package ProgramTest;

import Program.minCat;

public class Main {

	public static void main(String[] args) {
		minCat mincat = new minCat();
		
		String stringValue1;
		String stringValue2;
		
		stringValue1 = "Hello";
		stringValue2 = "Hi";
		System.out.println(mincat.mixString(stringValue1, stringValue2));
	}

}

package com.animalshelter.main;

import java.util.Scanner;

import com.animalshelter.presentation.Presentation;

public class Main {

	public static void main(String[] args) {
		Presentation present = new Presentation();
		Scanner input = new Scanner(System.in);
		
		present.displayMainMenu();
		
	}

}

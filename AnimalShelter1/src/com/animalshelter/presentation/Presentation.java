package com.animalshelter.presentation;

import java.util.Scanner;

import com.animalshelter.beans.AnimalBean;


public class Presentation {
	Scanner input = new Scanner(System.in);
	int userInput;

	public void displayMainMenu() {
		System.out.println("===========================================");
		System.out.println("||   Welcome to Hell's Animal Shelter!   ||");
		System.out.println("|| What shelter would you like to visit? ||");
		System.out.println("||    [1] - Dog Shelter                  ||");
		System.out.println("||    [2] - Cat Shelter                  ||");
		System.out.println("||    [3] - Parrot Shelter               ||");
		System.out.println("===========================================");

		int choiceInt;
		choiceInt = Integer.parseInt(input.nextLine());

		switch (choiceInt) {

		case 1:
			

		case 2:

		case 3:

		default:
		}

	}

	public void dogMenu() {

		System.out.println("===========================================");
		System.out.println("||       Welcome to the Dog Shelter!     ||");
		System.out.println("||        What would you like to do      ||");
		System.out.println("||    [1] - Add a Dog                    ||");
		System.out.println("||    [2] - Remove a Dog                 ||");
		System.out.println("||    [3] - View all Dogs                ||");
		System.out.println("||    [4] - Return to Main Menu          ||");
		System.out.println("===========================================");

		userInput = Integer.parseInt(input.nextLine());

		boolean toContinue = false;
		AnimalBean aniBean = new AnimalBean();

		while (!toContinue) {
			switch (userInput) {
			case 1: {
				String dogName;
				int dogAge;
				String dogGender;

				System.out.println("Name the dog: ");
				dogName = input.nextLine();
				aniBean.setAnimalName(dogName);
				
				System.out.println("How old is the dog?");
				dogAge = Integer.parseInt(input.nextLine());
				aniBean.setAnimalAge(dogAge);
				
				System.out.println("What is the gender of the dog?");
				dogGender = input.nextLine();
				aniBean.setAnimalGender(dogGender);

			}

			case 2: {

			}

			case 3: {

			}

			case 4: {
				displayMainMenu();
				toContinue = true;
				break;
			}

			default:

			}
		}
	}

}

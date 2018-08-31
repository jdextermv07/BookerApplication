package com.pointwest.sakila.main;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pointwest.sakila.presentation.FilmUI;

public class Main {

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Main.class);
		FilmUI userInterface = new FilmUI();
		Scanner input = new Scanner(System.in);
		int userInput;
try {
		boolean untilCorrectInput = true;
		while (untilCorrectInput) {
			userInterface.displayMainMenu();
			userInput = Integer.parseInt(input.nextLine());

			switch (userInput) {

			case 1: {
				userInterface.displayFilmsMenu();
				userInput = Integer.parseInt(input.nextLine());
				switch (userInput) {
				case 1: {
					userInterface.byTitle();
					break;
				}
				case 2: {
					userInterface.byGenre();
					break;
				}
				case 3: {
					userInterface.byFilmActorLastName();
					break;
				}
				}
				break;
			}

			case 2: {
				userInterface.displayActorsMenu();
				userInput = Integer.parseInt(input.nextLine());
				switch (userInput) {
				case 1: {
					userInterface.byActorFirstName();
					break;
				}
				case 2: {
					userInterface.byActorLastName();
					break;
				}

				}
				break;
			}

			case 3: {
				userInterface.displayCustomerMenu();
				userInput = Integer.parseInt(input.nextLine());
				switch (userInput) {
				case 1: {
					userInterface.returnCustomersByFirstName();
					break;
				}
				case 2: {
					userInterface.returnCustomersByLastName();
					break;
				}
				case 3: {
					userInterface.returnCustomerByCountry();
					break;
				}
				}
				break;
			}
			
			case 4: {
				System.exit(0);
			}

			}
		} 
		}catch (NumberFormatException e){
			logger.error("Error on User Input");
			System.out.println("Invalid Input");
		}catch (Exception e){
			logger.error("Error occurred");
			System.out.println("Error occurred");
		}
	}

}

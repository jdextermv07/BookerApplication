package com.exercise.main;

import java.util.List;
import java.util.Scanner;

import com.exercise.bean.FilmBean;
import com.exercise.bean.AccountBean;
import com.exercise.manager.FilmManager;
import com.exercise.manager.AccountManager;

public class MainTest {

	public static void main(String[] args) {

		FilmManager filmMan = new FilmManager();
		AccountBean logBean = new AccountBean();
		FilmBean filmBean = new FilmBean();
		AccountManager logMan = new AccountManager();
		Scanner input = new Scanner(System.in);
		String userInputStr;
		boolean quit = false;
		boolean authorized = false;

		while (!authorized) {
			System.out.println("Enter username: ");
			userInputStr = input.nextLine();
			logBean.setUsername(userInputStr);
			System.out.println("Enter password: ");
			userInputStr = input.nextLine();
			logBean.setPassword(userInputStr);

			if (logMan.loginDetails(logBean)) {
				System.out.println("Hi " + logBean.getUsername());
				authorized = true;
			}
			else {
				System.out.println("Invalid username or password");
			}
			
			

			 
		}

		try {
		while (!quit) {
			System.out.println("------------------ M E N U ------------------------");
			System.out.println("[1] View All Films");
			System.out.println("[2] Add Film");
			System.out.println("[3] Search Film by id");
			System.out.println("[4] Exit");

			int userInput = Integer.parseInt(input.nextLine());

			switch (userInput) {

			case 1: {
				List<FilmBean> filmBeanList = filmMan.getFilmList();
				for (FilmBean film : filmBeanList) {
					System.out.println("Film ID: " + film.getFilm_id());
					System.out.println("Film Title: " + film.getTitle());
					System.out.println("Film Description: " + film.getDescription());
					System.out.println("Film Rental Rate: " + film.getRental_rate());
					System.out.println("Film Rating: " + film.getRating());
					System.out.println("Special Features: " + film.getSpecial_feature());
					System.out.println("Film Genre: " + film.getGenre());
					System.out.println("==========================================");

				}
				break;
			}

			case 2: {
				System.out.println("Enter film id: ");
				userInput = Integer.parseInt(input.nextLine());
				filmBean.setFilm_id(userInput);
				System.out.println("Enter film title: ");
				userInputStr = input.nextLine().toUpperCase();
				filmBean.setTitle(userInputStr);
				System.out.println("Enter film description: ");
				userInputStr = input.nextLine();
				filmBean.setDescription(userInputStr);
				System.out.println("Enter film rental rate: ");
				userInputStr = input.nextLine();
				filmBean.setRental_rate(userInputStr);
				System.out.println("Enter film rating: ");
				userInputStr = input.nextLine();
				filmBean.setRating(userInputStr);
				System.out.println("Enter film special features: ");
				userInputStr = input.nextLine();
				filmBean.setSpecial_feature(userInputStr);
				System.out.println("Enter film genre: ");
				userInputStr = input.nextLine();
				filmBean.setGenre(userInputStr);

				int confirm = filmMan.addFilm(filmBean);

				if (confirm != 0) {
					System.out.println("Film successfully added");
				} else {
					System.out.println("Failed to be added");
				}
				break;
			}

			case 3: {
				System.out.println("Enter film id: ");
				userInput = Integer.parseInt(input.nextLine());
				filmBean.setFilm_id(userInput);
				FilmBean fBean = filmMan.searchFilm(userInput);
				System.out.println("==========================================");
				System.out.println("Film ID: " + fBean.getFilm_id());
				System.out.println("Film Title: " + fBean.getTitle());
				System.out.println("Film Description: " + fBean.getDescription());
				System.out.println("Film Rental Rate: " + fBean.getRental_rate());
				System.out.println("Film Rating: " + fBean.getRating());
				System.out.println("Special Features: " + fBean.getSpecial_feature());
				System.out.println("Film Genre: " + fBean.getGenre());
				System.out.println("==========================================");
				System.out.println("What do you want to do with this film? ");
				System.out.println("[1] Update details");
				System.out.println("[2] Delete");
				System.out.println("[3] Nothing, just bring me back to the main menu");

				userInput = Integer.parseInt(input.nextLine());

				switch (userInput) {
				case 1:
					FilmBean filmBeans = new FilmBean();
					filmBeans.setFilm_id(fBean.getFilm_id());

					System.out.println("Enter new film title: ");
					userInputStr = input.nextLine().toUpperCase();
					filmBeans.setTitle(userInputStr);
					if (userInputStr.equals("")) {
						filmBeans.setTitle(fBean.getTitle());
					}

					System.out.println("Enter new film description: ");
					userInputStr = input.nextLine();
					filmBeans.setDescription(userInputStr);
					if (userInputStr.equals("")) {
						filmBeans.setDescription(fBean.getDescription());
					}

					System.out.println("Enter new film rental rate: ");
					userInputStr = input.nextLine();
					filmBeans.setRental_rate(userInputStr);
					if (userInputStr.equals("")) {
						filmBeans.setRental_rate(fBean.getRental_rate());
					}

					System.out.println("Enter new film rating: ");
					userInputStr = input.nextLine();
					filmBeans.setRating(userInputStr);
					if (userInputStr.equals("")) {
						filmBeans.setRating(fBean.getRating());
					}

					System.out.println("Enter new film special features: ");
					userInputStr = input.nextLine();
					filmBeans.setSpecial_feature(userInputStr);
					if (userInputStr.equals("")) {
						filmBeans.setSpecial_feature(fBean.getSpecial_feature());
					}

					System.out.println("Enter new film genre: ");
					userInputStr = input.nextLine();
					filmBeans.setGenre(userInputStr);
					if (userInputStr.equals("")) {
						filmBeans.setGenre(fBean.getGenre());
					}

					int confirm = filmMan.updateFilm(filmBeans);
					if (confirm != 0) {
						System.out.println("Film successfully updated");
					} else {
						System.out.println("Failed to be updated");
					}
					break;
				case 2: {
					int confirm1 = filmMan.deleteFilm(fBean.getFilm_id());
					if (confirm1 != 0) {
						System.out.println("Film successfully deleted");
					} else {
						System.out.println("Failed to delete");
					}
					break;
				}
				case 3: {
					break;
				}
				}
				break;
			}
			case 4:
				quit = true;
				break;
			}

		}
	}catch (NumberFormatException e) {
		System.out.println("Invalid Input");
	}catch (Exception e) {
		System.out.println("An error occurred");
	}
		}
}

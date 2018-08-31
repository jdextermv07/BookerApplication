package com.pointwest.sakila.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.pointwest.sakila.bean.ActorBean;
import com.pointwest.sakila.bean.FilmBean;

public class ActorDao {
	Logger logger = Logger.getLogger(ActorDao.class);
	public List<ActorBean> searchByLastName(String param) {

		File inputFile = new File("actor-table.txt");
		Scanner scanner;

		List<ActorBean> actors = new ArrayList<ActorBean>();
		ActorBean actBean;
		String[] actorDetails;
		try {
			scanner = new Scanner(inputFile);
			String next = scanner.nextLine();
			while (scanner.hasNext()) {
				actorDetails = scanner.nextLine().split("\\|");
				if (actorDetails[2].toLowerCase().indexOf(param) != -1) {
					actBean = new ActorBean();
					actBean.setActorID(actorDetails[0]);
					actBean.setActorFisrtName(actorDetails[1]);
					actBean.setActorLastName(actorDetails[2]);
					actors.add(actBean);
				}
			}

		} catch (FileNotFoundException e) {
			logger.error("File not found");
			System.out.println("An error occurred");

		} catch (Exception e) {
			logger.error("An error occurred");
			System.out.println("An error occurred");
		}

		return actors;

	}

	public List<ActorBean> searchByFirstName(String param) {

		File inputFile = new File("actor-table.txt");
		Scanner scanner;

		List<ActorBean> actors = new ArrayList<ActorBean>();
		ActorBean actBean;
		String[] actorDetails;
		try {
			scanner = new Scanner(inputFile);
			String next = scanner.nextLine();
			while (scanner.hasNext()) {
				actorDetails = scanner.nextLine().split("\\|");
				if (actorDetails[1].toLowerCase().indexOf(param) != -1) {
					actBean = new ActorBean();
					actBean.setActorID(actorDetails[0]);
					actBean.setActorFisrtName(actorDetails[1]);
					actBean.setActorLastName(actorDetails[2]);
					actors.add(actBean);
				}
			}

		} catch (FileNotFoundException e) {
			logger.error("File not found");
			System.out.println("An error occurred");

		} catch (Exception e) {
			logger.error("An error occurred");
			System.out.println("An error occurred");
		}

		return actors;

	}

	public List<ActorBean> searchFilmByActorsLastName(String param) {
		File inputFile = new File("actor-table.txt");
		Scanner scanner;

		List<ActorBean> actors = new ArrayList<ActorBean>();
		ActorBean anActor;
		String[] actorLineDetails;

		try {
			scanner = new Scanner(inputFile);
			String toNext = scanner.nextLine();
			while (scanner.hasNext()) {
				actorLineDetails = scanner.nextLine().split("\\|");
				if (actorLineDetails[2].toLowerCase().indexOf(param) != -1) {
					anActor = new ActorBean();
					anActor.setActorID(actorLineDetails[0]);
					anActor.setActorFisrtName(actorLineDetails[1]);
					anActor.setActorLastName(actorLineDetails[2]);

					actors.add(anActor);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("File not found");
			System.out.println("An error occurred");

		} catch (Exception e) {
			logger.error("An error occurred");
			System.out.println("An error occurred");
		}
		return actors;

	}
	
	public List<ActorBean> searchFilmByActorsFirstName(String param) {
		File inputFile = new File("actor-table.txt");
		Scanner scanner;

		List<ActorBean> actors = new ArrayList<ActorBean>();
		ActorBean anActor;
		String[] actorLineDetails;

		try {
			scanner = new Scanner(inputFile);
			String toNext = scanner.nextLine();
			while (scanner.hasNext()) {
				actorLineDetails = scanner.nextLine().split("\\|");
				if (actorLineDetails[1].toLowerCase().indexOf(param) != -1) {
					anActor = new ActorBean();
					anActor.setActorID(actorLineDetails[0]);
					anActor.setActorFisrtName(actorLineDetails[1]);
					anActor.setActorLastName(actorLineDetails[2]);

					actors.add(anActor);
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("File not found");
			System.out.println("An error occurred");

		} catch (Exception e) {
			logger.error("An error occurred");
			System.out.println("An error occurred");
		}
		return actors;

	}

	public List<String> getActorsID(String param) {
		File inputFile = new File("actor-table.txt");
		Scanner scanner;

		List<String> actorsIDList = new ArrayList<String>();
		ActorBean actors;
		String[] actorsIDArray;
		String temp;

		try {
			scanner = new Scanner(inputFile);
			String toNext = scanner.nextLine();
			while (scanner.hasNext()) {
				actorsIDArray = scanner.nextLine().split("\\|");
				if (actorsIDArray[2].toLowerCase().indexOf(param) != -1) {
					actors = new ActorBean();
					actorsIDList.add(actors.setActorIDStr(actorsIDArray[0]));
				}

			}

		} catch (FileNotFoundException e) {
			logger.error("File not found");
			System.out.println("An error occurred");

		} catch (Exception e) {
			logger.error("An error occurred");
			System.out.println("An error occurred");
		}
		return actorsIDList;

	}

	public List<String> matchGetFilmID(List<String> compareVal) {
		File inputFile = new File("film-actor-table.txt");
		Scanner scanner;

		List<String> listFilmID = new ArrayList<String>();
		FilmBean filmID;
		String[] specificFilmID;

		try {
			scanner = new Scanner(inputFile);
			String toNext = scanner.nextLine();
			while (scanner.hasNext()) {
				specificFilmID = scanner.nextLine().split("\\|");
				for (String value : compareVal) {
					if (value.equals(specificFilmID[1])) {
						filmID = new FilmBean();
						listFilmID.add(filmID.setFilmIdStr(specificFilmID[0]));
						
					}
				}
			}

		} catch (FileNotFoundException e) {
			logger.error("File not found");
			System.out.println("An error occurred");

		} catch (Exception e) {
			logger.error("An error occurred");
			System.out.println("An error occurred");
		}
		return listFilmID;
	}

	public List<FilmBean> getFilmBeanListUsingFilmID(List<String> listParam) {
		File inputFile = new File("film-table.txt");
		Scanner scanner;

		List<FilmBean> filmBeanList = new ArrayList<FilmBean>();
		FilmBean filmDetails;
		String[] arrayFilmDetails;

		try {
			scanner = new Scanner(inputFile);
			String toNext = scanner.nextLine();
			while (scanner.hasNext()) {
				arrayFilmDetails = scanner.nextLine().split("\\|");
				for (String filmID : listParam) {
					if (filmID.equals(arrayFilmDetails[0])) {
						filmDetails = new FilmBean();
						filmDetails.setFilmId(arrayFilmDetails[0]);
						filmDetails.setFilmTitle(arrayFilmDetails[1]);
						filmDetails.setFilmDescription(arrayFilmDetails[2]);
						filmDetails.setFilmRentRate(Double.parseDouble(arrayFilmDetails[3]));
						filmDetails.setFilmRating(arrayFilmDetails[4]);
						filmDetails.setFilmSpecialFeatures(arrayFilmDetails[5]);
						filmDetails.setFilmGenre(arrayFilmDetails[6]);

						filmBeanList.add(filmDetails);
					}
				}
			}

		} catch (FileNotFoundException e) {
			logger.error("File not found");
			System.out.println("An error occurred");

		} catch (Exception e) {
			logger.error("An error occurred");
			System.out.println("An error occurred");
		}
		return filmBeanList;

	}

	public List<FilmBean> matchingOfActorToFilmActorSearch(ActorBean actor) {

		File inputFile = new File("film-actor-table.txt");
		File inputFileFilms = new File("film-table.txt");
		Scanner scanner1;
		Scanner scanner2;
		String[] compareActorFilm;
		List<String> filmList = new ArrayList<String>();
		List<FilmBean> films = new ArrayList<FilmBean>();

		try {
			scanner1 = new Scanner(inputFile);
			String next = scanner1.nextLine();
			while (scanner1.hasNext()) {
				compareActorFilm = scanner1.nextLine().split("\\|");

				if (actor.getActorID().equals(compareActorFilm[1])) {
					filmList.add(compareActorFilm[0]);
				}
			}
			scanner2 = new Scanner(inputFileFilms);
			FilmBean filmBean;
			String[] filmDetails;

			String nextline = scanner2.nextLine();
			while (scanner2.hasNext()) {
				filmDetails = scanner2.nextLine().split("\\|");

				if (filmList.contains(filmDetails[0])) {
					filmBean = new FilmBean();
					filmBean.setFilmId(filmDetails[0]);
					filmBean.setFilmTitle(filmDetails[1]);
					filmBean.setFilmDescription(filmDetails[2]);
					filmBean.setFilmRentRate(Double.parseDouble(filmDetails[3]));
					filmBean.setFilmRating(filmDetails[4]);
					filmBean.setFilmSpecialFeatures(filmDetails[5]);
					filmBean.setFilmGenre(filmDetails[6]);

					films.add(filmBean);
				}
			}

		} catch (FileNotFoundException e) {
			logger.error("File not found");
			System.out.println("An error occurred");

		} catch (Exception e) {
			logger.error("An error occurred");
			System.out.println("An error occurred");
		}

		return films;

	}

}

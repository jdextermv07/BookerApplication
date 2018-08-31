package com.pointwest.sakila.repository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

import com.pointwest.sakila.bean.ActorBean;
import com.pointwest.sakila.bean.FilmBean;

public class FilmDao {
	Logger logger = Logger.getLogger(FilmDao.class);
	public List<FilmBean> searchByTitle(String param) {

		
		File inputFile = new File("film-table.txt");
		Scanner scanner;

		List<FilmBean> films = new ArrayList<FilmBean>();
		FilmBean aFilm;
		String[] filmLineDetails;

		try {
			scanner = new Scanner(inputFile);
			String toNext = scanner.nextLine();
			while (scanner.hasNext()) {
				filmLineDetails = scanner.nextLine().split("\\|");
				if (filmLineDetails[1].toLowerCase().indexOf(param) != -1) {
					aFilm = new FilmBean();
					aFilm.setFilmId(filmLineDetails[0]);
					aFilm.setFilmTitle(filmLineDetails[1]);
					aFilm.setFilmDescription(filmLineDetails[2]);
					aFilm.setFilmRentRate(Double.parseDouble(filmLineDetails[3]));
					aFilm.setFilmRating(filmLineDetails[4]);
					aFilm.setFilmSpecialFeatures(filmLineDetails[5]);
					aFilm.setFilmGenre(filmLineDetails[6]);

					films.add(aFilm);
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

	public List<ActorBean> matchingBasisOfFilmActor(FilmBean film) {
				
		File inputFile = new File("film-actor-table.txt");
		File inputFileActors = new File("actor-table.txt");
		Scanner scanner;
		String[] compareFilmActor;
		List<String> actorList = new ArrayList<String>();
		List<ActorBean> actors = new ArrayList<ActorBean>();
		
		try {
			scanner = new Scanner(inputFile);
			String next = scanner.nextLine();
			while (scanner.hasNext()) {
				compareFilmActor = scanner.nextLine().split("\\|");
		
				if(film.getFilmId().equals(compareFilmActor[0])) {
					actorList.add(compareFilmActor[1]);
				}
			}
		
		Scanner scanner1 = new Scanner(inputFileActors);
		ActorBean actBean;
		String[] actorDetails;
		
		
		String nextline = scanner1.nextLine();
		while (scanner1.hasNext()) {
			actorDetails = scanner1.nextLine().split("\\|");
			
			if(actorList.contains(actorDetails[0])) {
				actBean = new ActorBean();
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
	public List<FilmBean> searchByGenre(String param) {

		File inputFile = new File("film-table.txt");
		Scanner scanner;

		List<FilmBean> films = new ArrayList<FilmBean>();
		FilmBean aFilm;
		String[] filmLineDetails;

		try {
			scanner = new Scanner(inputFile);
			String toNext = scanner.nextLine();
			while (scanner.hasNext()) {
				filmLineDetails = scanner.nextLine().split("\\|");
				if (filmLineDetails[6].toLowerCase().indexOf(param) != -1) {
					aFilm = new FilmBean();
					aFilm.setFilmId(filmLineDetails[0]);
					aFilm.setFilmTitle(filmLineDetails[1]);
					aFilm.setFilmDescription(filmLineDetails[2]);
					aFilm.setFilmRentRate(Double.parseDouble(filmLineDetails[3]));
					aFilm.setFilmRating(filmLineDetails[4]);
					aFilm.setFilmSpecialFeatures(filmLineDetails[5]);
					aFilm.setFilmGenre(filmLineDetails[6]);

					films.add(aFilm);
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


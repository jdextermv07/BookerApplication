package com.pointwest.sakila.presentation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import com.pointwest.sakila.bean.ActorBean;
import com.pointwest.sakila.bean.AddressBean;
import com.pointwest.sakila.bean.CustomerBean;
import com.pointwest.sakila.bean.FilmBean;
import com.pointwest.sakila.manager.CustomerManager;
import com.pointwest.sakila.manager.FilmAndActorManager;

public class FilmUI {
	Scanner input = new Scanner(System.in);
	FilmAndActorManager filmMan = new FilmAndActorManager();
	CustomerManager custMan = new CustomerManager();
	String userInputStr;

	public void displayMainMenu() {
		System.out.println("What do you want to search for?");
		System.out.println("[1] - Films");
		System.out.println("[2] - Actors");
		System.out.println("[3] - Customers");
		System.out.println("[4] - Exit");
		System.out.println("Enter input[1-4]");
	}

	public void displayFilmsMenu() {
		System.out.println("How do you want to search for FILMS?");
		System.out.println("[1] - By Title");
		System.out.println("[2] - By Genre/Category");
		System.out.println("[3] - By Actor's Last Name");
		System.out.println("Enter input[1-3]");
	}

	public void displayActorsMenu() {
		System.out.println("How do you want to search for ACTORS?");
		System.out.println("[1] - By Actor First Name");
		System.out.println("[2] - By Actor Last Name");
	}

	public void byTitle() {
		System.out.println("Enter search parameters: ");
		userInputStr = input.nextLine();
		Map<FilmBean, List<ActorBean>> mapFilmAct1 = filmMan.returnTitleSearchResult(userInputStr);

		for (Map.Entry<FilmBean, List<ActorBean>> entry : mapFilmAct1.entrySet()) {
			FilmBean beanFilm = entry.getKey();
			List<ActorBean> actBeanList = entry.getValue();
			System.out.println("=====================");
			System.out.println("Title: " + beanFilm.getFilmTitle());
			System.out.println("Genre: " + beanFilm.getFilmGenre());
			System.out.println("Description: " + beanFilm.getFilmDescription());
			System.out.println("Rating: " + beanFilm.getFilmRating());
			System.out.println("Special Features: " + beanFilm.getFilmSpecialFeatures());
			System.out.println("Starring: ");
			for (ActorBean actorB : actBeanList) {
				System.out.println("*  " + actorB.getActorLastName() + ", " + actorB.getActorFirstName());
			}
			System.out.println("=====================");

		}

	}

	public void byGenre() {
		System.out.println("Enter search parameters: ");
		userInputStr = input.nextLine();
		Map<FilmBean, List<ActorBean>> mapFilmAct5 = filmMan.returnGenreSearchResult(userInputStr);

		for (Map.Entry<FilmBean, List<ActorBean>> entry : mapFilmAct5.entrySet()) {
			FilmBean beanFilm = entry.getKey();
			List<ActorBean> actBeanList = entry.getValue();
			System.out.println("=====================");
			System.out.println("Title: " + beanFilm.getFilmTitle());
			System.out.println("Genre: " + beanFilm.getFilmGenre());
			System.out.println("Description: " + beanFilm.getFilmDescription());
			System.out.println("Rating: " + beanFilm.getFilmRating());
			System.out.println("Special Features: " + beanFilm.getFilmSpecialFeatures());
			System.out.println("Starring: ");
			for (ActorBean actorB : actBeanList) {
				System.out.println("*" + actorB.getActorLastName() + ", " + actorB.getActorFirstName());
			}
			System.out.println("=====================");

		}
	}

	public void byFilmActorLastName() {
		System.out.println("Enter search parameters: ");
		userInputStr = input.nextLine();
		Map<FilmBean, List<ActorBean>> mapFilmAct6 = filmMan.returnTitleByActorLastName(userInputStr);

		for (Map.Entry<FilmBean, List<ActorBean>> entry : mapFilmAct6.entrySet()) {
			FilmBean beanFilm = entry.getKey();
			List<ActorBean> actBeanList = entry.getValue();
			System.out.println("=====================");
			System.out.println("Title: " + beanFilm.getFilmTitle());
			System.out.println("Genre: " + beanFilm.getFilmGenre());
			System.out.println("Description: " + beanFilm.getFilmDescription());
			System.out.println("Rating: " + beanFilm.getFilmRating());
			System.out.println("Special Features: " + beanFilm.getFilmSpecialFeatures());
			System.out.println("Starring: ");
			for (ActorBean actorB : actBeanList) {
				System.out.println("*" + actorB.getActorLastName() + ", " + actorB.getActorFirstName());
			}
			System.out.println("=====================");

		}
	}

	public void byActorLastName() {
		System.out.println("Enter search parameters: ");
		userInputStr = input.nextLine();
		Map<ActorBean, List<FilmBean>> mapFilmAct7 = filmMan.returnActorWithTitleUsingLastName(userInputStr);

		for (Map.Entry<ActorBean, List<FilmBean>> entry : mapFilmAct7.entrySet()) {
			ActorBean beanAct = entry.getKey();
			List<FilmBean> filmBeanList = entry.getValue();

			System.out.println("=====================");
			System.out.println(beanAct.getActorLastName() + ", " + beanAct.getActorFirstName());
			System.out.println("Is in the following films: ");
			for (FilmBean filmB : filmBeanList) {
				System.out.println("* " + filmB.getFilmTitle());
			}
			System.out.println("=====================");

		}
	}

	public void byActorFirstName() {
		System.out.println("Enter search parameters: ");
		userInputStr = input.nextLine();
		Map<ActorBean, List<FilmBean>> mapFilmAct8 = filmMan.returnActorWithTitleUsingFirstName(userInputStr);

		for (Map.Entry<ActorBean, List<FilmBean>> entry : mapFilmAct8.entrySet()) {
			ActorBean beanAct = entry.getKey();
			List<FilmBean> filmBeanList = entry.getValue();

			System.out.println(beanAct.getActorLastName() + ", " + beanAct.getActorFirstName());
			System.out.println("Is in the following films: ");
			for (FilmBean filmB : filmBeanList) {
				System.out.println("* " + filmB.getFilmTitle());
			}
		}
	}

	public void displayCustomerMenu() {
		System.out.println("How do you want to search for CUSTOMER?");
		System.out.println("[1] - By First Name");
		System.out.println("[2] - By Last Name");
		System.out.println("[3] - By Country");
		System.out.println("Enter input[1-3]");

	}

	public void returnCustomersByFirstName() {
		System.out.println("Enter search parameters: ");
		userInputStr = input.nextLine();
		Map<CustomerBean, List<AddressBean>> mapCustAdd = custMan.returnCustomerByFirstName(userInputStr);

		for (Entry<CustomerBean, List<AddressBean>> entry : mapCustAdd.entrySet()) {
			CustomerBean custBean = entry.getKey();
			List<AddressBean> addBean = entry.getValue();
			System.out.println("==========================");
			System.out.println("First Name: " + custBean.getCustomerFN());
			System.out.println("Last Name: " + custBean.getCustomerLN());
			System.out.println("Email Address: " + custBean.getCustomerEmail());
			System.out.print("Address: ");
			for (AddressBean value : addBean) {
				System.out.println(value.getCustAddress() + " " + value.getAddressDistrict() + " "
						+ value.getAddressCity() + " " + value.getAddressCountry());
			}
			System.out.println("==========================");
		}
	}

	public void returnCustomersByLastName() {
		System.out.println("Enter search parameters: ");
		userInputStr = input.nextLine();
		Map<CustomerBean, List<AddressBean>> mapCustAdd1 = custMan.returnCustomerByLastName(userInputStr);

		for (Entry<CustomerBean, List<AddressBean>> entry : mapCustAdd1.entrySet()) {
			CustomerBean custBean = entry.getKey();
			List<AddressBean> addBean = entry.getValue();
			System.out.println("==========================");
			System.out.println("First Name: " + custBean.getCustomerFN());
			System.out.println("Last Name: " + custBean.getCustomerLN());
			System.out.println("Email Address: " + custBean.getCustomerEmail());
			System.out.print("Address: ");
			for (AddressBean value : addBean) {
				System.out.println(value.getCustAddress() + " " + value.getAddressDistrict() + ", "
						+ value.getAddressCity() + ", " + value.getAddressCountry());
			}
			System.out.println("==========================");
		}
	}
	
	public void returnCustomerByCountry() {
		System.out.println("Enter search parameters: ");
		userInputStr = input.nextLine();
		Map<AddressBean, List<CustomerBean>> mapCustAdd2 = custMan.returnCustomerByCountry(userInputStr);
		
		for (Entry<AddressBean, List<CustomerBean>> entry : mapCustAdd2.entrySet()) {
			AddressBean addressBean = entry.getKey();
			List<CustomerBean> customerBean = entry.getValue();
			for(CustomerBean value : customerBean) {
				System.out.println("==========================");
				System.out.println("First Name: " + value.getCustomerFN());
				System.out.println("Last Name: " + value.getCustomerLN());
				System.out.println("Email Address: " + value.getCustomerEmail());
				System.out.print("Address: ");
				System.out.println(addressBean.getCustAddress()+" "+ addressBean.getAddressDistrict()+", "+addressBean.getAddressCity()+", "+addressBean.getAddressCountry());
				System.out.println("==========================");
			}
			
			
			
		}
		
	}
}

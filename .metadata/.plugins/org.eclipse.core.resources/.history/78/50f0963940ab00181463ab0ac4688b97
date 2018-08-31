package com.pw.io.booker;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.pw.io.booker.model.Reservation;
import com.pw.io.booker.model.TravelItem;
import com.pw.io.booker.repository.FeedbackRepository;
import com.pw.io.booker.service.ReservationService;
import com.pw.io.booker.service.TravelItemService;
import com.pw.io.booker.util.BookerServiceUtil;

@SpringBootApplication(scanBasePackages = { "com.pw.io.booker.config", "com.pw.io.booker.controller"})
public class BookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext context) {
		return args -> {

			FeedbackRepository feedbackRepository = context.getBean("feedbackRepository", FeedbackRepository.class);
			ReservationService reservationService = context.getBean("reservationService", ReservationService.class);
			TravelItemService travelItemService = context.getBean(TravelItemService.class);
			BookerServiceUtil bookerServiceUtil = context.getBean(BookerServiceUtil.class);
			bookerServiceUtil.initializeData();
			System.out.println(feedbackRepository);
			System.out.println(reservationService);
			Reservation reservation = new Reservation();
			List<TravelItem> travelItems = new ArrayList<>();
			travelItems.add(travelItemService.findById(1001));
			reservation.setAvailedItemList(travelItems);
			reservationService.reserve(reservation);
			System.out.println(reservationService.findById(1000));
//    		System.out.println(reservationService.getFeedbackRepository());

		};
	}
}

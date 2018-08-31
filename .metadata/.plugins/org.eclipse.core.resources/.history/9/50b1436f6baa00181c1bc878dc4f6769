package com.pw.io.booker.repository.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.pw.io.booker.model.Reservation;

public class ReservationRepositoryList {

	private Map<Integer, Reservation> reservationMap = new HashMap<>();
	private int reservationIdGenerator = 1000;

	public List<Reservation> findAll() {
		return new ArrayList<>(reservationMap.values());
	}

	public Reservation find(int id) {
		return reservationMap.get(id);
	}

	public Reservation save(Reservation model) {
		if (find(model.getReservationId()) != null) {
			reservationMap.put(model.getReservationId(), model);
			return model;
		}
		model.setReservationId(reservationIdGenerator++);
		reservationMap.put(model.getReservationId(), model);
		return model;
	}

	public Reservation delete(Reservation model) {
		return reservationMap.remove(model.getReservationId());
	}

}

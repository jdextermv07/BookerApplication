package com.pw.io.booker.util;

import java.util.ArrayList;
import java.util.List;

import com.pw.io.booker.model.TravelItem;
import com.pw.io.booker.model.TravelPackage;
import com.pw.io.booker.repository.TravelItemRepository;
import com.pw.io.booker.repository.TravelPackageRepository;

public class BookerServiceUtil {

	private TravelItemRepository travelItemRepository;
	private TravelPackageRepository travelPackageRepository;
	private static final int TRAVEL_ITEM_LIMIT = 5;

	public BookerServiceUtil(TravelItemRepository travelItemRepository,
			TravelPackageRepository travelPackageRepository) {
		super();
		this.travelItemRepository = travelItemRepository;
		this.travelPackageRepository = travelPackageRepository;
	}

	/**
	 * @return Generates travel packages with TRAVEL_ITEM_LIMIT number of travel
	 *         items
	 */
	public TravelPackage generateTravelPackage() {
		TravelPackage travelPackage = new TravelPackage();

		TravelItem travelItem = null;
		List<TravelItem> travelItemList = new ArrayList<>();
		for (int ctr = 0; ctr < TRAVEL_ITEM_LIMIT; ctr++) {
			travelItem = travelItemRepository.save(generateTravelItem());
			travelItem.setTravelPackage(travelPackage);
			travelItemList.add(travelItem);
		}

		travelPackage.setAvailableItemList(travelItemList);
		return travelPackage;
	}

	public TravelItem generateTravelItem() {
		return new TravelItem();
	}

	public void initializeData() {
		travelPackageRepository.save(generateTravelPackage());
		travelPackageRepository.save(generateTravelPackage());
		travelItemRepository.save(generateTravelItem());
	}

}

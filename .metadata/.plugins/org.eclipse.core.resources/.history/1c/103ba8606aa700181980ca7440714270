package com.pw.io.booker.repository.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.pw.io.booker.model.TravelPackage;

@Repository
public class TravelPackageRepositoryList {

	private List<TravelPackage> travelPackageList = new ArrayList<>();
	private int travelPackageIdGenerator = 1000;

	public List<TravelPackage> findAll() {
		return travelPackageList;
	}

	public TravelPackage find(int id) {
		for (TravelPackage travelPackage : travelPackageList) {
			if (id == travelPackage.getTravelPackageId()) {
				return travelPackage;
			}
		}
		return null;
	}

	public TravelPackage save(TravelPackage model) {
		if (find(model.getTravelPackageId()) != null) {
			travelPackageList.add(model);
		}
		model.setTravelPackageId(travelPackageIdGenerator++);
		travelPackageList.add(model);
		return model;
	}

	public TravelPackage delete(TravelPackage model) {
		for (Iterator<TravelPackage> iter = travelPackageList.iterator(); iter.hasNext();) {
			TravelPackage travelPackage = iter.next();
			if (model.getTravelPackageId() == travelPackage.getTravelPackageId()) {
				iter.remove();
				return travelPackage;
			}
		}
		return null;
	}

}

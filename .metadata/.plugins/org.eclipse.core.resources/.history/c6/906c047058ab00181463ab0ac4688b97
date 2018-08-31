package com.pw.io.booker.repository.impl.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.pw.io.booker.model.TravelPackage;
import com.pw.io.booker.repository.TravelPackageRepository;

@Repository
public class TravelPackageRepositoryMap implements TravelPackageRepository {

	private Map<Integer, TravelPackage> travelPackageMap = new HashMap<>();
	private int travelPackageIdGenerator = 1000;

	@Override
	public List<TravelPackage> findAll() {
		return new ArrayList<>(travelPackageMap.values());
	}

	@Override
	public TravelPackage findById(int id) {
		return travelPackageMap.get(id);
	}

	@Override
	public TravelPackage save(TravelPackage model) {
		if(findById(model.getTravelPackageId()) != null) {			
			travelPackageMap.put(model.getTravelPackageId(), model);
			return model;
		}
		model.setTravelPackageId(travelPackageIdGenerator++);
		travelPackageMap.put(model.getTravelPackageId(), model);
		return model;	
	}

	@Override
	public void delete(TravelPackage model) {
		travelPackageMap.remove(model.getTravelPackageId());
	}

}

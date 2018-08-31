package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.demo.model.TravelPackage;
import com.example.demo.repository.TravelPackageRepository;

@Service
public class TravelPackageService {

	private TravelPackageRepository travelPackageRepository;
	private ServiceService serviceService;
	private ImageService imageService;

	public TravelPackageService(TravelPackageRepository travelPackageService) {
		super();
		this.travelPackageRepository = travelPackageService;
	}

	// travel packages
	public List<TravelPackage> findAllList() {
		Iterable<TravelPackage> iterTravPack = travelPackageRepository.findAll();
		List<TravelPackage> listTravelPackage = new ArrayList<TravelPackage>();
		for (TravelPackage value : iterTravPack) {
			listTravelPackage.add(value);
		}
		return listTravelPackage;
	}

	public List<TravelPackage> addTravelPackageList(List<TravelPackage> travelPackageList) {
		List<TravelPackage> listTravelPackage = new ArrayList<TravelPackage>();
		for (TravelPackage value : travelPackageList) {
			
			travelPackageRepository.save(value);
			listTravelPackage.add(value);
		}
		return listTravelPackage;
	}

	@Transactional
	public List<TravelPackage> updateTravelPackageList(List<TravelPackage> travelPackageList) {
		List<TravelPackage> listTravPack = new ArrayList<TravelPackage>();
		for (TravelPackage value : travelPackageList) {
			TravelPackage travPackTemp = travelPackageRepository.findById(value.getTravelpackageId()).get();
			if (value.getTravelpackageId() == travPackTemp.getTravelpackageId()) {
				
				travelPackageRepository.save(value);
				listTravPack.add(value);
			} else {
				System.out.println("Invalid");
			}
		}
		return listTravPack;
	}
	
	public void deleteTravelPackageList(int [] intArray) {
		for (int value : intArray) {
			travelPackageRepository.delete(travelPackageRepository.findById(value).get());
		}

	}
	

	// travel package

	public void deleteTravelPackage(TravelPackage travelPackage) {
		travelPackageRepository.delete(travelPackage);
	}

	public TravelPackage findById(int id) {
		return travelPackageRepository.findById(id).get();
	}

	public TravelPackage updateTravelPackage(TravelPackage travelPackage, int travelPackageId) {
		travelPackage.setTravelpackageId(travelPackageId);
		return travelPackageRepository.save(travelPackage);
	}

}

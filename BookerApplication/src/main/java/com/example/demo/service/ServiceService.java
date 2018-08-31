package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Service;
import com.example.demo.model.TravelPackage;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceService {

	private ServiceRepository serviceRepository;
	private ImageService imageService;

	public ServiceService(ServiceRepository serviceRepository, ImageService imageService) {
		super();
		this.serviceRepository = serviceRepository;
		this.imageService = imageService;
	}

	public List<Service> addService(TravelPackage travelPackage) {
		List<Service> listService = new ArrayList<Service>();
			for (Service value : travelPackage.getAvailableServiceList()) {
				imageService.addImages(value.getImages());
				serviceRepository.save(value);
				listService.add(value);
			}
		return listService;
	}

	public Service addServices(Service service) {
		return serviceRepository.save(service);
	}
	
	public void deleteServices(Service service) {
		serviceRepository.delete(service);
	}
}

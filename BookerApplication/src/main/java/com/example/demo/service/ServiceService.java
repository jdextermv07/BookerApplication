package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Service;
import com.example.demo.repository.ImageRepository;
import com.example.demo.repository.ServiceRepository;

public class ServiceService {
	
	private ServiceRepository serviceRepository;
	private ImageService imageService;
	
	public ServiceService(ServiceRepository serviceRepository, ImageService imageService) {
		super();
		this.serviceRepository = serviceRepository;
		this.imageService = imageService;
	}

	public List<Service> addService(List<Service> serviceList){
		List<Service> listService = new ArrayList<Service>();
		for (Service value:serviceList) {
			imageService.addImages(value.getImages());
			serviceRepository.save(value);
			listService.add(value);
		}
		return listService;
		
	}
	
	

}
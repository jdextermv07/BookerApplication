package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Image;
import com.example.demo.model.TravelPackage;
import com.example.demo.repository.ImageRepository;
@Service
public class ImageService {

	private ImageRepository imageRepository;

	public ImageService(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}
	
	public List<Image> addImages(TravelPackage travelPackage) {
		List<Image> listImage = new ArrayList<Image>();
		for(Image value : travelPackage.getImages()) {		
			imageRepository.save(value);
			listImage.add(value);
		}
		return listImage;	
	}
	
	public List<Image> addImages(List<Image> imageList) {
		List<Image> listImage = new ArrayList<Image>();
		for(Image value : imageList) {		
			imageRepository.save(value);
			listImage.add(value);
		}
		return listImage;	
	}
	
	public Image addImages(Image image) {
		return imageRepository.save(image);
	}
	
	
}

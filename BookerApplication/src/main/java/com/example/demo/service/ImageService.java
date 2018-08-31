package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Image;
import com.example.demo.repository.ImageRepository;

public class ImageService {

	private ImageRepository imageRepository;

	public ImageService(ImageRepository imageRepository) {
		super();
		this.imageRepository = imageRepository;
	}
	
	public List<Image> addImages(List<Image> imageList) {
		List<Image> listImage = new ArrayList<Image>();
		for(Image value : imageList) {
			imageRepository.save(value);
			listImage.add(value);
		}
		return listImage;	
	}
	
	
}

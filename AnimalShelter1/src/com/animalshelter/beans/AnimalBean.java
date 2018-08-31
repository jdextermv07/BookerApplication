package com.animalshelter.beans;

public class AnimalBean {

	String animalName;
	String animalGender;
	int animalAge;
	int referenceId;
	int numberIncrmnt = 1;
	
	
	public int changeId() {
		referenceId = numberIncrmnt;
		numberIncrmnt++;
		return referenceId;
	}
	
	public String getAnimalName() {
		return animalName;
	}
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}
	public String getAnimalGender() {
		return animalGender;
	}
	public void setAnimalGender(String animalGender) {
		this.animalGender = animalGender;
	}
	public int getAnimalAge() {
		return animalAge;
	}
	public void setAnimalAge(int animalAge) {
		this.animalAge = animalAge;
	}
	public int getReferenceId() {
		return referenceId;
	}
	
	
	
	
	
	
}

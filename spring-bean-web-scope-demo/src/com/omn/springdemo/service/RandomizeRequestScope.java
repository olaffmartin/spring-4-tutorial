package com.omn.springdemo.service;

public class RandomizeRequestScope {
	private int randomNumber = 10;
	
	public int getRandomNumber() {
		return randomNumber;
	}
	
	public void generateRandomNumber() {
		this.randomNumber = (int) (Math.random() * 99999);
	}

}

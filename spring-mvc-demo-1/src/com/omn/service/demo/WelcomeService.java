package com.omn.service.demo;

import java.util.ArrayList;
import java.util.List;

public class WelcomeService implements GenericWelcomeService {
	
	public List<String> getWelcomeMessage(String name){
		
		List<String> myWelcomeMessage = new ArrayList<>();
		
		// Add data to the list
		myWelcomeMessage.add("Hello! ");
		myWelcomeMessage.add(name);
		myWelcomeMessage.add(", Welcome to the Spring Demo");
		
		return myWelcomeMessage;
	}

}

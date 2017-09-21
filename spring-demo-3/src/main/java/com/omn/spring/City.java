/**
 * 
 */
package com.omn.spring;

/**
 * @author om
 *
 */
public class City {
	String name;
	
	
	
	public City() {
		this("New York");
	}


	public City(String name) {
		this.name = name;
	}


	public String cityName() {
		return name;
	}

}

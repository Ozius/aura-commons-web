package com.nemsolutions.auracommons.web.model;

import javax.faces.bean.ManagedBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ManagedBean
public class HelloWorld {
	
	private static final Logger log = LoggerFactory.getLogger(HelloWorld.class);
	
	public HelloWorld() {
		log.info("NUEVA INSTANCIA DE HelloWorld ManagedBean");
	}

	private String firstName = "John";
	private String lastName = "Doe";

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String showGreeting() {
		return "Hello " + firstName + " " + lastName + "!";
	}

}

package com.testando.teste.controler;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Scope(value = "view")
@Component
public class Teste {

	private String firstName;
	private String lastName;
	private String greetings;

	public String getFirstName() {
		return firstName;
	}

	public String getGreetings() {
		return greetings;
	}

	public void setGreetings(String greetings) {
		this.greetings = greetings;
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

	public static String showGreeting() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		return "Hello " + authentication.getName() + "!";
	}

	@PostConstruct
	private void loadObjects() {
		this.greetings = showGreeting();
	}
}
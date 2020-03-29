package com.hellofresh.challenge.helper;

public enum Url {
	
	BASE_URL("http://automationpractice.com/index.php");
	
	public String value;
	
	Url(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}

package com.hellofresh.challenge.dataprovider;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class DataProviderSignIn {
	
	@DataProvider(name = "validData")
	public static Object[][] signInWithValidData() {
		 Map<String, String> registrationData = new HashMap<String, String>();
		 registrationData.put("firstname", "Victor");
		 registrationData.put("lastname", "Jackson");
		 registrationData.put("password", "Qwerty");
		 registrationData.put("days", "1");
		 registrationData.put("months", "1");
		 registrationData.put("years", "2000");
		 registrationData.put("company", "Food Enterprise");
		 registrationData.put("address1", "Qwerty, 123");
		 registrationData.put("address2", "zxcvb");
		 registrationData.put("city", "Qwerty");
		 registrationData.put("state", "Colorado");
		 registrationData.put("postcode", "12345");
		 registrationData.put("additionInformation", "Qwerty");
		 registrationData.put("homePhone", "12345123123");
		 registrationData.put("mobilePhone", "998890308");
		 registrationData.put("alias", "hf");
		 return new Object[][] { { registrationData } };
	}
}

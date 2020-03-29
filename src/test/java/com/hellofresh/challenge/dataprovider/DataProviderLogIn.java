package com.hellofresh.challenge.dataprovider;

import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class DataProviderLogIn {
	
	@DataProvider(name = "validCredentials")
	public static Object[][] logInWithValidCredentials() {
		 Map<String, String> map = new HashMap<String, String>();
		 map = existingCustomerCredentials();
		 map.put("fullname", "Joe Black");
		 return new Object[][] { { map } };
	}
	
	public static Map<String, String> existingCustomerCredentials(){
		Map<String, String> map = new HashMap<String, String>();
		 map.put("email", "hf_challenge_123456@hf123456.com");
		 map.put("password", "12345678");
		 return map;
	}
}

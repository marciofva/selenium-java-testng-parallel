package com.hellofresh.challenge.dataprovider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.DataProvider;

public class DataProviderCheckout {
	
	@DataProvider(name = "purchaseForWomen")
	public static Object[][] purchaseForWomen() {
		 Map<String, String> purchaseRequirements = new HashMap<String, String>();
		 purchaseRequirements.put("category", "women");
		 purchaseRequirements.put("paymentType", "bank");
		 return new Object[][] { { purchaseRequirements } };
	}

	public static ArrayList<String> singleProductForWomen() {
		ArrayList<String> list = new ArrayList<String>();
		list.add("Faded Short Sleeve T-shirts");
		return list;
	}
}

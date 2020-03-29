package com.hellofresh.challenge.helper;

import java.util.Date;

public class Utils {
	
	public static String generateEmail() {
        String timestamp = String.valueOf(new Date().getTime());
        return "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
	}
}

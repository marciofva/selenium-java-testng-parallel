package com.hellofresh.challenge.factory;

import org.openqa.selenium.WebDriver;

public class WebdriverFactory {

	private static ThreadLocal<WebDriver> driverThread = new ThreadLocal<WebDriver>();
	
	public static WebDriver getDriver() {
		return driverThread.get();
	}

	public static void setWebDriver(String browser) throws IllegalAccessException {
		driverThread.set(BrowserFactory.createBrowserInstance(browser));
	}

	public static void removeDriver() {
		driverThread.get().quit();
		driverThread.remove();
	}
}

package com.hellofresh.challenge.test;

import java.util.logging.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import com.hellofresh.challenge.factory.WebdriverFactory;
import com.hellofresh.challenge.helper.Url;
import com.hellofresh.challenge.pages.AccountPage;
import com.hellofresh.challenge.pages.CheckoutPage;
import com.hellofresh.challenge.pages.HomePage;

public class BaseTest {
	
	protected WebDriver driver;
	protected HomePage home;
	protected AccountPage account;
	protected CheckoutPage checkout;
	
	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) throws IllegalAccessException {
		Logger.getGlobal().info(">>>> Start browser: " + browser.toUpperCase());

		WebdriverFactory.setWebDriver(browser);
		WebdriverFactory.getDriver().get(Url.BASE_URL.getValue());
		driver = WebdriverFactory.getDriver();
		home = new HomePage(driver);
	}
	
	@AfterMethod
	public void tearDown() {
		WebdriverFactory.removeDriver();
	}
}

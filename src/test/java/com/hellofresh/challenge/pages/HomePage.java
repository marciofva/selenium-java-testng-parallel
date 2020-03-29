package com.hellofresh.challenge.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	private static final String LOGIN_TITLE = "Login - My Store";
	
    @FindBy(className = "login")
    private WebElement loginBtn;
   
	public HomePage(WebDriver driver) {
		super(driver);
	}

    public AuthenticationPage goToAuthenticationPage() {
    	clickOn(loginBtn);
    	waitForTitle(LOGIN_TITLE);
    	return new AuthenticationPage(driver);
    }
}

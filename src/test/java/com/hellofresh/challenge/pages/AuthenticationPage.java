package com.hellofresh.challenge.pages;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {
	
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	
	private static final String ACCOUNT_TITLE = "My account - My Store";
	
    @FindBy(id = "email_create")
    private WebElement emailCreateInput;
    
    @FindBy(id = "SubmitCreate")
    private WebElement createBtn;
    
    @FindBy(id = "email")
    private WebElement emailLoginInput;
    
    @FindBy(id = "passwd")
    private WebElement passwordLoginInput;
    
    @FindBy(id = "SubmitLogin")
    private WebElement submitLoginBtn;
    
	public AuthenticationPage(WebDriver driver) {
		super(driver);
	}
    
    public SignInPage createNewAccount(String email) {
    	inputEmail(email);
    	clickOn(createBtn);
    	return new SignInPage(driver);
    }
    
    private void inputEmail(String email) {
    	sendValue(emailCreateInput, email);
    }
    
    public AccountPage logInMyAccount(Map<String, String> credentials) {
    	inputLoginCredentials(credentials.get(EMAIL), credentials.get(PASSWORD));
    	clickOn(submitLoginBtn);
    	waitForTitle(ACCOUNT_TITLE);
    	return new AccountPage(driver);
    }
    
    private void inputLoginCredentials(String email, String password) {
    	sendValue(emailLoginInput, email);
    	sendValue(passwordLoginInput, password);
    }
}

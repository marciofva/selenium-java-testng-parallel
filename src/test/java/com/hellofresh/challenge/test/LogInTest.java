package com.hellofresh.challenge.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Map;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.hellofresh.challenge.dataprovider.DataProviderLogIn;
import io.qameta.allure.Epic;

@Epic("Regression Tests")
@Listeners({com.hellofresh.challenge.listener.Listener.class})
public class LogInTest extends BaseTest {
	
	private static final String FULLNAME = "fullname";
	
  @Test(description="Login with valid credentials", dataProviderClass=DataProviderLogIn.class, dataProvider="validCredentials")
  public void logInWithValidCredentials(Map<String, String> credentials) {	  
	  
	  account = home.goToAuthenticationPage()
					.logInMyAccount(credentials);
	  
	  assertEquals(account.getHeading().getText(), "MY ACCOUNT");
	  assertEquals(credentials.get(FULLNAME), account.getAccountMenu().getText());
	  assertTrue(account.getTextForInfoAccount().getText().contains("Welcome to your account."));
	  assertTrue(account.getLogoutMenu().isDisplayed());
	  assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
  }
}

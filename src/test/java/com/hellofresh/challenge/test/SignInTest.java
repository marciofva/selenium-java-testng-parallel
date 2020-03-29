package com.hellofresh.challenge.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Map;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.hellofresh.challenge.dataprovider.DataProviderSignIn;
import com.hellofresh.challenge.helper.Utils;
import io.qameta.allure.Epic;

@Epic("Regression Tests")
@Listeners({com.hellofresh.challenge.listener.Listener.class})
public class SignInTest extends BaseTest {
	
	private static final String FIRST_NAME = "firstname";
	private static final String LAST_NAME = "lastname";
	
  @Test(description="Signin with valid data", dataProviderClass=DataProviderSignIn.class, dataProvider="validData")
  public void signInWithValidData(Map<String, String> registrationData) {
	  
	  account = home.goToAuthenticationPage()
					.createNewAccount(Utils.generateEmail())
					.submitAccountForm(registrationData);
	  
	  assertEquals(account.getHeading().getText(), "MY ACCOUNT");
	  assertEquals(account.getAccountMenu().getText(), registrationData.get(FIRST_NAME) + " " + registrationData.get(LAST_NAME));
	  assertTrue(account.getTextForInfoAccount().getText().contains("Welcome to your account."));
	  assertTrue(account.getLogoutMenu().isDisplayed());
	  assertTrue(driver.getCurrentUrl().contains("controller=my-account"));
  }
}

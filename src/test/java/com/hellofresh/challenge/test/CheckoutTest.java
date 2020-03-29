package com.hellofresh.challenge.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.util.Map;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.hellofresh.challenge.dataprovider.DataProviderCheckout;
import com.hellofresh.challenge.dataprovider.DataProviderLogIn;
import io.qameta.allure.Epic;

@Epic("Regression Tests")
@Listeners({com.hellofresh.challenge.listener.Listener.class})
public class CheckoutTest extends BaseTest {
	
	private static final String CATEGORY = "category";
	
  @Test(description="Checkout single product for Women", dataProviderClass=DataProviderCheckout.class, dataProvider="purchaseForWomen")
  public void checkoutSingleProductForWomen(Map<String, String> purchaseRequirements) throws IllegalAccessException  {
	  
	  checkout = home.goToAuthenticationPage()
					 .logInMyAccount(DataProviderLogIn.existingCustomerCredentials())
					 .selectCategory(purchaseRequirements.get(CATEGORY))
					 .shoppingProducts(purchaseRequirements, DataProviderCheckout.singleProductForWomen());
	  
	  assertEquals(checkout.getHeading().getText(), "ORDER CONFIRMATION");
	  assertTrue(checkout.getOrderSteps().isDisplayed());
	  assertTrue(checkout.getOrderReceipt().getText().contains("Your order on My Store is complete."));
	  assertTrue(driver.getCurrentUrl().contains("controller=order-confirmation"));
  }
}

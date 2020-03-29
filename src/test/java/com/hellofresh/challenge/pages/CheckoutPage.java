package com.hellofresh.challenge.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.hellofresh.challenge.helper.PaymentType;

public class CheckoutPage extends BasePage {
	
	private static final String PAYMENT_TYPE = "paymentType";
	
    @FindBy(xpath = "//a[@title='Faded Short Sleeve T-shirts']/ancestor::li")
    private WebElement item;
    
    @FindBy(css = "ul[class='product_list grid row'] > li > div > div > h5 > a")
    private List<WebElement> itemNames;
    
    @FindBy(name = "Submit")
    private WebElement addCartBtn;
    
    @FindBy(xpath = "//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']")
    private WebElement ProceedCheckoutModal;
    
    @FindBy(xpath = "//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']")
    private WebElement proceedCheckoutSummary;
    
    @FindBy(name = "processAddress")
    private WebElement ProceedAddress;
    
    @FindBy(id = "uniform-cgv")
    private WebElement termsCheckbox;
    
    @FindBy(name = "processCarrier")
    private WebElement ProcessCarrier;
    
    @FindBy(className = "bankwire")
    private WebElement paymentByBankOption;
    
    @FindBy(className = "cheque")
    private WebElement paymentByChequeOption;
    
    @FindBy(xpath = "//*[@id='cart_navigation']/button")
    private WebElement finishOrder;
    
    @FindBy(css = "h1")
    private WebElement heading;
    
    @FindBy(xpath = "//li[@class='step_done step_done_last four']")
    private WebElement orderSteps;
    
    @FindBy(xpath = "//*[@class='cheque-indent']/strong")
    private WebElement receiptOrderTitle;

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	public CheckoutPage shoppingProducts(Map<String, String> purchaseRequirements, ArrayList<String> listOfProducts) throws IllegalAccessException {
		selectProductByName(listOfProducts);
		addToCart();
		proceedToCheckoutModal();
		shoppingCartProcess(purchaseRequirements.get(PAYMENT_TYPE));
		return this;
	}

	private void selectProductByName(ArrayList<String> listOfProducts) {
		for(String productName: listOfProducts) {
	    	for(WebElement element : itemNames) {
	    		if(element.getText().equalsIgnoreCase(productName)) {
	    			clickOn(element);
	    			break;
	    		}
			}
		}
	}
	
	private void addToCart() {
		clickOn(addCartBtn);
	}
	
	private void proceedToCheckoutModal() {
		clickOn(ProceedCheckoutModal);
	}
	
	private void summaryStep() {
		clickOn(proceedCheckoutSummary);
	}
	
	private void addressStep() {
		clickOn(ProceedAddress);
	}
	
	private void shippingStep() {
		clickOn(termsCheckbox);
		clickOn(ProcessCarrier);
	}
	
	private void paymentStep(String paymentType) throws IllegalAccessException {	
		
		switch (PaymentType.valueOf(paymentType.toUpperCase())) {
			case BANK:
				clickOn(paymentByBankOption);
				break;
			case CHEQUE:
				clickOn(paymentByChequeOption);
				break;
			default:
				throw new IllegalAccessException("Payment '" + paymentType + "' is not allowed");
		}
		clickOn(finishOrder);
	}
	
	private void shoppingCartProcess(String paymentType) throws IllegalAccessException {
		summaryStep();
		addressStep();
		shippingStep();
		paymentStep(paymentType);
	}
	
    public WebElement getHeading() {
    	return heading;
    }
    
    public WebElement getOrderSteps() {
    	return orderSteps;
    }
    
    public WebElement getOrderReceipt() {
    	return receiptOrderTitle;
    }
}

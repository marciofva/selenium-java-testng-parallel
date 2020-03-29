package com.hellofresh.challenge.pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.hellofresh.challenge.helper.Category;

public class AccountPage extends BasePage {
	
    @FindBy(css = "h1")
    private WebElement heading;
    
    @FindBy(className = "account")
    private WebElement accountMenu;
    
    @FindBy(className = "info-account")
    private WebElement infoAccountLabel;
    
    @FindBy(className = "logout")
    private WebElement logoutMenu;
    
    @FindBy(css = "#block_top_menu > ul > li")
    private List<WebElement> categoryTopMenu;

	public AccountPage(WebDriver driver) {
		super(driver);
	}
	
    public WebElement getHeading() {
    	return heading;
    }
    
    public WebElement getAccountMenu() {
    	return accountMenu;
    }

    public WebElement getTextForInfoAccount() {
    	return infoAccountLabel;
    }
    
    public WebElement getLogoutMenu() {
    	return logoutMenu;
    }
    
    public CheckoutPage selectCategory(String category) {
    	    	
    	switch (Category.valueOf(category.toUpperCase())) {
			case WOMEN:
				clickOn(categoryTopMenu.get(0));
				break;
			case DRESSES:
				clickOn(categoryTopMenu.get(1));
				break;
			case TSHIRTS:
				clickOn(categoryTopMenu.get(2));
				break;
		}
    	return new CheckoutPage(driver);
    }
}

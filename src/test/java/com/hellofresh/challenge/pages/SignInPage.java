package com.hellofresh.challenge.pages;

import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {
	
	private static final String FIRST_NAME = "firstname";
	private static final String LAST_NAME = "lastname";
	private static final String PASSWORD = "password";
	private static final String DAY_OF_BIRTH = "days";
	private static final String MONTH_OF_BIRTH = "months";
	private static final String YEAR_OF_BIRTH = "years";
	private static final String COMPANY = "company";
	private static final String ADDRESS1 = "address1";
	private static final String ADDRESS2 = "address2";
	private static final String CITY = "city";
	private static final String STATE = "state";
	private static final String POSTCODE = "postcode";
	private static final String ADDITIONAL_INFORMATION = "additionInformation";
	private static final String HOME_PHONE = "homePhone";
	private static final String MOBILE_PHONE = "mobilePhone";
	private static final String ALIAS = "alias";
	
	private static final String ACCOUNT_TITLE = "My account - My Store";
    
    @FindBy(id = "customer_firstname")
    private WebElement firstNameInput;
    
    @FindBy(id = "customer_lastname")
    private WebElement lastNameInput;
    
    @FindBy(id = "passwd")
    private WebElement passwordInput;
    
    @FindBy(id = "days")
    private WebElement daysComboBox;
    
    @FindBy(id = "months")
    private WebElement monthsComboBox;
    
    @FindBy(id = "years")
    private WebElement yearsComboBox;
    
    @FindBy(id = "company")
    private WebElement companyInput;
    
    @FindBy(id = "address1")
    private WebElement address1Input;
    
    @FindBy(id = "address2")
    private WebElement address2Input;
    
    @FindBy(id = "city")
    private WebElement cityInput;
    
    @FindBy(id = "id_state")
    private WebElement stateInput;
    
    @FindBy(id = "postcode")
    private WebElement postcodeInput;
    
    @FindBy(id = "other")
    private WebElement additionInformationInput;
    
    @FindBy(id = "phone")
    private WebElement homePhoneInput;
    
    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneInput;
    
    @FindBy(id = "alias")
    private WebElement aliasInput;
    
    @FindBy(id = "submitAccount")
    private WebElement submitAccountBtn;
    
	public SignInPage(WebDriver driver) {
		super(driver);
	}
    
    public AccountPage submitAccountForm(Map<String, String> registrationData) {
    	fillOutForm(registrationData);
    	clickOn(submitAccountBtn);
    	waitForTitle(ACCOUNT_TITLE);
    	return new AccountPage(driver);
    }
    
    private void fillOutForm(Map<String, String> registrationData) {
    	inputFirstName(registrationData.get(FIRST_NAME));
    	inputLastName(registrationData.get(LAST_NAME));
    	inputPassword(registrationData.get(PASSWORD));
    	selectDateOfBirth(registrationData.get(DAY_OF_BIRTH), registrationData.get(MONTH_OF_BIRTH), registrationData.get(YEAR_OF_BIRTH));
    	inputCompany(registrationData.get(COMPANY));
    	inputAddress1(registrationData.get(ADDRESS1));
    	inputAddress2(registrationData.get(ADDRESS2));
    	inputCity(registrationData.get(CITY));
    	selectState(registrationData.get(STATE));
    	inputPostcode(registrationData.get(POSTCODE));
    	inputAdditionInformation(registrationData.get(ADDITIONAL_INFORMATION));
    	inputHomePhone(registrationData.get(HOME_PHONE));
    	inputMobilePhone(registrationData.get(MOBILE_PHONE));
    	inputAlias(registrationData.get(ALIAS));
    }

    private void inputFirstName(String firstname) {
    	sendValue(firstNameInput, firstname);
    }
    
    private void inputLastName(String lastname) {
    	sendValue(lastNameInput, lastname);
    }
    
    private void inputPassword(String password) {
    	sendValue(passwordInput, password);
    }
   
    private void selectDateOfBirth(String day, String month, String year) {
    	selectOptionComboBoxByValue(daysComboBox, day);
    	selectOptionComboBoxByValue(monthsComboBox, month);
    	selectOptionComboBoxByValue(yearsComboBox, year);
    }
    
    private void inputCompany(String company) {
    	sendValue(companyInput, company);
    }
    
    private void inputAddress1(String address1) {
    	sendValue(address1Input, address1);
    }
    
    private void inputAddress2(String address2) {
    	sendValue(address2Input, address2);
    }
    
    private void inputCity(String city) {
    	sendValue(cityInput, city);
    }
    
    private void selectState(String stateValue) {
    	selectOptionComboBoxByText(stateInput, stateValue);
    }
    
    private void inputPostcode(String postcode) {
    	sendValue(postcodeInput, postcode);
    }
    
    private void inputAdditionInformation(String additionInformation) {
    	sendValue(additionInformationInput, additionInformation);
    }
    
    private void inputHomePhone(String homePhone) {
    	sendValue(homePhoneInput, homePhone);
    }
    
    private void inputMobilePhone(String mobilePhone) {
    	sendValue(mobilePhoneInput, mobilePhone);
    }
    
    private void inputAlias(String alias) {
    	sendValue(aliasInput, alias);
    }
}

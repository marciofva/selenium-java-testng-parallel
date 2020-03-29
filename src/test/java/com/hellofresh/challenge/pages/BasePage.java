package com.hellofresh.challenge.pages;

import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import com.hellofresh.challenge.factory.WebdriverFactory;

public abstract class BasePage {

	protected WebDriver driver;
	private static final int POLLING_TIMEOUT = 250;
	private static final int MAX_SECONDS_TIMEOUT = 50;
	private FluentWait<WebDriver> wait;

	public BasePage(WebDriver driver) {
		this.driver = WebdriverFactory.getDriver();
		PageFactory.initElements(driver, this);
		this.wait =  new FluentWait<WebDriver>(driver).
						withTimeout(Duration.ofSeconds(MAX_SECONDS_TIMEOUT)).
						pollingEvery(Duration.ofMillis(POLLING_TIMEOUT)).
						ignoring(NoSuchElementException.class).
						ignoring(StaleElementReferenceException.class).
						ignoring(IndexOutOfBoundsException.class);
	}
	
	protected void clickOn(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	protected void sendValue(WebElement element, String value) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.clear();
		element.sendKeys(value);
	}

	protected boolean waitForTitle(String title) {
		return wait.until(ExpectedConditions.titleIs(title));
	}

	protected void selectOptionComboBoxByValue(WebElement element, String valueSelect) {
		Select comboBox = new Select(element);
		comboBox.selectByValue(valueSelect);
	}

	protected void selectOptionComboBoxByText(WebElement element, String textSelect) {
		Select comboBox = new Select(element);
		comboBox.selectByVisibleText(textSelect);
	}
}

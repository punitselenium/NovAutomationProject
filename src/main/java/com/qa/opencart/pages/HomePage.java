package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.JavaScriptUtil;

public class HomePage {

	private WebDriver driver;
	private JavaScriptUtil jsutil;
	private ElementUtil eleutil;

	// 1. Rule of define the project define By locator in the class
	// locator should be in private in nature encapsulation

	private By searchBoxButton = By.xpath("//input[@id='restaurantSearch']");
	private By logo = By.xpath("//img[@title='Dineout']");
	private By restaurantSeeAll = By.linkText("See all");
	private By topNavigation = By.linkText("Book a Table");
	private By framePath = By.xpath("//*[@id=\"__next\"]/div[3]/div/ul/li[1]/a");
	private By clickRestaurant = By.xpath("//img[@title='Tamasha']");

	// 2. Page constructor - to perform action every time we need a driver
	// so we have to create one constructor for that create one Object
	// reference and make it private in nature

	// constructor - here by creating object and initialize through the same class
	// we are achieving single re
	// responsibility principle

	public HomePage(WebDriver driver) {
		this.driver = driver;
		jsutil = new JavaScriptUtil(driver);
		eleutil = new ElementUtil(driver);

	}

	// 3 . Page Actions method here we have to write
// Note - here locator is given private in nature and we are using the reference of locator here

	public String getLoginPageTitle() {

		return eleutil.waitForTitleToBe(Constants.DEFAULT_TIME_OUT, Constants.LOGIN_PAGE_TITLE);
		// return driver.getTitle();

	}

	public boolean getLoginPageUrl() {
		return eleutil.waitForUrlContains(Constants.LOGIN_PAGE_URL_VALUE, Constants.DEFAULT_TIME_OUT);

		// return driver.getCurrentUrl();
	}

	public boolean getlogoPresent() {

		return eleutil.doIsDiplayed(logo);
		// return driver.findElement(logo).isDisplayed();
	}

	public boolean isSearchBoxButtonPresent() throws InterruptedException {
		Thread.sleep(2000);

		return eleutil.doIsDiplayed(searchBoxButton);
		// return driver.findElement(searchBoxButton).isDisplayed();
	}

	public boolean isBookaTableLinkExits() throws InterruptedException {
		Thread.sleep(2000);
		return eleutil.doIsDiplayed(topNavigation);
//		return driver.findElement(topNavigation).isDisplayed();
	}

	public boolean isRestaurnatSeeAllLinkPresent() throws InterruptedException {
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int height = 400;
		js.executeScript("window.scrollTo(0, '" + height + "')");
		Thread.sleep(2000);

		return eleutil.checkElementDisplayed(restaurantSeeAll);

		// return driver.findElement(restaurantSeeAll).isDisplayed();
	}

	public RestaurantDetailPage handleFrame() {
		eleutil.doClick(framePath);
		return new RestaurantDetailPage(driver);

	}

	public RestaurantDetailPage clickRestaurant() throws InterruptedException {
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		int height = 400;
		js.executeScript("window.scrollTo(0, '" + height + "')");
		Thread.sleep(2000);

		eleutil.doClick(clickRestaurant);
		return new RestaurantDetailPage(driver);
	}
}

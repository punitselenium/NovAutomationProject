package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.Constants;
import com.qa.opencart.utils.ElementUtil;

public class RestaurantDetailPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By search = By.name("header_search");
	private By loginLink = By.linkText("Log in");
	private By restaurantName = By.xpath("//h1[normalize-space()='Tamasha']");
//	private By totalRestaurantImage = By.xpath("//img[@class='rdp-banner_img']");
	private By totalRestaurantImage = By.tagName("a");

	public RestaurantDetailPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

//	Below statement - return driver.getTitle();  we should write wait concept here 

	public String getRestaurantDetailTitle() {
		return elementUtil.waitForTitleToBe(Constants.DEFAULT_TIME_OUT, Constants.RESTAURANT_DETAIL_PAGE_TITLE);
	}

	public boolean isLoginLinkExist() {
		return elementUtil.doIsDiplayed(loginLink);

	}

	public boolean isSearchFieldExist() {
		return elementUtil.doIsDiplayed(search);
	}

	public String nameOfRestaurantPresent() {
		return elementUtil.doGetText(restaurantName);
	}

	public void getrestaurantImage() {
		
		List<WebElement> linklist =elementUtil.getElements(totalRestaurantImage);

		System.out.println("Total link: " + linklist.size());

		for (WebElement e : linklist) {
			String hrefVal = e.getAttribute(Constants.RDP_LINK_VALUE);
			
			String srcVal = e.getAttribute(Constants.RDP_SRC_VALUE);
			
			
			String text = e.getText();
			
			System.out.println(text+ " : "+hrefVal + " : " +srcVal );
			
//			System.out.println(hrefVal + ":" + text);
		}

	}

}

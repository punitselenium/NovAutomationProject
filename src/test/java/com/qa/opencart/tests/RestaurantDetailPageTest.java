package com.qa.opencart.tests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class RestaurantDetailPageTest extends BaseTest {

	// this concept is page chaining model
	//
	@BeforeClass
	public void restaurantDetailpageSetUp() throws InterruptedException {
		rdp = homepage.handleFrame();

		rdp = homepage.clickRestaurant();
	}

	@Test
	public void restaurantDetailTitleTest() {
		String title = rdp.getRestaurantDetailTitle();
		System.out.println("Your account page title is :=" + title);
		Assert.assertEquals(title, Constants.RESTAURANT_DETAIL_PAGE_TITLE);
	}

	@Test
	public void isLoginLinkExistTest() {
		Assert.assertTrue(rdp.isLoginLinkExist());
	}

	@Test
	public void isSearchFieldExistTest() {
		Assert.assertTrue(rdp.isSearchFieldExist());
	}

	@Test
	public void nameOfRestaurantPresentTest() {
		String restName = rdp.nameOfRestaurantPresent();
		System.out.println("Restaurant Name is - " + restName);
		Assert.assertEquals(restName, Constants.RESTAURANT_NAME_IS);
	}

	@Test(enabled = false)
	public void isRestaurantImageExitsTest() {

		rdp.getrestaurantImage();

	}

}

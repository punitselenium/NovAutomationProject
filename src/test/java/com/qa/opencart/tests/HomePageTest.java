package com.qa.opencart.tests;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utils.Constants;

public class HomePageTest extends BaseTest {

	@BeforeClass
	public void handleFrame() {
		homepage.handleFrame();

	}

	@Test(priority = 0)
	public void getLoginPageTitleTest() {
		String title = homepage.getLoginPageTitle();
		System.out.println("Actual Page title is = " + title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);

	}

	@Test(priority = 1)
	public void getLoginPageUrlTest() {
		boolean url = homepage.getLoginPageUrl();
		System.out.println("Actual Page title is = " + url);
//		Assert.assertTrue(url.contains(Constants.LOGIN_PAGE_URL_VALUE));
	}

	@Test(priority = 2)
	public void logoPresentTest() {
		boolean logo = homepage.getlogoPresent();
		Assert.assertTrue(logo);
	}

	@Test(priority = 3)
	public void isSearchBoxPresentTest() throws InterruptedException {

		Assert.assertTrue(homepage.isSearchBoxButtonPresent());

	}

	@Test(priority = 5)
	public void isRestaurnatSeeAllLinkPresentTest() throws InterruptedException {
		Assert.assertFalse(homepage.isRestaurnatSeeAllLinkPresent());
	}

	@Test(priority = 4)
	public void isBookaTableLinkExitsTest() throws InterruptedException {
		Assert.assertTrue(homepage.isBookaTableLinkExits());
	}

	@Test(priority = 6)
	public void clickRestaurantTest() throws InterruptedException {
		homepage.clickRestaurant();
//		System.out.println();

	}
}

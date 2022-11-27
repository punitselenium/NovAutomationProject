package com.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.HomePage;
import com.qa.opencart.pages.RestaurantDetailPage;

public class BaseTest {

	public WebDriver driver;
	public DriverFactory df;
	public HomePage homepage;
	public Properties prop;
	public RestaurantDetailPage rdp;

	@BeforeTest
	public void setUp() {
		DriverFactory df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		homepage = new HomePage(driver);

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}

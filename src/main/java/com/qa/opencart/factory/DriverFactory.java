package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	/**
	 * This method will used to initialize the webdriver on the basis of given
	 * browser name
	 * 
	 * @author PUNIT
	 * @param browser
	 * @return this method will return the driver
	 */
	public WebDriver driver;
	public Properties prop;
	public static String highlight;

	public WebDriver initDriver(Properties prop) {

		highlight = prop.getProperty("highlight");

		String browser = prop.getProperty("browser").trim();
		System.out.println("browser name is :" + browser);

		// launch chrome browser
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		driver.get(prop.getProperty("url").trim());
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		return driver;

	}

	/**
	 * @author PUNIT This method will take ip from the config.poperties file.
	 * @return this method returns properties reference variable is prop;
	 */
	public Properties initProp() {
		prop = new Properties();

		String env = System.getProperty("env");
		FileInputStream ip = null;

		if (env == null) {

			try {
				ip = new FileInputStream("./src/test/resources/config/config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("Running on 	Environment =" + env);

			try {
				switch (env.toLowerCase()) {
				case "qa":
					ip = new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;

				case "stage":
					ip = new FileInputStream("./src/test/resources/config/stage.config.properties");
					break;

				default:
					System.out.println(".....Please Pass the Right Browser Name...  "+env);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;

	}
}
package com.qa.opencart.base;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegistrationPage;

public class BaseTest {
	private static final Logger LOGGER = Logger.getLogger(String.valueOf(DriverFactory.class));
	DriverFactory df;
	public Properties prop;
	WebDriver driver;
	public LoginPage loginPage;
	public AccountsPage accountPage;
	public RegistrationPage registrationPage;

	@BeforeTest
	public void setup() {
		df = new DriverFactory();
		prop = df.init_prop();
		//String browserName = prop.getProperty("browser");
		LOGGER.info("Properties initiliased");
		driver = df.init_driver(prop);
		driver.get(prop.getProperty("url"));
		loginPage = new LoginPage(driver);
		
	}// END of setup

	@AfterTest
	public void TearDown() {

		driver.quit();
	}// END of TearDown

}// End of BaseTest

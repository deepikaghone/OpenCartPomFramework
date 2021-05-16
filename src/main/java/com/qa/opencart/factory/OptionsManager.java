package com.qa.opencart.factory;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	private static final Logger LOGGER = Logger.getLogger(String.valueOf(DriverFactory.class));
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	public OptionsManager(Properties prop) {
		this.prop = prop;
	}
	
	
	
	public ChromeOptions getChromeOptions() {
		co = new ChromeOptions();
		
		co.addArguments("--ignore-certifcate-errors");
		LOGGER.info("getChromeOptions");
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) co.addArguments("--headless");
		
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) co.addArguments("--incognito");
		
		return co;
	}
	
	public FirefoxOptions getFirefoxOptions() {
		LOGGER.info("getFirefoxOptions");
		fo = new FirefoxOptions();
		fo.addArguments("--ignore-certifcate-errors");
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) fo.addArguments("--headless");
		
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) fo.addArguments("--incognito");
		
		return fo;
	}
	
	
	
	
	
	
	
	
	
}//END OF OptionsManager

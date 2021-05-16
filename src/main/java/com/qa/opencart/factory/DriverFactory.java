package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	private static final Logger LOGGER = Logger.getLogger(String.valueOf(DriverFactory.class));
	private WebDriver driver;
	private Properties prop;
	private OptionsManager optionsManager;
	public static String highlight;
	/**
	 * This Method is used to initialize the browser as per the user selection
	 * @param browerName
	 * @return Webdriver object
	 */
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	
	public WebDriver init_driver(Properties prop) {
		String browserName =prop.getProperty("browser");
		
		System.out.println("The selected browser is : "+browserName);
		highlight = prop.getProperty("highlight");
		optionsManager = new OptionsManager(prop);
		
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			LOGGER.info("setup chrome browser");
			//driver = new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			LOGGER.info("setup firefox browser");
			//driver = new FirefoxDriver(optionsManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
		}
		else
		{
			System.out.println("The selected browser does not exist, kindly select a valid browser: "+browserName);
			LOGGER.info("The selected browser does not exist, kindly select a valid browser");
		}
		/*driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;*/
		
		getDriver().manage().window().fullscreen();
		getDriver().manage().deleteAllCookies();
		
		return getDriver();
		
	}//END of init_driver

	
	public Properties init_prop() {
		/**
		 * This method is use to initialize the config properties
		 * return prop object
		 */
				
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}//End of init_prop
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
		
	}
	
	public String getScreenshot() throws IOException {
	/*	String src = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);
		File srcFile = new File(src);
		String path = System.getProperty("user.dir") + "//screenshots//" + System.currentTimeMillis() + ".png";
		//String path = new File("c:/screenshot/screenshot.png"); 
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);//
		} catch (IOException e) {
			//LOGGER.error("some exception is coming while creating the screenshot");
			e.printStackTrace();
		}
		return path;*/
		
		 TakesScreenshot scrShot =((TakesScreenshot)getDriver());
		 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		 File DestFile=new File(System.getProperty("user.dir") + "//screenshots//" + System.currentTimeMillis() + ".png");
		 FileUtils.copyFile(SrcFile, DestFile);
		 String path = DestFile.getAbsolutePath();
		 
		 return path;

	}
}//End of Class

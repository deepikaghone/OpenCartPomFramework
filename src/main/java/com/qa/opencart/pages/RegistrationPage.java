package com.qa.opencart.pages;

import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilities.ConstantUtil;
import com.qa.opencart.utilities.ElementUtilities;

public class RegistrationPage {

	
	
	private WebDriver driver;
	private ElementUtilities elementUtil;

	private By firstname = By.id("input-firstname");
	private By lastname = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("//label[@class='radio-inline'][position()=1]/input");
	private By subscribeNo = By.xpath("//label[@class='radio-inline'][position()=2]/input");

	private By agreeCheckbox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value = 'Continue']");
	
	private By accountSuccessMessg = By.cssSelector("#content h1");
	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtilities(this.driver);
	}
	
	public int getRandomNumber() {
		int rand_int1 = ThreadLocalRandom.current().nextInt(); 
		return rand_int1;
	}

	public boolean accountRegistration(String firstname, String lastname, 
			String email, String telephone, String password,
			String subscribe) {

	//	email = "dee" + getRandomNumber() + "@gmail.com";
		
		elementUtil.doSendKeys(this.firstname, firstname);
		elementUtil.doSendKeys(this.lastname, lastname);
		elementUtil.doSendKeys(this.email, email);//tom9898@gmail.com
		elementUtil.doSendKeys(this.telephone, telephone);
		elementUtil.doSendKeys(this.password, password);
		elementUtil.doSendKeys(this.confirmpassword, password);

		if (subscribe.equals("yes")) {
			elementUtil.doClick(subscribeYes);
		} else {
			elementUtil.doClick(subscribeNo);
		}

		elementUtil.doClick(agreeCheckbox);
		elementUtil.doClick(continueButton);
		
		String text = elementUtil.doGetText(accountSuccessMessg);
		if(text.contains(ConstantUtil.ACCOUNT_SUCCESS_MESSG)) {
			elementUtil.doClick(logoutLink);
			elementUtil.doClick(registerLink);

			return true;
		}
		return false;
	}
}

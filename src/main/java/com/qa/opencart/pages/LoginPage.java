package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utilities.ConstantUtil;
import com.qa.opencart.utilities.ElementUtilities;

public class LoginPage {

	private WebDriver driver;
	private ElementUtilities elementUtil;
	// 1. By Locator or Object Repository

	private By userName = By.id("input-email");
	private By password = By.id("input-password");
	private By loginButton = By.cssSelector("input[type='submit']");
	private By forgtPwdLink = By.cssSelector("div.form-group a");
	private By registerLink = By.linkText("Register");

	// 2 Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtilities(this.driver);
	}

	// 3 Page Action or Page Methods

	public String getTitle() {
		return elementUtil.waitForPageTitlePresent(ConstantUtil.LOGIN_PAGE_TITLE, 5);
	}

	public boolean isForgotPasswordlinkPresent() {
		return elementUtil.doIsDisplayed(forgtPwdLink);
	}

	public AccountsPage doLogin(String username, String Password) {

		System.out.println("Login with username :" + username);
		elementUtil.doSendKeys(userName, username);
		elementUtil.doSendKeys(password, Password);
		elementUtil.doClick(loginButton);
		return new AccountsPage(driver);

	}
	
	public RegistrationPage navigateToRegistrationPage() {
		System.out.println("Navigate to Register Page");
		elementUtil.doClick(registerLink);
		return new RegistrationPage(driver);
	}

}// End of class LoginPage

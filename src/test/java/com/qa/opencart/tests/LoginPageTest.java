package com.qa.opencart.tests;

import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utilities.ConstantUtil;

import junit.framework.Assert;

public class LoginPageTest extends BaseTest {
	
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.getTitle();
		System.out.println("The Loginpage title is "+title);
		Assert.assertEquals(ConstantUtil.LOGIN_PAGE_TITLE, title);
	}
	
	@Test(priority=2)
	public void forgotPasswordLink() {
		Assert.assertTrue(loginPage.isForgotPasswordlinkPresent());
	}
	
	@Test(priority=3)
	public void doLogin() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	
	
}//END OF LoginPageTest

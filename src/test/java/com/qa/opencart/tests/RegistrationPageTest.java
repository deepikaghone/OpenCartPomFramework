package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utilities.ConstantUtil;
import com.qa.opencart.utilities.ExcelUtilities;

public class RegistrationPageTest extends BaseTest{

	
	
	@BeforeClass
	public void registerationPageSetup() {
		registrationPage = loginPage.navigateToRegistrationPage();
	}
	
	
	/*@DataProvider(parallel = true)
	public Object[][] getRegisterData() {
		Object data[][] = ExcelUtilities.getTestData(ConstantUtil.REGISTER_SHEET_NAME);
		return data; 	
		
		String firstName, String lastName, String emailID, String phone, 
			String password, String subscribe
	}
	@Test(dataProvider = "getRegisterData")*/
	@Test
	public void userRegsiterationTest() throws InterruptedException {
		
		Assert.assertTrue(registrationPage.accountRegistration("Deep", "Goons", "deep11peep@gmail.com", "12345", "Looks", "yes"));
		//Thread.sleep(5000);
		//Assert.assertTrue(registrationPage.accountRegistration(firstName, lastName, emailID, phone, 
		//						password, subscribe));
	}
}

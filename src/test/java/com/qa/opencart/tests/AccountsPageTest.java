package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.utilities.ConstantUtil;

public class AccountsPageTest extends BaseTest {

	@BeforeClass
	public void accountPageSetup() {
		accountPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}

	@Test(priority = 1)
	public void accountPageTitleTest() {
		String title = accountPage.getAccountPageTitle();
		Assert.assertEquals(title, ConstantUtil.ACCOUNTS_PAGE_TITLE);
	}

	@Test(priority = 2)
	public void verifyAccountHeaderSectionTest() {
		String headerText = accountPage.getHeaderText();
		Assert.assertEquals(headerText, ConstantUtil.ACCOUNTS_PAGE_HEADER);
	}

	@Test(priority = 3)
	public void verifyAccountHeaderCountTest() {
		int headerCount = accountPage.getAccountSection();
		Assert.assertTrue(headerCount == ConstantUtil.ACCOUNT_PAGE_SECTION_COUNT);
	}

	@Test(priority = 4)
	public void verifySectionCountList() {

		List<String> sectionList = accountPage.getAccountSectionList();
		System.out.println("sectionList :" + sectionList);
		Assert.assertEquals(sectionList, ConstantUtil.getAccSectionsList(), "Assert List");
		
	}
	@Test(priority = 5)
	public void verifyNavigationList() {
		List<String> NavigationList = accountPage.getNavigationList();
		System.out.println("Navigation list :" + NavigationList);
		Assert.assertEquals(NavigationList, NavigationList, "This works");
	}
	
	@DataProvider
	public Object[][] searchData() {
		return new Object[][] {{"iMac"}, 
							   {"iPhone"}, 
							   {"Macbook"}};
	}
	
	@Test(priority = 6,dataProvider ="searchData")
	public void serachTest1(String productName) {
		Assert.assertTrue(accountPage.doSearch(productName));
	}
	
}// END OF AccountsPageTest

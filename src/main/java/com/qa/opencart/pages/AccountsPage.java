package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utilities.ConstantUtil;
import com.qa.opencart.utilities.ElementUtilities;

public class AccountsPage {
	private WebDriver driver;
	private ElementUtilities elementUtil;

	// OR

	private By logo = By.cssSelector("div#logo");
	private By accountSectionHeaders = By.cssSelector("div#content h2");
	private By navigationGrid = By.cssSelector("div.navbar-collapse a");
	private By searchText = By.cssSelector("div#search input[name='search']");
	private By searchButton = By.cssSelector("div#search button[type='button']");
	private By searchItemResult = By.cssSelector("div.product-layout div.product-thumb");
	private By resultItems = By.cssSelector("div.product-thumb h4 a");
	

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtilities(this.driver);
	}

	// Page Methods or Actions

	public String getAccountPageTitle() {
		return elementUtil.waitForPageTitlePresent(ConstantUtil.ACCOUNTS_PAGE_TITLE, 5);
	}
	
	public String getHeaderText() {
	return elementUtil.doGetText(logo);
	}

	public int getAccountSection() {
		return elementUtil.getSize(accountSectionHeaders);
		
	}

	public List<String> getAccountSectionList() {
	//	List<WebElement> accountSectionList = driver.findElements(accountSectionHeaders);
		List<WebElement> accountSectionList = elementUtil.getElements(accountSectionHeaders);
		List<String> sectionList = new ArrayList();

		for (int i = 0; i < accountSectionList.size(); i++) {
			String text = accountSectionList.get(i).getText();
			//System.out.println("Account Section text : " + text);
			sectionList.add(text);
		}
		return sectionList;

	}
	
	public List<String> getNavigationList() {
		List<WebElement> accountSectionList = elementUtil.getElements(navigationGrid);
		List<String> navigationList = new ArrayList();
		for (int i = 0; i < accountSectionList.size(); i++) {
			String text = accountSectionList.get(i).getText();
			if(!text.isEmpty()) navigationList.add(text);
			//System.out.println("Account Section text : " + text);
			
		}
		return navigationList;
	}//END of getNavigationList
	
	public boolean  doSearch(String productName) {
		elementUtil.clearText(searchText);
		elementUtil.doSendKeys(searchText, productName);
		
		elementUtil.doClick(searchButton);
		
		if (elementUtil.getSize(searchItemResult)>0) {
			return true;
		}
		return false;
	}
	
	
	public void selectProductFromResults(String productName) {
		List<WebElement> resultItemList = elementUtil.getElements(resultItems);
		System.out.println("Result List text : " + resultItemList);
		 for (int i=0;i<resultItemList.size();i++) {
			 String text = resultItemList.get(i).getText();
			 
			 if (text.equals(productName)) {
				 resultItemList.get(i).click();
				 break;
			 }
		 }
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}// END of Accounts

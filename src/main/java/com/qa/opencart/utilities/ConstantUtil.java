package com.qa.opencart.utilities;

import java.util.ArrayList;
import java.util.List;

public class ConstantUtil {
	
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACCOUNTS_PAGE_TITLE = "My Account";
	public static final String ACCOUNTS_PAGE_HEADER = "Your Store";
	public static final int ACCOUNT_PAGE_SECTION_COUNT = 4;
	public static final String ACCOUNT_SUCCESS_MESSG= "Your Account Has Been Created!";
	public static final String REGISTER_SHEET_NAME = "registerData";
	
	public static List<String> getAccSectionsList() {
		List<String> accList = new ArrayList<>();
		accList.add("My Account");
		accList.add("My Orders");
		accList.add("My Affiliate Account");
		accList.add("Newsletter");
		return accList;
	}
	

}//END of ConstantUtil

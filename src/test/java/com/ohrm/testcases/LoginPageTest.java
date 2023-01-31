package com.ohrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.pages.DashboardPage;
import com.ohrm.pages.LoginPage;

public class LoginPageTest {

	/*
	 * Mistakes:
	 * 1. Mixing the code and tests together 
	 * 2. Hard Coded the data
	 * 3. Object Chaining
	 */

	LoginPage lp;
	DashboardPage dp;

	@BeforeMethod
	public void browserConfig() {
		lp = new LoginPage();
		lp.initialization();
	}

	@Test
	public void validateTitleTest() {
		String expTitle = "OrangeHRM";
		String actTitle = lp.getTitle();
		Assert.assertEquals(actTitle, expTitle);
	}

	@Test
	public void validateLogin() {
		dp = lp.login();
		Assert.assertTrue(dp.myActionPresent());
	}

	@Test
	public void forgotPasswordTest() {
		Assert.assertTrue(lp.forgotPasswordClick());
	}

	@Test
	public void companyLinkTest() {
		Assert.assertTrue(lp.getCompanyLink());
	}

	@AfterMethod
	public void closeBrowser() {
		lp.tearDown();
	}
}

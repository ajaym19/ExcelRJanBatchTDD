package com.ohrm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ohrm.base.OHRMBase;
import com.ohrm.pages.DashboardPage;
import com.ohrm.pages.LoginPage;

public class DashboardPageTest extends OHRMBase {

	LoginPage lp;
	DashboardPage dp;

	@BeforeMethod
	public void browserConfig() {
		initialization();
		lp = new LoginPage();
		dp = lp.login();
	}

	@Test
	public void myActionSection() {
		Assert.assertTrue(dp.myActionPresent());
	}

	@AfterMethod
	public void closeSetup() {
		tearDown();
	}
}

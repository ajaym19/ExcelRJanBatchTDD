package com.ohrm.pages;

import org.openqa.selenium.By;

import com.ohrm.base.OHRMBase;

public class DashboardPage extends OHRMBase{

	public boolean myActionPresent() {
		return driver.findElement(By.xpath("//p[text()='My Actions']")).isDisplayed();
	}
}

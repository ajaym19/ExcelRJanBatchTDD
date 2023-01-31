package com.ohrm.pages;

import org.openqa.selenium.By;

import com.ohrm.base.OHRMBase;

public class LoginPage extends OHRMBase{

	
	public DashboardPage login() {
		captureScreenshot("validateLogin");
		driver.findElement(By.name("username")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//button[@type = 'submit']")).click();
		return new DashboardPage();
	}

	public String getTitle() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		captureScreenshot("validateTitle");
		return driver.getTitle();
	}

	public boolean forgotPasswordClick() {
		driver.findElement(By.xpath("//p[text()='Forgot your password? ']")).click();
		return driver.findElement(By.xpath("//h6[text()='Reset Password']")).isDisplayed();
	}

	public boolean getCompanyLink() {
		return driver.findElement(By.linkText("OrangeHRM, Inc")).isDisplayed();
	}
	
	public void m1() {
		
	}

	
}

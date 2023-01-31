package com.ohrm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OHRMBase {

	public static WebDriver driver;
	public static Properties prop;

	public void initialization() {
		readPropertyFile();
		driver = new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void tearDown() {
		driver.quit();
	}
	
	public void readPropertyFile() {
		String propFilePath = "./src/main/java/com/ohrm/config/config.properties";
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(propFilePath);
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void captureScreenshot(String tcname) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		String scrPath = "./Screenshots/" + tcname + ".png";
		File file = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File(scrPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}

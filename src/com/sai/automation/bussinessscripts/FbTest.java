package com.sai.automation.bussinessscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sai.automation.basetest.BaseTest;

public class FbTest  extends BaseTest{
	
	public void FbDemo() {
		getDriver().get("https://www.facebook.com");
		WebElement un = getDriver().findElement(By.id("email"));
		un.clear();
		un.sendKeys("saipinjala");
		un.click();
		
	}

}

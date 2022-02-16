package com.sai.automation.bussinessscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.sai.automation.basetest.BaseTest;

@Test
public class GmailTest extends BaseTest {
	
public void GmailDemo() throws InterruptedException {
	getDriver().get("https://www.gmail.com");
	WebElement un = getDriver().findElement(By.id("identifierId"));
	un.clear();
	un.sendKeys("sai.pinjala4@gmail.com");
	
	WebElement next = getDriver().findElement(By.id("identifierNext5"));
	next.click();;
	
	
	}
	}
	



package com.sai.automation.basetest;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;
import com.sai.automation.utilitys.DriversPath;

public class BaseTest {
	private static 	WebDriver driver;
	
	@Parameters({"browser"})
	@BeforeSuite
	public void OpenBrowser(@Optional("chrome")String browser) {
		
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty(DriversPath.firefoxKey,DriversPath.firefoxValue);
			driver = new FirefoxDriver();
			init();
			
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(DriversPath.chromeKey,DriversPath.chromeValue);
			driver = new ChromeDriver();
			init();			
		}
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty(DriversPath.edgeKey,DriversPath.edgeValue);
			driver = new EdgeDriver();
			init();	
		}	
		else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty(DriversPath.ieKey,DriversPath.ieValue);
			driver = new EdgeDriver();
			init();
			}
		}
	    private void init() {
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	    @AfterSuite
	    public void closeBrowser() {
			if (driver!=null) {
				driver.close();
				
			}
			else {
				System.out.println("driver is pointing to null.......");
			}
		
		}
	    @org.testng.annotations.BeforeMethod
	    public void BeforeMethod(Method method) {
	    	String tcname = method.getName();
			System.out.println("current test execution is:"+tcname);

		}
	    @AfterMethod
	    public void AfterMethod(ITestResult result) throws IOException {
	    	if (result.getStatus()==ITestResult.SUCCESS) {
	    		System.out.println("test case is passed:"+result.getName());
			}
	    	else if (result.getStatus()==ITestResult.FAILURE) {
	    		System.out.println("test case is failed so takling screenshot:"+result.getName());
	    		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
	    		FileUtils.copyFile(file, new File("C:\\Users\\pinja\\eclipse-workspace\\framework\\ScreenShorts\\"+result.getName()+".jpeg"));
	    		
	    		
			}
	    	else if (result.getStatus()==ITestResult.SKIP) {
	    		System.out.println("test case is skiped so takling screenshot:"+result.getName());
	    		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	    		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
	    		FileUtils.copyFile(file, new File("C:\\Users\\pinja\\eclipse-workspace\\framework\\ScreenShorts\\"+result.getName()+".jpeg"));
	    		
	    		
			}
			

		}

		/*
		 * @BeforeTest public void BeforeTest() { System.out.println("BT");
		 * 
		 * }
		 * 
		 * @AfterTest public void AfterTest() { System.out.println("AT");
		 * 
		 * }
		 * 
		 * @BeforeClass public void BeforeClass() { System.out.println("BC"); }
		 * 
		 * @AfterClass public void AfterClass() { System.out.println("AC");
		 * 
		 * }
		 */
	    public static WebDriver getDriver() {
			return driver;
		}
	    
	

}

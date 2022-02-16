package com.sai.automation.utilitys;

public interface DriversPath {
	
	String chromeKey   ="webdriver.chrome.driver";
	String chromeValue  =System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe";
	
	String firefoxKey   ="webdriver.gecko.driver";
	String firefoxValue  ="";
	
	String edgeKey   ="webdriver.edge.driver";
	String edgeValue  ="";
	
	String ieKey   ="webdriver.ie.driver";
	String ieValue  ="";

}

package com.sai.automation.utilitys;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public interface ScreenShotUtilitys {
	public static String takesScrennShot() {
		return null;
	}
	TakesScreenshot ts = new TakesScreenshot() {
		
		@Override
		public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
			// TODO Auto-generated method stub
			return null;
		}
	};
 

}

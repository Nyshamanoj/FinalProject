package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import constants.Constants;

public class ElementUtility {
	WebDriver driver;
		public static String getPropertyValue(String key) {
		File src=new File(Constants.propertyConfig_File); 
		Properties pro=new Properties(); 
		try { 
			FileInputStream fis = new FileInputStream (src);
			pro.load(fis);
			} 
		catch (Exception e) {
			e.printStackTrace(); 
			} 
		String value=pro.get(key).toString();
		return value; 
		}

	public ElementUtility(WebDriver driver) {
		this.driver=driver;
	}
public void dosendKeys(WebElement element,String value) {
	element.sendKeys(value);

}
public void doClick(WebElement element) {
	element.click();
}

public String getText(WebElement element) {
	String value=element.getText();
	return value;
	
}
public void doclear(WebElement element) {
	element.clear();
}
public void scrollIntoView(WebElement element) {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();",element);
}

}
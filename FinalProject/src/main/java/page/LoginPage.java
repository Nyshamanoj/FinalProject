package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;
import utility.WaitUtility;

public class LoginPage {
	WebDriver driver;
	ElementUtility elementUtil;
	WaitUtility waitUtil;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailfield;
	//webelements are identified by using @FindBy annotation
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passwordfield;
	
	@FindBy(xpath="//button[text()='Sign in']")
	WebElement signinbutton;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtil =new ElementUtility(driver);
		waitUtil=new WaitUtility(driver);
		
		PageFactory.initElements(driver, this); //initialize WebElements declared usig @FindBy
		//PageFactory is a class
		//initElements method will create all webelements
		
	}
	public void doLogin(String emailId,String password) {
		
		waitUtil.waitForVisibility(emailfield);
		elementUtil.dosendKeys(emailfield,emailId);
		
		
		waitUtil.waitForVisibility(passwordfield);
		elementUtil.dosendKeys(passwordfield, password);
		
		
		waitUtil.waitForVisibility(signinbutton);
		elementUtil.doClick(signinbutton);

	}

}

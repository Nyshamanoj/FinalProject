package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;
import utility.WaitUtility;

public class ClientPage {
	WebDriver driver;
	ElementUtility elementUtil;
	WaitUtility waitUtil;
	
	@FindBy(xpath="//span[text()='Clients']")
	WebElement clientClick;
	
	@FindBy(xpath="//a[text()=' Add client']")
	WebElement addClientClick;
	
	@FindBy(xpath="//input[@id='company_name']")
	WebElement companyNameClick;
	
	@FindBy(xpath="//textarea[@id='address']")
	WebElement addressNameClick;

	@FindBy(xpath="//input[@id='city']")
	WebElement cityNameClick;

	@FindBy(xpath="//input[@id='state']")
	WebElement stateNameClick;
	
	@FindBy(xpath="//input[@id='zip']")
	WebElement zipCodeClick;
	
	@FindBy(xpath="//input[@id='country']")
	WebElement countryNameClick;
	
	@FindBy(xpath="//input[@id='phone']")
	WebElement phoneNumberClick;
	
	@FindBy(xpath="//input[@id='website']")
	WebElement websiteNameClick;

	@FindBy(xpath="//input[@id='vat_number']")
	WebElement VATNumberClick;

	@FindBy(xpath="//div[@id='s2id_currency']")
	WebElement currencyClick;
	
	@FindBy(xpath="//div[text()='INR']")
	WebElement currencyOptionClick;
	
	@FindBy(xpath="//input[@id='currency_symbol']")
	WebElement currencySymbolClick;
	
	@FindBy(xpath="//input[@id='disable_online_payment']")
	WebElement clickBox;

	@FindBy(xpath="//button[text()=' Save']")
	WebElement saveButton;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchfield;
    
	@FindBy(xpath="//table[@id='client-table']//tbody//tr[1]//td[2]//a")
	WebElement companyNameField;
	
	@FindBy(xpath="//table[@id='client-table']//tbody//tr[1]//td[9]//a[1]")
	WebElement editButton;
	
	@FindBy(xpath="//table[@id='client-table']//tbody//tr[1]//td[9]//a[2]")
	WebElement deleteButton;
	
	@FindBy(xpath="//button[@id='confirmDeleteButton']")
	WebElement confirmDeleteButton;


	
	public ClientPage(WebDriver driver) {
		this.driver=driver;
		elementUtil =new ElementUtility(driver);
		waitUtil=new WaitUtility(driver);
		PageFactory.initElements(driver, this);

}
	public void doClientClick() {
		waitUtil.waitForClick(clientClick);
		elementUtil.doClick(clientClick);
		
		
	}
	public void doAddClientClick(String cmpnyName,String AddressName,String CityName,String StateName,
			String ZipCode,String CountryName,String PhoneNumber,String WebsiteName,String VATNumber,String Currency) {
		waitUtil.waitForClick(addClientClick);
		elementUtil.doClick(addClientClick);
		
		waitUtil.waitForVisibility(companyNameClick);
		elementUtil.dosendKeys(companyNameClick, cmpnyName);
		
		elementUtil.doClick(addressNameClick);
		elementUtil.dosendKeys(addressNameClick, AddressName);
		
		elementUtil.doClick(cityNameClick);
		elementUtil.dosendKeys(cityNameClick, CityName);
		
		elementUtil.doClick(stateNameClick);
		elementUtil.dosendKeys(stateNameClick, StateName);
		
		elementUtil.doClick(zipCodeClick);
		elementUtil.dosendKeys(zipCodeClick, ZipCode);
		
		elementUtil.doClick(countryNameClick);
		elementUtil.dosendKeys(countryNameClick, CountryName);
		
		elementUtil.doClick(phoneNumberClick);
		elementUtil.dosendKeys(phoneNumberClick, PhoneNumber);
		
		elementUtil.doClick(websiteNameClick);
		elementUtil.dosendKeys(websiteNameClick, WebsiteName);
		
		elementUtil.scrollIntoView(VATNumberClick);
		elementUtil.doClick(VATNumberClick);
		elementUtil.dosendKeys(VATNumberClick, VATNumber);
		
		waitUtil.waitForClick(currencyClick);
		elementUtil.doClick(currencyClick);
		elementUtil.doClick(currencyOptionClick);
		elementUtil.doClick(currencySymbolClick);
		elementUtil.dosendKeys(currencySymbolClick, Currency);
				
		waitUtil.waitForClick(clickBox);
		elementUtil.doClick(clickBox);
		
		waitUtil.waitForClick(saveButton);
		elementUtil.doClick(saveButton);
		
		
		
	}
	public String dosearchTitle(String titleName) {
		waitUtil.waitForVisibility(searchfield);
		waitUtil.waitForClick(searchfield);
		elementUtil.doClick(searchfield);
		elementUtil.dosendKeys(searchfield, titleName);
		String value=elementUtil.getText(companyNameField);
		return value;
				
		
	}
	public void doEditTitle(String titleName) {
		waitUtil.waitForClick(editButton);
		elementUtil.doClick(editButton);
		elementUtil.doclear(companyNameClick);
		elementUtil.dosendKeys(companyNameClick, titleName );
		waitUtil.waitForClick(saveButton);
		elementUtil.doClick(saveButton);
		
		
		}
	public void doDeleteFeld(String titleName) {
		waitUtil.waitForClick(searchfield);
		elementUtil.doClick(searchfield);
		elementUtil.dosendKeys(searchfield, titleName);
		waitUtil.waitForClick(deleteButton);
		elementUtil.doClick(deleteButton);
		waitUtil.waitForClick(confirmDeleteButton);
		elementUtil.doClick(confirmDeleteButton);
		
		
		}
}

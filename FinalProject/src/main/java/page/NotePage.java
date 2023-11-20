package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.ElementUtility;
import utility.WaitUtility;

public class NotePage {
	WebDriver driver;
	ElementUtility elementUtil;
	WaitUtility waitUtil;
	
	@FindBy(xpath="//span[text()='Notes']")	
	WebElement noteClick;
	
	@FindBy(xpath="//a[text()=' Add note']")	
	WebElement addNote;
	
	@FindBy(xpath="//input[@name='title']")	
	WebElement titlefield ;
	
	@FindBy(xpath="//textarea[@id='description']")	
	WebElement descriptionfield ;
	
	@FindBy(xpath="//button[text()=' Save']")	
	WebElement savefield ;
	
	@FindBy(xpath="//input[@type='search']")	
	WebElement searchfield;
	
	@FindBy(xpath="//a[text()='New Note']")	
	WebElement firstNewNoteText;
	
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td[4]//a[1]")	
	WebElement editfield;
	
	@FindBy(xpath="//table[@id='note-table']//tbody//tr[1]//td[4]//a[2]")	
	WebElement deletefield  ;
	
	@FindBy(xpath="//button[@id='confirmDeleteButton']")	
	WebElement confirmDeletefield  ;

	public NotePage(WebDriver driver) {
		this.driver=driver;
		elementUtil =new ElementUtility(driver);
		waitUtil=new WaitUtility(driver);
		PageFactory.initElements(driver, this);//initialize webelements declared using @FindBy
		//PageFactory is a class

	}	
	public void doNoteClick() {
	waitUtil.waitForClick(noteClick);
	elementUtil.doClick(noteClick);
	
		}
	public void doAddNoteField(String titleName,String descriptionName) {
		waitUtil.waitForClick(addNote);
		elementUtil.doClick(addNote);
		
		waitUtil.waitForVisibility(titlefield);
		elementUtil.dosendKeys(titlefield, titleName);
		
		waitUtil.waitForVisibility(descriptionfield);
		elementUtil.dosendKeys(descriptionfield, descriptionName);
		
		waitUtil.waitForVisibility(savefield);
		elementUtil.doClick(savefield);
		
	}
	public String doSearchField(String textName) {
		waitUtil.waitForVisibility(searchfield);
		waitUtil.waitForClick(searchfield);	
		//elementUtil.doClick(searchfield);
		elementUtil.dosendKeys(searchfield, textName);
		
		String value=elementUtil.getText(firstNewNoteText);
		return value;
		
		}
	public void doEditTitle(String value) {
		waitUtil.waitForClick(editfield);
		elementUtil.doClick(editfield);
		
		elementUtil.doclear(titlefield);
		elementUtil.dosendKeys(titlefield, "titleNew");
		
		waitUtil.waitForVisibility(savefield);
		elementUtil.doClick(savefield);
		
		}
	public void doDeleteField() {
		waitUtil.waitForClick(deletefield);
		elementUtil.doClick(deletefield);
		waitUtil.waitForClick(confirmDeletefield);
		elementUtil.doClick(confirmDeletefield);
		
		}

}

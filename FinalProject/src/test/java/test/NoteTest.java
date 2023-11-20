package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.LoginPage;
import page.NotePage;

public class NoteTest extends BaseTest{
  @Test(priority=1,groups= {"smoke","regression"},retryAnalyzer=generaltest.Retry.class)
  public void verifyAddNote() {
	  LoginPage lp=new LoginPage(driver);//creating LoginPage object(lp) to invoke the method such as doLogin 
	  lp.doLogin("admin@admin.com", "12345678");
	  
	  //creating NotePage object
	  //by using NotePage object call the note page and then pass the values
	  
	  NotePage npPage=new NotePage(driver);//creating NotePage object to invoke the methods such as doNoteClick,doAddNoteField
	  npPage.doNoteClick();//calling first method 
	  npPage.doAddNoteField("New Note", "First New Note");//calling second method
	 
	  	 
	  }
  @Test(priority=2,groups= {"regression"})
  public void verifySearchNote() {
	  LoginPage lp=new LoginPage(driver); 
	  lp.doLogin("admin@admin.com", "12345678");
	  
	  NotePage npPage=new NotePage(driver);
	  npPage.doNoteClick();
	 
	  String actualvalue=npPage.doSearchField("New Note");
	  Assert.assertEquals(actualvalue, "New Note");
	  System.out.println("The actual value is:"+actualvalue);
	  	 
	  }
  @Test(priority=3)
  public void verifyEditNote() {
	  LoginPage lp=new LoginPage(driver); 
	  lp.doLogin("admin@admin.com", "12345678");
	  
	  NotePage npPage=new NotePage(driver);
	  npPage.doNoteClick();
	  
	  npPage.doSearchField("New Note");
	  
	  npPage.doEditTitle("New Title Edit");

	 
	 	  	 
	  }
  @Test(priority=4)
  public void verifyDeleteNote() {
	  LoginPage lp=new LoginPage(driver); 
	  lp.doLogin("admin@admin.com", "12345678");
	  
	  NotePage npPage=new NotePage(driver);
	  npPage.doNoteClick();
	  
	  npPage.doDeleteField();
	 
	   }


 }

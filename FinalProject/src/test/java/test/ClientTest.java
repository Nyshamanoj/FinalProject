package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import page.ClientPage;
import page.LoginPage;

public class ClientTest extends BaseTest{
  @Test(priority=1)
  public void verifyAddClient() {
	  LoginPage lp=new LoginPage(driver); 
	  lp.doLogin("admin@admin.com", "12345678");
	  
	  ClientPage cpPage=new ClientPage(driver);
	  cpPage.doClientClick();
	  cpPage.doAddClientClick("KLM Company", "Madurai", "North Gate", "TamilNadu", "673577", "India", "9947450582", "www.klm.com", "KLM0987654322", "₹");
	  


  }
  @Test(priority=2)
  public void verifySearchClient() {
	  LoginPage lp=new LoginPage(driver); 
	  lp.doLogin("admin@admin.com", "12345678");
	  
	  ClientPage cpPage=new ClientPage(driver);
	  cpPage.doClientClick();
	  String actualvalue=cpPage.dosearchTitle("KLM Company");
	  Assert.assertEquals(actualvalue, "KLM Company");
	  System.out.println("The actual value is:"+actualvalue);
	 
	 }
  @Test(priority=3)
  public void verifyEditClient() {
	  LoginPage lp=new LoginPage(driver); 
	  lp.doLogin("admin@admin.com", "12345678");
	  
	  ClientPage cpPage=new ClientPage(driver);
	  cpPage.doClientClick();
	  cpPage.dosearchTitle("KLM Company");
	  cpPage.doEditTitle("New MLK Company");

	  
	  }
  @Test(priority=4)
  public void verifyDeleteClient() {
	  LoginPage lp=new LoginPage(driver); 
	  lp.doLogin("admin@admin.com", "12345678");
	  
	  ClientPage cpPage=new ClientPage(driver);
	  cpPage.doClientClick();
	  cpPage.doDeleteFeld("New MLK Company");
	  }
}

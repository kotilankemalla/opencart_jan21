package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email,String password,String exp)
	{
		logger.info("****Sarting********");
		
		
		 HomePage  hp=new  HomePage (driver);
		 hp.clickMyAccount();
		 logger.info("click my account");
		 hp.Clicklogin();
		 logger.info("click my login");
		 
		 
		 
		 LoginPage lp=new LoginPage(driver);
		 
		 logger.info("***providing user deatials");
		 lp.setEmail(email);      //valid email, get it from config.propeties
		 lp.setPassword(password); //valid password ,get it from config.propeties
		 
		 logger.info("Click login");
		 lp.ClickLogin();
		 
		 MyAccountPage macc=new MyAccountPage(driver);
		 
		 boolean targetpage=macc.isMyAccountpageexists();
		 
		 if(exp.equals("valid"))
		 {
			 if(targetpage==true)
			 {
				 //macc.clicklogout();
				 Assert.assertTrue(true);
			 }
			 else
			 {
				 Assert.fail();
			 }
		 }
		 
		 if(exp.equals("invalid"))
		 {
			 if(targetpage==true)
			 {
				 //macc.clicklogout();
				 Assert.assertTrue(false);
			 }
			 else
			 {
				 Assert.fail();
			 }
		 }
	}
}

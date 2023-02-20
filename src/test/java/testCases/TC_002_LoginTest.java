package testCases;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_LoginTest  extends BaseClass{

	@Test(groups= {"master","sanity"})
	public void test_login()
	{
		try
		{
		logger.info("****Sarting********");
		
		
		 HomePage  hp=new  HomePage (driver);
		 hp.clickMyAccount();
		 logger.info("click my account");
		 hp.Clicklogin();
		 logger.info("click my login");
		 
		 
		 
		 LoginPage lp=new LoginPage(driver);
		 
		 logger.info("***providing user deatials");
		 lp.setEmail(rb.getString("email"));      //valid email, get it from config.propeties
		 lp.setPassword(rb.getString("password")); //valid password ,get it from config.propeties
		 
		 logger.info("Click login");
		 lp.ClickLogin();
		 
		 
		 MyAccountPage macc=new MyAccountPage(driver);
				 
		boolean targetpage=macc.isMyAccountpageexists();
		
		Assert.assertEquals(targetpage, true,"invalid login data");
		
		logger.info("*****finished*******");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
	
}

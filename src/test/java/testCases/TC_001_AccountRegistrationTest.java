package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC_001_AccountRegistrationTest extends BaseClass{

	@Test(groups= {"master","regression"})
	void  test_Account_Registration()
	{
		logger.debug("Appliation logs.........");
		logger.info("*** starting TC_TC_001_AccountRegistrationTest");
		try
		{
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on my Account link");
		
		hp.clickRegister();
		logger.info("Clicked on Registerpage");
		
		
		 AccountRegistrationPage  regpage=new  AccountRegistrationPage(driver);
		 
		 logger.info("Providing user details");
		 
		 regpage.setFirstName(randomString());
		 
		 regpage.setLastName(randomString());
		 
		 regpage.setEmail(randomString() +"@gmail.com");
		 
		 regpage.setPassword(randomAlphaNumaric());
		 
		 regpage.checkPolicy();
		 
		 logger.info("Click On ontinue button");
		  regpage.clickContinue();
		  
		  logger.info("ConfermationMeassage");
		  String confmmsg=regpage.getConfemationmsg();
		  Assert.assertEquals(confmmsg, "Your acount has been created","Test failed");
		}catch(Exception e)
		{
			logger.error("Test failed");
			Assert.fail();
		}
		logger.info("*** test is finished *****");
	}
	
	
	
	
	
	
	
	
}

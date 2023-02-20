package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}

	
	
	//Elements
	
	@FindBy(name="firstname")
	WebElement txtfname;
	
	@FindBy(name="lastname")
	WebElement txtlname;
	
	@FindBy(name="email")
	WebElement txtemail;
	
	@FindBy(name="password")
	WebElement txtpwd;
	
	/*@FindBy(xpath="//label[normalize-space()='Subscribe']")
	WebElement subscribe;
	
	@FindBy(xpath="//label[normalize-space()='Yes']")
	WebElement Yes;
	
	
	
	@FindBy(xpath="//label[normalize-space()='No']")
	WebElement no;*/
	
	@FindBy(name="agree")
	WebElement chkpolicy;
	
	
	@FindBy(xpath="//button[normalize-space()='Continue']")
	WebElement btncontinue;
	
	
	@FindBy(xpath="//h1[normalize-space='your account is registered']")
	WebElement confirmMesssage;
	
	
	
	//Action methods
	public void setFirstName(String fname)
	
	{
		 txtfname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtlname.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		 txtemail.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtpwd.sendKeys(pwd);
	}
	
	
	public void checkPolicy()
	{
		chkpolicy.click();
	}
	
	public void clickContinue()
	
	{
		btncontinue.click();
	}
	
	public String getConfemationmsg()
	{
		try {
			
		return(confirmMesssage.getText());
		}catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	
	
	
	
	
	
}

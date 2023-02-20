package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	public HomePage(WebDriver driver) {
	
		super(driver);
	}
	
	
	//Elements
	@FindBy(xpath="//span[normalize-space()='My Account']")
	 WebElement lnkMyAcount;
	
	@FindBy(linkText="Register")
	WebElement lnkText;
	
	@FindBy(linkText="Login")  //Login step 6
	WebElement lnkLogin;
	
	
	//Action methods
	public void clickMyAccount()
	{
		lnkMyAcount.click();
	}
	 public void clickRegister()
	 {
		 lnkText.click();
	 }
	
	public void Clicklogin() //step 6
	{
		lnkLogin.click();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

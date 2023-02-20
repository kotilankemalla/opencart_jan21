package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	

	@FindBy(xpath="//h2(text()=['My Account']") //My account page head
	WebElement msgHeading;
	
	//logout element
	
	public boolean isMyAccountpageexists()
	{
		try
		{
		return(msgHeading.isDisplayed()); //my account heading
		}
		catch(Exception e)
		{
			return (false);
		}
		
		//logout method
	}

	
	
}

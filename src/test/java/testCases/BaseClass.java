package testCases;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.math3.geometry.spherical.twod.Edge;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.reporters.Files;

public class BaseClass {

	

	public static WebDriver driver;
	
	public Logger logger; //for logging
	
	public ResourceBundle rb;
	
	
	//OPEN BROWSER AND APPLICATION
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters("browser")
	public void setup(String br)
	{
		
		logger=LogManager.getLogger(this.getClass());
		
		rb=ResourceBundle.getBundle("config"); //load config.propetis
		
		
		if(br.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(br.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			driver=new FirefoxDriver();
		}
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appUrl"));
		//driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
	}
	
	
	
	//CLOSE WINDOWS
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown()
	{
		
		driver.quit();
	}
	
	
	
	
	//PASSING DATA IN RANDOM ORDER ALPHABETIC
	public String randomString()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return(generatedString);
	}
	
	
	//PASSING DATA IN RANDOM ORDER IN NUMARIC
	public String randomNumber()
	{
		String generatedString2=RandomStringUtils.randomNumeric(5);
		return(generatedString2);
	}
	

	//PASSING DATA IN NUMARIC AND ALPHABETIC BOTH 
	public String randomAlphaNumaric()
	{
		String st=RandomStringUtils.randomAlphabetic(5);
		String str=RandomStringUtils.randomNumeric(5);
		return(st+"@"+str);
	}
	

	//CAPTURESCREENSHOTS
	public 	String captureScreenshots(String tname)
	{
		
		String timestamp=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot=(TakesScreenshot)driver;
		File source=takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir") +"//screenshots//"+tname+"_"+"timestamp"+"png";
		
		try {
		FileUtils.copyFile(source,new File(destination));
		}
		catch(Exception e) {
			e.getMessage();
		}
		return destination;
	}
	
	
	
}

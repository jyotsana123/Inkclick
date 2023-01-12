package Inkclick.TestComponent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

import Inkclick.PageObject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	
//	WebDriverManager.chromedriver().setup();
//	WebDriver driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//We write these lines of code in base test
	
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties(); //Java Properties class is used to read 'GlobalData.properties' file
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"src\\main\\java\\Inkclick\\resources\\GlobalData.properties");
		prop.load(fis); //with the help of load method 'GlobalData.properties' file will be load, after loading - method parse the file and extract all key value pair from 'GlobalData.properties' file
		                 // In load method we need to pass "FileInputStream" argument. with the help of this argument load method parse the 'GlobalData.properties' file.
		                 //Before load method we need to define the "FileInputStream" argument.
		String browserName = prop.getProperty("browser");  //With the help of this method we extract the property define in the 'GlobalData.properties' file
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@BeforeMethod
	public LandingPage openWebsite() throws IOException
	{
		driver = initializeDriver();
		LandingPage landingPage = new LandingPage(driver);
		landingPage.launchWebsite();
		return landingPage;
	}
	
	

}

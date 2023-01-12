package Inkclick.PageObject;

import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void launchWebsite()
	{
		driver.get("https://inkclick.com/");
	}

}

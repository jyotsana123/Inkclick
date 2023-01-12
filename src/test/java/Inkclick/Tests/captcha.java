package Inkclick.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class captcha {
	
	public static void main (String args[]) {

	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://app.workstatus.io/auth/login");
	driver.findElement(By.cssSelector("input[formcontrolname='email']")).sendKeys("jyotsana.pandey@mail.vinove.com");
	driver.findElement(By.cssSelector("input[formcontrolname='password']")).sendKeys("Vinove@321");
	
//	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//	wait.until(
//		ExpectedConditions.frameToBeAvailableAndSwitchToIt(
//			By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")
//		)
//	);
//	// wait a couple of seconds before clicking the Captcha
//
//	wait.until(
//		ExpectedConditions.elementToBeClickable(
//			By.cssSelector("div.recaptcha-checkbox-checkmark")
//		)
//	).click();
	
	//Captcha handling
	String framename=driver.findElement(By.tagName("iframe")).getAttribute("name");
    driver.switchTo().frame(framename);
driver.findElement(By.xpath("//span[@id='recaptcha-anchor']")).click();

driver.findElement(By.cssSelector(".submit-button"));
}
}
package qa.testCasesNinjaTutorials;



import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Tutorials.Utilities.Utilities;
import baseClass.TestBase;

public class Register extends TestBase {

	public Register() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}


	@BeforeMethod 
	public void before() {
		driver=initializeBrowser(prop.getProperty("BrowserName"));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
	}
	
	@Test
	public void verifyRegistrationWithMandatoryFields() { 
		driver.findElement(By.id("input-firstname")).sendKeys("Selenium1");	
		driver.findElement(By.id("input-lastname")).sendKeys("celia1");
		driver.findElement(By.id("input-email")).sendKeys(Utilities. generateDateTimeStamp() );
		driver.findElement(By.id("input-telephone")).sendKeys("6156789908");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Selenium@123");
		driver.findElement(By.name("agree")).click(); 
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualHeading =driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertTrue(actualHeading.contains("Your Account Has Been Created!"));
	}
	
	@Test
	public void verifyRegistrationWithAllFields() throws InterruptedException { 
		driver.findElement(By.id("input-firstname")).sendKeys("Selenium1");	
		driver.findElement(By.id("input-lastname")).sendKeys("celia1");
		driver.findElement(By.id("input-email")).sendKeys(Utilities. generateDateTimeStamp() );
		driver.findElement(By.id("input-telephone")).sendKeys("6156789908");
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.id("input-confirm")).sendKeys("Selenium@123");
		driver.findElement(By.xpath("(//input[@name='newsletter'])[1]")).click();
		driver.findElement(By.name("agree")).click(); 
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualHeading =driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertTrue(actualHeading.contains("Your Account Has Been Created!"));
		
	}
	@Test
	public void verifyRegistrationWthoutenteringAnything() { 
		
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String actualPrivacyWarning =driver.findElement(By.xpath("//div[contains(@class, 'alert alert-danger alert-dismissible')]")).getText();
		Assert.assertTrue(actualPrivacyWarning.contains("Warning: You must agree to the Privacy Policy"));
        String actualFirstWarning=driver.findElement(By.xpath("//div[contains(text(), 'First Name must be between 1 and 32 characters!')]")).getText();
        Assert.assertTrue(actualFirstWarning.contains("First Name must be between 1 and 32 characters!"));
	
	} 
	@AfterMethod
	
	public void after() {
		driver.quit();
	}
	
}

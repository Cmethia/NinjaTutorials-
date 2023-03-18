package qa.testCasesNinjaTutorials;



import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Tutorials.Utilities.Utilities;
import baseClass.TestBase;

public class LoginTest extends TestBase {
	public LoginTest() throws Exception {
		super();
		// I can directly call the Super Keyword
	}


	@BeforeMethod 
	public void before() {
		driver=initializeBrowser(prop.getProperty("BrowserName"));
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
	}
	
	@Test(priority=1)
	public void verifyLoginWithValidCredential() {
		
		//click first on my account	
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		//assert is very important to verify that the links exist
		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		driver.quit();
	}
	@Test(priority=2)
	public void verifyLoginWithInvalidCredential() {
		
		driver.findElement(By.id("input-email")).sendKeys(Utilities. generateDateTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123t");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		//actual warning messages
		String actualWarningMessage=driver.findElement(By.xpath("//div[contains(@class, 'alert alert-danger alert-dismissible')]")).getText();
		
		Assert.assertTrue(actualWarningMessage.equals("Warning: No match for E-Mail Address and/or Password."));
		
		driver.quit();

}
	@Test(priority =3)
	public void verifyLoginWithInvalidEmailValidPass() {
			driver.findElement(By.id("input-email")).sendKeys(Utilities. generateDateTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("Selenium@123");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
					
}
	@Test(priority =4)
	public void verifyLoginWithValidEmailInvalidPass() {				
		driver.findElement(By.id("input-email")).sendKeys(Utilities. generateDateTimeStamp());
		driver.findElement(By.id("input-password")).sendKeys("Selenium@1243");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();		
		
}
	@Test(priority =5)
	public void verifyLoginWithoutcredential(){
		
		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		
	}
	

@AfterMethod
public void After() {
	driver.quit();				
	
}
}
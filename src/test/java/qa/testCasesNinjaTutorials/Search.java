package qa.testCasesNinjaTutorials;





import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClass.TestBase;

public class Search extends TestBase {
public Search() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod 
	public void before() {
		driver=initializeBrowser(prop.getProperty("BrowserName"));
	
	}
	@Test(priority=1)
	public void VerifySearchWithValidProduct() {
		driver.findElement(By.name("search")).sendKeys("Samsung");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		//Assertion:just to make sure the link is displayed 
		Assert.assertTrue(driver.findElement(By.linkText("Samsung SyncMaster 941BW")).isDisplayed());
		
		
		}
	
	@Test(priority=2)
	public void VerifySearchWithInvalidProduct() {
		driver.findElement(By.name("search")).sendKeys("Dell");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		String actualSearchProMessage=driver.findElement(By.xpath("//p[contains(text(), 'There is no product that matches the search criteria.')]")).getText();
		Assert.assertTrue(actualSearchProMessage.contains("There is no product that matches the search criteria."));
		
	}
	@Test(priority=3)
	public void VerifySearchWithoutAnyProduct() {
		driver.findElement(By.name("search")).sendKeys("");
		driver.findElement(By.cssSelector("button.btn.btn-default.btn-lg")).click();
		String actualSearchNoProMessage=driver.findElement(By.xpath("//p[contains(text(), 'There is no product that matches the search criteria.')]")).getText();
		Assert.assertTrue(actualSearchNoProMessage.contains("There is no product that matches the search criteria."));
	}
	
	@AfterMethod
	
	public void after() {
		driver.quit();
		
	}
	
}


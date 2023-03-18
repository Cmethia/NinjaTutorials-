package baseClass;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Tutorials.Utilities.Utilities;

public class TestBase {

	
	public static WebDriver driver; 
	public static Properties prop;
	
public void LoadPropertiesFile() throws Exception { //this a method 
		
		
		prop = new Properties();
		
		FileInputStream ip =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties");
		prop.load(ip);
	}
	//I like to use the constructor betterbecause I want to use the super keyWord , 
//and you can keep them both it doesnt affect
	public TestBase() throws Exception {
		
		
	 prop = new Properties();
		
		FileInputStream ip =new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties");
		prop.load(ip);
	}
	
	public WebDriver initializeBrowser(String BrowserName) {
		if (BrowserName.equalsIgnoreCase("chrome")) {
			ChromeOptions co=new ChromeOptions();
			co.addArguments("--remote-allow-origins=*");
			driver=new ChromeDriver(co);
	
		}else if(BrowserName.equalsIgnoreCase("firefox")) {
			driver =new FirefoxDriver();
		}else if(BrowserName.equalsIgnoreCase("edge")) {
			driver =new EdgeDriver();
		}else {
			System.out.println("the url is not working");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGELOAD_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver; //you can return the driver //here we are returning the reference of an interface , 
		//my code will fall everthing under webdriver entity and the code will respond better 
		//And the chances of Null point exceptions will decreases 
	}
	
	
		
	
	
	
	
}

package InitialInformation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import drivers.ChromeDriverManager;
import drivers.DriverManager;
import drivers.DriverManagerFactory;
import drivers.DriverType;

//!!!---Thisclass is inhabilitated, i was not able to make it work properly, the main intention was
//that every class in the testcases inherite this class, but for some reason the driver instantiation did not
//work properly

//This class loads driver manager for chrome
public abstract class SetUp {
	
	//initialize Driver manager to call for the browser's driver
	DriverManager driverManager;
	//initialize the variable for the selenium webdriver
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		//we will use Chrome
		//driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
		
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\iamCa\\Desktop\\NotPorn\\cursos\\HXFramework\\BrowserDrivers\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
	    options.setHeadless(false);
	    //driver = driverManager.getWebDriver(options);
	    driver = new ChromeDriver(options);     
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    

		
		//driver.get("http://automationpractice.com/index.php");
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}	
	
	@AfterMethod
	public void close() {
		driver.close();
	}

}

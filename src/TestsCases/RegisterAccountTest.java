package TestsCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.ExtractData;
import pageObjects.RegisterUserPage;
	
	//SetUp is the class that loads driver managers !!---failed currently
public class RegisterAccountTest {
	
	//Uses pageObjects.RegisterUser --> which uses ExtractData --> which uses Read Data
	
	RegisterUserPage registerNewUser;
	WebDriver driver;	
	
	//----------------------------------------------------------------------------------------
	
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\iamCa\\Desktop\\NotPorn\\cursos\\Framework\\HXFramework3\\BrowserDrivers\\chromedriver.exe");
	
		ChromeOptions options = new ChromeOptions();
	    options.setHeadless(false); //makes that the web browser window does not open
	    driver = new ChromeDriver(options);     
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    //driver.get("http://automationpractice.com/index.php");
	}
	//------------------------
	@Test
	public void RegisterUserTest() {
		
		registerNewUser =  new RegisterUserPage(driver);
		
		registerNewUser.register2("fergseh");
		
		Assert.assertEquals(registerNewUser.logInMessage(), 
				"Welcome to your account. Here you can manage all of your personal information and orders.");
		
	}	


		

}

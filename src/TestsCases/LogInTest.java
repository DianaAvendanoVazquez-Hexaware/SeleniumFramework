package TestsCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import drivers.DriverManager;
import drivers.DriverManagerFactory;
import drivers.DriverType;
import pageObjects.LogIn;

public class LogInTest 
{
	WebDriver driver;
	LogIn logIn;

	//This will eventually be taken from an excel
	String username = "holi1@email.com";
	String password = "P@ssw0rd";
	
//-------------------	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\iamCa\\Desktop\\NotPorn\\cursos\\Framework\\HXFramework3\\BrowserDrivers\\chromedriver.exe");
	
		ChromeOptions options = new ChromeOptions();
	    options.setHeadless(false);//makes that the web browser window does not open
	    driver = new ChromeDriver(options);     
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	    //driver.get("http://automationpractice.com/index.php");
	}
//-------------------
	@Test
	public void logInTest() {
		
		logIn = new LogIn(driver);
		
		logIn.logIn(driver, username, password);
		
		System.out.println(driver.findElement(By.xpath("//*[@id=\"center_column\"]/p")).getText());
		//verifies this message appears
		Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"authentication\"]")).getText(), 
				"Welcome to your account. Here you can manage all of your personal information and orders.");
	}
	
	

}

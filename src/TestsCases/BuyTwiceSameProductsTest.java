package TestsCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BuySearchProducts;
import pageObjects.LogIn;

//SetUp class contains the web driver instances and methods
public class BuyTwiceSameProductsTest{
	//For this test we need to log in
	LogIn logIn;
	BuySearchProducts buy2elements;
	WebDriver driver;
	
	//please introduce an existing account 
	String username = "holi1@email.com";
	String password = "P@ssw0rd";
	
	//-------------------	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\iamCa\\Desktop\\NotPorn\\cursos\\HXFramework\\BrowserDrivers\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		   options.setHeadless(true);//makes that the web browser window does not open
		   driver = new ChromeDriver(options);     
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		   driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		    //driver.get("http://automationpractice.com/index.php");
		}
	//-------------------
	
	@Test
	public void buySameProductTwiceTest() {
		
		//for simplicity we log in first
		logIn = new LogIn(driver);
		logIn.logIn(driver, username, password);
		
		buy2elements = new BuySearchProducts(driver);
		buy2elements.buy2Elements();
		
		 Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p/strong")).getText(), 
					"Your order on My Store is complete.");
		
	}

}

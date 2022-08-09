package TestsCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.BuySearchProducts;


//Uses pageObjects.BuySearchProducts
public class SearchProductTest{
	
	//We will verifay the search box looks for an existing product on the catalogue
	BuySearchProducts verifyProducts;
	WebDriver driver;
	
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
	public void verifyProductIsSearchCorrectly() {
		verifyProducts = new BuySearchProducts(driver);
		verifyProducts.verifySearchProduct();
		
		Assert.assertEquals(verifyProducts.firstProduct(), 
				"Faded Short Sleeve T-shirts");
	}
	
}

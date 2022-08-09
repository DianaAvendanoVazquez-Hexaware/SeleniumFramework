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

//This usese pageObjects.BuySearchProducts
public class VerifyPriceChanges {

	
	//For this test we need to log in
	LogIn logIn;
	BuySearchProducts verification;
	WebDriver driver;
	
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
	
	//Este esta incompleto, el if en el metodo editedquiantitycheckout no funciona
	//tambien hay que hacer que el metodo regrese un string para hacer el assert
	
	@Test
	public void verifyPriceChanges() throws InterruptedException {

		logIn = new LogIn(driver);
		logIn.logIn(driver, username, password);
		
		verification = new BuySearchProducts(driver);
		verification.editCartAndBuy();
		
		Assert.assertEquals(driver.findElement(By.id("total_product_price_2_9_725962")).getText(), "$54.00");
		
	}
}

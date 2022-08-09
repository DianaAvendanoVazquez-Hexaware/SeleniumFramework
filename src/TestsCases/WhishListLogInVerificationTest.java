package TestsCases;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.BuySearchProducts;

public class WhishListLogInVerificationTest{
	//this test check that in order to add an iten to the wishlist you need to login
	BuySearchProducts action;
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
	public void wishListNeedsLogin() throws InterruptedException {
		action = new BuySearchProducts(driver);
		
		action.addToWishList();
		
		String errormessage = action.wishlistErrorMessage();
		
		Assert.assertEquals(errormessage, 
				"You must be logged in to manage your wishlist.");

	}
	

}

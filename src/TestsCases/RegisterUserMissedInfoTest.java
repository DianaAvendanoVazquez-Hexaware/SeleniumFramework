package TestsCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import drivers.DriverManager;
import drivers.DriverManagerFactory;
import drivers.DriverType;
import pageObjects.RegisterUserNoDropDown;

//Uses pageObjects.RegisterUserNoDropDown

public class RegisterUserMissedInfoTest {
	
	//initialize Driver manager to call for the browser's driver
		DriverManager driverManager;
		WebDriver driver;
		RegisterUserNoDropDown registerNewUser;
		
		//variables from the excel file
		String firstName = "";
		String lastName = "";
		String password = "";
		String nameAddress = "";
		String lastNameAddress = "";
		String company = "hexaware";
		String address1 = "";
		String address2 = "House 456";
		String city = "";
		String ZC = "";
		String comments = "The meaning of life is 42";
		String phone = "12345678";
		String mobilePhone = "";
		String alias = "";
		
		//----------------------------------------------------------------------------------------
		
	
		@BeforeTest
		public void setUp() {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\iamCa\\Desktop\\NotPorn\\cursos\\HXFramework\\BrowserDrivers\\chromedriver.exe");
		
			ChromeOptions options = new ChromeOptions();
		    options.setHeadless(false);//makes that the web browser window does not open
		    driver = new ChromeDriver(options);     
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		    //driver.get("http://automationpractice.com/index.php");
		}
	//-------------------
		@Test
		public void RegisterUserTest() {
			
			registerNewUser =  new RegisterUserNoDropDown(driver);
			
			registerNewUser.register(firstName, lastName, password, nameAddress, lastNameAddress, company,
					address1, address2, city, ZC, comments, phone, mobilePhone, alias);	
			
			//checks that creation account message appears
			System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText());
			String errmssg = "There are 7 errors";

			Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/p")).getText(), errmssg);
			
		}	//"//div[@class='alert alert-danger']"
		//----------------------------------------------------------------------------------------


}

package TestsCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import drivers.DriverManager;
import pageObjects.RegisterUserPage;

public class RegisterAccountWrongDataTest{
	
	//Uses pageObjects.RegisterUserPage
	
	//initialize Driver manager to call for the browser's driver
	DriverManager driverManager;
	//initialize the variable for the selenium webdriver
	WebDriver driver;
	RegisterUserPage registerNewUser;
	
	//variables from the excel file
	String firstName = "33333";
	String lastName = "3333333";
	String password = "P@ssw0rd";
	String nameAddress = "333333";
	String lastNameAddress = "33333";
	String company = "337746463";
	String address1 = "123";
	String address2 = "456";
	String city = "337746463";
	String ZC = "ABCDEF";
	String comments = "The meaning of life is 42";
	String phone = "fdhmmkhj";
	String mobilePhone = "zfdgndh";
	String alias = "34125";
	
	//----------------------------------------------------------------------------------------
		
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
	public void registerAccountWrongDataTest() {
		
		registerNewUser =  new RegisterUserPage(driver);
		
		registerNewUser.register(firstName, lastName, password, nameAddress, lastNameAddress,
				company, address1, address2, city, ZC, comments, phone, mobilePhone, alias);
		
		//System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText());
		
		String errmssage = "There are 5 errors\n"
				+ "lastname is invalid.\n"
				+ "firstname is invalid.\n"
				+ "phone is invalid.\n"
				+ "phone_mobile is invalid.\n"
				+ "The Zip/Postal code you've entered is invalid. It must follow this format: 00000";
		
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText(), errmssage);
	}
		

}

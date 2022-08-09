package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn {
	
	WebDriver driver;
	
	//constructor
	public LogIn(WebDriver driver) {
		this.driver = driver;
	}
	
	//private By welcomeMessage  = By.xpath("//div[@id=\'center_column\']/p");
	
	//----------------------------------------------------------------------------------------	
	//this method allows you to log in into your account providing that you have an unused username
	public static void logIn(WebDriver driver, String userName, String password) {
		
		driver.findElement(By.id("email")).sendKeys(userName);
		driver.findElement(By.id("passwd")).sendKeys(password);
		driver.findElement(By.xpath("//button[@id=\'SubmitLogin\']/span")).click();

	}
	//----------------------------------------------------------------------------------------
	//this method allows you to type a mail to create an account
	public static void newAccount(WebDriver driver, String email) {
		driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		driver.findElement(By.name("email_create")).sendKeys(email);
  		driver.findElement(By.id("SubmitCreate")).click();	
	}
	//-------------------------------------------------------------------------------------
	
	//public String welcomeMessage() {
		//String message = driver.findElement(welcomeMessage).getText();
		//return message;
	//}
	
}

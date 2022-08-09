package drivers;

import java.time.Duration;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager{
	
	@Override
	public void createWebDriver() {
		
		//instantiate ChromeOptions
		FirefoxOptions options = new FirefoxOptions();
		
		//look for the browser's webdriver
			//change this directory to your own
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\iamCa\\Desktop\\NotPorn\\cursos\\HXFramework\\BrowserDrivers\\geckodriver.exe");
		
		//set browser-specific options
		this.driver = new FirefoxDriver(options);
		
		//time to wait until pages loads correctly
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

}

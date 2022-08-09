package drivers;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager{
	
	@Override
	public void createWebDriver() {
		
		//look for the browser's webdriver
			//change this directory for your own
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\iamCa\\Desktop\\NotPorn\\cursos\\HXFramework\\BrowserDrivers\\chromedriver.exe");

		//instantiate ChromeOptions
		ChromeOptions options = new ChromeOptions();
		//options.setHeadless(true);
		
		//set browser-specific options
		this.driver = new ChromeDriver(options);
		
		//time to wait until pages loads correctly
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}

}

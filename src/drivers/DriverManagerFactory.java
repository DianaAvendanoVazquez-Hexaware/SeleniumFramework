package drivers;

/*DriverManagerFactory is a factory that “manufactures” DriverManager objects.
 *  You invoke the getDriverManager() method of this class with your DriverType to receive a DriverManager-type object.
 *  Since DriverManager is an abstract class, you won’t receive an actual DriverManager, just one of its implementations,
 *   such as ChromeDriverManager, FireFoxDriverManager, etc. */

public class DriverManagerFactory {
	
	public static DriverManager getDriverManager(DriverType type) {
		
		//initialize DriverManager
		DriverManager driverManager = null;
		
		//This will chose the correct driver for your browser
		switch (type) {
		case CHROME:
			driverManager = new ChromeDriverManager();
			break;
			
		case FIREFOX:
			driverManager = new FirefoxDriverManager();
			break;
				
		//default:
			//break;
		}
		return driverManager;
	}

}

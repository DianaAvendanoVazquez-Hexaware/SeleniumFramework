package pageObjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import InitialInformation.ReadData;


//From this class you will be able to obtain data from an excel file in order to fill texboxes for the test cases
public class ExtractData {

	
	//--------------------------------------------------------------------------------------------------------
	//This method is to create random usernames for the mail
	//random usernames generators (will only produce 200, if you wish more raise the upperbound)
	public String randomUsers() {
		Random rand = new Random();
	    int upperbound = 200;
	    int int_random = rand.nextInt(upperbound);
		String email = "user"+ int_random +"@email.com";
		//email = "holi1@email.com";
		return email;
	}
	
//=========================================================================================================
	private static void selectBirth(WebDriver driver) {
		//day
		driver.findElement(By.xpath("//div[@id='uniform-days']")).click();
		driver.findElement(By.xpath("//option[@value='13']")).click();
		//month
		driver.findElement(By.xpath("//div[@id='uniform-months']")).click();
		driver.findElement(By.xpath("//select[@id=\"months\"]/option[5]")).click();
		//year
		driver.findElement(By.xpath("//div[@id='uniform-years']")).click();
		driver.findElement(By.xpath("//option[@value='1997']")).click();
	}
//==========================================================================================================	
	private static void selectState(WebDriver driver) {
		driver.findElement(By.id("id_state"));
		driver.findElement(By.xpath("//select[@id=\'id_state\']/option[20]")).click();
	}
	
	
//===========================================================================================================	
	//This method extracts data from the excel file
	//testname is the name of the row we are gonna use labeled by "test" in the excel file
	
		//Uses ReadData
	public static String[] submitData(WebDriver driver, String fileName, String testName, String dpassword) {
		
		String[] array = ReadData.readData(fileName,testName);
		//d is for data
		for(int i=0; i<array.length; i++) {
			//System.out.println(array[i]);
			if (array[i].equals("x")) {
				array[i] = "";
				//System.out.println("1");
			}
		}
	return array;
	
	}
	
}

package pageObjects;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterUserNoDropDown {
	
	//initialize WebDriver as driver
		WebDriver driver;
		
		//constructor of the page
		public RegisterUserNoDropDown(WebDriver driver) {
			//Now this class owns driver >:D
			this.driver = driver;
			
		}
		
		//element locators of the web elements on this page
			//private is only accessed within the class
		private By userNameTextBox = By.xpath("//input[@id='email_create']");
		private By createAccountButton = By.xpath("//button[@id='SubmitCreate']");
		//----after the first page
		private By genderBullet = By.xpath("//input[@id='id_gender2']"); //this one if or female
		private By firstNameTextBox = By.xpath("//input[@id='customer_firstname']");
		private By lastNameTextBox = By.xpath("//input[@id='customer_lastname']");
		private By passwordTextBox  = By.xpath("//input[@id='passwd']");
		private By birthDayDropDownMenu = By.xpath("//div[@id='uniform-days']");
		private By birthDayChosen = By.xpath("//option[@value='28']"); //day 28th
		private By birthMonthDropDownMenu = By.xpath("//div[@id='uniform-months']");
		private By birthMonthChosen = By.xpath("//select[@id=\"months\"]/option[5]");// month 5
		private By birthYearDropDownMenu = By.xpath("//div[@id='uniform-years']");
		private By birthYearChosen = By.xpath("//option[@value='1993']"); //1993
		//--address
		private By nameAddressTextBox = By.id("firstname");
		private By lastNameAddressTextBox = By.id("lastname");
		private By companyAddressTextBox = By.id("company");
		private By address1TextBox = By.id("address1");
		private By address2TextBox = By.id("address2");
		private By cityTextBox = By.id("city");
		//private By stateDropDownMenu = By.id("id_state");
		//private By stateChosenOption = By.xpath("//select[@id=\'id_state\']/option[20]"); //state no.20 in the list
		private By zipcode = By.id("postcode"); 
		private By commentsTextBox = By.id("other"); 
		private By phoneTextBox = By.id("phone");
		private By mobilePhoneTextBox = By.id("phone_mobile");
		private By aliasTextBox = By.id("alias");
		private By submitButton = By.xpath("//button[@id=\'submitAccount\']/span");
		
		
		//---------------------------------------------------------------------------------------------------------
		//this method allows you to register an account providing that you have an unused username
		public void register(String firstName, String lastName, String password, 
				String nameAddress, String lastNameAddress, String company, String address1, String address2,
				String city, String ZC, String comments, String phone, String mobilePhone, String alias ) {
			this.setNewUserName();
			this.createAccountButton();
			this.fillForm(firstName, lastName, password, nameAddress, lastNameAddress, company, address1, 
					address2, city, ZC, comments, phone, mobilePhone, alias);
		}
		//------------
		public void setNewUserName() {
			driver.findElement(userNameTextBox).sendKeys( randomUsers() );
		}
		//------------
		public void createAccountButton() {
			driver.findElement(createAccountButton).click();
		}
		
		public void fillForm(String firstName, String lastName, String password, 
				String nameAddress, String lastNameAddress, String company, String address1, String address2,
				String city, String ZC, String comments, String phone, String mobilePhone, String alias ) {
			driver.findElement(genderBullet).click();
			driver.findElement(firstNameTextBox).sendKeys(firstName);
			driver.findElement(lastNameTextBox).sendKeys(lastName);
			driver.findElement(passwordTextBox).sendKeys(password);
			//-----	Birthday drop down menus
			driver.findElement(birthDayDropDownMenu).click();
			driver.findElement(birthDayChosen).click();
			
			driver.findElement(birthMonthDropDownMenu).click();
			driver.findElement(birthMonthChosen).click();
			
			driver.findElement(birthYearDropDownMenu).click();
			driver.findElement(birthYearChosen).click();
			//----	Address	
			
			driver.findElement(nameAddressTextBox).sendKeys(nameAddress);
			driver.findElement(lastNameAddressTextBox).sendKeys(lastNameAddress);
			driver.findElement(companyAddressTextBox).sendKeys(company);
			driver.findElement(address1TextBox).sendKeys(address1);
			driver.findElement(address2TextBox).sendKeys(address2);
			driver.findElement(cityTextBox).sendKeys(city);
			//----State
			//driver.findElement(stateDropDownMenu).click();
			//driver.findElement(stateChosenOption ).click();
			
			driver.findElement(zipcode).sendKeys(ZC);
			driver.findElement(commentsTextBox).sendKeys(comments);
			driver.findElement(phoneTextBox).sendKeys(phone);
			driver.findElement(mobilePhoneTextBox).sendKeys(mobilePhone);
			driver.findElement(aliasTextBox).sendKeys(alias);
			driver.findElement(submitButton).click();
			
		}
		//-----------------------------------------------------------------
		//random usernames generators (will only produce 200, if you wish more raise the upperbound)
		public String randomUsers() {
			Random rand = new Random();
		    int upperbound = 200;
		    int int_random = rand.nextInt(upperbound);
			String email = "user"+ int_random +"@email.com";
			//email = "holi@email.com";
			return email;
		}

}

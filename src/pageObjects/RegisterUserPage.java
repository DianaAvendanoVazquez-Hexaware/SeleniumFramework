package pageObjects;

import java.util.Random;
import org.openqa.selenium.*;

public class RegisterUserPage {
	
	//initialize WebDriver as driver
	WebDriver driver;
	ExtractData username; //ExtractData will use the random generator
	
	//constructor of the page
	public RegisterUserPage(WebDriver driver) {
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
	private By stateDropDownMenu = By.id("id_state");
	private By stateChosenOption = By.xpath("//select[@id=\'id_state\']/option[20]"); //state no.20 in the list
	private By zipcode = By.id("postcode"); 
	private By commentsTextBox = By.id("other"); 
	private By phoneTextBox = By.id("phone");
	private By mobilePhoneTextBox = By.id("phone_mobile");
	private By aliasTextBox = By.id("alias");
	private By submitButton = By.xpath("//button[@id=\'submitAccount\']/span");
	
	private By messageLogIn = By.xpath("//div[@id=\'center_column\']/p");
	
	//---------------------------------------------------------------------------------------------------------

	public void createNewAccount() {
		
		ExtractData username = new ExtractData() ;
		
		driver.findElement(userNameTextBox).sendKeys( username.randomUsers() );
		driver.findElement(createAccountButton).click();
	}
	//------------

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
		
		driver.findElement(stateDropDownMenu).click();
		driver.findElement(stateChosenOption ).click();
		
		driver.findElement(zipcode).sendKeys(ZC);
		driver.findElement(commentsTextBox).sendKeys(comments);
		driver.findElement(phoneTextBox).sendKeys(phone);
		driver.findElement(mobilePhoneTextBox).sendKeys(mobilePhone);
		driver.findElement(aliasTextBox).sendKeys(alias);
		driver.findElement(submitButton).click();
		
	}
	//======================================================================
	//this method fills the form based on the data from the excel file
	//Uses initialInformation.ExtractData
	public void register2(String password) {
		
		//loads the excelfile
		String filePath = "C:\\Users\\iamCa\\Desktop\\NotPorn\\cursos\\Framework\\HXFramework3\\data\\account_data.xlsx";
		//this array will store the data to fill the form for the account creation
		String[] array = ExtractData.submitData(driver, filePath, "Create Account", password);
		
		//finds the user textbox and clicks on create account
		ExtractData username = new ExtractData(); //to instantiate the random user generator
		driver.findElement(userNameTextBox).sendKeys( username.randomUsers() );
		driver.findElement(createAccountButton).click();
		
		String dname = array[2];
		String dlastname = array[3];
		//String ddate = array[5];
		String dcompany = array[6];
		String daddress1 = array[7];
		String daddress2 = array[8];
		String dcity = array[9];
		String dpostcode = array[10];
		String dother = array[11];
		String dphone = array[12];
		String dphoneMobile = array[13];
		String dalias = array[14];
		//String dstate = array[15];
		
		//---Now we fill the form
		driver.findElement(genderBullet).click();
		driver.findElement(firstNameTextBox).sendKeys(dname);
		driver.findElement(lastNameTextBox).sendKeys(dlastname);
		driver.findElement(passwordTextBox).sendKeys(password);
		//-----	Birthday drop down menus
		driver.findElement(birthDayDropDownMenu).click();
		driver.findElement(birthDayChosen).click();
		
		driver.findElement(birthMonthDropDownMenu).click();
		driver.findElement(birthMonthChosen).click();
		
		driver.findElement(birthYearDropDownMenu).click();
		driver.findElement(birthYearChosen).click();
		//----	Address	
		
		driver.findElement(nameAddressTextBox).sendKeys(dname);
		driver.findElement(lastNameAddressTextBox).sendKeys(dlastname);
		driver.findElement(companyAddressTextBox).sendKeys(dcompany);
		driver.findElement(address1TextBox).sendKeys(daddress1);
		driver.findElement(address2TextBox).sendKeys(daddress2);
		driver.findElement(cityTextBox).sendKeys(dcity);
		
		driver.findElement(stateDropDownMenu).click();
		driver.findElement(stateChosenOption ).click();
		
		driver.findElement(zipcode).sendKeys(dpostcode);
		driver.findElement(commentsTextBox).sendKeys(dother);
		driver.findElement(phoneTextBox).sendKeys(dphone);
		driver.findElement(mobilePhoneTextBox).sendKeys(dphoneMobile);
		driver.findElement(aliasTextBox).sendKeys(dalias);
		
		driver.findElement(submitButton).click();
	
	}
	
	//=======================================================================
	public String logInMessage() {
		return driver.findElement(messageLogIn).getText();
	}
	
	//--------------------------------------------------------------------
	//this method allows you to register an account providing that you have an unused username
	public void register(String firstName, String lastName, String password, 
			String nameAddress, String lastNameAddress, String company, String address1, String address2,
			String city, String ZC, String comments, String phone, String mobilePhone, String alias ) {
		
		this.createNewAccount();
		this.fillForm(firstName, lastName, password, nameAddress, lastNameAddress, company, address1, 
				address2, city, ZC, comments, phone, mobilePhone, alias);
	}
	
	

}

package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class BuySearchProducts {
	
	//initialize WebDriver
	WebDriver driver;
	
	public BuySearchProducts(WebDriver driver) {
		this.driver = driver;
	}
	
	//Locators
	private By womenTab = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[1]/a");
	private By secondElementMoreButton = By.xpath("//*[@id=\'center_column\']/ul/li[2]/div/div[2]/div[2]/a[2]/span");
	private By secondElementWishlistButton = By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[3]/div[1]/a");
	//http://automationpractice.com/index.php?id_product=2&controller=product
	private By increaseQuantityButton = By.xpath("//*[@id=\"quantity_wanted_p\"]/a[2]/span/i");
	private By sizeDropDownMenu = By.xpath("//*[@id=\"group_1\"]");
	private By largeSize = By.xpath("//option[@value='3']");
	private By whiteColourButton = By.xpath("//*[@id=\"color_8\"]");
	private By addToCartButton = By.xpath("//*[@id=\"add_to_cart\"]/button/span");
	//popup to go to check in
	private By proceedToCheckOutButton = By.xpath("//*[@id=\'layer_cart\']/div[1]/div[2]/div[4]/a/span");
	//Check Out page
	private By summaryProceedCheckoutButton = By.xpath("//*[@id=\'center_column\']/p[2]/a[1]/span");
	private By addressProceedCheckoutButton = By.xpath("//*[@id=\'center_column\']/form/p/button/span");
	private By shippingTermsAndCondCheckbox = By.id("cgv");
	private By shippingProceedToCheckoutButton = By.xpath("//*[@id=\'form\']/p/button/span");
		//payment tab
	private By payByBankWireButton = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a");
	private By confirmOrderButton = By.xpath("//*[@id=\"cart_navigation\"]/button");
	
	//errorMessages
	private By wishlistErrorMessage = By.xpath("//*[@id=\"category\"]/div[2]/div/div/div/div/p");
	
	//----These locators are for the search box
	private By searchTextBox = By.id("search_query_top");
	private By secondElementWomenCatalogue = By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/h5/a");
	private By firstElementWomenCatalogue = By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a");
	
	//--Check out cart prices
	
	private By unitPriceCart = By.id("product_price_2_7_0");
	private By totalPriceCart = By.id("total_product_price_2_7_0");
	private By increaseQuantityCheckoutButton = By.xpath("//*[@id=\"cart_quantity_up_2_12_0_723852\"]/span/i"); 

//-------------------------------------------------------------------
	//               METHODS THAT DESCRIBE ACTIONS
	//----------------------------------------------------------------
	
	//directs us to the women catalogue
	public void womenCatalogue() {
		
		//we instantiate the packages needed to perform actions on the webpage
		Actions actions = new Actions(driver);
		//hovers the mouse over the women tab
		WebElement women = driver.findElement(womenTab);
		actions.moveToElement(women).perform();
		
		driver.findElement(womenTab).click();
	
	}
//-------------		
	//this methos chooses 2 pieces of the same product
	public void choose2PcsSameProduct() {
		
		//clicks on the "more" button of the second element
		driver.findElement(secondElementMoreButton).click();
		//This will lead to another page
		
		//increase the quantity of roducts
		driver.findElement(increaseQuantityButton).click();
		//select size
		driver.findElement(sizeDropDownMenu).click();
		driver.findElement(largeSize).click();
		//selec Colour
		driver.findElement(whiteColourButton).click();
		//add to cart
		driver.findElement(addToCartButton).click();
		
	}
//-------------		
	//this methos chooses 1 piece of the same product
	
		public void chooseProduct() {
			//clicks on the "more" button of the second element
			driver.findElement(secondElementMoreButton).click();
			//This will lead to another page
			//select size
			driver.findElement(sizeDropDownMenu).click();
			driver.findElement(largeSize).click();
			//selec Colour
			driver.findElement(whiteColourButton).click();
			//add to cart
			driver.findElement(addToCartButton).click();
			
		}
	//-------------	
		//You must be logged in to use this method
		public void directCheckout() {
			driver.findElement(proceedToCheckOutButton).click();
			//address tab
			driver.findElement(summaryProceedCheckoutButton).click();
			//address tab
			driver.findElement(addressProceedCheckoutButton).click();
			//shipping tab
			driver.findElement(shippingTermsAndCondCheckbox).click();
			driver.findElement(shippingProceedToCheckoutButton).click();
			//payment tab
			driver.findElement(payByBankWireButton).click();
			driver.findElement(confirmOrderButton).click();
		}
//-------------			
		//You must be logged in to use this method
		//This method belongs to test VerifyPriceChanges
		
		public void editedQuantityCheckOut() throws InterruptedException{
			
			driver.findElement(proceedToCheckOutButton).click();
			
			//check for current price
			String price1 = driver.findElement(unitPriceCart).getText();
			System.out.println(driver.findElement(unitPriceCart).getText());
			
			driver.findElement(By.cssSelector(".icon-plus")).click();

			driver.findElement(increaseQuantityCheckoutButton).click();

	        

			/*
			//increase by one the quantity
			driver.findElement(increaseQuantityCheckoutButton).click();
			//check new current price
			String price2 = driver.findElement(totalPriceCart).getText();
			System.out.println(driver.findElement(totalPriceCart).getText());

			
			//The price takes a while to update

			//specific case of second element women catalogue
			//checks that price has been changed
			if (price2 == price1) {
				
				String value = "No";
				System.out.println("The price didn't update");
				return value;
				
				
			}else if (price2 == "$54.00"){
				
				String value = "yes";
				System.out.println("The price updated successfully");
				
				return value;
			}else {
				return null;
			}
			*/
			
		}

//-------------		
		public void searchForFirstProduct() {
			//get the name of the second element in the catalogue
			String product = driver.findElement(firstElementWomenCatalogue).getText();
			System.out.println(product);
			//type the product name and press enter
			driver.findElement(searchTextBox).sendKeys(product,Keys.ENTER);
					
				}		
		
//-------------		
		public void searchForAProduct() {
			//get the name of the second element in the catalogue
			String product = driver.findElement(secondElementWomenCatalogue).getText();
			System.out.println(product);
			//type the product name and press enter
			driver.findElement(searchTextBox).sendKeys(product,Keys.ENTER);
			
		}
//-------------	
		
		//this is just for the assert in Test SearchProductTest.java
		public String firstProduct() {
			String product = driver.findElement(firstElementWomenCatalogue).getText();
			System.out.println(product);
			return product;
		}
//------------
		//this is just for the assert in come test 
		public String secondProduct() {
			String product = driver.findElement(secondElementWomenCatalogue).getText();
			return product;
		}
//-------------
		public void addProductToWishlist(){
			//adds directly second product to the wishlist
			driver.findElement(secondElementWishlistButton).click();
				
		}
		
		public String wishlistErrorMessage() {
			String message = driver.findElement(wishlistErrorMessage).getText();
			System.out.println(message);
			
			return message;		
		}

	
//---------------------------------------------------------------------
		//METHODS THAT MIX UP ACTIONS
//----------------------------------------------------------------
	//Used in BuyTwiceSameProductstest	
	public void buy2Elements() {
		this.womenCatalogue();
		this.choose2PcsSameProduct();
		//chooseSizeQuantityColour
		this.directCheckout();				
	}
	
	//Used in test VerifyPriceChanges
	public void editCartAndBuy() throws InterruptedException {
		
		//This method verifys that total price changes if
		//you change the quantity of products during checkout
		this.womenCatalogue();
		this.chooseProduct();
		this.editedQuantityCheckOut();
		
	}
	
	//Test SearchProductTest.java
	public void verifySearchProduct() {
		this.womenCatalogue();
		this.searchForFirstProduct();
	}
	
	//this is for addWhishlistTest
	public void addToWishList() {
		this.womenCatalogue();
		this.addProductToWishlist();
	}
	
	
	
}

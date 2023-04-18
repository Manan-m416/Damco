package QapitolQA.StepDefinition;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import QapitolQA.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import qapitolQA.pageobjects.CartPage;
import qapitolQA.pageobjects.CheckoutPage;
import qapitolQA.pageobjects.ConfirmationPage;
import qapitolQA.pageobjects.LandingPage;
import qapitolQA.pageobjects.ProductCatalogue;

public class StepDefintionimplementation extends BaseTest{
  
	
	public LandingPage landingPage;
	public ProductCatalogue productCatalogue ;
	public ConfirmationPage confirmationpage;
	
	@Given("User lands on ecommerce website")
	
	public void User_lands_on_ecommerce_website() throws IOException{
		
	landingPage	= (LandingPage) initializedriver();
		
	}
	
	@Given("^Login with username (.+) and password (.+)$")
	
	public void Login_with_username_and_password(String username, String password){
		
		productCatalogue= landingPage.loginApplication(username,password);
	}
	
	@When("^Add product (.+) from Cart$")
	public void Add_product_from_Cart(String productName) 
	{
		List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
		
	}
	
	@And("^Checkout (.+) and submit the order$")
	
	public void Checkout_and_submit_the_order(String productName) {
		    CartPage cartpage =  productCatalogue.goToCartPage(); 
		    Boolean match =  cartpage.verifyProductDisplay(productName);
	        Assert.assertTrue(match);
	        CheckoutPage checkoutpage =   cartpage.gotoCheckout();
			checkoutpage.selectCountry("India");
	        confirmationpage = checkoutpage.submitOrder();
	}
	
	
	// Then "THANKYOU FOR THE ORDER" message is displayed on ConfirmationPage
	
	@Then ( "{string} message is displayed on ConfirmationPage")
	
	public void   message_is_displayed_on_ConfirmationPage(String string) {
		
		 String confirmMessage = confirmationpage.getConfirmationMessage();
		 Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		 driver.quit();
	}
	
	 @Then("^\"([^\"]*)\" message is displayed$")
	    public void something_message_is_displayed(String strArg1) throws Throwable {
	   
	    	Assert.assertEquals(strArg1, landingPage.getErrorMessage());
	    	driver.close();
	
}}

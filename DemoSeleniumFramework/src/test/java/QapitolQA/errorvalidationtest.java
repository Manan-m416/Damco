package QapitolQA;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import QapitolQA.TestComponents.BaseTest;
import qapitolQA.pageobjects.CartPage;
import qapitolQA.pageobjects.ProductCatalogue;

public class errorvalidationtest extends BaseTest {

	@Test(groups= {"ErrorHandling"})
	
	public void loginErrorValidation() throws IOException {
		// TODO Auto-generated method stub

		//String productName = "ADIDAS ORIGINAL";
	    landingPage.loginApplication("anshika@gmail.com","Iam@000");
		//wrong password
	    Assert.assertEquals("Incorrect email  password.",landingPage.getErrorMessage());
          
        
	}
	
	
	@Test
	public void productErrorValidation() {
		
		String productName = "ADIDAS ORIGINAL";
	    ProductCatalogue productCatalogue =landingPage.loginApplication("anshika@gmail.com","Iamking@000");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//this will send these values in argument for login application method which will furhte be used by find by object
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(productName);
        CartPage cartpage =  productCatalogue.goToCartPage(); //child classes have access to all methpds of parent class
	    Boolean match =  cartpage.verifyProductDisplay("ADIDAS ORIGINAL1");
        Assert.assertFalse(match);
		
	}

}

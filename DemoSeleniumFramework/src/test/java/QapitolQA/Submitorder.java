package QapitolQA;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import QapitolQA.TestComponents.BaseTest;
import qapitolQA.pageobjects.CartPage;
import qapitolQA.pageobjects.CheckoutPage;
import qapitolQA.pageobjects.ConfirmationPage;
import qapitolQA.pageobjects.OrderPage;
import qapitolQA.pageobjects.ProductCatalogue;

public class Submitorder extends BaseTest {

	

	String productName = "ADIDAS ORIGINAL";
	@Test(dataProvider="getData1",groups= {"Purchase"})
	
	public void submitOrder(HashMap<String,String> input) throws IOException {
		// TODO Auto-generated method stub

	    ProductCatalogue productCatalogue =landingPage.loginApplication(input.get("email"),input.get("password"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//this will send these values in argument for login application method which will furhte be used by find by object
        List<WebElement> products = productCatalogue.getProductList();
        productCatalogue.addProductToCart(input.get("product"));
        CartPage cartpage =  productCatalogue.goToCartPage(); //child classes have access to all methpds of parent class
	    Boolean match =  cartpage.verifyProductDisplay(input.get("product"));
        Assert.assertTrue(match);
        CheckoutPage checkoutpage =   cartpage.gotoCheckout();
		checkoutpage.selectCountry("India");
        ConfirmationPage confirmationpage = checkoutpage.submitOrder();
        String confirmMessage = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
     
          
        
	}
	
	@Test (dependsOnMethods= {"submitOrder"})
	
	public void OrderHistoryTest()
	{
		ProductCatalogue productCatalogue = landingPage.loginApplication("anshika@gmail.com", "Iamking@000");
		OrderPage ordersPage = productCatalogue.goToOrderPage();
	    Assert.assertTrue(ordersPage.verifyOrderDisplay(productName));
}

	
	
	
	
	@DataProvider 
	
	public Object[][] getData1() throws IOException {
		
		
	//	HashMap<String, String> map = new HashMap<String, String>();
	//	map.put("email", "anshika@gmail.com");
	//	map.put("password", "Iamking@000");
	//	map.put("productName","ADIDAS ORIGINAL");
		
	//	HashMap<String, String> map1 = new HashMap<String, String>();
	//	map1.put("email", "shetty@gmail.com");
	//	map1.put("password", "Iamking@000");
	//	map1.put("productName","ZARA COAT 3");
		
   List<HashMap<String,String>> data =  getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//QapitolQA//data//Purchase.json");
		return new  Object[][] {{data.get(0)},{data.get(1)}};
		
	}
	
}

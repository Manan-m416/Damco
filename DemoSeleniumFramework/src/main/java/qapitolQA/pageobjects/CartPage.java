package qapitolQA.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qaqpitolQA.Abstractcomponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver ;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (css =".totalRow button")
	WebElement checkoutEle;
	
	@FindBy (css=".cartSection h3")
	private List<WebElement> cartProducts;
	
	public Boolean verifyProductDisplay (String productName) {
		
		
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		
		return match;
		
	}
	
	public CheckoutPage  gotoCheckout() {
		checkoutEle.click();
		
		 return new CheckoutPage(driver);
	}
	
	
	

}

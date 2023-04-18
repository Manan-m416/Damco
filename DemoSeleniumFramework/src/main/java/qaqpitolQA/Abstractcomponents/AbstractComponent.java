package qaqpitolQA.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import qapitolQA.pageobjects.CartPage;
import qapitolQA.pageobjects.OrderPage;

public class AbstractComponent {

	//create methods such as javascript executor , synchronization
	WebDriver driver;
	
	public AbstractComponent(WebDriver driver) {
		
		this.driver =driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	//driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	
	@FindBy (css="[routerlink*='cart']")
	WebElement cartHeader;
	
	@FindBy (css="[routerlink*='myorders']")
	WebElement orderHeader;

	public void waitForElementToAppear(By findBy) {
		

	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	
	
	
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		

		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public CartPage goToCartPage(){
		
		cartHeader.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
     public OrderPage goToOrderPage(){
		
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	
	
	
	public void waitForElementToDisappear(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	}
	
	
}

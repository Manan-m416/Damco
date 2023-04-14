package QapitolQA.Damco;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AOL {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
        WebDriver driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
        
        driver.manage().window().maximize();
        
        driver.get("https://mail.aol.com/");
        
        driver.findElement(By.cssSelector(".login")).click();
        
        driver.findElement(By.id("login-username")).sendKeys("manansrivastava");
        
        driver.findElement(By.id("login-signin")).click();
        
        driver.findElement(By.id("login-passwd")).sendKeys("Damco@711890");
        
        driver.findElement(By.id("login-signin")).click();
        
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(20));
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@aria-label='Compose']")));
        
        driver.findElement(By.xpath("//a[@aria-label='Compose']")).click();
        
        driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys("Damco");
        
        driver.findElement(By.id("message-to-field")).sendKeys("manansrivastava");
        
      //  driver.findElement(By.xpath(" //button[@title='Bulleted List']//*[name()='svg']")).click();
        //unable to select bullet from drop down
      //  driver.findElement(By.xpath("//div[@aria-label='Message body']")).sendKeys("Line 1");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Attach')] ")));
        
        driver.findElement(By.xpath("//span[contains(text(),'Attach')]")).sendKeys("C:\\Users\\QQA0325\\Downloads\\image.jpg");
        
        
     
      
      
      
      
		
	}

}

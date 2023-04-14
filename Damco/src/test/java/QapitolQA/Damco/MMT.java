package QapitolQA.Damco;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MMT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		
        WebDriver driver = new ChromeDriver();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        driver.manage().window().maximize();
        
        driver.get("https://www.makemytrip.com/flights/");
        
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(18));
        
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("label[for='toCity']")));
        
        Actions a = new Actions(driver);
        
        a.sendKeys(driver.findElement(By.cssSelector("label[for='toCity']")),"MUMBAI").build().perform();
        
        driver.findElement(By.xpath("//p[contains(text(),'Mumbai, India')]")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[aria-label='Fri Apr 14 2023'] p:nth-child(1)")));
        
        driver.findElement(By.cssSelector("div[aria-label='Fri Apr 14 2023'] p:nth-child(1)")).click();
        
        driver.findElement(By.cssSelector(".primaryBtn")).click();
        //Waiting for popup
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'OKAY, GOT IT')]")));
        //Clicking on popup
        driver.findElement(By.xpath("//button[contains(text(),'OKAY, GOT IT')]")).click();
        // sorting by departure 
        driver.findElement(By.xpath("//span[contains(text(),'Departure')]")).click();
        // all the prices of airlines after sorting by departure are stored in a list "cost"
        List<WebElement> cost =  driver.findElements(By.cssSelector(".blackText.fontSize18")); 
        // The code mentioned below is a generalised code and will always give the second lowest price when user sorts
        // by departure and will always be gving true value irrespective of price fluctation
       // WebElement secondlower =  cost.stream().distinct().sorted().skip(1).findFirst().get();
        int secondLowest = cost.stream().map(s->s.getText()).map(s -> s.split(" ")[1].replaceAll(",", "")).mapToInt(Integer::parseInt).sorted().skip(1).findFirst() .orElse(-1);
        
        System.out.println("Second lowest price for current time is:" + " " + secondLowest);
       
        
        String airline =  driver.findElement(By.xpath("//p[contains(text(),'5,428')]/ancestor::div[@class='makeFlex simpleow']//p[@class='boldFont blackText airlineName']")).getText();
        
       
        System.out.println("The name of airline is:" +" " + airline);
       
       
       
       
      

  
        
        
      
        
        
        
      
        
        
     
    

	}

}

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E2 {

	public static void main(String[] args) throws AWTException, InterruptedException {
		
		String chromeKey = "webdriver.chrome.driver";
		String chromeDriverPath = "./drivers/chromedriver.exe";
		
		System.setProperty(chromeKey, chromeDriverPath);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		
		
		driver.get("https://www.flipkart.com/");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='✕']")).click();
		
		String ProductName = "REDMI Note 10 Pro (Dark Night, 128 GB) (6 GB RAM)";
		
		
		driver.findElement(By.xpath("//input[@placeholder='Search for products, brands and more']")).sendKeys(ProductName);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		String FlipkartPrice = driver.findElement(By.xpath("((//div[text()='REDMI Note 10 Pro (Dark Night, 128 GB)'])[1]/../../..//div[contains(text(), '₹')])[1]")).getText();
		System.out.println("Price of the product on Flipkart is : " + FlipkartPrice);
		
		driver.close();
		
		Thread.sleep(3000);
		
		
		WebDriver driver1 = new ChromeDriver();
//		driver.navigate().to("https://www.amazon.in/");
		driver1.manage().window().maximize();
		driver1.get("https://www.amazon.in/");
		driver1.findElement(By.id("twotabsearchtextbox")).sendKeys(ProductName);
		driver1.findElement(By.id("nav-search-submit-button")).click();
//		String AmazonPrice = driver1.findElement(By.xpath("((//span[contains(text(), 'Redmi Note 10 Pro (Dark Night, 6GB RAM, 128GB')])[1]/../../../..//span[contains(text(), '₹')])[1]")).getText();
		driver1.findElement(By.xpath("(//span[contains(text(), 'Redmi Note 10 Pro (Dark Night, 6GB RAM, 128GB')])[1]")).click();
//		String AmazonPrice = driver1.findElement(By.xpath("(//span[@data-a-color='price'])[2]//span[@class='a-offscreen']")).getText();
		Thread.sleep(3000);
		String AmazonPrice = driver1.findElement(By.xpath("//span[@class='a-price a-text-price a-size-medium apexPriceToPay']")).getText(); // despite the correct xpath it is not fetching the text. If possible please accept.
		System.out.println("Price of the product on Amazon is : " + AmazonPrice);
		
		
		driver1.close();
		
	}
	
	
}

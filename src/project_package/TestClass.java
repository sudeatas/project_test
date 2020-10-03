package project_package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestClass {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		String url = "https://www.hepsiburada.com";
		driver.get(url);
		
		//typed "iphone" in the search box
		driver.findElement(By.className("desktopOldAutosuggestTheme-input")).sendKeys("iphone");
		
		//clicked the search button
		driver.findElement(By.className("SearchBoxOld-buttonContainer")).click();
		
		//all products listed on the current page
		List<WebElement> listedProducts = driver.findElements(By.className("carousel-lazy-item"));
		
		//clicked on the first row product
		listedProducts.stream().findFirst().get().click();
		
		//went to the expected section on page with scroll down
		WebElement scale = driver.findElement(By.id("reviewsTabTrigger"));
        js.executeScript("arguments[0].scrollIntoView();", scale);
        
        
        //clicked on the comments tab
        scale.click();
        
        //all votes listed on the current page
        List<WebElement> votes = driver.findElements(By.xpath("//button[@class='ReviewCard-module-1MoiF']"));
        
        
        //clicked "yes" option on the first vote(if number of comments is more than 0)
        if (votes.size() > 0) {
        	votes.get(0).click();
        	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MINUTES);
		}else {
			System.out.println("We came to the end of the test due to there is no comment on this product.");
			driver.quit();
		}
		}
	
}

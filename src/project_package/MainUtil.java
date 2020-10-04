package project_package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainUtil {
	
	static String url = "https://www.hepsiburada.com";
	static WebDriver driver;
	static List<WebElement> findElementsList;
	static WebElement findElement;
	static JavascriptExecutor ex = (JavascriptExecutor)driver;
		
	public static WebDriver gotoPage() {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get(url);
		return driver;
	}

	public static WebElement findElementClass(String byClass, String byId) {
		try {
			findElement = null != byClass ? driver.findElement(By.className(byClass)) : driver.findElement(By.id(byId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findElement;
	}

	public static List<WebElement> findElementsClass(String byClass, String byXpath) {
		try {
			findElementsList =  null != byClass ? driver.findElements(By.className(byClass)) : driver.findElements(By.xpath(byXpath));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return findElementsList;
	}

	public static void click(WebElement scale) {
		try {
			scale.click();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}

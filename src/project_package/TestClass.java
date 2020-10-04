package project_package;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class TestClass extends MainUtil {

	public static void main(String[] args) {

		// go to related page
		gotoPage();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			// typed "iphone" in the search box
			findElementClass("desktopOldAutosuggestTheme-input", null).sendKeys("iphone");
			Thread.sleep(1000);
			
			// clicked the search button
			click(findElementClass("SearchBoxOld-buttonContainer", null));
						
			// all products listed on the current page
			List<WebElement> listedProducts = findElementsClass("carousel-lazy-item", null);
			Thread.sleep(10000);
			
			// clicked on the first row product
			click(listedProducts.stream().findFirst().get());
			Thread.sleep(10000);
			
			// went to the expected section on page with scroll down
			WebElement scale = findElementClass(null, "reviewsTabTrigger");
			js.executeScript("arguments[0].scrollIntoView();", scale);
			Thread.sleep(1000);

			// clicked on the comments tab
			click(scale);

			// all votes listed on the current page
			List<WebElement> votes = findElementsClass(null, "//button[@class='ReviewCard-module-1MoiF']");

			// clicked "yes" option on the first vote(if number of comments is more than 0)
			if (votes.size() > 0) {
				votes.get(0).click();
				driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MINUTES);
			} else {
				System.out.println("We came to the end of the test due to there is no comment on this product.");
				driver.quit();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

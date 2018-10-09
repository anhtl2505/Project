package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Search {

	private static WebElement element = null;

	public static void Execute(WebDriver driver) throws InterruptedException {

	    WebDriverWait wait =new WebDriverWait(driver, 10);

		
		Search.Search_Input(driver).sendKeys("Eclipse");
		Thread.sleep(1000);
		Search.Btn_Search(driver).sendKeys(Keys.ENTER);
		
		element = wait.until(ExpectedConditions.elementToBeClickable(Search.Hyperlink_Click1(driver)));

		Search.Hyperlink_Click1(driver).click();
		Thread.sleep(3000);
		
	    Assert.assertEquals("Enabling Open Innovation & Collaboration | The Eclipse Foundation", Search.Verify_Tiltle(driver));    

	}

	// Get element Search_Input
	public static WebElement Search_Input(WebDriver driver) {
		element = driver.findElement(By.id("lst-ib"));
		return element;
	}

	// Get element Button Search
	public static WebElement Btn_Search(WebDriver driver) {
		element = driver.findElement(By.name("btnK"));
		return element;
	}

	// Get tiltle page
	public static String Verify_Tiltle(WebDriver driver) {
		String element = driver.getTitle();
		return element;
	}

	// Get element hyperlink
	public static WebElement Hyperlink_Click1(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/h3"));
		return element;
	}

}

package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn {

	private static WebElement element = null;

	public static void Execute(WebDriver driver) throws InterruptedException {

		SignIn.btn_SignIn(driver).click();
		SignIn.txtbx_EmailOrPhone(driver).sendKeys("mindy.kenz@gmail.com");
		SignIn.btn_Next(driver).click();
		Thread.sleep(2000);
		SignIn.txtbx_Password(driver).sendKeys("753869123");
		SignIn.btn_LogIn(driver).click();
		Thread.sleep(2000);

	}

	// Get element Button SignIn
	public static WebElement btn_SignIn(WebDriver driver) {
		element = driver.findElement(By.id("gb_70"));
		return element;
	}

	// Get element Textbox Email
	public static WebElement txtbx_EmailOrPhone(WebDriver driver) {
		element = driver.findElement(By.id("identifierId"));
		return element;
	}

	// Get element Button Next
	public static WebElement btn_Next(WebDriver driver) {
		element = driver.findElement(By
				.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/content/span"));
		return element;
	}

	// Get element Textbox Password
	public static WebElement txtbx_Password(WebDriver driver) {
		element = driver.findElement(By.className("whsOnd"));
		return element;
	}

	// Get element Button Login
	public static WebElement btn_LogIn(WebDriver driver) {
		element = driver.findElement(By.cssSelector("#passwordNext > content > span"));
		return element;
	}

}

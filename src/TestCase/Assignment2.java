package TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObject.GetValue;
import PageObject.SignIn;

public class Assignment2 {

	public static WebDriver driver = null;

	@Test
	// Main
	public static void main(String[] args) throws Exception {

		OpenBrowser();
		// Call Functions
		SignIn.Execute(driver);
		GetValue.Execute(driver);
		driver.quit();

	}

	public static void OpenBrowser() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}

}

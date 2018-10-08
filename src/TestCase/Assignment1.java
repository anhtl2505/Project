package TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObject.Search;
import PageObject.SignIn;

public class Assignment1 {
	public static WebDriver driver = null;

	@Test
	public static void main(String[] args) throws Exception {
		OpenBrowser();

		// Call functions
		SignIn.Execute(driver);
		Search.Execute(driver);
		driver.quit();
	}

	public static void OpenBrowser() {
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}
}

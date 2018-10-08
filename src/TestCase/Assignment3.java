package TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import PageObject.Calculate;

public class Assignment3 {

	public static WebDriver driver = null;

	@Test
	// Main
	public static void main(String[] args) throws Exception {

		OpenBrowser();

		// Call Functions
		Calculate.Execute(driver);
		driver.quit();
	}

	public static void OpenBrowser() {
		driver = new ChromeDriver();
		driver.get("https://web2.0calc.com/");
		driver.manage().window().maximize();
	}

}

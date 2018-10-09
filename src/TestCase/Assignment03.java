package TestCase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import PageObject.*;

public class Assignment03 {
	
	public static WebDriver driver = null;

  @Test(priority = 0)
  public void SignIn() throws InterruptedException, IOException {
	  	// Get data and implement method addition/ subtraction/ multiplication/ division
		Calculate.Execute(driver);
  }
  
  @BeforeSuite	
  public void beforeMethod() {
	  	driver = new ChromeDriver();
		driver.get("https://web2.0calc.com/");
		driver.manage().window().maximize();
  }

  @AfterSuite
  public void afterMethod() {
	  driver.quit();
  }
  
  	
}

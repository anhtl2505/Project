package TestCase;





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

public class Assignment01 {
	
	public static WebDriver driver = null;

  @Test(priority = 0)
  public void SignIn() throws InterruptedException {
	  	
	  // Sign in Google HomePage
	  	SignIn.Execute(driver);
  }
  
  @Test(priority = 1)
  public void Search() throws InterruptedException {
	  // Search and verify tiltle
	  	Search.Execute(driver);
  }
  
  
  @BeforeSuite	
  public void beforeMethod() {
	  	driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
  }

  @AfterSuite
  public void afterMethod() {
	  driver.quit();
  }
  
  	
}

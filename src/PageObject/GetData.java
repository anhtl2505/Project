package PageObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GetData {

	private static WebElement element = null;
	private static HSSFWorkbook workbook;
	private static HSSFSheet sheet;
	private static HSSFCell cell;

	public static void Execute(WebDriver driver) throws InterruptedException, IOException {

		File src = new File("C:\\Users\\anhtl\\Desktop\\DataSearch.xls");
		// Load the file.
		FileInputStream fis = new FileInputStream(src);
		// Load the workbook.
		workbook = new HSSFWorkbook(fis);
		// Load the sheet in which data is stored.
		sheet = workbook.getSheetAt(0);
		FileOutputStream fos = new FileOutputStream(src);

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			// Step Read Keyword from xls file
			cell = sheet.getRow(i).getCell(0);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			driver.findElement(By.id("lst-ib")).clear();
			driver.findElement(By.id("lst-ib")).sendKeys(cell.getStringCellValue());

			driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
			Thread.sleep(4000);
			driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/div[1]/a/h3")).click();
			Thread.sleep(4000);

			cell = sheet.getRow(i).getCell(1);

			cell.setCellType(Cell.CELL_TYPE_STRING);
			if (Search.Verify_Tiltle(driver).equals(cell.getStringCellValue())) {
				System.out.println("Case " + i + ": Pass");
			} else {
				System.out.println("Case " + i + ": Fail");
			}
			Thread.sleep(1000);
			driver.get("https://www.google.com/");
		}

	}
}

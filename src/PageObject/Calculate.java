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
import org.openqa.selenium.WebDriver;

public class Calculate {

	private static WebDriver driver = null;
	private static HSSFWorkbook workbook;
	private static HSSFSheet sheet;
	private static HSSFCell cell;
	private static HSSFCell cellx;


	public static void Execute(WebDriver driver) throws InterruptedException, IOException {

		// Import excel sheet.
		File src = new File("C:\\Users\\anhtl\\Desktop\\Data.xls");
		// Load the file.
		FileInputStream fis = new FileInputStream(src);
		// Load he workbook.
		workbook = new HSSFWorkbook(fis);
		// Load the sheet in which data is stored.
		sheet = workbook.getSheetAt(0);

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			// Read 1st Number from Excel.
			cell = sheet.getRow(i).getCell(0);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			driver.findElement(By.id("input")).clear();
			driver.findElement(By.id("input")).sendKeys(cell.getStringCellValue());
			Thread.sleep(1000);

			// Read method from file Excel
			cell = sheet.getRow(i).getCell(2);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			System.out.println(cell.getStringCellValue());

			if (cell.getStringCellValue().equals("Addition")) {
				driver.findElement(By.id("BtnPlus")).click();
			}
			if (cell.getStringCellValue().equals("Subtraction")) {
				driver.findElement(By.id("BtnMinus")).click();
			}
			if (cell.getStringCellValue().equals("Multiplication")) {
				driver.findElement(By.id("BtnMult")).click();
			}
			if (cell.getStringCellValue().equals("Division")) {
				driver.findElement(By.id("BtnDiv")).click();
			}
			Thread.sleep(1000);

			// Read 2nd Number from Excel.
			cell = sheet.getRow(i).getCell(1);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			driver.findElement(By.id("input")).sendKeys(cell.getStringCellValue());
			Thread.sleep(1000);

			// Result
			driver.findElement(By.id("BtnCalc")).click();
			Thread.sleep(2000);
			
			//Get Actual Result
			float rs = Float.parseFloat(driver.findElement(By.id("input")).getAttribute("value"));
			//Write Actual REsult to Excel
			sheet.getRow(i).createCell(4).setCellValue(rs);		
			cell = sheet.getRow(i).getCell(3);
			
			//Compare 
			float temp = (float) cell.getNumericCellValue();
			if (rs == temp) {
				cell = sheet.getRow(i).getCell(4);
				sheet.getRow(i).createCell(5).setCellValue("Pass");
				
			} else {
				cell = sheet.getRow(i).getCell(4);
				sheet.getRow(i).createCell(5).setCellValue("Fail");				
			}
			//Output File
			FileOutputStream fout=new FileOutputStream(new File("F:\\Result.xls"));	        
			workbook.write(fout);
	        fout.close(); 
	        
			Thread.sleep(1000);
			
		}
		driver.quit();
	}
}

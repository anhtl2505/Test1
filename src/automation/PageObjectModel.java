

package automation;

    import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.IOException;
    import java.util.concurrent.TimeUnit;


	import PageObjects.LoginPage;
	import PageObjects.SearchPage;
	import PageObjects.Home_Page;
	import PageObjects.LoginPage;

	import org.apache.poi.hssf.usermodel.HSSFCell;
	import org.apache.poi.hssf.usermodel.HSSFSheet;
	import org.apache.poi.hssf.usermodel.HSSFWorkbook;
	import org.apache.poi.ss.usermodel.Cell;
	import org.omg.CORBA_2_3.portable.InputStream;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	



	import PageObjects.LoginPage;
	import PageObjects.SearchPage;
	

	public class PageObjectModel  {

		private static WebDriver driver = null;
	    private static HSSFWorkbook workbook;
	    private static HSSFSheet sheet;
	    private static HSSFCell cell;
	   

		public static void main(String[] args) throws InterruptedException, IOException {
	   
	    	
	 		File src=new File("C:\\Users\\anhtl\\Desktop\\1.xls");		  
	 		// Load the file.
	 		FileInputStream fis = new FileInputStream(src);
	 		// Load he workbook.
	 		workbook = new HSSFWorkbook(fis);
	 		// Load the sheet in which data is stored.
	 		sheet= workbook.getSheetAt(0);
	 		FileOutputStream fos = new FileOutputStream(src);
	    	
	    	
	    
//Step Open Google
			
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.get("https://www.google.com/");
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
	    
	    
//1.Login to google home page
		     Home_Page.lnk_Signin(driver).click(); 
		     LoginPage.txtbx_EmailOrPhone(driver).sendKeys("mindy.kenz@gmail.com"); 
		     LoginPage.btn_Next(driver).click();
		     Thread.sleep(2000);
		     LoginPage.txtbx_Password(driver).sendKeys("753869123");
		     LoginPage.btn_LogIn(driver).click();  
		     Thread.sleep(2000);
	    
	     
	     
//2. Enter any Keyword (Load by DataDriven).
	 		for(int i=1; i<=sheet.getLastRowNum(); i++){
	 				
	 				// Step Read Keyword from xls file
	 				cell = sheet.getRow(i).getCell(0);
	 				cell.setCellType(Cell.CELL_TYPE_STRING);
	 				driver.findElement(By.id("lst-ib")).clear();
	 				driver.findElement(By.id("lst-ib")).sendKeys(cell.getStringCellValue());
	 				
	 				
//3. Click OK button
	 				driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
	 				Thread.sleep(4000);
	 				driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/h3")).click();
	 				Thread.sleep(2000);
	 				
	 				
//4. Verify the 1st search result contain this Keyword.
	 				cell = sheet.getRow(i).getCell(1);
	 				cell.setCellType(Cell.CELL_TYPE_STRING);
	 				
	 				if(SearchPage.Verify_Tiltle(driver)==cell.getStringCellValue()) {
		 			   System.out.println("Case "+ i + ": Pass");
	 				}
	 				else
	 				{
	 					System.out.println("Case "+ i + ": Fail");
	 				}
	 				Thread.sleep(1000);
	 			    driver.get("https://www.google.com/");
	 		}
	 		
	    System.out.println("Finish");

	    driver.quit();

	   

	    }

}
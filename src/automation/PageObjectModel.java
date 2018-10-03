

package automation;

    import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.util.concurrent.TimeUnit;

	import org.testng.Assert;

	import PageObjects.LoginPage;
	import PageObjects.SearchPage;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.omg.CORBA_2_3.portable.InputStream;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Sleeper;
	import org.openqa.selenium.support.ui.WebDriverWait;

	


//Import cac class de lay thuoc tinh 

	import PageObjects.LoginPage;
	import PageObjects.SearchPage;
	

	public class PageObjectModel  {

     private static WebDriver driver = null;
     
     static XSSFWorkbook workbook;
 	 static XSSFSheet sheet;
 	static XSSFCell cell;
     
     
     public void BeforeTest(){ 
    	//Setup
    	 
    	     }	

     public static void main(String[] args) throws InterruptedException, IOException {
    	 
    	 System.setProperty("webdriver.chrome.driver","F:\\Webdriver\\chromedriver_win32\\chromedriver.exe");
    	 System.setProperty("webdriver.gecko.driver","C:\\Users\\anhtl\\Downloads\\geckodriver-v0.22.0-win64\\geckodriver.exe");

    	     WebDriver driver = new ChromeDriver();
    	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Wait time
    	     driver.get("https://www.google.com");  // Navigate Google
    	     driver.manage().window().maximize();
    	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Wait time
    	 
    	 //Start
    	 /*SearchPage.Btn_SignIn(driver).click();
         Thread.sleep(2000);
         LoginPage.txtbx_EmailOrPhone(driver).sendKeys("mindy.kenz@gmail.com");
         LoginPage.btn_Next(driver).click();
         Thread.sleep(2000);
         LoginPage.txtbx_Password(driver).sendKeys("753869123");
         LoginPage.btn_LogIn(driver).click();
         Thread.sleep(2000);*/
    	
    	 
    	
 		
 	// Import excel sheet.
 		 File src = new File("C:\\Users\\anhtl\\Desktop\\TestData.xlsx");
 		 
 		 // Load the file.
 		 FileInputStream finput = new FileInputStream(src);
 		 
 		 // Load he workbook.
 		workbook = new XSSFWorkbook(finput);
 		 
 	     // Load the sheet in which data is stored.
 		 sheet= workbook.getSheetAt(0);
 				
 	     System.out.println("quá trình xong");

 			for(int i=1; i<=sheet.getLastRowNum(); i++){
 				
 				 
 				// Import data for keyword
 				cell = sheet.getRow(i).getCell(1);
 				XSSFRichTextString key = cell.getRichStringCellValue();
 				SearchPage.Search_Input(driver).sendKeys(cell.toString());
 				
 				
 				
 			    SearchPage.Btn_Search(driver).sendKeys(Keys.ENTER);
 			  //  Assert.assertEquals("Page Object Model (POM) & Page Factory in Selenium: Complete Tutorial", SearchPage.Verify_Tiltle(driver));    
 			}
    	 

     /*SearchPage.Search_Input(driver).sendKeys("Selenium");
     SearchPage.Btn_Search(driver).sendKeys(Keys.ENTER);*/
     
 

/*     Assert.assertEquals("Enabling Open Innovation & Collaboration | The Eclipse Foundation", SearchPage.Verify_Tiltle(driver));    
*/
     System.out.println("quá trình xong");

     driver.quit();

     }

}
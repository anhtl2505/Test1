 package PageObjects;

import org.openqa.selenium.*;

public class SearchPage {

        private static WebElement element = null;
        
//Get element Button Sign in
    public static WebElement Btn_SignIn(WebDriver driver){
         element = driver.findElement(By.id("gb_70"));
         return element;}
    
//Get element Search_Input
    public static WebElement Search_Input(WebDriver driver){
        element = driver.findElement(By.id("lst-ib"));
        return element;}
    
//Get element Button Search
    public static WebElement Btn_Search(WebDriver driver){
        element = driver.findElement(By.name("btnK")); 
        return element;}
    
//Get tiltle page
    public static String Verify_Tiltle(WebDriver driver){
    	String element = driver.getTitle();
        return element;}
    
//Get element hyperlink
    public static WebElement Hyperlink_Click1(WebDriver driver){
   	 	element = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div/h3")); 
	    return element;}
}
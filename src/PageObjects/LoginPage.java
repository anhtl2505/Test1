 package PageObjects;

import org.openqa.selenium.*;

public class LoginPage {

        private static WebElement element = null;
        
//Get element Textbox Email
    public static WebElement txtbx_EmailOrPhone(WebDriver driver){
         element = driver.findElement(By.id("identifierId"));
         return element;}
    
//Get element Button Next
    public static WebElement btn_Next(WebDriver driver){
    	element = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/content/span"));
    	return element;}
    
//Get element Textbox Password
     public static WebElement txtbx_Password(WebDriver driver){
    	element = driver.findElement(By.className("whsOnd"));
        return element;}   
     
//Get element Button Login
     public static WebElement btn_LogIn(WebDriver driver){
    	 element = driver.findElement(By.cssSelector("#passwordNext > content > span"));
    	 return element;}

}
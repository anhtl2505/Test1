package PageObjects;


    import org.openqa.selenium.By;

    import org.openqa.selenium.WebDriver;

    import org.openqa.selenium.WebElement;

 public class Home_Page {

    private static WebElement element = null;
 // Get element button SignIn
 public static WebElement lnk_Signin(WebDriver driver){

    element = driver.findElement(By.id("gb_70"));
    return element;

    }

}
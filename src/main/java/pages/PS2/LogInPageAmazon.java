package pages.PS2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPageAmazon {
    WebDriver driver;
    public LogInPageAmazon(WebDriver driver){
        this.driver = driver;
    }
    public void EnterPhoneNo(String phone){
        driver.findElement(By.cssSelector("input#ap_email")).sendKeys(phone);
    }
    public void clickContinue(){
        driver.findElement(By.cssSelector("input#continue")).click();
    }
    public void EnterPassword(String pass){
        driver.findElement(By.cssSelector("input#ap_password")).sendKeys(pass);
    }
    public void SignIn(){
        driver.findElement(By.cssSelector("input#signInSubmit")).click();
    }
    public void loginAmazon(String phone,String pass){
        EnterPhoneNo(phone);
        clickContinue();
        EnterPassword(pass);
        SignIn();
    }
}

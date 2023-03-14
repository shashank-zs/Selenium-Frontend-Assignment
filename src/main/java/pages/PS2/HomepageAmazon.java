package pages.PS2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomepageAmazon {
        WebDriver driver;
        public HomepageAmazon(WebDriver driver){
            this.driver = driver;
        }
        public void clickSignIn(){
            driver.findElement(By.cssSelector("span#nav-link-accountList-nav-line-1")).click();
        }
        public void setSearch(String text){
            driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys(text);
        }
        public void clickSearch(){
            driver.findElement(By.cssSelector("input#nav-search-submit-button")).click();
        }

        public void homepage(String text){
            clickSignIn();
            LogInPageAmazon logIn = new LogInPageAmazon(driver);
            logIn.loginAmazon("9380329046","shashank123");
            setSearch(text);
            clickSearch();

        }
}

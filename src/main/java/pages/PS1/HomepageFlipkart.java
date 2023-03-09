package pages.PS1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomepageFlipkart {
    WebDriver driver;
    public HomepageFlipkart(WebDriver driver){
        this.driver = driver;
    }
    public void clickCross(){
        driver.findElement(By.xpath("//button[@class=\"_2KpZ6l _2doB4z\"]")).click();
    }
    public void setSearch(String text){
        driver.findElement(By.xpath("//input[@class=\"_3704LK\"]")).sendKeys(text);
    }
    public void clickSearch(){
        driver.findElement(By.xpath("//button[@class=\"L0Z3Pu\"]")).click();
    }
    public void SearchingMobilePhone(String text){
        this.clickCross();
        this.setSearch( text);
        this.clickSearch();
    }

}

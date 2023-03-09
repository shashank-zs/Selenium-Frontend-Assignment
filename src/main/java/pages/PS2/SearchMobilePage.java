package pages.PS2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;


public class SearchMobilePage {
    WebDriver driver;

    public SearchMobilePage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickFilter(){
        driver.findElement(By.xpath("//span[contains(text(),'64 GB')]")).click();
    }

    public void AddtoCart() {
        driver.findElement(By.cssSelector("input#add-to-cart-button")).click();
    }

    public void checkCart() {
        driver.findElement(By.cssSelector("span#attach-sidesheet-view-cart-button")).click();
    }
    public void Quantity(){
        if (!driver.findElement(By.cssSelector("span[class=\"a-dropdown-prompt\"]")).getText().equals(1)){
            driver.findElement(By.cssSelector("span[class=\"a-dropdown-prompt\"]")).click();
            driver.findElement(By.cssSelector("a#quantity_1")).click();
        }
    }
    public void checkItemInCart() {
        List<WebElement> list1 = driver.findElements(By.xpath("span.a-truncate-cut"));
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).getText().contains("64GB")) {
                Assert.assertEquals("Apple iPhone 12 (64GB)",list1.get(i).getText().substring(0,22));
            }
        }
    }
    public void Proceed() {
        driver.findElement(By.cssSelector("span#sc-buy-box-ptc-button")).click();
    }

    public void clickFirstAfterFilter(){
        driver.findElement(By.xpath("(//span[@class=\"a-size-medium a-color-base a-text-normal\"])[1]")).click();
    }

    public void switchToNewWindow(){
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
        public void mobiles() {
        clickFilter();
        clickFirstAfterFilter();
        switchToNewWindow();
        String phoneTitle=driver.findElement(By.cssSelector("span#productTitle")).getText();
            if (phoneTitle.contains("64GB")){
                AddtoCart();
                checkCart();
                Quantity();
                checkItemInCart();
                Proceed();

            }
            else{
                Assert.assertEquals(phoneTitle.substring(0,23),"Apple iPhone 12 (64GB)");
            }

        }
    }




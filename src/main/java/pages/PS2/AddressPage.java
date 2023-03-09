package pages.PS2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddressPage {
    WebDriver driver;
    public AddressPage(WebDriver driver){
        this.driver = driver;
    }
    public void ChangeAddress() {
        driver.findElement(By.cssSelector("a#addressChangeLinkId")).click();
    }
    public void addAddress() {
        driver.findElement(By.cssSelector("a#add-new-address-popover-link")).isDisplayed();
        driver.findElement(By.cssSelector("a#add-new-address-popover-link")).click();

    }
    public void EnterName(String name){
        driver.findElement(By.cssSelector("input#address-ui-widgets-enterAddressFullName")).sendKeys(name);
    }
    public void Enterphone(String phone){
        driver.findElement(By.cssSelector("input#address-ui-widgets-enterAddressPhoneNumber")).sendKeys(phone);
    }
    public void EnterpostalCode(String postalCode){
        driver.findElement(By.cssSelector("input#address-ui-widgets-enterAddressPostalCode")).sendKeys(postalCode);
    }
    public void EnterAddress(String Address){
        driver.findElement(By.cssSelector("input#address-ui-widgets-enterAddressLine1")).sendKeys(Address);
    }

    public void AddThatAddress(){
        driver.findElement(By.cssSelector("span#address-ui-widgets-form-submit-button")).click();
    }
    public void checkCheckout(){
        Assert.assertEquals(driver.getTitle(),"Amazon.in Checkout");

    }
    public void AddNewAddress(String name,String phone,String postal,String address) throws InterruptedException {
        ChangeAddress();
        addAddress();
        EnterName(name);
        Enterphone(phone);
        EnterpostalCode(postal);
        Thread.sleep(2000);
        EnterAddress(address);
        AddThatAddress();
        checkCheckout();


    }








}

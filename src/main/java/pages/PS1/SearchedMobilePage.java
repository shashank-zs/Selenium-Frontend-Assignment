package pages.PS1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchedMobilePage {
    WebDriver driver;
    public SearchedMobilePage(WebDriver driver){
        this.driver = driver;
    }
    public Map<String,String> mobileWithPrice(){
        List<WebElement> list = driver.findElements(By.xpath("//div[@class=\"_4rR01T\"]"));
        List<WebElement> list2 = driver.findElements(By.xpath(" //div[@class=\"_30jeq3 _1_WHN1\"]"));
        Map<String,String> phonePrice=new HashMap<>();
        for (int i=0;i<list.size();i++){
            phonePrice.put(list.get(i).getText(),list2.get(i).getText());
        }
        return  phonePrice;
    }
}

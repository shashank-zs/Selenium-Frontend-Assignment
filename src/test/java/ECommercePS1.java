import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.utils.excelWriter;
import org.utils.webDriverUtils;
import pages.PS1.HomepageFlipkart;
import pages.PS1.SearchedMobilePage;

import java.io.IOException;
import java.util.Map;

import static org.utils.dataPath.URL_FOR_FLIPKART;

public class ECommercePS1 {
    @Test

    public void problem1() throws IOException, InvalidFormatException {
        webDriverUtils webd =new webDriverUtils();
        webd.browserOpen();
        WebDriver driver = webd.driver;
        driver.get(URL_FOR_FLIPKART);
        HomepageFlipkart objHomepage = new HomepageFlipkart(driver);
        objHomepage.SearchingMobilekPhone("Mobile Phones");
        SearchedMobilePage objMobiles = new SearchedMobilePage(driver);
        Map<String, String> PhoneWithPrice = objMobiles.mobileWithPrice();
        excelWriter dataStored= new excelWriter();
        dataStored.excelWrite(PhoneWithPrice);
    }
}

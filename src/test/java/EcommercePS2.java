import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.utils.webDriverUtils;
import pages.PS2.AddressPage;
import pages.PS2.HomepageAmazon;
import pages.PS2.SearchMobilePage;

import static org.utils.dataPath.URL_FOR_AMAZON;

public class EcommercePS2 {
    @Test

    public void problem2() throws InterruptedException {
        webDriverUtils webd = new webDriverUtils();
        webd.browserOpen();
        WebDriver driver = webd.driver;
        driver.get(URL_FOR_AMAZON);
        HomepageAmazon objHomepage = new HomepageAmazon(driver);
        objHomepage.homepage("iphone 12 ");
        SearchMobilePage mobileWith64 = new SearchMobilePage(driver);
        mobileWith64.mobiles();
        AddressPage addAddress= new AddressPage(driver);
        addAddress.AddNewAddress("shashank","9380329046","560072","kishore building , 3rd main 4th cross , radha reddy layout");
    }
}

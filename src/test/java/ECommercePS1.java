import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
        System.out.println("shashank");
        String shan="jing";
        Assert.assertEquals("jindg",shan);
    }
}

import com.qa.utils.AdvancedExcelUtils;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.pojoForPostStore;

import java.io.IOException;

import static com.qa.utils.DataPath.*;
import static com.qa.utils.Generic.postApiCall;
import static com.qa.utils.testUtil.getSerialization;

public class Store {
    @DataProvider(name = "dataProvider")
    public Object[][] DataProviderForFunctionalEmployee() throws IOException {
        return AdvancedExcelUtils.getDataXssf(DATAPATH_FOR_STORE_EXCEL, SHEETNAME_FOR_STORE);
    }
    @Test(dataProvider = "dataProvider")
    public void postStore(Object id,Object petId,Object quantity ,Object shipDate ,Object status,Object complete,Object testCase) {
        pojoForPostStore postStore = new pojoForPostStore(id,petId,quantity,shipDate,status,complete);
        String payload = getSerialization(postStore);
        System.out.println(payload);
        Response response = postApiCall(payload,BASE_URL_STORE);
        response.then().log().all();
    }
}

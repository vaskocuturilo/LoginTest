package tests;

import driver.DriveMaster;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.ReceiptPage;
import page.SignUpPage;
import ru.yandex.qatools.allure.annotations.Title;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.PropertiesReader.loadProperty;
import static utils.DataProviders.getCellData;

public class SignUpWithIncorrectData extends DriveMaster {

    @DataProvider
    public Object[][] getNegativeExcelData() throws Exception {
        return getCellData(loadProperty("NegativePath"), "Sheet1");
    }


    @Title("Negative login test")
    @Test(description = "Negative login test", testName = "Negative login test", dataProvider = "getNegativeExcelData")
    public void negativeLoginTest(String login, String password, String header) {
        SignUpPage signUpPage = new SignUpPage(driver);
        assertTrue(signUpPage.isInit());
        signUpPage.doLogin(login, password);
        ReceiptPage receiptPage = signUpPage.doSubmit();
        assertTrue(receiptPage.isInit());
        assertEquals(header, receiptPage.confirmationHeader());
        signUpPage.doLogout();
    }
}

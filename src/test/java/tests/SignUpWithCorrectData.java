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

public class SignUpWithCorrectData extends DriveMaster {

    @DataProvider
    public Object[][] getPositiveExcelData() throws Exception {
        return getCellData(loadProperty("PositivePath"), "Sheet1");
    }

    @Title("Positive login test")
    @Test(description = "Positive login test", testName = "Positive login test", dataProvider = "getPositiveExcelData")
    public void testPositiveLogin(String login, String password, String header) {
        SignUpPage signUpPage = new SignUpPage(driver);
        assertTrue(signUpPage.isInit());
        signUpPage.doLogin(login, password);
        ReceiptPage receiptPage = signUpPage.doSubmit();
        assertTrue(receiptPage.isInit());
        assertEquals(header, receiptPage.confirmationHeader());
        signUpPage.doLogout();
    }
}

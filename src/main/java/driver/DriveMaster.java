package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static utils.PropertiesReader.loadProperty;

/**
 * Class Drive master.
 */
public class DriveMaster {
    /**
     * Value webDriverThreadLocal.
     */
    private final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    /**
     * Constant DELAY.
     */
    private static final int DELAY = 10;
    /**
     * Value driver.
     */
    protected WebDriver driver;

    /**
     * Method Start.
     *
     * @throws Exception the exception
     */
    @BeforeTest
    public void start() {
        if (webDriverThreadLocal.get() != null) {
            driver = webDriverThreadLocal.get();
            return;
        }
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(loadProperty("URL"));
        driver.manage().timeouts().implicitlyWait(DELAY, TimeUnit.SECONDS);
        webDriverThreadLocal.set(driver);
    }

    /**
     * Method Stop.
     */
    @AfterTest
    public void stop() {
        if (driver != null) {
            driver.close();
        }
    }

}

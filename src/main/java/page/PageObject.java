package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Class Page object.
 */
class PageObject {
    /**
     * Value driver.
     */
    WebDriver driver;

    /**
     * Instantiates a new Page object.
     *
     * @param driver the driver
     */
    PageObject(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}

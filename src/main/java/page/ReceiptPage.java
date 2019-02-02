package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Class Receipt page.
 */
public class ReceiptPage extends PageObject {

    /**
     * FindBy annotation header.
     */
    @FindBy(tagName = "p")
    private WebElement header;

    /**
     * Instantiates a new Receipt page.
     *
     * @param driver the driver
     */
    ReceiptPage(final WebDriver driver) {
        super(driver);
    }

    /**
     * Is init boolean.
     *
     * @return the boolean
     */
    public boolean isInit() {
        return header.isDisplayed();
    }

    /**
     * Method confirmationHeader.
     *
     * @return the string
     */
    public String confirmationHeader() {
        return header.getText();
    }

}

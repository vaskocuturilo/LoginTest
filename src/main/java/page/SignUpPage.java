package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Class Sign up page.
 */
public class SignUpPage extends PageObject {

    /**
     * FindBy annotation login.
     */
    @FindBy(name = "login_field")
    private WebElement login;

    /**
     * FindBy annotation password.
     */
    @FindBy(name = "password_field")
    private WebElement password;

    /**
     * FindBy annotation loginButton.
     */
    @FindBy(id = "login_click")
    private WebElement loginButton;

    /**
     * FindBy annotation logoutLink.
     */
    @FindBy(css = ".content > a")
    private WebElement logoutLink;

    /**
     * Instantiates a new Sign up page.
     *
     * @param driver the driver
     */
    public SignUpPage(final WebDriver driver) {
        super(driver);

    }

    /**
     * Is init boolean.
     *
     * @return the boolean
     */
    @Step
    public boolean isInit() {
        return login.isDisplayed();
    }

    /**
     * Method doLogin.
     *
     * @param login    the login
     * @param password the password
     */
    @Step
    public void doLogin(final String login, final String password) {
        this.login.clear();
        this.login.sendKeys(login);

        this.password.clear();
        this.password.sendKeys(password);

    }

    /**
     * Method doLogout.
     */
    @Step
    public void doLogout() {
        this.logoutLink.click();

    }

    /**
     * Method doSubmit.
     *
     * @return the receipt page
     */
    @Step
    public ReceiptPage doSubmit() {
        this.loginButton.click();
        return new ReceiptPage(driver);
    }
}

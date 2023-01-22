package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement enterUsernameField;
    @FindBy(id = "password")
    private WebElement enterPasswordField;
    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement loginNotApprovedMessage;

    public LoginPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public void login(String username, String password) {
        enterUsernameField.clear();
        enterPasswordField.clear();
        enterUsernameField.sendKeys(username);
        enterPasswordField.sendKeys(password);
        loginButton.click();
    }

    public String getMessageloginNotApproved() {
        return loginNotApprovedMessage.getText();
    }
}

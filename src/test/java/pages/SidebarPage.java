package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SidebarPage extends BasePage {
    @FindBy(id = "react-burger-menu-btn")
    private WebElement sidebar;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    public SidebarPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public void logOut() {
        sidebar.click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        logoutButton.click();
    }
}

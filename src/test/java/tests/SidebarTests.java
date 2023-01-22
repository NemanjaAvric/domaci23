package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SidebarPage;

public class SidebarTests extends BaseTest {

    private SidebarPage sidebarPage;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        sidebarPage = new SidebarPage(driver, webDriverWait);
    }

    @BeforeMethod
    public void setUp() {
        super.setUp();
        loginPage.login("standard_user", "secret_sauce");
        driver.manage().window().fullscreen();
    }

    @Test
    public void testLogOutButton() {
        sidebarPage.logOut();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        driver.navigate().refresh();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        driver.get("https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3")).getText(), "Epic sadface: You can only access '/inventory.html' when you are logged in.");
    }
}

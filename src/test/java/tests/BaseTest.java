package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected LoginPage loginPage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.driver.chromedriver", "C:\\Nova fascikla\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        loginPage = new LoginPage(driver, webDriverWait);
    }

    @BeforeMethod
    public void setUp() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Test
    public void loginStandardUser() {
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void loginStrandardUserWrongPassword() {
        loginPage.login("standard_user", "secret_hot_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.getMessageloginNotApproved().contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public void loginLockedOutUser() {
        loginPage.login("locked_out_user", "secret_hot_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/");
        Assert.assertTrue(loginPage.getMessageloginNotApproved().contains("Epic sadface: Username and password do not match any user in this service"));
    }
}

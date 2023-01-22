package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InventoryPage;

public class InventoryTests extends BaseTest {

    private InventoryPage inventoryPage;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        inventoryPage = new InventoryPage(driver, webDriverWait);
    }

    @BeforeMethod
    public void setUp() {
        super.setUp();
        loginPage.login("standard_user", "secret_sauce");
        driver.manage().window().fullscreen();
    }

    @Test
    public void testAddToCart() {
        inventoryPage.addToCart();
        Assert.assertEquals(inventoryPage.numberOfItemsInCart(), "1");
    }

    @Test
    public void testRemoveFromCart() {
        inventoryPage.removeFromCart();
        Assert.assertTrue(inventoryPage.getCart().isEmpty());
    }
}

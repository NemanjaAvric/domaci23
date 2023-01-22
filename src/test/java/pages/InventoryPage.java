package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasePage {
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;
    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement remove;

    @FindBy(className = "shopping_cart_link")
    private WebElement cart;
    @FindBy(className = "shopping_cart_badge")
    private WebElement numberOfItemsInCart;


    public InventoryPage(WebDriver driver, WebDriverWait webDriverWait) {
        super(driver, webDriverWait);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void removeFromCart() {
        remove.click();
    }

    public String numberOfItemsInCart() {
        return numberOfItemsInCart.getText();
    }

    public String getCart() {
        return cart.getText();
    }
}

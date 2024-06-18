package TestCases;

import Pages.P03_ShoppingCart;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC03_ShoppingCart extends TestBase {


    @Test(priority = 1, description = "Checkout Products")
    public void clickShoppingCart() {
        new P03_ShoppingCart(driver).clickOnShoppingCart();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/cart.html");
    }
}
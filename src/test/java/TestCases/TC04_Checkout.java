package TestCases;

import Pages.P04_Checkout;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_Checkout extends TestBase {


    @Test(priority = 1, description = "Checkout Products")
    public void clickCheckoutButton() {
        new P04_Checkout(driver).clickCheckoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/checkout-step-one.html");
    }
}
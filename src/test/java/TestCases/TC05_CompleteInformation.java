package TestCases;

import Pages.P05_CompleteInformation;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_CompleteInformation extends TestBase {


    @Test(priority = 1, description = "Checkout Products")
    public void clickContinueButton() {
        new P05_CompleteInformation(driver).inputFirstName("Reheem").inputLastName("Mahmoud").inputZipCode("10010").clickContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/checkout-step-two.html");
    }
}
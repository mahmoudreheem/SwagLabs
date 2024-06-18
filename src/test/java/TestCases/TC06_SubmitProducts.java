package TestCases;

import Pages.P01_LoginPage;
import Pages.P06_SubmitProducts;
import Util.Utility;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC06_SubmitProducts extends TestBase {

    @Test(priority = 1, description = "Login with Valid Username and Password")
    public void clickFinishButton() {
        new P06_SubmitProducts(driver).pressFinish();
       Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/checkout-complete.html");
    }
}
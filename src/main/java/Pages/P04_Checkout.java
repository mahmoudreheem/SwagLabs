package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Pages.PageBase.longWait;
import static org.junit.Assert.fail;

public class P04_Checkout {

    WebDriver driver;

    public P04_Checkout(WebDriver driver) {

        this.driver = driver;
    }

    private final By CHECKOUT_BUTTON = By.xpath("(//a[@href=\"./checkout-step-one.html\"])");

    public P04_Checkout clickCheckoutButton() {
        try{
            longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
        }catch (TimeoutException exception){
            fail("Element not found");
        }

        driver.findElement(this.CHECKOUT_BUTTON).click();
        return this;
    }
}

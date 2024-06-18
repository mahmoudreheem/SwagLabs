package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Pages.PageBase.*;
import static org.junit.Assert.fail;

public class P06_SubmitProducts {
    WebDriver driver;

    public P06_SubmitProducts(WebDriver driver) {

        this.driver = driver;
    }

    private final By FINISH_BUTTON = By.xpath("(//a[@class=\"btn_action cart_button\"])");


    public P06_SubmitProducts pressFinish() {
        try {
            longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(FINISH_BUTTON));
        } catch (TimeoutException exception) {
            fail("Element not found");
        }

        driver.findElement(this.FINISH_BUTTON).click();
        return this;
    }
}

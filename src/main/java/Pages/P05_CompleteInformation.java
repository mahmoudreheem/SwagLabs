package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Pages.PageBase.longWait;
import static org.junit.Assert.fail;

public class P05_CompleteInformation {

    WebDriver driver;

    public P05_CompleteInformation(WebDriver driver) {

        this.driver = driver;
    }

    private final By FIRST_NAME = By.xpath("(//input[@id=\"first-name\"])");
    private final By LAST_NAME = By.xpath("(//input[@id=\"last-name\"])");
    private final By ZIP_CODE = By.xpath("(//input[@id=\"postal-code\"])");
    private final By CONTINUE_BUTTON=By.xpath("(//input[@class=\"btn_primary cart_button\"])");


    public P05_CompleteInformation inputFirstName(String firstname) {
        try{
            longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(FIRST_NAME));
        }catch (TimeoutException exception){
            fail("Element not found");
        }

        driver.findElement(this.FIRST_NAME).sendKeys(firstname);
        return this;
    }

    public P05_CompleteInformation inputLastName(String lastname) {
        try{
            longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(LAST_NAME));
        }catch (TimeoutException exception){
            fail("Element not found");
        }

        driver.findElement(this.LAST_NAME).sendKeys(lastname);
        return this;
    }
    public P05_CompleteInformation inputZipCode(String zipcode) {
        try{
            longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(ZIP_CODE));
        }catch (TimeoutException exception){
            fail("Element not found");
        }

        driver.findElement(this.ZIP_CODE).sendKeys(zipcode);
        return this;
    }
    public P05_CompleteInformation clickContinueButton() {
        try{
            longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(CONTINUE_BUTTON));
        }catch (TimeoutException exception){
            fail("Element not found");
        }

        driver.findElement(this.CONTINUE_BUTTON).click();
        return this;
    }
}

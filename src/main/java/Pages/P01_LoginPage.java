package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Pages.PageBase.*;
import static org.junit.Assert.fail;

public class P01_LoginPage {

    //define webdriver
    //define constractur
    //define locators using By
    //define Action method for each locator
    WebDriver driver;

    public P01_LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    private final By EMAIL_TEXT = By.xpath("//input[@id=\"user-name\"]");
    private final By PASSWORD_TEXT = By.xpath("//input[@id=\"password\"]");
    private final By LOGIN_BUTTON = By.xpath("//input[@id=\"login-button\"]");
    private final By PRODUCT_TITLE = By.xpath("//div[@class=\"product_label\"]");
    private final By ADD_TO_CARD_BUTTON = By.xpath("(//button[@class=\"btn_primary btn_inventory\"])[1]");
    private final By ERROR_VALIDATION_MESSAGE= By.xpath("//*[@id=\"login_button_container\"]/div/form/h3");

    public P01_LoginPage inputEmail(String email) {
        try{
            longWait(driver).until(ExpectedConditions.visibilityOfElementLocated(EMAIL_TEXT));
        }catch (TimeoutException exception){
            fail("Element not found");
        }

        driver.findElement(this.EMAIL_TEXT).sendKeys(email);
        return this;
    }

    public P01_LoginPage inputPassword(String password) {
        // TODO: call explicit wait
        PageBase.explicitWaitForVisibility(driver,PASSWORD_TEXT);

        //TODO; perform action
        driver.findElement(this.PASSWORD_TEXT).sendKeys(password);
        return this;
    }

    public P01_LoginPage clickLoginButton() {
        try {
            shortWait(driver).until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON));
        }catch (TimeoutException exception){
            fail("Element not found");
        }
        driver.findElement(this.LOGIN_BUTTON).click();

        // TODO: wait for page load
        waitForPageLoad(driver);

        return this;
    }

    public boolean verifyLoginIsFailed() {
        return driver.findElement(this.ERROR_VALIDATION_MESSAGE).getText().contains("Epic sadface: ");
    }

    public String verifyLoginSuccess() {
        return driver.findElement(this.PRODUCT_TITLE).getText();
    }

    public boolean verifyAddButtonVisible() {
        return driver.findElement(ADD_TO_CARD_BUTTON).isDisplayed();
        //can choose multi method
        // return driver.findElement(ADD_TO_CARD_BUTTON).isEnabled();
        //in case assert on checkbox is Checked
        // return driver.findElement(ADD_TO_CARD_BUTTON).isSelected();
    }
}

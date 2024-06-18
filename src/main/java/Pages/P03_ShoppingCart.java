package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.fail;

public class P03_ShoppingCart {

    WebDriver driver;

    public  P03_ShoppingCart (WebDriver driver)
    {
        this.driver = driver;
    }

   private final By SHOPPING_CART= By.xpath("(//a[@href=\"./cart.html\"])");
    public P03_ShoppingCart clickOnShoppingCart() {
        driver.findElement(this.SHOPPING_CART).click();
        return this;
    }

}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static Pages.PageBase.shortWait;
import static Util.Utility.*;
import static org.junit.Assert.fail;

public class P02_Products {

    WebDriver driver;
    public static float total;
static int temp;

    public P02_Products(WebDriver driver) {
        this.driver = driver;
    }

    private final By PRODUCT_PAGE_TITLE_VISIBLE =By.xpath("//div[@class=\"product_label\"]");
    private final By ADD_TO_CART_VISIBLE=By.xpath("(//button[@class=\"btn_primary btn_inventory\"])[1]");
    public P02_Products addRandomProducts(int count) throws InterruptedException {
        temp=count;
        List<Integer> uniqueRandomNumbers = generateUniqueRandomNumbers(count);
        total=0;
        // 1,4,6,2
        for(int i=1;i<=count;i++){
            // click "add to card"
            try {
                shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(ADD_TO_CART_VISIBLE));
            }catch (TimeoutException exception){
                fail("Element not found");
            }
            driver.findElement(By.xpath("(//button[@class=\"btn_primary btn_inventory\"])["+uniqueRandomNumbers.get(i-1)+"]")).click();
            // store price
            total+=parsePriceFromString(driver.findElement(By.xpath("(//div[@class=\"inventory_item_price\"])["+uniqueRandomNumbers.get(i-1)+"]")).getText());

        }
        System.out.println("Total Price Is : " + total);
        try {
            shortWait(driver).until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_PAGE_TITLE_VISIBLE));
        }catch (TimeoutException exception){
            fail("Element not found");
        }
        return this;
    }

    public boolean VerifyProductSelected(){
        System.out.println("Temp Value : " + temp);
        return driver.findElements(By.xpath("(//button[@class=\"btn_secondary btn_inventory\"])")).size() ==temp;

    }

   // TODO: to be done next friday
public P02_Products removeRandomProducts(int count) throws InterruptedException {
        temp=count;
        List<Integer> removeRandomNumbers = generateUniqueRandomNumbers(count);
        total=0;
        // 1,4,6,2
        for(int i=1;i<=count;i++){
            // click "remove to card"
            driver.findElement(By.xpath("(//button[@class=\"btn_secondary btn_inventory\"])["+removeRandomNumbers.get(i-1)+"]")).click();
            // remove price
            total-=parsePriceFromString(driver.findElement(By.xpath("(//div[@class=\"inventory_item_price\"])["+removeRandomNumbers.get(i-1)+"]")).getText());

        }
        System.out.println("Total Price Is : " + total);
        Thread.sleep(5000);
        return this;
    }
}

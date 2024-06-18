package TestCases;

import Pages.P02_Products;
import Util.Utility;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_Product extends TestBase {


        @Test(priority = 1,description = "Select Random Product")
        public void SelectRandomProduct() throws InterruptedException {
            int number_product= Utility.generateUniqueRandomNumbers(1).get(0);
         new P02_Products(driver).addRandomProducts(number_product);
            System.out.println(number_product);
            Assert.assertTrue(new P02_Products(driver).VerifyProductSelected());

        }

    @Test(priority = 2,description = "Remove selected Product")
    public void RemoveProduct() throws InterruptedException {
        new P02_Products(driver).removeRandomProducts(1);

    }
}

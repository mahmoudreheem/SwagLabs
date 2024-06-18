package TestCases;

import Util.Utility;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.P01_LoginPage;

import java.io.IOException;

public class TC01_Login extends TestBase {

    // define test data
 // define string variable equal to read from json file method username and password
   String invaliduser="standard_userss";
   String invalidpassword ="secret_saucess";
   // String userfromjsonfile = Utility.getSingleJsonData(System.getProperty("user.dir")+"/src/test/resources/test_data/loginmultibledata.json","username");
  //  String passwordfromjsonfile = Utility.getSingleJsonData(System.getProperty("user.dir")+"/src/test/resources/test_data/loginmultibledata.json","password");
   String userfromexcel =Utility.getExcelData(0,0,"Sheet1");
    String passwordfromexcel=Utility.getExcelData(1,0,"Sheet1");

    public TC01_Login() throws IOException, ParseException {
    }

    // check login positive scenarios
    @Test(priority = 1, description = "Login with Valid Username and Password")
    public void loginWithValidData_P() {
        new P01_LoginPage(driver).inputEmail(userfromexcel).inputPassword(passwordfromexcel).clickLoginButton();
        Assert.assertEquals(new P01_LoginPage(driver).verifyLoginSuccess(), "Products");
        String Text = new P01_LoginPage(driver).verifyLoginSuccess();
        System.out.println("text is:"  + Text);
       Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/v1/inventory.html");

    }

    @Test(priority = 2, description = "Login with Invalid Username ")
    public void loginWithInvalidUserName_N() {
        new P01_LoginPage(driver).inputEmail(invaliduser).inputPassword(invalidpassword).clickLoginButton();
        Assert.assertTrue(new P01_LoginPage(driver).verifyLoginIsFailed());




    }}
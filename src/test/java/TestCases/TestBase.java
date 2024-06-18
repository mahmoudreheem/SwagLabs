package TestCases;

import Drivers.DriverFactory;
import Drivers.DriverHolder;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static Drivers.DriverHolder.driver;

public class TestBase {
 protected static WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    public void setupDriver(@Optional("chrome") String browser) throws Exception {
// start recording
        // MyScreenRecorder.startRecording("sprint1");
        driver = DriverFactory.getNewInstance(browser);
        DriverHolder.setDriver(driver);
        //set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7000));

        driver.get("https://www.saucedemo.com/v1/");
    }

    @AfterTest
    public void tearDown() {

        driver.quit();
      //Thread.currentThread().interrupt();
    }
}
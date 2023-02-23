import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {
    public WebDriver driver;

    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure();
            driver.close();
            driver.quit();
        }

        @Attachment("Screenshot on failure")
        public byte[] makeScreenshotOnFailure() {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        @Override
        protected void succeeded(Description description){
            driver.close();
            driver.quit();
        }
    };


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/C:/Users/anyut/Webdriver/chromedriver.exe");
        driver = new ChromeDriver();
        String BASE_URL = "https://www.saucedemo.com/";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public void TearDown() {
        if (driver!=null) {
            driver.quit();
        }
    }


    String username = "standard_user";

    String password = "secret_sauce";

    String lockedOut = "Locked_out_user";
    String passwordLocked = "secret_sauce";

    String userInvalid = "Locked_out_user1";
    String passwordInvalid = "secret_sauce";
}



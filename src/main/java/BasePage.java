import io.qameta.allure.Attachment;
//import org.junit.Rule;
import io.qameta.allure.Attachment;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    WebDriver driver;
    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure();
        }

        @Attachment("Screenshot on failure")
        public byte[] makeScreenshotOnFailure() {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
    };

    int waitTimeBeforeClick = 20;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterTextToElement(String text, WebElement element){
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public boolean allElementsOfCollectionAreDisplayed(List<WebElement> collection){
        for (WebElement element: collection) {
            if (!element.isDisplayed()){
                return false;
            }
        }
        return true;
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }


    public void clickOnTheElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeBeforeClick));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }


}

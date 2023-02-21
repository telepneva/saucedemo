import io.qameta.allure.Step;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepOnePage extends BasePage{

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement zipCode;

    @FindBy(id = "continue")
    private WebElement continueButton;



    @Step("Enter first name")
    public void enterFirstName(String name){
        enterTextToElement(name, firstName);
    }

    @Step("Enter last name")
    public void enterLastName(String lastNameValue){
        enterTextToElement(lastNameValue, lastName);
    }

    @Step("Enter xip code")
    public void enterZipCode(String zipValue){
        enterTextToElement(zipValue, zipCode);
    }

    @Step("Push continue button")
    public void pushContinueButton(){
        clickOnTheElement(continueButton);
    }
}

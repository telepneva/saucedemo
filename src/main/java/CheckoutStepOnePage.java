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




    public void enterFirstName(String name){
        enterTextToElement(name, firstName);
    }

    public void enterLastName(String lastNameValue){
        enterTextToElement(lastNameValue, lastName);
    }

    public void enterZipCode(String zipValue){
        enterTextToElement(zipValue, zipCode);
    }

    public void pushContinueButton(){
        clickOnTheElement(continueButton);
    }
}

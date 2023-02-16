import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
@FindBy(id = "checkout")
    private WebElement buttonCheckout;

    public boolean clickButtonCheckout(){
    return buttonCheckout.isDisplayed();
    }
}

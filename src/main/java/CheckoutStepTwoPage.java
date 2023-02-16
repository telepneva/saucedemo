import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
@Getter
public class CheckoutStepTwoPage extends BasePage {
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "cart_item_label")
    private List<WebElement> productsNames;


    public boolean checkProductCardsQuantity(int expectedQuantity) {
        //assertEquals("Product cards quantity is not equal to"+ expectedQuantity,productsCard.size());
        System.out.println(productsNames.size());
        return productsNames.size() == expectedQuantity;
    }
}
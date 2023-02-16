import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }
@FindBy(id = "checkout")
    private WebElement buttonCheckout;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> productsCard;

    @FindBy(className = "cart_item_label")
    private List<WebElement> productsName;



    public boolean clickButtonCheckout(){
    return buttonCheckout.isDisplayed();
    }
     public boolean checkProductCardsQuantity(int expectedQuantity){
       //assertEquals("Product cards quantity is not equal to"+ expectedQuantity,productsCard.size());
      return productsCard.size() == expectedQuantity;
     }

     public void clickOnCheckoutButton(){
        buttonCheckout.click();
     }

}

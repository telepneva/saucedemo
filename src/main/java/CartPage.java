import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
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

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement buttonRemoveCartPage;


    @Step("Checkout button is displayed")
    public boolean clickButtonCheckout(){
    return buttonCheckout.isDisplayed();
    }

    @Step("Get Quantity of products")
    public boolean checkProductCardsQuantity(int expectedQuantity){
       //assertEquals("Product cards quantity is not equal to"+ expectedQuantity,productsCard.size());
      return productsCard.size() == expectedQuantity;
     }

     @Step("Cart is empty")
     public boolean cartListIsEmptyNew(){
        boolean empty = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            wait.until(ExpectedConditions.visibilityOf(productsCard.get(0)));
            productsCard.get(0).isDisplayed();
        } catch (Exception e){
            empty = true;
        }
        return empty;
     }

     public void cartListIsEmpty(){ productsName.isEmpty();}

    @Step("Click on checkout button")
     public void clickOnCheckoutButton(){
        buttonCheckout.click();
     }

     public void clickButtonRemoveCartPage(){ buttonRemoveCartPage.click();}

}

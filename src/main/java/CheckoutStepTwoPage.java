import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.lang.Math.abs;
import static java.lang.Math.sin;
import static org.junit.Assert.assertEquals;

@Getter
public class CheckoutStepTwoPage extends BasePage {
    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "cart_item_label")
    private List<WebElement> productsNames;

    @FindBy(xpath = "//div[text()='29.99']")
    private WebElement priceSauceLabsBackpack;

    @FindBy(xpath = "//div[text()='9.99']")
    private WebElement priceBikeLight;

    @FindBy(xpath = "//div[text()='39.98']")
    private WebElement amountProductsInCart;

    //public int sumPriceInCart(Integer a, Integer b){

      //  return a+b;
    //}
    //public boolean sumPriceInCartExpected (int expectedSum, int a, int b){
      //  assertEquals(expectedSum,sumPriceInCart(a,b));
       // System.out.println();
    //}

    public boolean checkProductCardsQuantity(int expectedQuantity) {
        //assertEquals("Product cards quantity is not equal to"+ expectedQuantity,productsCard.size());
        System.out.println(productsNames.size());
        return productsNames.size() == expectedQuantity;
    }
}
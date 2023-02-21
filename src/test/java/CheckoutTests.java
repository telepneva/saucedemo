import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertTrue;

public class CheckoutTests extends TestBase{


   @Test
    public void checkQuantityProducts(){
       User user = new User(username, password);
       LoginPage loginPage = new LoginPage(driver);
       loginPage.login(user);
       InventoryPage inventoryPage = new InventoryPage(driver);
       inventoryPage.resetAppState();
       inventoryPage.clickOnToBackpack();
       inventoryPage.clickOnTheCartIcon();
       inventoryPage.clickOnAddToCartBikeLight();
       CartPage cartPage = new CartPage(driver);
       cartPage.clickOnCheckoutButton();
       CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
       checkoutStepOnePage.enterFirstName("Hanna");
       checkoutStepOnePage.enterLastName("Hallo");
       checkoutStepOnePage.enterZipCode("1525");
       checkoutStepOnePage.pushContinueButton();
       CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
       assertTrue(checkoutStepTwoPage.checkProductCardsQuantity(2));
       assertThat(checkoutStepTwoPage.getProductsNames(), hasSize(2));


    }
}

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class CartPageTests extends TestBase {
    @Test
    public void cartPageIsOpen(){
        User user = new User(username, password);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnTheSideBarOpenIcon();
        inventoryPage.resetAppClick();
        inventoryPage.clickOnTheSideBarCloseIcon();
        inventoryPage.refreshPage();

        inventoryPage.clickOnToBackpack();
        inventoryPage.clickOnTheCartIcon();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.clickButtonCheckout());
    }

    @Test
    public void addSeveralItems(){
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppStateIsDisplayed();
        inventoryPage.clickOnToBackpack();
        inventoryPage.clickOnAddToCartBikeLight();
        inventoryPage.clickSortCloseIcon();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.checkProductCardsQuantity(2));


    }
}

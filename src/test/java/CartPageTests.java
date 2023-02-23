import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class CartPageTests extends TestBase {
    @Test
    public void cartPageIsOpen() {
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
    public void addSeveralItems() {
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickOnToBackpack();
        inventoryPage.clickOnAddToCartBikeLight();
        inventoryPage.clickToTheBadge();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.checkProductCardsQuantity(2));
    }

    @Test
    public void cartIsEmpty() {
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickToTheBadge();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.cartListIsEmpty());
    }

    @Test
    public void cartIsEmptyNew() {
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickToTheBadge();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.cartListIsEmptyNew());

    }

    @Test
    public void cartIsEmptyAfterDelete() {
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickOnToBackpack();
        inventoryPage.clickToTheBadge();
        CartPage cartPage = new CartPage(driver);
        assertTrue(cartPage.checkProductCardsQuantity(1));
        cartPage.clickButtonRemoveCartPage();
        assertTrue(cartPage.cartListIsEmpty());

    }

    @Test
    public void checkTheAmountOfItemsInTheCart() {
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.resetAppState();
        inventoryPage.clickOnToBackpack();
        inventoryPage.clickOnAddToCartBikeLight();
        inventoryPage.clickToTheBadge();
        CartPage cartPage = new CartPage(driver);


    }
}

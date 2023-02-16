import org.junit.Test;

public class InventoryPageTest extends TestBase {
    @Test
    public void amountOfProducts() {
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkAllProductsAreDisplayed();
        inventoryPage.checkAmountOfProducts(6);

    }
    @Test
    public void amountOfProductsName() {
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkProductNameIsDisplayed();
        inventoryPage.checkProductTitleAmount(6);
        inventoryPage.checkProductNameIsNotEmpty();

    }
    @Test
    public void allElementsAreDisplayed(){
       User user = new User(username, password);
       new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkLogoIsDisplayed();
        inventoryPage.checkRobotIsDisplayed();
        inventoryPage.checkProductsNameIsDisplayed();
        inventoryPage.checkPriceIsDisplayed();
        inventoryPage.checkImgIsDisplayed();
        inventoryPage.setProductBadge();
    }
    //sort
    @Test
    public void allElementsSort(){
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.sort();
        inventoryPage.setSortNameAToZ();
        inventoryPage.setSortNameZToA();
        inventoryPage.setSortNameLohi();
        inventoryPage.setSortNameHilo();
        inventoryPage.clickSortCloseIcon();
    }


    //Footer
    @Test
    public void allElementsFooterAreDisplayed(){
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.checkTwitterLink();
        inventoryPage.checkFacebookLink();
        inventoryPage.checkTLinkedinLink();
        inventoryPage.checkRobotFooterLink();
        inventoryPage.checkFooterTextLink();

    }

    @Test
    public void sideBar() throws InterruptedException {
        User user = new User(username, password);
        new LoginPage(driver).login(user);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.clickOnTheSideBarOpenIcon();
        inventoryPage.allItimesIsDisplayed();
        inventoryPage.aboutIsDisplayed();
        inventoryPage.logoutIsDisplayed();
        inventoryPage.resetAppStateIsDisplayed();
        inventoryPage.clickOnTheSideBarCloseIcon();
        inventoryPage.setSideBarAllItimesisNotDisplayed();
    }

}









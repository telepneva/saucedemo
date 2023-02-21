import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.beust.jcommander.Strings.startsWith;
import static java.lang.Thread.sleep;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.Assert.*;

public class InventoryPage extends BasePage {

    //InventoryPageAllElements
    @FindBy(id = "inventory_container")
    WebElement inventoryList;

    @FindBy(css = "[class='inventory_item']")
    private List<WebElement> productCards;

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<WebElement> titleProducts;

    @FindBy(xpath = "//span[@class='title']")
    private WebElement titleAllProducts;

    @FindBy(xpath = "//img[@class='inventory_item_img']")
    private List<WebElement> imgProductsList;

    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement logoInventoryPage;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartContainer;

    @FindBy(className = "product_sort_container")
    private WebElement productSortContainer;

    @FindBy(className = "peek")
    private WebElement robot;

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    private List<WebElement> buttonAddToCardList;

    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> priseList;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement productBadge;

    //Sort
    @FindBy(xpath = "//option[@value='az']")
    private WebElement sortNameAToZ;
    @FindBy(xpath = "//option[@value='za']")
    private WebElement sortNameZToA;
    @FindBy(xpath = "//option[@value='lohi']")
    private WebElement sortNameLohi;
    @FindBy(xpath = "//option[@value='hilo']")
    private WebElement sortNameHilo;

    //Footer
    @FindBy(xpath = "//a[@href='https://twitter.com/saucelabs']")
    private WebElement twitterIconLink;

    @FindBy(xpath = "//a[@href='https://www.facebook.com/saucelabs']")
    private WebElement facebookIconLink;

    @FindBy(xpath = "//a[@href='https://www.linkedin.com/company/sauce-labs/']")
    private WebElement linkedinIconLink;

    @FindBy(xpath = "//img[@alt='Swag Bot Footer']")
    private WebElement robotFooter;

    @FindBy(xpath = "//div[@class='footer_copy']")
    private WebElement footerText;


    //sideBsrAllElements
    //@FindBy (xpath = "//div[@class='bm-burger-button']")
    @FindBy(id = "react-burger-menu-btn")
    private WebElement sideBarOpenIcon;

    @FindBy(xpath = "//div[@class='bm-cross-button']")
    private WebElement sideBarCloseIcon;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement sideBarAllItimes;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutSideBar;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logout;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetApp;

    //BackPack
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addOnToCartBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addBikeLightToCartButton;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addLabsBackPack;

    //Tests

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    //inventoryPageAllElements
    public void setInventoryListShouldBeDisplayed() {
        assertTrue(inventoryList.isDisplayed());
    }

    public void checkAllProductsAreDisplayed() {
        for (WebElement product : productCards) {
            assertTrue(product.isDisplayed());
        }
    }

    public void checkAmountOfProducts(int expectedAmount) {
        assertEquals("Amount of products is not" + expectedAmount, productCards.size(), expectedAmount);
    }

    public void checkProductNameIsDisplayed() {
        for (WebElement productTitle : titleProducts) {
            assertTrue(productTitle.isDisplayed());
        }
    }

    public void checkProductTitleAmount(int expectedAmount) {
        assertEquals("Amount of title products is not" + expectedAmount, titleProducts.size(), expectedAmount);
        //assertThat(titleProducts, hasSize(expectedAmount));
    }

    public void checkProductNameIsNotEmpty() {
        for (WebElement productTitle : titleProducts) {
            assertFalse(productTitle.getText().isEmpty());
        }
    }

    public void checkLogoIsDisplayed() {
        assertTrue(logoInventoryPage.isDisplayed());
    }

    public void checkRobotIsDisplayed() {
        assertTrue(robot.isDisplayed());
    }

    public void checkProductsNameIsDisplayed() {
        assertTrue(titleAllProducts.isDisplayed());
    }

    public void checkPriceIsDisplayed() {
        for (WebElement priseIsNotEmpty : priseList) {
            assertFalse(priseIsNotEmpty.getText().isEmpty());
        }
    }

    public void checkImgIsDisplayed() {
        assertTrue(robot.isDisplayed());
    }

    public void setProductBadge() {
        assertTrue(productBadge.isDisplayed());
    }
    public void clickToTheBadge(){
        productBadge.click();
    }


    //footer
    public void checkTwitterLink() {
        assertTrue(twitterIconLink.isDisplayed());
    }

    public void checkFacebookLink() {
        assertTrue(facebookIconLink.isDisplayed());
    }

    public void checkTLinkedinLink() {
        assertTrue(linkedinIconLink.isDisplayed());
    }

    public void checkRobotFooterLink() {
        assertTrue(robotFooter.isDisplayed());
    }

    public void checkFooterTextLink() {
        assertTrue(footerText.isDisplayed());
    }


    //sideBarAllElements
    public void clickOnTheSideBarOpenIcon() {
        {
            Actions actions = new Actions(driver);
            actions.moveToElement(sideBarOpenIcon).perform();
        }
        sideBarOpenIcon.click();
    }

    public void allItimesIsDisplayed() throws InterruptedException {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(ExpectedConditions.visibilityOf(sideBarAllItimes));
        //sleep(5000);
        assertTrue(sideBarAllItimes.isDisplayed());
    }

    public void aboutIsDisplayed() {
        assertTrue(aboutSideBar.isDisplayed());
        //assertThat(aboutSideBar.isDisplayed(),is(true));
        //assertThat(aboutSideBar.getAttribute("href"), startsWith("https//"));
   }

    public void logoutIsDisplayed() {
        assertTrue(logout.isDisplayed());
    }

    public void resetAppStateIsDisplayed() {
        assertTrue(resetApp.isDisplayed());
    }

    public void clickOnTheSideBarCloseIcon() {
        //{
          //  Actions actions = new Actions(driver);
            //actions.moveToElement(sideBarCloseIcon).perform();
        //}
        sideBarCloseIcon.click();
    }

    public void setSideBarAllItimesisNotDisplayed() {
        assertFalse(sideBarAllItimes.isDisplayed());
    }

        //sortAllElements
        public void sort() {
            productSortContainer.click();
        }
        public void setSortNameAToZ() {
            assertTrue(sortNameAToZ.isDisplayed());
        }
        public void setSortNameZToA() {
            assertTrue(sortNameZToA.isDisplayed());
        }
        public void setSortNameLohi() {
            assertTrue(sortNameLohi.isDisplayed());
        }
        public void setSortNameHilo() {
            assertTrue(sortNameHilo.isDisplayed());
        }
        public void clickSortCloseIcon() {
           // {
             //   Actions actions = new Actions(driver);
               // actions.moveToElement(productSortContainer).perform();
           // }
            productSortContainer.click();
        }

    public void clickOnToBackpack(){
        addOnToCartBackpack.click();
    }


    public void clickOnAddToCartBikeLight(){
        clickOnTheElement(addBikeLightToCartButton);
    }
    public void clickOnAddToLabsBackPack(){
        clickOnTheElement(addLabsBackPack);
    }

    public void clickOnTheCartIcon(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(productBadge));
        productBadge.click();
    }

    public void clickOnTheResetAppState(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(resetApp));
       resetApp.click();
    }
    public void resetAppClick(){
        resetApp.click();
    }

    public void resetAppState(){
        clickOnTheSideBarOpenIcon();
        clickOnTheResetAppState();
        clickOnTheSideBarCloseIcon();
        refreshPage();
    }



    }





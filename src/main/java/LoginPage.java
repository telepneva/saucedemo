import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {

    @FindBy(id= "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//h3[contains(text(), 'Epic sadface: Sorry, this user has been locked out.')]")
    private WebElement messageLockedUser;

    @FindBy(xpath = "//h3[contains(text(), 'Epic sadface: Username and password do not match any user in this service')]")
    private WebElement messageInvalidUser;

    @FindBy(css = "[class='login_logo']")
    WebElement logo;

    @FindBy(css = "[class='bot_column']")
    WebElement bot;

    @FindBy(id = "login_credentials")
    WebElement acceptedUsernamesAre;

    @FindBy(css = "[class='login_password']")
    WebElement passwordForAllUsers;


    public LoginPage (WebDriver driver){
        super(driver);
    }

    public void loginButtonShouldBeDisplayed(){
        assertTrue(loginButton.isDisplayed());
    }

    public void messageLockedUserShouldBeDisplayed(){
        assertTrue(messageLockedUser.getText().contains("Epic sadface: Sorry, this user has been locked out"));
    }

    public void messageInvalidUserShouldBeDisplayed(){
        assertTrue(messageInvalidUser.getText().contains("Epic sadface: Username and password do not match any user in this service"));
    }

    public boolean logoIsDisplayed(){
        return logo.isDisplayed();
    }

    public void fieldUsernameIsDisplayed(){
        assertTrue(userName.isDisplayed());
    }

    public void fieldPasswordIsDisplayed(){
        assertTrue(password.isDisplayed());
    }

    public void botIsDisplayed(){
        assertTrue(bot.isDisplayed());
    }

    public void acceptedUsernameAreIsDisplayed(){
        assertTrue(acceptedUsernamesAre.isDisplayed());
    }

    public void passwordForAllUsersIsDisplayed(){
        assertTrue(passwordForAllUsers.isDisplayed());
    }


    @Step
    public InventoryPage login(User user){
        enterTextToElement(user.getName(), userName);
        enterTextToElement(user.getPassword(), password);
        loginButton.click();
        return new InventoryPage(driver);
    }

    //public void loginWithValidate()

}

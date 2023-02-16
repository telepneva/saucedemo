import io.qameta.allure.Attachment;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginTest extends TestBase {


    @Test
    public void loginWithValidDate() {
        User user = new User(username, password);
        new LoginPage(driver).login(user).setInventoryListShouldBeDisplayed();
    }

    @Test
    public void allLoginPageElementsAreDisplayed(){
        LoginPage loginPage = new LoginPage(driver);
        assertTrue(loginPage.logoIsDisplayed());
        loginPage.fieldUsernameIsDisplayed();
        loginPage.fieldPasswordIsDisplayed();
        loginPage.botIsDisplayed();
        loginPage.loginButtonShouldBeDisplayed();
        loginPage.acceptedUsernameAreIsDisplayed();
        loginPage.passwordForAllUsersIsDisplayed();
    }



    @Test
    public void loginLockOut(){
        User user = new User (lockedOut, passwordLocked);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        loginPage.loginButtonShouldBeDisplayed();
        //loginPage.messageLockedUserShouldBeDisplayed();
    }

    @Test
    public void loginInvalid(){
        User user = new User (userInvalid, passwordInvalid);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(user);
        loginPage.loginButtonShouldBeDisplayed();
        loginPage.messageInvalidUserShouldBeDisplayed();
    }

}

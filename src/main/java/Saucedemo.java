import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Saucedemo {

    ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/C:/Users/anyut/chromedriver.exe");
        driver = new ChromeDriver();
        String BASE_URL = "https://www.saucedemo.com/\n";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(200));
        driver.manage().window().maximize();
    }

    @Test
    public void loginWithValueDate(){
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement submitButton = driver.findElement(By.cssSelector("[type='submit']"));
        submitButton.click();
        assertFalse(driver.getCurrentUrl().contains("result"));

        WebElement header = driver.findElement(By.cssSelector("[class=title]"));
        //assertEquals("Congratulations! You have successfully registered!", header.getText());
       // assertTrue("User is still on the registration page",header.getText().contains("Congratulations"));
        //System.out.println("Current URL:" + driver.getCurrentUrl());

    }

    @After
    public void TearDown() {
        driver.quit();
    }


}

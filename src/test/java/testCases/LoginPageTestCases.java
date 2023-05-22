package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageTestCases extends BasePage {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        loginPage = new LoginPage(driver);
    }
    @Test
    public void loginWithValidCredentials() throws InterruptedException{
        driver.findElement(By.id("login")).click();
        loginPage.enterUserName("TestUsername");
        loginPage.enterPassword("TestPassword1234@");
        loginPage.clickOnLoginButton();
        WebElement loggedInUserName = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id("userName-value")));
        Assert.assertTrue(loggedInUserName.isDisplayed(), "User is not logged in");
    }
}
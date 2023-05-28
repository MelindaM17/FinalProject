package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
    public void loginWithValidCredentialsAndClickOnLogin() throws InterruptedException{
        driver.findElement(By.id("login")).click();
        loginPage.enterUserName("TestUsername");
        loginPage.enterPassword("TestPassword1234@");
        loginPage.clickOnLoginButton();
        WebElement loggedInUserName = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id("userName-value")));
        Assert.assertTrue(loggedInUserName.isDisplayed(), "User is not logged in");
    }

    @Test
    public void loginWithValidCredentialsAndPressEnter() throws InterruptedException{
        driver.findElement(By.id("login")).click();
        loginPage.enterUserName("TestUsername");
        loginPage.enterPassword("TestPassword1234@");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
        WebElement loggedInUserName = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id("userName-value")));
        Assert.assertTrue(loggedInUserName.isDisplayed(), "User is not logged in");
    }
    @Test
    public void leaveUserNameFieldEmpty() throws InterruptedException{
        driver.findElement(By.id("login")).click();
        loginPage.enterPassword("TestPassword1234@");
        loginPage.clickOnLoginButton();
        WebElement userNameField = driver.findElement(By.id("userName"));
        Assert.assertEquals(userNameField.getAttribute("class"), "mr-sm-2 is-invalid form-control");
    }

    @Test
    public void leavePasswordFieldEmpty() throws InterruptedException{
        driver.findElement(By.id("login")).click();
        loginPage.enterUserName("TestUsername");
        loginPage.clickOnLoginButton();
        WebElement passwordField = driver.findElement(By.id("password"));
        Assert.assertEquals(passwordField.getAttribute("class"), "mr-sm-2 is-invalid form-control");
    }

    @Test
    public void writeIncorrectUsername() throws InterruptedException{
        driver.findElement(By.id("login")).click();
        loginPage.enterUserName("WrongUsername");
        loginPage.enterPassword("TestPassword1234@");
        loginPage.clickOnLoginButton();
        WebElement errorMessage = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id("name")));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
    }

    @Test
    public void writeIncorrectPassword() throws InterruptedException{
        driver.findElement(By.id("login")).click();
        loginPage.enterUserName("TestUsername");
        loginPage.enterPassword("IncorrectPassword");
        loginPage.clickOnLoginButton();
        WebElement errorMessage = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.id("name")));
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed");
    }
    @Test
    public void redirectToRegisterPage() throws InterruptedException{
        driver.findElement(By.id("login")).click();
        loginPage.clickOnNewUserButton();
        Assert.assertTrue(driver.getPageSource().contains("Register to Book Store"));
    }

}
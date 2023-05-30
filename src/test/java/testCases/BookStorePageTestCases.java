package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.BookStorePage;
import pages.LoginPage;

import java.time.Duration;

public class BookStorePageTestCases extends BasePage {
    private BookStorePage bookStorePage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        bookStorePage = new BookStorePage(driver);
    }
    @Test
    public void clickOnFirstBook() throws InterruptedException {
        driver.manage().window().maximize();
        bookStorePage.clickOnBook1();
        Assert.assertTrue(driver.getPageSource().contains("This pocket guide is the perfect on-the-job companion to Git"));
    }

    @Test
    public void clickOnSecondBook() throws InterruptedException {
        driver.manage().window().maximize();
        bookStorePage.clickOnBook2();
        Assert.assertTrue(driver.getPageSource().contains("A JavaScript and jQuery Developer's Guide"));
    }
    @Test
    public void searchForFirstBook() throws InterruptedException {
        bookStorePage.searchForBook("Git");
        Assert.assertTrue(driver.getPageSource().contains("Git Pocket Guide"));
    }
    @Test
    public void searchForFirstBookThenClearSearchBox() throws InterruptedException {
        bookStorePage.searchForBook("Git");
        Assert.assertTrue(driver.getPageSource().contains("Git Pocket Guide"));

        driver.findElement(By.id("searchBox")).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.id("searchBox")).sendKeys(Keys.DELETE);
        Assert.assertTrue(driver.getPageSource().contains("Learning JavaScript"));
    }
}
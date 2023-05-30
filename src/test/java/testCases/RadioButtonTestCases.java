package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.RadioButtonPage;
import java.time.Duration;
import static org.testng.Assert.assertEquals;

public class RadioButtonTestCases extends BasePage {
    private RadioButtonPage radioButtonPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        radioButtonPage = new RadioButtonPage(driver);
    }

    @Test
    public void selectYesButton() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement radioButtonMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-2\"]/span")));
        radioButtonMenu.click();
        radioButtonPage.clickOnYesButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-success")));

        String actualMessage = messageElement.getText();
        String expectedMessage = "Yes";
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void selectImpressiveButton() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement radioButtonMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-2\"]/span")));
        radioButtonMenu.click();
        radioButtonPage.clickOnImpressiveButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-success")));

        String actualMessage = messageElement.getText();
        String expectedMessage = "Impressive";
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void verifyNoButtonIsDisabled() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement radioButtonMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-2\"]/span")));
        radioButtonMenu.click();
        radioButtonPage.clickOnNoButton();

        WebElement noButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[4]/label"));
        boolean isNoButtonDisabled = false;
        if (!noButton.isSelected()) {
            isNoButtonDisabled = true;
        }
        Assert.assertTrue(isNoButtonDisabled);
    }

    @Test
    public void selectYesThenImpressiveButton() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement radioButtonMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-2\"]/span")));
        radioButtonMenu.click();
        radioButtonPage.clickOnYesButton();
        radioButtonPage.clickOnImpressiveButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("text-success")));

        String actualMessage = messageElement.getText();
        String expectedMessage = "Impressive";
        assertEquals(expectedMessage, actualMessage);
    }
}


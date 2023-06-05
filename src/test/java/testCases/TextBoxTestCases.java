package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.TextBoxPage;

import java.time.Duration;

public class TextBoxTestCases extends BasePage {
    private TextBoxPage textBoxPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        textBoxPage = new TextBoxPage(driver);
    }

    @Test
    public void submitEmptyForm() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement textBoxMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-0\"]")));
        textBoxMenu.click();
        textBoxPage.clickOnSubmitButton();

        try {
            WebElement nameMessage = driver.findElement(By.id("name"));
            WebElement emailMessage = driver.findElement(By.id("email"));
            WebElement currentAddressMessage = driver.findElement(By.cssSelector("output[id=currentAddress][class=mb-1]"));
            WebElement permanentAddressMessage = driver.findElement(By.cssSelector("output[id=permanentAddress][class=mb-1]"));
        } catch (Exception e) {
            System.out.println("No messages are displayed");
        }
    }

    @Test
    public void submitFullNameOnly() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement textBoxMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-0\"]")));
        textBoxMenu.click();
        textBoxPage.enterFullName("John Smith");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(driver.getPageSource().contains("John Smith"));
    }

    @Test
    public void submitFullNameWithNumbers() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement textBoxMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-0\"]")));
        textBoxMenu.click();
        textBoxPage.enterFullName("John Smith123");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(driver.getPageSource().contains("John Smith123"));
    }

    @Test
    public void submitFullNameWithSpecialCharacters() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement textBoxMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-0\"]")));
        textBoxMenu.click();
        textBoxPage.enterFullName("John Smith!@");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(driver.getPageSource().contains("John Smith!@"));
    }

    @Test
    public void submitFullNameOnlyNumbers() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement textBoxMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-0\"]")));
        textBoxMenu.click();
        textBoxPage.enterFullName("12345");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(driver.getPageSource().contains("12345"));
    }

    @Test
    public void submitFullNameOnlyOneCharacter() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement textBoxMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-0\"]")));
        textBoxMenu.click();
        textBoxPage.enterFullName("A");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(driver.getPageSource().contains("A"));
    }

    @Test
    public void submitFullNameOnlySpecialCharacters() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement textBoxMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-0\"]")));
        textBoxMenu.click();
        textBoxPage.enterFullName("!@#$");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(driver.getPageSource().contains("!@#$"));
    }
    @Test
    public void submitNonValidEmail() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement textBoxMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-0\"]")));
        textBoxMenu.click();
        textBoxPage.enterEmail("test");
        textBoxPage.clickOnSubmitButton();
        WebElement emailField = driver.findElement(By.id("userEmail"));
        Assert.assertEquals(emailField.getAttribute("class"), "mr-sm-2 field-error form-control");
    }

    @Test
    public void submitValidEmailOnlyLetters() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement textBoxMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-0\"]")));
        textBoxMenu.click();
        textBoxPage.enterEmail("Test@test.com");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(driver.getPageSource().contains("Test@test.com"));
    }
    @Test
    public void submitValidEmailLettersAndNumbers() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement textBoxMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-0\"]")));
        textBoxMenu.click();
        textBoxPage.enterEmail("Test12@test.com");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(driver.getPageSource().contains("Test12@test.com"));
    }

    @Test
    public void submitValidEmailLettersNumbersAndSpecialCharacters() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement textBoxMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-0\"]")));
        textBoxMenu.click();
        textBoxPage.enterEmail("example.Email_@test.com");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(driver.getPageSource().contains("example.Email_@test.com"));
    }
    @Test
    public void submitCurrentAddressOnlyLetters() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement textBoxMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-0\"]")));
        textBoxMenu.click();
        textBoxPage.enterCurrentAddress("test address");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(driver.getPageSource().contains("test address"));
    }

    @Test
    public void submitCurrentAddressLettersAndNumbers() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement textBoxMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-0\"]")));
        textBoxMenu.click();
        textBoxPage.enterCurrentAddress("test address 123");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(driver.getPageSource().contains("test address 123"));
    }

    @Test
    public void submitPermanentAddressOnlyLetters() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement textBoxMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-0\"]")));
        textBoxMenu.click();
        textBoxPage.enterPermanentAddress("test address");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(driver.getPageSource().contains("test address"));
    }

    @Test
    public void submitPermanentAddressLettersAndNumbers() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement textBoxMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-0\"]")));
        textBoxMenu.click();
        textBoxPage.enterPermanentAddress("test address 123");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(driver.getPageSource().contains("test address 123"));
    }

    @Test
    public void submitCompleteValidForm() throws InterruptedException {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/span/div")).click();
        WebElement textBoxMenu = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"item-0\"]")));
        textBoxMenu.click();
        textBoxPage.enterFullName("John Smith");
        textBoxPage.enterEmail("test@test.com");
        textBoxPage.enterCurrentAddress("test address 12");
        textBoxPage.enterPermanentAddress("test address 123");
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(driver.getPageSource().contains("John Smith"));
        Assert.assertTrue(driver.getPageSource().contains("test@test.com"));
        Assert.assertTrue(driver.getPageSource().contains("test address 12"));
        Assert.assertTrue(driver.getPageSource().contains("test address 123"));
    }
}
package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RadioButtonPage extends BasePage {

    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }

    By YesButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[2]/label");
    By ImpressiveButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[3]/label");
    By NoButton = By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[2]/div[2]/div[4]/label");

    public void clickOnYesButton() {driver.findElement(YesButton).click();}
    public void clickOnImpressiveButton() {driver.findElement(ImpressiveButton).click();}
    public void clickOnNoButton() {driver.findElement(NoButton).click();}
}

package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBoxPage extends BasePage {

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    By FullName = By.id("userName");
    By Email = By.id("userEmail");
    By CurrentAddress = By.id("currentAddress");
    By PermanentAddress = By.id("permanentAddress");
    By SubmitButton = By.id("submit");

    public void enterFullName(String arg1) {
        driver.findElement(FullName).sendKeys(arg1);}
    public void enterEmail(String arg1) {
        driver.findElement(Email).sendKeys(arg1);}
    public void enterCurrentAddress(String arg1) {
        driver.findElement(CurrentAddress).sendKeys(arg1);}
    public void enterPermanentAddress(String arg1) {
        driver.findElement(PermanentAddress).sendKeys(arg1);}
    public void clickOnSubmitButton(){ driver.findElement(SubmitButton).click();}
}

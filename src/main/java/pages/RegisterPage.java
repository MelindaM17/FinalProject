package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {

    public RegisterPage (WebDriver driver){
        super(driver);
    }

    //Locators for Register page
    By FirstName = By.id("firstname");
    By LastName = By.id("lastname");
    By UserNameRegister = By.id("userName");
    By PasswordRegister = By.id("password");
    By Captcha = By.id("recaptcha-anchor");
    By RegisterButton = By.id("register");

    //Methods to click on Register page

    public void EnterFirstName(String arg1) {
        driver.findElement(FirstName).sendKeys(arg1);}
    public void EnterLastName(String arg1) {
        driver.findElement(LastName).sendKeys(arg1);}
    public void EnterUserNameRegister(String arg1) {
        driver.findElement(UserNameRegister).sendKeys(arg1);}
    public void EnterPasswordRegister(String arg1) {
        driver.findElement(PasswordRegister).sendKeys(arg1);}
    public void clickOnCaptcha(){ driver.findElement(Captcha).click();}
    public void clickOnRegisterButton(){ driver.findElement(RegisterButton).click();}

}

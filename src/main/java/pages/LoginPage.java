package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);
    }

    //Locators for Login page
    By UserName = By.id("userName");
    By Password = By.id("password");
    By LoginButton = By.id("login");
    By NewUser = By.id("newUser");

    //Methods to click on Login page
    public void enterUserName(String arg1) {
        driver.findElement(UserName).sendKeys(arg1);}
    public void enterPassword(String arg1) {
        driver.findElement(Password).sendKeys(arg1);}
    public void clickOnLoginButton(){ driver.findElement(LoginButton).click();}

    public void clickOnNewUserButton(){ driver.findElement(NewUser).click();}

}

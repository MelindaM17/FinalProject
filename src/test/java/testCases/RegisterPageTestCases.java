package testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BasePage;
import pages.RegisterPage;

public class RegisterPageTestCases extends BasePage{
    private RegisterPage registerPage;

    @BeforeMethod
    public void setUp() {
        super.setUp();
        registerPage = new RegisterPage(driver);
    }
}
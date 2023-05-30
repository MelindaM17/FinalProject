package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookStorePage extends BasePage {

    public BookStorePage(WebDriver driver) {
        super(driver);
    }

    By SearchBox = By.id("searchBox");
    By Book1 = By.id("see-book-Git Pocket Guide");
    By Book2 = By.id("see-book-Learning JavaScript Design Patterns");

    public void searchForBook(String arg1) {
        driver.findElement(SearchBox).sendKeys(arg1);}
    public void clickOnBook1() {
        driver.findElement(Book1).click();}
    public void clickOnBook2() {
        driver.findElement(Book2).click();}
}

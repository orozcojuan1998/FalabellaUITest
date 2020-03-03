package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    private String baseURL = "http://automationpractice.com/index.php";

    @FindBy(id = "search_query_top")
    private WebElement inputSearch;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public HomePage goToThePage() {
        driver.get(baseURL);
        return this;
    }

    public void findProduct(String product) {
        waitVisibility(inputSearch);
        writeText(inputSearch, product);
        inputSearch.submit();
    }
}
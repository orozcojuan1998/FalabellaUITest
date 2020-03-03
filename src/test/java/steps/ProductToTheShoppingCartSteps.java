package steps;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.PageGenerator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.ProductOverviewPage;
import pages.SearchResultsPage;
import pages.ShoppingCartSummaryPage;
import webdrivermanager.Hook;

public class ProductToTheShoppingCartSteps {

    protected WebDriver driver;

    @Before
    public void setupClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("^That I opened the browser at automation practice page$")
    public void thatIOpenedTheBrowserAtAutomationPracticePage() throws Exception {
        HomePage homePage = new HomePage(driver);
        homePage.goToThePage();
    }

    @When("^I look for \"([^\"]*)\" and select any displayed result to go to the shopping cart$")
    public void iLookForAndSelectAnyDisplayedResultToGoToTheShoppingCart(String product) throws Throwable {
        HomePage homePage = new HomePage(driver);
        homePage.findProduct(product);
        SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
        searchResultsPage.chooseRandomProduct();
        ProductOverviewPage productOverviewPage = new ProductOverviewPage(driver);
        productOverviewPage.addToShoppingCart();
    }

    @Then("^Should the shopping cart show the product is not \"([^\"]*)\"$")
    public void shouldTheShoppingCartShowTheProductIsNot(String result) throws Throwable {
        ShoppingCartSummaryPage shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
        Assert.assertEquals(result,shoppingCartSummaryPage.validateShoppingCart());
    }


    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


}
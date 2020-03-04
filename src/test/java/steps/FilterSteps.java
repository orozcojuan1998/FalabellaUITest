package steps;

import controllers.FilterController;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.StaticWait;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomeFalabella;
import pages.ProductsPage;

public class FilterSteps {

    private WebDriver driver;
    private HomeFalabella homeFalabella;
    private ProductsPage productsPage;
    private String fromRange;
    private String toRange;
    FilterController filterController = new FilterController();


    @Before
    public void setupClass() {
        driver = new ChromeDriver();
        driver.get("https://www.falabella.com.co/falabella-co/#");
        driver.manage().window().maximize();
    }


    @Given("^The guest user is in the Falabella homepage$")
    public void theGuestUserIsInTheFalabellaHomepage() {
        homeFalabella = new HomeFalabella(driver);
    }

    @And("^The guest type \"([^\"]*)\" in the search bar$")
    public void theGuestTypeInTheSearchBar(String query) throws Throwable {
        productsPage= homeFalabella.searchProduct(query);
    }


    @When("^The guest apply the price for filter between \"([^\"]*)\" and \"([^\"]*)\"$")
    public void theGuestApplyThePriceForFilterBetweenAnd(String rangeFrom, String rangeTo) throws Throwable {
        fromRange = rangeFrom;
        toRange = rangeTo;
        productsPage.setPriceFilter(rangeFrom,rangeTo);
    }

    @Then("^The guest should just see products in the given range$")
    public void theGuestShouldJustSeeProductsInTheGivenRange() {
        Boolean response = productsPage.getResults(fromRange,toRange);
        Assert.assertThat("Logout invalido", response, Matchers.equalTo(true));
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

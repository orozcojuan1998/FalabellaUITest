package pages;

import helpers.StaticWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class ProductOverviewPage extends BasePage {

    @FindBy(name = "Submit")
    private WebElement buttonAddToCart;

    @FindBy(xpath = "//a[@class='btn btn-default button button-medium']//span")
    private WebElement buttonProceedToCheckout;

    @FindBy(className = "navigation_page")
    private WebElement labelYourShoppingCart;

    public ProductOverviewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void addToShoppingCart() {
        waitVisibility(buttonAddToCart);
        click(buttonAddToCart);
        waitVisibility(buttonProceedToCheckout);
        click(buttonProceedToCheckout);
        waitVisibility(labelYourShoppingCart);
    }

}
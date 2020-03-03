package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartSummaryPage extends BasePage {

    @FindBy(xpath = "//td[@class='cart_description']//p[@class='product-name']//a")
    private WebElement productInShoppingCart;

    public ShoppingCartSummaryPage(WebDriver driver) {
        super(driver);
    }

    public String validateShoppingCart() {
        return exists(productInShoppingCart);
    }

}
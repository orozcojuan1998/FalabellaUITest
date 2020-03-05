package pages;

import helpers.StaticWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends BasePage{

    @FindBy(xpath = "//div[@data-name]")
    private WebElement productName;

    @FindBy(id = "//button[@class = 'jsx-1816208196 button button-primary button-primary-xtra-large']")
    private WebElement buttonAdd;

    @FindBy(xpath = "//span[@class='jsx-3049166186 label']")
    private WebElement labelSuccess;

    @FindBy(xpath = "//a[@class='jsx-3840845563 button button-primary button- ']")
    private WebElement addToCart;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void getProductDetail(){
        WebDriverWait waitItems = new WebDriverWait(driver, Long.parseLong("8"));
        waitItems.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class = 'jsx-1816208196 button button-primary button-primary-xtra-large']")));
        click(driver.findElement(By.xpath("//button[@class = 'jsx-1816208196 button button-primary button-primary-xtra-large']")));
        WebDriverWait waitLabel = new WebDriverWait(driver, Long.parseLong("10"));
        waitLabel.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='jsx-3049166186 label']")));


    }

    public String getProductName(){
        return this.productName.getText();
    }

    public CartPage goToCartSummary() {
        click(addToCart);
        return new CartPage(driver);
    }


    public String getLabelSuccess() {
        return labelSuccess.getText();
    }
}

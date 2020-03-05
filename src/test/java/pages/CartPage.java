package pages;

import helpers.StaticWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

    @FindBy(xpath = "//p[@class ='fb-order-status__empty-basket']")
    private WebElement labelEmpty;

    @FindBy(xpath = "//a[text()='Eliminar']")
    private WebElement deleteLink;



    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void deleteLink() {
        WebDriverWait waitItems = new WebDriverWait(driver, Long.parseLong("5"));
        waitItems.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Eliminar']")));
        click(deleteLink);
    }

    public boolean getLabelEmpty() {
        WebDriverWait waitItems = new WebDriverWait(driver, Long.parseLong("10"));
        waitItems.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class = 'fb-order-status__empty-basket']")));
        System.out.println(labelEmpty.getText());
        return labelEmpty.getText().toLowerCase().contains("tu bolsa de compras está vacía");
    }
}

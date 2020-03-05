package pages;

import helpers.StaticWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;



public class ProductsPage extends BasePage {

    @FindBy(id = "testId-Accordion-Precio")
    private WebElement buttonPrice;

    @FindBy(id = "testId-range-from")
    private WebElement rangeFrom;

    @FindBy(id = "testId-range-to")
    private WebElement rangeTo;

    @FindBy(xpath = "//button[@class = 'jsx-3084763500']")
    private WebElement buttonForFilter;



    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setPriceFilter(String from, String to) {
        By filterPriceButton = By.id("testId-Accordion-Precio");
        WebDriverWait waitItems = new WebDriverWait(driver, Long.parseLong("8"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(filterPriceButton));
        click(buttonPrice);
        click(rangeFrom);
        clear(rangeFrom);
        writeText(rangeFrom, from);
        click(rangeTo);
        clear(rangeTo);
        writeText(rangeTo, to);
        click(buttonForFilter);

    }

    public Boolean getResults(String from, String to) {
        List<WebElement> results = new ArrayList<>();
        By resultSearch = By.id("testId-searchResults-products");
        WebDriverWait waitItems = new WebDriverWait(driver, Long.parseLong("5"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(resultSearch));
        List<Integer> prices = new ArrayList<>();
        boolean key = false;
        int contFilterElements = 0;
        By searchResults = By.xpath("//div[@class='jsx-1395131234 search-results-4-grid']");
        results = driver.findElements(searchResults);
        for (WebElement element : results) {
            String price = (element.getText().substring(element.getText().indexOf('$') + 2, element.getText().indexOf('$') + 9));
            int indexOfDecimal = price.indexOf(".");
            String integerPart = price.substring(0, indexOfDecimal);
            String IntegerPartTwo = price.substring(indexOfDecimal + 1);
            integerPart = integerPart.concat(IntegerPartTwo);
            prices.add(Integer.valueOf(integerPart));
        }

        for (Integer price : prices) {
            if (price <= Integer.parseInt(to)) {
                contFilterElements++;
            } else {
                return false;
            }
        }
        if (contFilterElements == prices.size()) {
            key = true;
        }
        return key;
    }
}

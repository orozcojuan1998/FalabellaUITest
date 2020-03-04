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

    // //div[@class='jsx-1395131234 search-results-4-grid'][3]


    public ProductsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setPriceFilter(String from, String to) {
        WebDriverWait waitItems = new WebDriverWait(driver, Long.parseLong("8"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(By.id("testId-Accordion-Precio")));
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
        WebDriverWait waitItems = new WebDriverWait(driver, Long.parseLong("4"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(By.id("testId-searchResults-products")));
        List<WebElement> results = driver.findElements(By.xpath("//div[@class='jsx-1395131234 search-results-4-grid']"));
        List<Integer> prices = new ArrayList<>();
        Boolean key = false;
        int cont = 0;

        for (WebElement element : results) {
            String price = (element.getText().substring(element.getText().indexOf('$') + 2, element.getText().indexOf('$') + 9));
            int indexOfDecimal = price.indexOf(".");
            String partOne = price.substring(0, indexOfDecimal);
            String partTwo = price.substring(indexOfDecimal + 1);
            partOne = partOne.concat(partTwo);
            System.out.println(partOne);
            prices.add(Integer.valueOf(partOne));
        }

        for (Integer price : prices) {
            if (price <= Integer.valueOf(to)) {
                cont ++;
            }
            else {
                return false;
            }
        }
        if (cont == prices.size()){
            key = true;
        }

        return key;
    }


}

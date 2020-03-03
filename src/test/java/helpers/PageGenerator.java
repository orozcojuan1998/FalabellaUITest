package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.BasePage;

import java.lang.reflect.InvocationTargetException;

public class PageGenerator {
    public static  <TPage extends BasePage> TPage getInstance (Class<TPage> pageClass , WebDriver driver ) throws Exception {
        return PageFactory.initElements(driver,  pageClass);
    }
}
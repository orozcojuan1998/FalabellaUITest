package webdrivermanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private WebDriver webDriver;

    public static DriverManager getManager(DriverType type) {
        DriverManager driverManager;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            default:
                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;

    }
    public WebDriver setWebDriver(){
        webDriver=new ChromeDriver();
        return webDriver;
    }

}

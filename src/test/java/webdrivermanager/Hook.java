package webdrivermanager;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Hook{
    private static WebDriver webDriver;


    @Before
    public void setup() {
        DriverFactory driverFactory=new DriverFactory();
        webDriver=driverFactory.setWebDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.falabella.com.co/falabella-co/");
    }

    @After
    public void teardown() {
        webDriver.quit();
    }

    public static WebDriver getWebDriver(){
        return webDriver;
    }
}


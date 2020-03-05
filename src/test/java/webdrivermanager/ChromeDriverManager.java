package webdrivermanager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager extends DriverManager{
    @Override
    protected void startService() {

    }

    @Override
    public void createDriver() {
        driver = new ChromeDriver();
    }
}

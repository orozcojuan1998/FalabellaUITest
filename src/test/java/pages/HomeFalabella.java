package pages;

import helpers.StaticWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomeFalabella extends BasePage{

    @FindBy(id = "header-login-modal")
    private WebElement buttonLogin;

    @FindBy (id = "emailAddress")
    private WebElement inputEmail;

    @FindBy (className = "InputPassword__inputText__2IUUv")
    private WebElement inputPassword;

    @FindBy (xpath = "//button/p[text() = 'Iniciar sesión']")
    private WebElement loginButton;

    @FindBy (xpath = "//a[@href='/falabella-co/myaccount/register.jsp']")
    private WebElement registerLink;

    @FindBy (id = "searchQuestionSolr")
    private WebElement searchBar;

    public HomeFalabella(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public HomeFalabella goToThePage(String baseURL) {
        driver.get(baseURL);
        return this;
    }

    public WebElement getButtonLogin() {
        return buttonLogin;
    }

    public WebElement getInputEmail() {
        return inputEmail;
    }

    public WebElement getInputPassword() {
        return inputPassword;
    }

    public void getRegisterLink() {
        click(this.registerLink);
    }

    public void sendCredentials (String user, String password){
        click(this.inputEmail);
        clear(this.inputEmail);
        writeText(inputEmail, user);
        click(this.inputPassword);
        clear(this.inputPassword);
        writeText(inputPassword, password);

    }

    public void login (){
        click(this.loginButton);
        WebDriverWait waitItems = new WebDriverWait(driver,Long.parseLong("5"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(" //div[@class='fb-masthead-login__name re-design-cl__name']")));

    }

    public void loginInvalid (){
        click(this.loginButton);
        WebDriverWait waitItems = new WebDriverWait(driver,Long.parseLong("5"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class ='Login__errorBlock__3q25u']")));

    }

    public String getLoginText() {
        WebElement welcomeMessage = driver.findElement(By.xpath("//div[@class='fb-masthead-login__name re-design-cl__name']"));
        waitVisibility(welcomeMessage);
        System.out.println(welcomeMessage.getText());
        return welcomeMessage.getText();
    }

    public String getLoginErrorText() {
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='Login__errorBlock__3q25u']"));
        System.out.println(errorMessage.getText());
        return errorMessage.getText();


    }

    public void logOut() {
        Actions action = new Actions(this.driver);
        WebElement subMenuLoginOption = driver.findElement(By.xpath("//div[@class='fb-masthead-login__name re-design-cl__name']"));
        action.moveToElement(subMenuLoginOption).perform();
        WebElement logOut = driver.findElement(By.xpath("//li/a[@class='fb-filter-header__log-out']"));
        waitVisibility(logOut);
        logOut.click();

    }

    public boolean getLogOutMessage() {
        WebDriverWait waitItems = new WebDriverWait(driver,Long.parseLong("5"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='fb-masthead-login__name re-design-cl__name login-redesing_logout-box']")));
        WebElement logUpdate = driver.findElement(By.xpath("//div[@class='fb-masthead-login__name re-design-cl__name login-redesing_logout-box']"));
        return logUpdate.getText().toLowerCase().contains("inicia sesión");
    }

    public ProductsPage searchProduct(String query) {
        //WebElement alert = driver.findElement(By.id("acc-alert-deny"));
        //click(alert);
        WebDriverWait waitItems = new WebDriverWait(driver,Long.parseLong("5"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchQuestionSolr")));
        click(searchBar);
        clear(searchBar);
        writeText(searchBar,query);
        searchBar.sendKeys(Keys.ENTER);
        return new ProductsPage(driver);
    }
}

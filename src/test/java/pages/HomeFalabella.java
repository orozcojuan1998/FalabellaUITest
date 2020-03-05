package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class HomeFalabella extends BasePage {

    @FindBy(id = "header-login-modal")
    private WebElement buttonLogin;

    @FindBy(id = "emailAddress")
    private WebElement inputEmail;

    @FindBy(className = "InputPassword__inputText__2IUUv")
    private WebElement inputPassword;

    @FindBy(xpath = "//button/p[text() = 'Iniciar sesión']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='/falabella-co/myaccount/register.jsp']")
    private WebElement registerLink;

    @FindBy(id = "searchQuestionSolr")
    private WebElement searchBar;

    private By loginFrame = By.xpath("//div[@class='fb-masthead-login__name re-design-cl__name']");
    private By loginError = By.xpath("//div[@class ='Login__errorBlock__3q25u']");
    private By welcomeMessageText = By.xpath("//div[@class='fb-masthead-login__name re-design-cl__name']");
    private By errorMessageText = By.xpath("//div[@class='Login__errorBlock__3q25u']");
    private By subMenuForLogin = By.xpath("//div[@class='fb-masthead-login__name re-design-cl__name']");
    private By louOutButton = By.xpath("//li/a[@class='fb-filter-header__log-out']");
    private By logOutBox = By.xpath("//div[@class='fb-masthead-login__name re-design-cl__name login-redesing_logout-box']");
    private By logOutMessage = By.xpath("//div[@class='fb-masthead-login__name re-design-cl__name login-redesing_logout-box']");
    private By searchBarQuery = By.id("searchQuestionSolr");
    private By alertMessage = By.id("acc-alert-deny");

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

    public void sendCredentials(String user, String password) {
        click(this.inputEmail);
        clear(this.inputEmail);
        writeText(inputEmail, user);
        click(this.inputPassword);
        clear(this.inputPassword);
        writeText(inputPassword, password);

    }

    public void login() {
        click(this.loginButton);
        WebDriverWait waitItems = new WebDriverWait(driver, Long.parseLong("5"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(loginFrame));

    }

    public void loginInvalid() {
        click(this.loginButton);
        WebDriverWait waitItems = new WebDriverWait(driver, Long.parseLong("7"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(loginError));

    }

    public String getLoginText() {
        WebDriverWait waitItems = new WebDriverWait(driver, Long.parseLong("5"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessageText));
        WebElement welcomeMessage = driver.findElement(welcomeMessageText);
        return welcomeMessage.getText();
    }

    public String getLoginErrorText() {
        WebElement errorMessage = driver.findElement(errorMessageText);
        return errorMessage.getText();


    }

    public void logOut() {
        WebDriverWait waitItems = new WebDriverWait(driver, Long.parseLong("7"));
        waitItems.until(ExpectedConditions.elementToBeClickable(subMenuForLogin));
        Actions action = new Actions(this.driver);
        WebElement subMenuLoginOption = driver.findElement(subMenuForLogin);
        action.moveToElement(subMenuLoginOption).perform();
        WebElement logOut = driver.findElement(louOutButton);
        click(logOut);

    }

    public boolean getLogOutMessage() {
        WebDriverWait waitItems = new WebDriverWait(driver, Long.parseLong("5"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(logOutBox));
        WebElement logUpdate = driver.findElement(logOutMessage);
        return logUpdate.getText().toLowerCase().contains("inicia sesión");
    }

    public ProductsPage searchProduct(String query) {
       /* WebDriverWait waitItemAlert = new WebDriverWait(driver, Long.parseLong("8"));
        waitItemAlert.until(ExpectedConditions.visibilityOfElementLocated(alertMessage));
        WebElement alert = driver.findElement(alertMessage);
        click(alert);*/
        WebDriverWait waitItems = new WebDriverWait(driver, Long.parseLong("5"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(searchBarQuery));
        click(searchBar);
        clear(searchBar);
        writeText(searchBar, query);
        searchBar.sendKeys(Keys.ENTER);
        return new ProductsPage(driver);
    }
}

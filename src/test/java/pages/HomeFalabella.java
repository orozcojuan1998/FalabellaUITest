package pages;

import helpers.StaticWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeFalabella extends BasePage{

    @FindBy(id = "header-login-modal")
    private WebElement buttonLogin;

    @FindBy (id = "emailAddress")
    private WebElement inputEmail;

    @FindBy (className = "InputPassword__inputText__2IUUv")
    private WebElement inputPassword;

    @FindBy (xpath = "//button/p[text() = 'Iniciar sesión']")
    private WebElement loginButton;

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

    public void sendCredentials (String user, String password){
        click(this.inputEmail);
        clear(this.inputEmail);
        writeText(inputEmail, user);
        click(this.inputPassword);
        clear(this.inputPassword);
        writeText(inputPassword, password);

    }

    public HomeFalabella login (){

        click(this.loginButton);
        return new HomeFalabella(driver);
    }

    public String getLoginText() {
        WebElement welcomeMessage = driver.findElement(By.xpath("//div[@class='fb-masthead-login__name re-design-cl__name']"));
        System.out.println(welcomeMessage.getText());
        return welcomeMessage.getText();
    }

    public String getLoginErrorText() {
        WebElement errorMessage = driver.findElement(By.xpath(" //div[@class='Login__errorBlock__3q25u']"));
        System.out.println(errorMessage.getText());
        return errorMessage.getText();


    }
}

package steps;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.User;
import helpers.StaticWait;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomeFalabella;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    protected WebDriver driver;
    private User user;
    private HomeFalabella homeFalabella;

    @Before
    public void setupClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Given("^The user is in the Falabella homepage$")
    public void theUserIsInTheFalabellaHomepage() {
        user = new User();
        driver.get("https://www.falabella.com.co/falabella-co/#");
    }

    @And("^The user clicks the login button$")
    public void theUserClicksTheLoginButton() {
        homeFalabella = new HomeFalabella(driver);
        homeFalabella.click(homeFalabella.getButtonLogin());
    }

    @When("^The user enters its data$")
    public void theUserEntersItsData(DataTable userData) {
        List<Map<String, String>> data = userData.asMaps(String.class, String.class);
        user.setEmail(data.get(0).get("email"));
        user.setPassword(data.get(0).get("password"));
        homeFalabella.sendCredentials(user.getEmail(),user.getPassword());
        
    }

    @And("^Clicks the Iniciar sesion button$")
    public void clicksTheIniciarSesionButton() {
        homeFalabella.login();
        StaticWait.WaitForSeconds(8);
        
    }

    @Then("^The user is signed in$")
    public void theUserIsSignedIn() {
        String text = homeFalabella.getLoginText();
        Assert.assertEquals("Login invalido","Bienvenid@,\n" +
                "Juan David", text);
    }
    @Then("^The user stays in the same page and is informed that credentials are wrong$")
    public void theUserStaysInTheSamePageAndIsInformedThatCredentialsAreWrong() {
        String text = homeFalabella.getLoginErrorText();
        Assert.assertEquals("Login invalido","E-mail o clave incorrecta. Por favor inténtalo nuevamente.", text);
    }
    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


}

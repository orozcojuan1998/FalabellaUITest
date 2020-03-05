package steps;

import builders.UserBuilder;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import entities.User;
import helpers.StaticWait;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomeFalabella;
import webdrivermanager.Hook;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    protected WebDriver driver;
    private User user;
    private HomeFalabella homeFalabella = new HomeFalabella(Hook.getWebDriver());


    @Given("^The user is in the Falabella homepage$")
    public void theUserIsInTheFalabellaHomepage() {
        user = new User();
    }

    @And("^The user clicks the login button$")
    public void theUserClicksTheLoginButton() {
        homeFalabella.click(homeFalabella.getButtonLogin());
    }

    @When("^The user enters its data$")
    public void theUserEntersItsData(DataTable userData) {
        List<Map<String, String>> data = userData.asMaps(String.class, String.class);
        user = new UserBuilder().
                withEmail(data.get(0).get("email")).
                withPassword(data.get(0).get("password")).create();
        homeFalabella.sendCredentials(user.getEmail(), user.getPassword());

    }

    @And("^Clicks the Iniciar sesion button$")
    public void clicksTheIniciarSesionButton() {
        homeFalabella.login();

    }

    @And("^Clicks on the Iniciar sesion button$")
    public void clicksOnTheIniciarSesionButton() {
        homeFalabella.loginInvalid();
    }

    @Then("^The user is signed in$")
    public void theUserIsSignedIn() {
        String text = homeFalabella.getLoginText();
        Assert.assertEquals("Login invalido", "Bienvenid@,\n" +
                "Juan David", text);
    }

    @Then("^The user stays in the same page and is informed that credentials are wrong$")
    public void theUserStaysInTheSamePageAndIsInformedThatCredentialsAreWrong() {
        String text = homeFalabella.getLoginErrorText();
        Assert.assertEquals("Login invalido", "E-mail o clave incorrecta. Por favor inténtalo nuevamente.", text);
    }


    @When("^The user hover on the account button and clicks the log out button$")
    public void theUserHoverOnTheAccountButtonAndClicksTheLogOutButton() {
        homeFalabella.logOut();
    }


    @Then("^The user is logout from the web page$")
    public void theUserIsLogoutFromTheWebPage() {
        Boolean logOutResponse = homeFalabella.getLogOutMessage();
        Assert.assertThat("Logout invalido", logOutResponse, Matchers.equalTo(true));
    }


}

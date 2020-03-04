package steps;

import builders.UserBuilder;
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
import pages.RegisterPage;

public class RegisterSteps {

    protected WebDriver driver;
    private User user;
    private HomeFalabella homeFalabella;
    private RegisterPage registerPage;
    private UserBuilder userBuilder;

    @Before
    public void setupClass() {
        driver = new ChromeDriver();
        driver.get("https://www.falabella.com.co/falabella-co/#");
        driver.manage().window().maximize();
        homeFalabella = new HomeFalabella(driver);
        registerPage = new RegisterPage(driver);
    }



    @Given("^The user want to register in the page$")
    public void theUserWantToRegisterInThePage() {
        user = new UserBuilder().withName("Juan David").
                    withFatherLastname("Orozco").
                    withMotherLastName("Llerena").
                    withEmail("testjuanorozco6@gmail.com").
                    withPassword("test1234").
                    withCountry("Colombia").
                    withDocumentType("CEDULA_DE_CIUDADANIA").
                    withNumDocument(1032748964).
                    withDay(13).
                    withMonth(10).
                    withYear(1994).
                    create();
        
    }

    @When("^The user clicks the log in button$")
    public void theUserClicksTheLogInButton() {
        homeFalabella.click(homeFalabella.getButtonLogin());
    }

    @And("^The user clicks the registrarse link$")
    public void theUserClicksTheRegistrarseLink() {
        homeFalabella.getRegisterLink();

    }

    @And("^The user enters the data to register$")
    public void theUserEntersTheDataToRegister() {
        registerPage.enterData(user);


    }

    @And("^The user clicks the Guardar button$")
    public void theUserClicksTheGuardarButton() {
        registerPage.click(registerPage.getButtonRegister());

    }

    @Then("^The user stays in the same page and is informed that cellphone is required$")
    public void theUserStaysInTheSamePageAndIsInformedThatCellphoneIsRequired() {
        String textResponse = registerPage.getRegisterMessageError();
        Assert.assertEquals("Login invalido", "Debes ingresar un celular", textResponse);

    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


}

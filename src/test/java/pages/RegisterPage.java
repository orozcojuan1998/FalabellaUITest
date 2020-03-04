package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{

    @FindBy(id = "user")
    private WebElement name;

    @FindBy(id = "apellidopaterno")
    private WebElement fatherLastname;

    @FindBy(id = "apellidomaterno")
    private WebElement motherLastName;

    @FindBy(id = "mail")
    private WebElement email;

    @FindBy(id = "clave1")
    private WebElement passwordOne;

    @FindBy(id = "clave2")
    private WebElement passwordTwo;

    @FindBy(id = "status")
    private WebElement country;

    @FindBy(id = "cedula")
    private WebElement documentType;

    @FindBy(id = "cedula_colombiana")
    private WebElement documentNumber;

    @FindBy(xpath = "//input[@value='male']")
    private WebElement genderMale;

    @FindBy(xpath = "//input[@value='female']")
    private WebElement genderFemale;

    @FindBy(id = "day")
    private WebElement day;

    @FindBy(id = "month")
    private WebElement month;

    @FindBy(id = "year")
    private WebElement year;

    @FindBy(id = "celular")
    private WebElement cellphone;

    @FindBy(id = "agreelegaleId")
    private WebElement checkTerms;

    @FindBy(id = "boton_Ar")
    private WebElement buttonRegister;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }


    //https://stackoverflow.com/questions/20138761/how-to-select-a-dropdown-value-in-selenium-webdriver-using-java

}

package pages;

import entities.User;
import helpers.StaticWait;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(id = "cedula_colombia")
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

    @FindBy(id = "mensajeCelVacio")
    private WebElement messageCellphone;

    private By messageErrorCellphone = By.id("mensajeCelVacio");



    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void enterData(User user) {
        WebDriverWait waitItems = new WebDriverWait(driver,Long.parseLong("6"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(By.id("user")));
        click(name);
        clear(name);
        writeText(name,user.getName());
        click(fatherLastname);
        clear(fatherLastname);
        writeText(fatherLastname,user.getFatherLastName());
        click(motherLastName);
        clear(motherLastName);
        writeText(motherLastName,user.getMotherLastName());
        click(email);
        clear(email);
        writeText(email,user.getEmail());
        click(passwordOne);
        clear(passwordOne);
        writeText(passwordOne,user.getPassword());
        click(passwordTwo);
        clear(passwordTwo);
        writeText(passwordTwo,user.getPassword());
        Select dropCountry = new Select(country);
        dropCountry.selectByVisibleText(user.getCountry());
        Select dropDocument = new Select(documentType);
        dropDocument.selectByValue(user.getDocType());
        click(documentNumber);
        clear(documentNumber);
        writeText(documentNumber,String.valueOf(user.getNumDocument()));
        if(user.getGender().equals("M")){
            click(genderMale);
        }
        else if (user.getGender().equals("F")){
            click(genderFemale);
        }
        Select dropDay = new Select(day);
        dropDay.selectByValue(String.valueOf(user.getDay()));
        Select dropMonth = new Select(month);
        dropMonth.selectByValue(String.valueOf(user.getMonth()));
        Select dropYear = new Select(year);
        dropYear.selectByValue(String.valueOf(user.getYear()));
        if(!checkTerms.isSelected()){
            checkTerms.sendKeys(Keys.SPACE);
        }
    }

    public WebElement getButtonRegister() {
        return buttonRegister;
    }

    public String getRegisterMessageError() {
        WebDriverWait waitItems = new WebDriverWait(driver,Long.parseLong("7"));
        waitItems.until(ExpectedConditions.visibilityOfElementLocated(messageErrorCellphone));
        return messageCellphone.getText();
    }


}

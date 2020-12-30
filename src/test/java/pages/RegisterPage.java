package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author Matthias Veelaert r0704252 & Younes Mounnadi r0786792;
 **/

public class RegisterPage extends Page {

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver.get(path + "?command=Register");
    }
    @FindBy(id = "userId")
    private WebElement userIdRegisterField;

    @FindBy(id = "firstName")
    private WebElement firstNameRegisterField;

    @FindBy(id = "lastName")
    private WebElement lastNameRegisterField;

    @FindBy(id = "email")
    private WebElement emailRegisterField;

    @FindBy(id = "password")
    private WebElement passwordRegisterField;

    @FindBy(id = "signUp")
    private WebElement registerButton;


    public void setUserIdRegisterField(String useridRegister) {
        userIdRegisterField.clear();
        userIdRegisterField.sendKeys(useridRegister);
    }

    public void setFirstNameRegisterField(String firstNameRegister) {
        firstNameRegisterField.clear();
        firstNameRegisterField.sendKeys(firstNameRegister);
    }

    public void setLastNameRegisterField(String lastNameRegister) {
        lastNameRegisterField.clear();
        lastNameRegisterField.sendKeys(lastNameRegister);
    }

    public void setEmailRegisterField(String emailRegister) {
        emailRegisterField.clear();
        emailRegisterField.sendKeys(emailRegister);
    }

    public void setPasswordRegisterField(String passwordRegister) {
        passwordRegisterField.clear();
        passwordRegisterField.sendKeys(passwordRegister);
    }

    public void submitRegister() {
        registerButton.click();
    }
}
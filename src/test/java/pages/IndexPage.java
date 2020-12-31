package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends Page{

    public IndexPage(WebDriver driver) {
        super(driver);
        this.driver.get(path + "?command=Home");
    }

    @FindBy(id = "userId")
    private WebElement userIdField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login")
    private WebElement LoginButton;

    public void setUseridField(String userId) {
        userIdField.clear();
        userIdField.sendKeys(userId);
    }

    public void setPasswordField(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void submitLogin() {
        LoginButton.click();
    }

    public boolean hasLogInForm() {
        return driver.findElement(By.id("login")) != null;
    }
}

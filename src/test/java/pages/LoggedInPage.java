package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedInPage extends Page{

    public LoggedInPage(WebDriver driver) {
        super(driver);
        this.driver.get(path + "?command=Home");
    }

    @FindBy(id = "logout")
    private WebElement LogoutButton;

    public void submitlogout() {
        LogoutButton.click();
    }

    public boolean hasLogOutButton() {
        return driver.findElement(By.id("logOut")) != null;
    }
}

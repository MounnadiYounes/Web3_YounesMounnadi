import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class AdminFunctionalities {
    private WebDriver driver;
    private String path = "http://localhost:8081/Web3_YounesMounnadi_war_exploded/Controller";
    private String userId = "younes";
    private String userPassword = "t";
    private String adminId = "admin";
    private String adminPassword = "admin";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\youne\\Desktop\\Semester 1\\Webontwikkeling 3\\jars and files\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(path + "?command=Home");
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void adminCanDeleteAnyUser() {
        assertEquals("Home", driver.getTitle());
        loginAsAdmin();
        driver.get(path + "?command=UsersOverview");

        assertTrue(retrieveDeleteButtonsFromUsersOverview());
    }

    @Test
    public void userCannotDeleteAnyUser() {
        assertEquals("Home", driver.getTitle());
        loginAsUser();
        driver.get(path + "?command=UsersOverview");

        assertFalse(retrieveDeleteButtonsFromUsersOverview());
    }

    @Test
    public void adminSeesAllContacts() {
        assertEquals("Home", driver.getTitle());
        loginAsAdmin();
        driver.get(path + "?command=ContactsOverview");

        assertTrue(isThereContactsFromDifferentUsers());
    }

    @Test
    public void usersDoesNotSeeAllContact() {
        assertEquals("Home", driver.getTitle());
        loginAsUser();
        driver.get(path + "?command=ContactsOverview");

        assertFalse(isThereContactsFromDifferentUsers());
    }

    private boolean isThereContactsFromDifferentUsers() {
        List<WebElement> contactsUserIds = driver.findElements(By.cssSelector("table tr td#userId"));
        System.out.println(contactsUserIds);
        Set<String> userIds = new HashSet<>();

        for (WebElement contactUserId: contactsUserIds) {
            userIds.add(contactUserId.getText());
        }
        return userIds.size() > 1;
    }

    private boolean retrieveDeleteButtonsFromUsersOverview() {
        ArrayList<WebElement> listItems = (ArrayList<WebElement>) driver.findElements(By.cssSelector("table tr td input"));
        boolean found = false;

        for (WebElement listItem : listItems) {
            if (listItem.getAttribute("id").equals("removeButton")) {
                found = true;
            }
        }

        return found;
    }

    private void loginAsUser() {
        submitForm(userId, userPassword);
    }

    private void loginAsAdmin() {
        submitForm(adminId, adminPassword);
    }

    private void submitForm(String userId, String password) {
        fillOutField("userId", userId);
        fillOutField("password", password);

        WebElement button = driver.findElement(By.id("login"));
        button.click();
    }

    private void fillOutField(String name, String value) {
        WebElement field = driver.findElement(By.id(name));
        field.clear();
        field.sendKeys(value);
    }
}
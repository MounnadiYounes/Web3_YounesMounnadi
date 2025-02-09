import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RegisterTest {
    private WebDriver driver;
    private String path = "http://localhost:8081/Web3_YounesMounnadi_war_exploded/Controller";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\youne\\Desktop\\Semester 1\\Webontwikkeling 3\\jars and files\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.managed_default_content_settings.javascript", 2);
        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        driver.get(path + "?command=Register");
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_Register_AllFieldsFilledInCorrectly_UserIsRegistered() {
        String userIdRandom = generateRandomuserIdInOrderToRunTestMoreThanOnce("jakke");
        submitForm(userIdRandom, "Jan", "Janssens", "jan.janssens@hotmail.com", "1234");

        String title = driver.getTitle();
        assertEquals("Contacts overview", title);
    }

    @Test
    public void test_Register_userIdNotFilledIn_ErrorMessageGivenForuserIdAndOtherFieldsValueKept() {
        submitForm("", "Jan", "Janssens", "jan.janssens@hotmail.com", "1234");

        String title = driver.getTitle();
        assertEquals("Sign Up", title);

        WebElement errorMsg = driver.findElement(By.cssSelector("div#alert-danger ul li"));
        assertEquals("No user id given", errorMsg.getText());

        WebElement fielduserId = driver.findElement(By.id("userId"));
        assertEquals("", fielduserId.getAttribute("value"));

        WebElement fieldFirstName = driver.findElement(By.id("firstName"));
        assertEquals("Jan", fieldFirstName.getAttribute("value"));

        WebElement fieldLastName = driver.findElement(By.id("lastName"));
        assertEquals("Janssens", fieldLastName.getAttribute("value"));

        WebElement fieldEmail = driver.findElement(By.id("email"));
        assertEquals("jan.janssens@hotmail.com", fieldEmail.getAttribute("value"));
    }

    @Test
    public void test_Register_FirstNameNotFilledIn_ErrorMessageGivenForFirstNameAndOtherFieldsValueKept() {
        submitForm("jakke", "", "Janssens", "jan.janssens@hotmail.com", "1234");

        String title = driver.getTitle();
        assertEquals("Sign Up", title);

        WebElement errorMsg = driver.findElement(By.cssSelector("div#alert-danger ul li"));
        assertEquals("No first name given", errorMsg.getText());

        WebElement fielduserId = driver.findElement(By.id("userId"));
        assertEquals("jakke", fielduserId.getAttribute("value"));

        WebElement fieldFirstName = driver.findElement(By.id("firstName"));
        assertEquals("", fieldFirstName.getAttribute("value"));

        WebElement fieldLastName = driver.findElement(By.id("lastName"));
        assertEquals("Janssens", fieldLastName.getAttribute("value"));

        WebElement fieldEmail = driver.findElement(By.id("email"));
        assertEquals("jan.janssens@hotmail.com", fieldEmail.getAttribute("value"));
    }

    @Test
    public void test_Register_LastNameNotFilledIn_ErrorMessageGivenForLastNameAndOtherFieldsValueKept() {
        submitForm("jakke", "Jan", "", "jan.janssens@hotmail.com", "1234");

        String title = driver.getTitle();
        assertEquals("Sign Up", title);

        WebElement errorMsg = driver.findElement(By.cssSelector("div#alert-danger ul li"));
        assertEquals("No last name given", errorMsg.getText());

        WebElement fielduserId = driver.findElement(By.id("userId"));
        assertEquals("jakke", fielduserId.getAttribute("value"));

        WebElement fieldFirstName = driver.findElement(By.id("firstName"));
        assertEquals("Jan", fieldFirstName.getAttribute("value"));

        WebElement fieldLastName = driver.findElement(By.id("lastName"));
        assertEquals("", fieldLastName.getAttribute("value"));

        WebElement fieldEmail = driver.findElement(By.id("email"));
        assertEquals("jan.janssens@hotmail.com", fieldEmail.getAttribute("value"));
    }

    @Test
    public void test_Register_EmailNotFilledIn_ErrorMessageGivenForEmailAndOtherFieldsValueKept() {
        submitForm("jakke", "Jan", "Janssens", "", "1234");

        String title = driver.getTitle();
        assertEquals("Sign Up", title);

        WebElement errorMsg = driver.findElement(By.cssSelector("div#alert-danger ul li"));
        assertEquals("No email given", errorMsg.getText());

        WebElement fielduserId = driver.findElement(By.id("userId"));
        assertEquals("jakke", fielduserId.getAttribute("value"));

        WebElement fieldFirstName = driver.findElement(By.id("firstName"));
        assertEquals("Jan", fieldFirstName.getAttribute("value"));

        WebElement fieldLastName = driver.findElement(By.id("lastName"));
        assertEquals("Janssens", fieldLastName.getAttribute("value"));

        WebElement fieldEmail = driver.findElement(By.id("email"));
        assertEquals("", fieldEmail.getAttribute("value"));
    }


    @Test
    public void test_Register_PasswordNotFilledIn_ErrorMessageGivenForEmailAndOtherFieldsValueKept() {
        submitForm("jakke", "Jan", "Janssens", "jan.janssens@hotmail.com", "");

        String title = driver.getTitle();
        assertEquals("Sign Up", title);

        WebElement errorMsg = driver.findElement(By.cssSelector("div#alert-danger ul li"));
        assertEquals("No password given", errorMsg.getText());

        WebElement fielduserId = driver.findElement(By.id("userId"));
        assertEquals("jakke", fielduserId.getAttribute("value"));

        WebElement fieldFirstName = driver.findElement(By.id("firstName"));
        assertEquals("Jan", fieldFirstName.getAttribute("value"));

        WebElement fieldLastName = driver.findElement(By.id("lastName"));
        assertEquals("Janssens", fieldLastName.getAttribute("value"));

        WebElement fieldEmail = driver.findElement(By.id("email"));
        assertEquals("jan.janssens@hotmail.com", fieldEmail.getAttribute("value"));
    }

    @Test
    public void test_Register_UserAlreadyExists_ErrorMessageGiven() {
        submitForm("kadil", "Pasfnee", "Kadieel", "pasfnee.kadieel@ucll.be", "1234");

        WebElement errorMsg = driver.findElement(By.cssSelector("div#alert-danger ul li"));
        assertEquals("User already exists", errorMsg.getText());

        WebElement fielduserId = driver.findElement(By.id("userId"));
        assertEquals("kadil", fielduserId.getAttribute("value"));

        WebElement fieldFirstName = driver.findElement(By.id("firstName"));
        assertEquals("Pasfnee", fieldFirstName.getAttribute("value"));

        WebElement fieldLastName = driver.findElement(By.id("lastName"));
        assertEquals("Kadieel", fieldLastName.getAttribute("value"));

        WebElement fieldEmail = driver.findElement(By.id("email"));
        assertEquals("pasfnee.kadieel@ucll.be", fieldEmail.getAttribute("value"));
    }

    private String generateRandomuserIdInOrderToRunTestMoreThanOnce(String component) {
        int random = (int) (Math.random() * 1000 + 1);
        return random + component;
    }

    private void fillOutField(String name, String value) {
        WebElement field = driver.findElement(By.id(name));
        field.clear();
        field.sendKeys(value);
    }

    private void submitForm(String userId, String firstName, String lastName, String email, String password) {
        fillOutField("userId", userId);
        fillOutField("firstName", firstName);
        fillOutField("lastName", lastName);
        fillOutField("email", email);
        fillOutField("password", password);

        WebElement button = driver.findElement(By.id("signUp"));
        button.click();
    }
}
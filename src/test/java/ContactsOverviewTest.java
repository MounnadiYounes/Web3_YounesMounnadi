import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import pages.ContactOverviewPage;
import pages.HomePage;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * @author Evert
 */

public class ContactsOverviewTest {
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
    }

    @After
    public void clean() { driver.quit(); }

    @Test
    public void test_Not_Logged_In_User_Navigates_From_Home_To_Contacts_Throws_Exception()  {
        HomePage page = PageFactory.initElements(driver, HomePage.class);
        ContactOverviewPage contactOverviewPage = PageFactory.initElements(driver, ContactOverviewPage.class);
        assertEquals(driver.getTitle(),"Error");
    }

    @Test
    public void test_User_Without_Contacts_Shows_No_Contacts() {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.setUserId("nocontact");
        homePage.setPassword("t");
        homePage.submitForm();

        ContactOverviewPage contactOverviewPage = PageFactory.initElements(driver, ContactOverviewPage.class);
        assertEquals(contactOverviewPage.countContacts(), 0);
    }

    @Test
    public void test_User_With_Contacts_Shows_Positive_Number_Of_Contacts()  {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.loginAsUser();

        ContactOverviewPage contactOverviewPage = PageFactory.initElements(driver, ContactOverviewPage.class);
        assertNotEquals(contactOverviewPage.countContacts(), 0);
    }
}

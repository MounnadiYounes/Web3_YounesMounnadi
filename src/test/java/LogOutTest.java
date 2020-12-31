import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.IndexPage;
import pages.LoggedInPage;
import pages.RegisterPage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Matthias Veelaert r0704252 & Younes Mounnadi r0786792;
 **/

public class LogOutTest {
    private WebDriver driver;
    private String path = "http://localhost:8081/Web3_YounesMounnadi_war_exploded/";

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\youne\\Desktop\\Semester 1\\Webontwikkeling 3\\jars and files\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void clean() {
        driver.quit();
    }

    @Test
    public void test_LoggedInUserLogsOut_IndexPageShownWithLogInForm() {
        //Register and log in
        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.setUserIdRegisterField("test");
        registerPage.setFirstNameRegisterField("test");
        registerPage.setLastNameRegisterField("test");
        registerPage.setEmailRegisterField("test@ucll.be");
        registerPage.setPasswordRegisterField("t");
        registerPage.submitRegister();
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);

        indexPage.setUseridField("testuser");
        indexPage.setPasswordField("t");
        indexPage.submitLogin();

        LoggedInPage loggedInPage = PageFactory.initElements(driver, LoggedInPage.class);
        loggedInPage.submitlogout();
        assertTrue(indexPage.hasLogInForm());
    }

    @Test(expected = NoSuchElementException.class)
    public void test_GuestVisitsSite_CannotSeeLogOutButton() {
        IndexPage indexPage = PageFactory.initElements(driver, IndexPage.class);
        assertTrue(indexPage.hasLogInForm());
        LoggedInPage loggedInPage = PageFactory.initElements(driver, LoggedInPage.class);
        assertFalse(loggedInPage.hasLogOutButton());
    }
}
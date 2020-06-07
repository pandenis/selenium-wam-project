package tests;

import inputdata.DataSetter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.browsers.DriverManager;
import utils.browsers.DriverManagerFactory;
import utils.browsers.DriverType;

public class LoginPageTest {
    DriverManager driverManager;
    WebDriver driver;
    LoginPage loginPage;
    WebDriverWait wait;
    DataSetter dataSetter;

    private String uRL;
    private final String CorrectUserName;
    private String CorrectPassword;



    public LoginPageTest() {
        this.uRL = dataSetter.getuRL();
        this.CorrectUserName = dataSetter.getUsername();
        this.CorrectPassword = dataSetter.getPassword();
    }

    String expectedTitle = "ContinUse";
    String getTitle;

    @BeforeClass
    public void setUp() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.FIREFOX);
        driver = driverManager.getWebDriver();
        driver.navigate().to(uRL);
    }

    @Test(priority = 0, description = "Launch the Login Page")
    public void _00loginPageTest() {
        loginPage = new LoginPage(driver);
        getTitle = driver.getTitle();
        Assert.assertEquals(getTitle, expectedTitle, "The Login Page of " + uRL + " disappears");
    }

    @Test(priority = 1, dependsOnMethods = {"_00loginPageTest"}, description = "Login with correct username and password")
    public void _01loginWithCorrectUsernameAndPassword() {

        loginPage = new LoginPage(driver);

        try {
            loginPage.login(CorrectUserName, CorrectPassword);
        } catch (NullPointerException e) {
            String  errorMessage = "Server Unavailable";
            Assert.fail(errorMessage);
        }

        wait = new WebDriverWait(driver, 20);
        //TODO Move String class_user... to Header class
        String class_usersNameInitialsLogo = "mainLayoutheader-usersNameInitialsLogo";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(class_usersNameInitialsLogo)));
        String actualURL = driver.getCurrentUrl();
        String expectedURL = uRL + "/locations";
        System.out.println(actualURL);
        Assert.assertEquals(actualURL, expectedURL, "Login failed");
    }


    @Test(priority = 2, dependsOnMethods = {"_00loginPageTest"}, description = "Login with Correct Username and incorrect password")
    public void _02loginWithCorrectUsernameAndIncorrectPassword() {
        CorrectPassword = (CorrectPassword.substring(0, 6)) + 321;

        driverManager.quitWebDriver();
        this.setUp();

        loginPage = new LoginPage(driver);

        try {
            loginPage.login(CorrectUserName, CorrectPassword);
            wait = new WebDriverWait(driver, 30);
        } catch (Exception e) {
            System.out.println("Server Unavailable");
        }

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        String actualURL = driver.getCurrentUrl();
        String expectedURL = uRL + "/LoginPage/login";
        System.out.println(actualURL);

        Assert.assertEquals(actualURL, expectedURL, "Login executed");

    }

    @AfterClass
    public void tearDown() {
        driverManager.quitWebDriver();
    }
}

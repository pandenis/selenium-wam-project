package common;

import inputdata.DataSetter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;

import java.io.IOException;

public class LoginFlow {
    WebDriverWait wait;
    WebDriver driver;
    LoginPage loginPage;

    private final String uRL;
    private final String CorrectUserName;
    private String CorrectPassword;

    DataSetter dataSetter = new DataSetter();

    public LoginFlow() throws IOException {
        this.uRL = dataSetter.getuRL();
        this.CorrectUserName = dataSetter.getUsername();
        this.CorrectPassword = dataSetter.getPassword();
    }

    public WebDriver LoginToAdminManager() {

        loginPage = new LoginPage(driver);

        try {
            loginPage.login(CorrectUserName, CorrectPassword);
        } catch (NullPointerException e) {
            String errorMessage = "Server Unavailable";
            Assert.fail(errorMessage);
        }

        wait = new WebDriverWait(driver, 20);
        //TODO Move String class_user... to Header class
        String class_usersNameInitialsLogo = "mainLayoutheader-usersNameInitialsLogo";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(class_usersNameInitialsLogo)));
        String actualURL = driver.getCurrentUrl();
        System.out.println(actualURL);

        return driver;
    }
}

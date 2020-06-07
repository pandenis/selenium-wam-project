package common;

import inputdata.DataSetter;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import java.util.Set;

public class CookiesManagement {
    LoginPage loginPage;
    DataSetter dataSetter;
    WebDriver driver;

    private final String CorrectUserName;
    private String CorrectPassword;

    public CookiesManagement(WebDriver driver) {

        this.CorrectUserName = dataSetter.getUsername();
        this.CorrectPassword = dataSetter.getPassword();
        this.driver = driver;
    }

    public Set<Cookie> getAllCookies(WebDriver driver) {
        loginPage = new LoginPage(driver);
        loginPage.login(CorrectUserName, CorrectPassword);
        return driver.manage().getCookies();
    }

    public WebDriver setAllCookies(WebDriver driver) {
        Set<Cookie> cookiesList = getAllCookies(driver);
        for (Cookie cookie : cookiesList) {
            driver.manage().addCookie(cookie);
        }
        return driver;
    }
}

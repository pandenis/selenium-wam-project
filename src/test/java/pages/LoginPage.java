package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //element locators

    private By userNameTextBox = By.name("email");
    private By passwordTextBox = By.name("password");
    private By loginButton = By.className("LoginFormComponent-LoginButton");

    public void login(String userName, String password) {
        this.setUserName(userName);
        this.setPassword(password);
        this.clickLogin();

    }

    public void setUserName(String userName) {
        driver.findElement(userNameTextBox).sendKeys(userName);
    }

    public void setPassword(String password) {
        driver.findElement(passwordTextBox).sendKeys(password);
    }


    public void clickLogin() {
        try {
            driver.findElement(loginButton).click();
        } catch (NullPointerException e) {

        }

    }
}

package utils.browsers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverManager extends DriverManager{
    protected void createWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        this.driver = new FirefoxDriver();
    }
}

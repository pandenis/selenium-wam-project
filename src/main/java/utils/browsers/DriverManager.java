package utils.browsers;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
    protected WebDriver driver;
    protected abstract void createWebDriver();
    public void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getWebDriver() {
        if (driver == null) {
            createWebDriver();
        }
        return driver;
    }

    public WebDriver resetWebDriver() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
        }
        return driver;
    }

    public WebDriver restartWebDriver() {
        if (driver != null) {
//            this.resetWebDriver();
            this.quitWebDriver();
            this.getWebDriver();
        }
        return driver;
    }
}

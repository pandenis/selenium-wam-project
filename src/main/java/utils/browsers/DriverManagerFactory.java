package utils.browsers;

public class DriverManagerFactory {
    public static DriverManager getDriverManager (DriverType type) {
        DriverManager driverManager;
        switch (type) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
                //more browsers here
            default:
                driverManager = new FirefoxDriverManager();
                break;
        }
        return driverManager;
    }
}

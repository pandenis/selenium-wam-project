package tests;

import common.LoginFlow;
import inputdata.DataSetter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pages.LocationPage;
import utils.browsers.DriverManager;
import utils.browsers.DriverManagerFactory;
import utils.browsers.DriverType;

import java.io.IOException;

public class LocationPageCRUDTest {
    DriverManager driverManager;
    WebDriver driver;
    LoginFlow loginFlow;
    WebDriverWait wait;
    DataSetter dataSetter;
    LocationPage locationPage;

    private final String uRL;
    private final String locationName;
    private final String locationDescription;

    public LocationPageCRUDTest(String uRL, String locationName, String description) throws IOException {
        this.uRL = uRL;
        this.locationName = locationName;
        this.locationDescription = description;
    }

    @BeforeClass
    public void setUp() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.FIREFOX);
        driver = driverManager.getWebDriver();
        driver.navigate().to(uRL);
        loginFlow.LoginToAdminManager();
    }

    @Test(priority = 0, description = "Create Location")
    public void _01createLocation_setGeneralInformation() {
        locationPage = new LocationPage(driver);
        locationPage.generalInformationContainer(locationName, "type", locationDescription);
    }
}

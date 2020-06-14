package tests;

import common.CookiesManagement;
import common.DropDownList;
import common.LoginFlow;
import inputdata.DataSetter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
    CookiesManagement cookiesManagement;
    LocationPage locationPage;
    String dropDownElement;

    private final String uRL;
    private final String locationName;
    private final String locationDescription;

    public LocationPageCRUDTest() throws IOException {
        this.dataSetter = new DataSetter();
        this.uRL = dataSetter.getuRL();
        this.locationName = "Loc name";
        this.locationDescription = "Loc desc";
    }

    @BeforeClass
    public void setUp() throws IOException {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.FIREFOX);
        driver = driverManager.getWebDriver();
        driver.navigate().to(uRL);
        cookiesManagement = new CookiesManagement();
//        cookiesManagement.getAllCookies(driver);
        driver = cookiesManagement.cookieWrite(driver);
        //driver = cookiesManagement.setAllCookies(driver);
        driver.navigate().to(uRL + "/locations");

    }

    @Test(priority = 0, description = "Create Location")
    public void _01createLocation_setGeneralInformation() {

        dropDownElement = new DropDownList().getElementByNumber(locationPage.getLocationTypeDropDownList(), 0);
        locationPage = new LocationPage(driver);
        locationPage.generalInformationContainer(locationName, dropDownElement, locationDescription);
    }
}

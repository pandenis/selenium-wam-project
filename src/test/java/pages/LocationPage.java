package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocationPage {
    WebDriver driver;

    public LocationPage(WebDriver driver) {
        this.driver = driver;
    }

    //General Information element locators
    private By createNewButton = By.className("EntitiesComponentHeader-CreateButton");
    private By locationNameTextField = By.name("locationName");
   // private By LocationTypeArrow = By.cssSelector("svg.css-19bqh2r");
    private By locationTypeDropDownList = By.id("react-select-2-option-0");
    private By locationDescription = By.name("locationDescription");
    private By saveButton = By.xpath("(//div[text()='SAVE'])");
    private By cancelButton = By.xpath("(//div[text()='Cancel'])");

    public void generalInformationContainer(String locationName, String type, String description) {
        this.clickCreateNew();
        this.setLocationNameTextField(locationName);
        this.setLocationTypeDropDownList(type);
        this.setLocationDescription(description);
        this.clickSave();
    }

    public void setLocationNameTextField(String locationName) {
        driver.findElement(locationNameTextField).sendKeys(locationName);
    }

    public void setLocationTypeDropDownList(String type) {
        driver.findElement(locationTypeDropDownList).sendKeys(type);
    }

    public void setLocationDescription(String description) {
        driver.findElement(locationDescription).sendKeys(description);
    }

    public void clickCreateNew() {
        try {
            driver.findElement(createNewButton).click();
        } catch (NullPointerException e) {}
    }

    public void clickSave() {
        try {
            driver.findElement(saveButton).click();
        } catch (NullPointerException e) {}
    }

    public void clickCancel() {
        try {
            driver.findElement(cancelButton).click();
        } catch (NullPointerException e) {}
    }


    //Address

//    private By countryTypeArrow = By.cssSelector("svg.css-19bqh2r");
    private By countryTypeDropDownList = By.id("react-seled-3-input");
//    private By stateTypeArrow = By.cssSelector("");
    private By stateTypeDropDownList = By.id("react-select-4-input");
//    private By cityTypeArrow = By.cssSelector("");
    private By cityTypeDropDownList = By.id("react-select-5-input");
    private By locationAddressTextField = By.name("locationAddress");

    private By createButton = By.xpath("//div[text()='CREATE']");
}
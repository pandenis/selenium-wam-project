package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownList {

    WebDriver driver;
    WebElement dropDown;
    String id;

/*    public DropDownList(WebDriver driver, WebElement dropDown, String xpath, Integer elementNumber) {
        this.driver = driver;
        this.dropDown = dropDown;
        this.id = xpath;
        this.elementNumber = elementNumber;
    }

    public DropDownList(WebElement dropDown, String xpath) {

        this.dropDown = dropDown;
        this.id = xpath;
        this.elementNumber = 0;
    }
    */
    public DropDownList() {

    }

    private By dropDownList = By.id(id);

    public String getElementByNumber(By dropDownList, Integer elementNumber) {
        this.dropDownList = dropDownList;
        dropDown = driver.findElement(this.dropDownList);
        Select select = new Select(dropDown);
        List<WebElement> elements = select.getOptions();
        WebElement element = elements.get(elementNumber);
        return element.getText();
    }

    public By getDropDownList() {
        return dropDownList;
    }
}

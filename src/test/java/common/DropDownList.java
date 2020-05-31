package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownList {

    WebDriver driver;
    WebElement dropDown;
    String xpath;
    Integer elementNumber;

    public DropDownList(WebDriver driver, WebElement dropDown, String xpath, Integer elementNumber) {
        this.driver = driver;
        this.dropDown = dropDown;
        this.xpath = xpath;
        this.elementNumber = elementNumber;
    }

    public DropDownList(WebElement dropDown, String xpath) {
        this.dropDown = dropDown;
        this.xpath = xpath;
        this.elementNumber = 0;
    }

    private By dropDownList = By.xpath(xpath);

    public String getElementByNumber() {
        dropDown = driver.findElement(dropDownList);
        Select select = new Select(dropDown);
        List<WebElement> elements = select.getOptions();
        WebElement element = elements.get(elementNumber);
        String elementText = element.getText();
        return elementText;
    }
}

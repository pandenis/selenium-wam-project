package common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextField {

    WebDriver driver;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public TextField(WebDriver driver) {
        this.driver = driver;
    }
    public TextField() {
    }

    private By textBox = By.name(name);

    public void cleanTextFieldByName(String fieldName){
        driver.findElement(textBox).clear();
    }



    public By getTextBox() {
        return textBox;
    }

    public void setTextBox(By textBox) {
        this.textBox = textBox;
    }
}

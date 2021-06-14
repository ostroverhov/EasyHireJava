package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ComboBox {

    private final BaseElement element;

    public ComboBox(String name, By locator, WebDriver driver) {
        this.element = new BaseElement(String.format("[%s] comboBox", name), locator, driver);
    }

    public void click() {
        element.click();
    }

    public void SelectByValue(String value) {
        new Select(element.getElement()).selectByValue(value);
    }

    public void SelectByText(String text) {
        new Select(element.getElement()).selectByVisibleText(text);
    }
}

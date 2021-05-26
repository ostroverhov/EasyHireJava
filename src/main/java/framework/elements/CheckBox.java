package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckBox {

    private final BaseElement element;

    public CheckBox(String name, By locator, WebDriver driver) {
        this.element = new BaseElement(String.format("[%s] checkBox", name), locator, driver);
    }

    public void click() {
        element.click();
    }
}

package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TextBox {

    private final BaseElement element;

    public TextBox(String name, By locator, WebDriver driver) {
        this.element = new BaseElement(String.format("[%s] textBox", name), locator, driver);
    }

    public void clearAndType(String text) {
        element.clearAndType(text);
    }
}

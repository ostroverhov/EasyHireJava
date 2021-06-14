package framework.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Label {

    private final BaseElement element;

    public Label(String name, By locator, WebDriver driver) {
        this.element = new BaseElement(String.format("[%s] label", name), locator, driver);
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    public String getText() {
        return element.getText();
    }

    public String getValue() {
        return element.getValue();
    }

    public boolean waitForText(String text) {
        return element.waitForText(text);
    }

    public void clickElementFromList(int elementNumber) {
        element.clickElementFromList(elementNumber);
    }

    public int countElements() {
        return element.countElements();
    }
}

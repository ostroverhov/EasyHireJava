package framework.elements;

import framework.steps.BaseSteps;
import framework.utils.ConfigReader;
import framework.utils.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseElement {

    protected String name;
    private By locator;
    private WebDriver driver;
    private static final Logger logger = Logger.getInstance();

    public BaseElement(String name, By locator, WebDriver driver) {
        this.name = name;
        this.locator = locator;
        this.driver = driver;
    }

    protected WebElement getElement() {
        logger.info("Get element [%s]", name);
        return driver.findElement(locator);
    }

    protected List<WebElement> getElements() {
        logger.info("Get elements [%s]", name);
        return driver.findElements(locator);
    }

    protected boolean isDisplayed() {
        logger.info("Is element [%s] displayed", name);
        return getElement().isDisplayed();
    }

    protected boolean isPresent() {
        logger.info("Is element [%s] present", name);
        try {
            getElement();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void click() {
        logger.info("Click on element [%s]", name);
        getElement().click();
    }

    protected void clearAndType(String text) {
        logger.info("Type text [%s] in element [%s]", text, name);
        getElement().clear();
        getElement().sendKeys(text);
    }

    protected String getText() {
        logger.info("Get text from element [%s]", name);
        return getElement().getText();
    }

    protected String getValue() {
        logger.info("Get value from element [%s]", name);
        return getElement().getAttribute("value");
    }

    protected boolean waitForText(String text) {
        logger.info("Wait text [%s] from element [%s]", text, name);
        return new WebDriverWait(driver, Integer.parseInt(ConfigReader.getParameter("ImplicitlyWait")))
                .until(ExpectedConditions.textToBe(locator, text));
    }

    public void clickElementFromList(int elementNumber)
    {
        logger.info("Click element [%d] from List [%s]", elementNumber, name);
        getElements().get(elementNumber).click();
    }

    public int countElements()
    {
        logger.info("Get count of elements [%s]", name);
        return getElements().size();
    }
}

package framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private static final int timeout = Integer.parseInt(ConfigReader.getParameter("Wait"));

    public static boolean waitForTextToBe(String text, WebDriver driver, By locator) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.textToBe(locator, text));
    }

    public static WebElement waitForVisibilityElement(WebDriver driver, By locator) {
        return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

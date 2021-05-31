package framework.pages;

import framework.utils.Logger;
import framework.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {

    private final String namePage;
    private final By locator;
    protected final WebDriver driver;

    public BasePage(String namePage, By locator, WebDriver driver) {
        this.namePage = namePage;
        this.locator = locator;
        this.driver = driver;
    }

    public boolean isPresentPage(){
        Logger.getInstance().info("Is [%s] opened", namePage);
        return WaitUtils.waitForVisibilityElement(driver, locator).isDisplayed();
    }
}

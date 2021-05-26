package pages.forms;

import enums.MyAccountSideMenuItem;
import framework.elements.Button;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class MyAccountHeaderForm extends BasePage {

    public MyAccountHeaderForm(WebDriver driver) {
        super("My account header form", By.cssSelector("div.Header-buttonsWrap-28"), driver);
    }

    private Button menuButton = new Button("Menu", By.cssSelector("[aria-label=Menu] > span.MuiIconButton-label"), driver);

    private Label sideMenuLabel = new Label("Side menu", By.cssSelector("[role=menu]"), driver);

    private Button sideMenuButton(MyAccountSideMenuItem item) {
        return new Button(item.getTitle(), By.xpath(String.format("//ul[@role='menu']//*[contains(text(), '%s')]", item.getTitle())), driver);
    }

    private Label userProfileLabel = new Label("User profile", By.cssSelector("[class*='(CurrentUserProfile)-main']"), driver);

    private Label firstNameLabel = new Label("First name", By.cssSelector("[name='name.first']"), driver);

    private Label lastNameLabel = new Label("Last name", By.cssSelector("[name='name.last']"), driver);

    private Label emailLabel = new Label("Email", By.cssSelector("[name='email']"), driver);

    public void clickMenuButton() {
        menuButton.click();
    }

    public boolean isSideMenuPresent() {
        return sideMenuLabel.isDisplayed();
    }

    public void clickSideMenuButton(MyAccountSideMenuItem item) {
        sideMenuButton(item).click();
    }

    public boolean isUserProfilePresent() {
        return userProfileLabel.isDisplayed();
    }

    public String getValueFromFirstName() {
        return firstNameLabel.getValue();
    }

    public String getValueFromLastName() {
        return lastNameLabel.getValue();
    }

    public String getValueFromEmail() {
        return emailLabel.getValue();
    }
}

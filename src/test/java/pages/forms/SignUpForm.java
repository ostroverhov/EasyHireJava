package pages.forms;

import enums.AccountTypeItem;
import framework.elements.Button;
import framework.elements.CheckBox;
import framework.elements.Label;
import framework.elements.TextBox;
import framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpForm extends BasePage {

    public SignUpForm(WebDriver driver) {
        super("Sign Up form", By.cssSelector("header.MuiPaper-root"), driver);
    }

    private Button accountButton(AccountTypeItem item) {
        return new Button(item.getTitle(), By.xpath(String.format("//span[contains(text(), '%s') and @class='MuiTab-wrapper']", item.getTitle())), driver);
    }

    private TextBox emailTextBox = new TextBox("Email", By.name("email"), driver);

    private TextBox firstNameTextBox = new TextBox("First name", By.name("firstName"), driver);

    private TextBox lastNameTextBox = new TextBox("Last name", By.name("lastName"), driver);

    private TextBox passwordNameTextBox = new TextBox("Password", By.name("password"), driver);

    private CheckBox termsAndConditionsCheckBox = new CheckBox("Terms and conditions", By.name("termAgree"), driver);

    private Label signUpAlertLabel = new Label("Sign Up", By.id("message-id"), driver);

    private Button signUpButton =
            new Button("Sign Up", By.xpath("//button//span[@class='MuiTouchRipple-root']/preceding-sibling::span[contains(text(), 'Sign up')]"), driver);

    public void selectAccountType(AccountTypeItem item) {
        accountButton(item).click();
    }

    public SignUpForm typeEmail(String email) {
        emailTextBox.clearAndType(email);
        return this;
    }

    public SignUpForm typeFirstName(String firstName) {
        firstNameTextBox.clearAndType(firstName);
        return this;
    }

    public SignUpForm typeLastName(String lastName) {
        lastNameTextBox.clearAndType(lastName);
        return this;
    }

    public SignUpForm typePassword(String password) {
        passwordNameTextBox.clearAndType(password);
        return this;
    }

    public void clickTermsAndConditions() {
        termsAndConditionsCheckBox.click();
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public boolean isSignUpButtonPresent() {
        return signUpButton.isPresent();
    }

    public boolean waitTextFromSignUpAlert(String text) {
        return signUpAlertLabel.waitForText(text);
    }
}

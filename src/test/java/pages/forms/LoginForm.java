package pages.forms;

import framework.elements.Button;
import framework.elements.Label;
import framework.elements.TextBox;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class LoginForm extends BasePage {

    public LoginForm(WebDriver driver) {
        super("Login form", By.cssSelector("header.MuiPaper-root"), driver);
    }

    private TextBox emailTextBox = new TextBox("Login", By.name("email"), driver);

    private TextBox passwordTextBox = new TextBox("Password", By.name("password"), driver);

    private Button loginButton = new Button("Login",
            By.xpath("//button//span[@class='MuiTouchRipple-root']/preceding-sibling::span[contains(text(), 'Log in')]"), driver);

    private Label messageAlertLabel = new Label("Message alert", By.id("message-id"), driver);

    public LoginForm typeEmail(String email){
        emailTextBox.clearAndType(email);
        return this;
    }

    public LoginForm typePassword(String password){
        passwordTextBox.clearAndType(password);
        return this;
    }

    public void clickLogin(){
        loginButton.click();
    }

    public boolean waitTextFromAlert(String text) {
        return messageAlertLabel.waitForText(text);
    }
}

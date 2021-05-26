package pages;

import framework.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super("Main page", By.tagName("video"), driver);
    }

    private Button signUpButton = new Button("Sign up", By.xpath("//span[contains(text(), 'Free sign up')]"), driver);

    public void clickSignUpButton() {
        signUpButton.click();
    }
}

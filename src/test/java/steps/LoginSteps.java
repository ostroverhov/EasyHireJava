package steps;

import framework.steps.BaseSteps;
import models.TestUser;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.forms.LoginForm;

public class LoginSteps extends BaseSteps {

    private final LoginForm loginForm;

    public LoginSteps(WebDriver driver) {
        loginForm = new LoginForm(driver);
    }

    public void checkLoginForm() {
        LogAssertion();
        loginForm.isPresentPage();
    }

    public void typeLoginData(TestUser testUser) {
        LogStep();
        loginForm.typeEmail(testUser.getEmail())
                .typePassword(testUser.getPassword());
    }

    public void clickLoginButton() {
        LogStep();
        loginForm.clickLogin();
    }

    public void checkAccountNotFoundAlert() {
        LogAssertion();
        Assertions.assertTrue(loginForm.waitTextFromAlert("Account not activated"),
                "Alert message is not presented");
    }
}

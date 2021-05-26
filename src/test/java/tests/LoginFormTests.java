package tests;

import enums.HeaderButtonItem;
import framework.utils.ConfigReader;
import models.TestData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.HeaderSteps;
import steps.LoginSteps;
import steps.MainPageSteps;
import steps.MyAccountHeaderFormSteps;

public class LoginFormTests extends BaseTest {

    private final MainPageSteps mainPageSteps = new MainPageSteps(browserFactory.getDriver());
    private final HeaderSteps headerSteps = new HeaderSteps(browserFactory.getDriver());
    private final LoginSteps loginSteps = new LoginSteps(browserFactory.getDriver());
    private final MyAccountHeaderFormSteps myAccountHeaderFormSteps =
            new MyAccountHeaderFormSteps(browserFactory.getDriver());

    @BeforeEach
    public void openLoginForm() {
        mainPageSteps.checkMainPage();
        headerSteps.checkHeaderForm();
        headerSteps.clickHeaderButton(HeaderButtonItem.LOGIN);
        loginSteps.checkLoginForm();
    }

    @Test
    @DisplayName("Successful login")
    public void successfulLogin() {
        loginSteps.typeLoginData(ConfigReader.getObjectFromJson(TestData.class).getLoginUser());
        loginSteps.clickLoginButton();
        myAccountHeaderFormSteps.checkMyAccountHeaderFormPage();
    }

    @Test
    @DisplayName("Login with incorrect data")
    public void loginWithIncorrectData() {
        loginSteps.typeLoginData(ConfigReader.getObjectFromJson(TestData.class).getSignUpUser());
        loginSteps.clickLoginButton();
        loginSteps.checkAccountNotFoundAlert();
    }
}

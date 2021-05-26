package tests;

import enums.HeaderButtonItem;
import enums.MyAccountSideMenuItem;
import framework.utils.ConfigReader;
import models.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.HeaderSteps;
import steps.LoginSteps;
import steps.MainPageSteps;
import steps.MyAccountHeaderFormSteps;

public class MyAccountPageTests extends BaseTest {

    private final MainPageSteps mainPageSteps = new MainPageSteps(browserFactory.getDriver());
    private final HeaderSteps headerSteps = new HeaderSteps(browserFactory.getDriver());
    private final LoginSteps loginSteps = new LoginSteps(browserFactory.getDriver());
    private final MyAccountHeaderFormSteps myAccountHeaderFormSteps =
            new MyAccountHeaderFormSteps(browserFactory.getDriver());

    @Test
    @DisplayName("Check profile information")
    public void CheckProfileInformation() {
        mainPageSteps.checkMainPage();
        headerSteps.checkHeaderForm();
        headerSteps.clickHeaderButton(HeaderButtonItem.LOGIN);
        loginSteps.checkLoginForm();
        loginSteps.typeLoginData(ConfigReader.getObjectFromJson(TestData.class).getLoginUser());
        loginSteps.clickLoginButton();
        myAccountHeaderFormSteps.checkMyAccountHeaderFormPage();
        myAccountHeaderFormSteps.clickMenuButton();
        myAccountHeaderFormSteps.checkSideMenu();
        myAccountHeaderFormSteps.clickSideMenuButton(MyAccountSideMenuItem.SETTINGS);
        myAccountHeaderFormSteps.checkUserProfileOnMyAccount();
        myAccountHeaderFormSteps.checkProfileInformation();
    }
}

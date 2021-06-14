package steps;

import enums.MyAccountSideMenuItem;
import framework.utils.ConfigReader;
import framework.steps.BaseSteps;
import models.TestData;
import models.TestUser;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.forms.MyAccountHeaderForm;

public class MyAccountHeaderFormSteps extends BaseSteps {

    private final MyAccountHeaderForm myAccountHeaderForm;
    private final TestUser testUser = ConfigReader.getObjectFromJson(TestData.class).getLoginUser();

    public MyAccountHeaderFormSteps(WebDriver driver) {
        myAccountHeaderForm = new MyAccountHeaderForm(driver);
    }

    public void checkMyAccountHeaderFormPage() {
        LogAssertion();
        Assertions.assertTrue(myAccountHeaderForm.isPresentPage(), "My account header form should be presented");
    }

    public void clickMenuButton() {
        LogStep();
        myAccountHeaderForm.clickMenuButton();
    }

    public void checkSideMenu() {
        LogAssertion();
        Assertions.assertTrue(myAccountHeaderForm.isSideMenuPresent(), "Side menu should be presented");
    }

    public void clickSideMenuButton(MyAccountSideMenuItem item) {
        LogStep();
        myAccountHeaderForm.clickSideMenuButton(item);
    }

    public void checkUserProfileOnMyAccount(){
        LogAssertion();
        Assertions.assertTrue(myAccountHeaderForm.isUserProfilePresent(), "User profile should be presented");
    }

    public void checkProfileInformation()
    {
        LogAssertion();
        Assertions.assertAll(
                () -> Assertions.assertEquals(testUser.getEmail(), myAccountHeaderForm.getValueFromEmail()),
                () -> Assertions.assertEquals(testUser.getFirstName(), myAccountHeaderForm.getValueFromFirstName()),
                () -> Assertions.assertEquals(testUser.getLastName(), myAccountHeaderForm.getValueFromLastName())
        );
    }
}

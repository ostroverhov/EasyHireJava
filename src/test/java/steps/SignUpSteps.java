package steps;

import enums.AccountTypeItem;
import framework.steps.BaseSteps;
import models.TestUser;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.forms.SignUpForm;

public class SignUpSteps extends BaseSteps {

    private final SignUpForm signUpForm;

    public SignUpSteps(WebDriver driver) {
        signUpForm = new SignUpForm(driver);
    }

    public void checkSignUpForm() {
        LogAssertion();
        Assertions.assertTrue(signUpForm.isPresentPage(), "Sign up form should be presented");
    }

    public void selectAccount(AccountTypeItem item) {
        LogStep();
        signUpForm.selectAccountType(item);
    }

    public void typeSignUpData(TestUser testUser){
        LogStep();
        signUpForm.typeEmail(testUser.getEmail())
                .typeFirstName(testUser.getFirstName())
                .typeLastName(testUser.getLastName())
                .typePassword(testUser.getPassword());
    }

    public void clickTermsAndConditionsCheckBox(){
        LogStep();
        signUpForm.clickTermsAndConditions();
    }

    public void clickSignUpButton() {
        LogStep();
        signUpForm.clickSignUpButton();
    }

    public void checkSignUpAlertMessage() {
        LogAssertion();
        Assertions.assertTrue(signUpForm.waitTextFromSignUpAlert("Thank you for signing up! Please check your email to activate your account."),
                "Sign up alert message is not correct");
    }

    public void checkSignUpButtonNotActive() {
        LogAssertion();
        Assertions.assertFalse(signUpForm.isSignUpButtonPresent(), "Sign up button should not be active");
    }
}

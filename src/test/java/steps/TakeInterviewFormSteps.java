package steps;

import framework.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import pages.forms.TakeInterviewForm;

public class TakeInterviewFormSteps extends BaseSteps {

    private final TakeInterviewForm takeInterviewForm;

    public TakeInterviewFormSteps(WebDriver driver) {
        takeInterviewForm = new TakeInterviewForm(driver);
    }

    public void checkTakeInterviewForm() {
        LogAssertion();
        Assertions.assertTrue(takeInterviewForm.isPresentPage(), "Take interview form page should be presented");
    }

    public void typeEmail(String email) {
        LogStep();
        takeInterviewForm.typeEmail(email);
    }

    public void acceptTermsAndConditions(){
        LogStep();
        takeInterviewForm.clickTermsAndConditionsCheckBox();
    }

    public void clickRequestInterviewButton() {
        LogStep();
        takeInterviewForm.clickRequestInterviewButton();
    }

    public void checkTakeInterviewAlertMessage() {
        LogAssertion();
        Assertions.assertTrue(takeInterviewForm.waitTextFromAlert("The Interview invitation is sent. Please, check your e-mail."),
                "Take interview alert message is not correct");
    }
}

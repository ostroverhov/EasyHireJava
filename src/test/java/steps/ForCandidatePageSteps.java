package steps;

import framework.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.ForCandidatePage;

import java.util.Random;

public class ForCandidatePageSteps extends BaseSteps {

    private final ForCandidatePage forCandidatePage;

    public ForCandidatePageSteps(WebDriver driver) {
        forCandidatePage = new ForCandidatePage(driver);
    }

    public void checkForCandidatePage() {
        LogAssertion();
        Assertions.assertTrue(forCandidatePage.isPresentPage(), "For candidate page should be presented");
    }

    public void selectRandomInterviewLanguage() {
        LogStep();
        forCandidatePage.clickSelectLanguageComboBox();
        forCandidatePage.clickComboBoxItem(new Random().nextInt(forCandidatePage.sizeComboBox()));
    }

    public void selectRandomQuestionCategory() {
        LogStep();
        forCandidatePage.clickSelectQuestionCategoryComboBox();
        forCandidatePage.clickComboBoxItem(new Random().nextInt(forCandidatePage.sizeComboBox()));
    }

    public void clickTakeInterviewOnPanel() {
        LogStep();
        forCandidatePage.clickTakeInterviewOnPanel();
    }
}

package tests;

import enums.HeaderButtonItem;
import framework.utils.ConfigReader;
import models.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.ForCandidatePageSteps;
import steps.HeaderSteps;
import steps.MainPageSteps;
import steps.TakeInterviewFormSteps;

public class ForCandidatePageTests extends BaseTest {

    private final MainPageSteps mainPageSteps = new MainPageSteps(browserFactory.getDriver());
    private final HeaderSteps headerSteps = new HeaderSteps(browserFactory.getDriver());
    private final ForCandidatePageSteps forCandidatePageSteps = new ForCandidatePageSteps(browserFactory.getDriver());
    private final TakeInterviewFormSteps takeInterviewFormSteps = new TakeInterviewFormSteps(browserFactory.getDriver());

    @Test
    @DisplayName("Take interview through the candidate page")
    public void takeInterviewThroughTheCandidatePage() {
        mainPageSteps.checkMainPage();
        headerSteps.checkHeaderForm();
        headerSteps.clickHeaderButton(HeaderButtonItem.FORCANDIDATE);
        forCandidatePageSteps.checkForCandidatePage();
        forCandidatePageSteps.selectRandomInterviewLanguage();
        forCandidatePageSteps.selectRandomQuestionCategory();
        forCandidatePageSteps.clickTakeInterviewOnPanel();
        takeInterviewFormSteps.checkTakeInterviewForm();
        takeInterviewFormSteps.typeEmail(ConfigReader.getObjectFromJson(TestData.class).getSignUpUser().getEmail());
        takeInterviewFormSteps.acceptTermsAndConditions();
        takeInterviewFormSteps.clickRequestInterviewButton();
        takeInterviewFormSteps.checkTakeInterviewAlertMessage();
    }
}

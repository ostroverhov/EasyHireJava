package tests;

import enums.AccountTypeItem;
import framework.tests.BaseTest;
import framework.utils.ConfigReader;
import models.TestData;
import models.TestUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import steps.MainPageSteps;
import steps.SignUpSteps;

import java.util.stream.Stream;

public class SignUpFormTest extends BaseTest {

    private final MainPageSteps mainPageSteps = new MainPageSteps(browserFactory.getDriver());
    private final SignUpSteps signUpSteps = new SignUpSteps(browserFactory.getDriver());

    @BeforeEach
    public void openSignUpForm() {
        mainPageSteps.checkMainPage();
        mainPageSteps.clickSignUpButton();
        signUpSteps.checkSignUpForm();
    }

    @ParameterizedTest
    @EnumSource(AccountTypeItem.class)
    @DisplayName("Successful create account test")
    public void successfulCreateAccountTest(AccountTypeItem accountTypeItem) {
        signUpSteps.selectAccount(accountTypeItem);
        signUpSteps.typeSignUpData(ConfigReader.getObjectFromJson(TestData.class).getSignUpUser());
        signUpSteps.clickTermsAndConditionsCheckBox();
        signUpSteps.clickSignUpButton();
        signUpSteps.checkSignUpAlertMessage();
    }

    @ParameterizedTest
    @MethodSource("signUpTestUsers")
    @DisplayName("SignUp without data")
    public void signUpWithoutData(TestUser testUser) {
        signUpSteps.selectAccount(AccountTypeItem.APPLICANT);
        signUpSteps.typeSignUpData(testUser);
        signUpSteps.clickTermsAndConditionsCheckBox();
        signUpSteps.checkSignUpButtonNotActive();
    }

    static Stream<TestUser> signUpTestUsers() {
        return Stream.of(
                new TestUser("easyhirenew@gmail.com", "Easy", "Hire", ""),
                new TestUser("easyhirenew@gmail.com", "Easy", "", "Test1234@"),
                new TestUser("easyhirenew@gmail.com", "", "Hire", "Test1234@"),
                new TestUser("", "Easy", "Hire", "Test1234@")
        );
    }
}
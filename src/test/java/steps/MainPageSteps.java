package steps;

import framework.steps.BaseSteps;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.MainPage;

public class MainPageSteps extends BaseSteps {

    private final MainPage mainPage;

    public MainPageSteps(WebDriver driver) {
        mainPage = new MainPage(driver);
    }

    public void checkMainPage() {
        LogAssertion();
        Assertions.assertTrue(mainPage.isPresentPage(), "Main page should be presented");
    }

    public void clickSignUpButton() {
        LogStep();
        mainPage.clickSignUpButton();
    }
}

package steps;

import enums.HeaderButtonItem;
import framework.steps.BaseSteps;
import org.openqa.selenium.WebDriver;
import pages.forms.HeaderForm;

public class HeaderSteps extends BaseSteps {

    private final HeaderForm headerForm;

    public HeaderSteps(WebDriver driver) {
        headerForm = new HeaderForm(driver);
    }

    public void clickHeaderButton(HeaderButtonItem item){
        LogStep();
        headerForm.clickHeaderButton(item);
    }

    public void checkHeaderForm(){
        LogAssertion();
        headerForm.isPresentPage();
    }
}

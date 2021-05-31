package pages.forms;

import framework.elements.Button;
import framework.elements.CheckBox;
import framework.elements.Label;
import framework.elements.TextBox;
import framework.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TakeInterviewForm extends BasePage {

    public TakeInterviewForm(WebDriver driver) {
        super("Take interview form", By.cssSelector("div.MuiDialog-container"), driver);
    }

    private TextBox emailTextBox = new TextBox("Email", By.name("email"), driver);

    private CheckBox termsAndConditionsCheckBox = new CheckBox("Terms and conditions", By.name("termAgree"), driver);

    private Button requestInterviewButton = new Button("Request practice interview",
            By.xpath("//button//span[@class='MuiTouchRipple-root']/preceding-sibling::span[contains(text(), 'Request practice interview')]"), driver);

    private Label takeInterviewAlertLabel = new Label("Take interview alert",By.id("message-id"), driver);


    public void typeEmail(String email) {
        emailTextBox.clearAndType(email);
    }

    public void clickTermsAndConditionsCheckBox(){
        termsAndConditionsCheckBox.click();
    }

    public void clickRequestInterviewButton() {
        requestInterviewButton.click();
    }

    public boolean waitTextFromAlert(String text){
        return takeInterviewAlertLabel.waitForText(text);
    }
}

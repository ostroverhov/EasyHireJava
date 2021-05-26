package pages;

import framework.elements.Button;
import framework.elements.ComboBox;
import framework.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForCandidatePage extends BasePage {

    public ForCandidatePage(WebDriver driver) {
        super("For candidate page", By.cssSelector(".vjs-tech"), driver);
    }

    private ComboBox selectLanguageComboBox = new ComboBox("Select language",
            By.xpath("//label[contains(text(), 'Select language')]/following-sibling::div//input"), driver);

    private ComboBox selectQuestionCategoryComboBox = new ComboBox("Select question category",
            By.xpath("//label[contains(text(), 'Select question category')]/following-sibling::div//input"), driver);

    private Label comboBoxItemLabel = new Label("ComboBox item", By.cssSelector("[role=option]"), driver);

    private Button takeInterviewButtonOnPanel = new Button("Take interview on panel",
            By.xpath("//button//span[contains(text(), 'Take practice interview')] "), driver);

    public void clickSelectLanguageComboBox() {
        selectLanguageComboBox.click();
    }

    public void clickSelectQuestionCategoryComboBox() {
        selectQuestionCategoryComboBox.click();
    }

    public void clickComboBoxItem(int item) {
        comboBoxItemLabel.clickElementFromList(item);
    }

    public int sizeComboBox() {
        return comboBoxItemLabel.countElements();
    }

    public void clickTakeInterviewOnPanel() {
        takeInterviewButtonOnPanel.click();
    }
}

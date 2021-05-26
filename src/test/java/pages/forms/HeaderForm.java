package pages.forms;

import enums.HeaderButtonItem;
import framework.elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class HeaderForm extends BasePage {

    public HeaderForm(WebDriver driver) {
        super("Header form", By.cssSelector("[alt=logo]"), driver);
    }

    private Button headerButton(HeaderButtonItem item) {
        return new Button(item.getTitle(), By.xpath(String.format("//span[contains(text(), '%s') and @class='MuiButton-label']", item.getTitle())), driver);
    }

    public void clickHeaderButton(HeaderButtonItem item) {
        headerButton(item).click();
    }
}

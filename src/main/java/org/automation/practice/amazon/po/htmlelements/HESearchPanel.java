package org.automation.practice.amazon.po.htmlelements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Select;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by alexanderzaverukha on 3/5/17.
 */

@Name("Search Panel")
@FindBy(className = "nav-searchbar")
public class HESearchPanel extends HtmlElement {

    @FindBy(id = "twotabsearchtextbox")
    private TextInput searchType;

    @FindBy(className = "nav-input")
    private Button submitButton;

    @FindBy(id = "searchDropdownBox")
    private Select topic;

    public void search(String searchFor, String option){
        searchType.sendKeys(searchFor);
        topic.selectByVisibleText(option);
        submitButton.click();
    }
}

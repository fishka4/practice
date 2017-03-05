package org.automation.practice.amazon.po.htmlelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

/**
 * Created by alexanderzaverukha on 3/5/17.
 */
@Name("Search Result")
@FindBy(id = "s-results-list-atf")
public class HESearchResult extends HtmlElement {
    @FindBy(className = "s-item-container")
    private List<HtmlElement> result;

    public List<HtmlElement> getResult(){
        return this.result;
    }
}

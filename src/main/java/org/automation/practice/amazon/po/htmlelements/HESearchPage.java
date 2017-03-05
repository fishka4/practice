package org.automation.practice.amazon.po.htmlelements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Created by alexanderzaverukha on 3/5/17.
 */
public class HESearchPage {

    HESearchPanel heSearchPanel;

    HESearchResult heSearchResult;

    public HESearchPage(WebDriver driver){
        HtmlElementDecorator htmlElementDecorator = new HtmlElementDecorator(new HtmlElementLocatorFactory(driver));
         PageFactory.initElements(htmlElementDecorator,this);
    }

    public void search(String searchFor, String option){
        heSearchPanel.search(searchFor, option);
        heSearchResult.getResult();
    }

}

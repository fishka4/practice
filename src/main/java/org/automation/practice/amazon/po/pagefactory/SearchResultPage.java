package org.automation.practice.amazon.po.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by alexanderzaverukha on 3/5/17.
 */
public class SearchResultPage {

    @FindBy(xpath = "//*[@id='s-results-list-atf']//*[@class='s-item-container']")
    private List<WebElement> result;

    public List<WebElement> getResult(){
        return this.result;
    }

}

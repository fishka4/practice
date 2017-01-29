package org.automation.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alexanderzaverukha on 1/29/17.
 */
public class YouTube extends WebBase {
    protected void openApp(){
        getDriver().get("http://www.youtube.com");
    }

    protected void search(String string){
        //masthead-search-term
        WebElement element = getDriver().findElementById("masthead-search-term");
        element.sendKeys(string);
        element.submit();
        (new WebDriverWait(getDriver(), 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().startsWith(string);
            }
        });
    }
}

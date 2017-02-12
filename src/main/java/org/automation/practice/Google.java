package org.automation.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by alexanderzaverukha on 1/29/17.
 */
public class Google extends WebBase implements Searchable {
    @Step("Search {0}")
    public void search(String search){

        // Find the text input element by its name
        WebElement element = getDriver().findElement(By.cssSelector("[name=q]"));
        makeScreenshot();
        // Enter something to search for
        element.sendKeys(search);
        makeScreenshot();

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        makeScreenshot();

        (new WebDriverWait(getDriver(), 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().startsWith(search);
            }
        });
        makeScreenshot();

    }

    public void search(String search, String option){

    }

    @Override
    protected String getAppURL() {
        return "http://www.google.com";
    }

}

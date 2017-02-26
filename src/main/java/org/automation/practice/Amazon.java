package org.automation.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by alexanderzaverukha on 2/4/17.
 */
public class Amazon extends WebBase implements Searchable{

    public Amazon(){
        super();
    }

    @Override
    protected String getAppURL() {
        return "http://www.amazon.com";
    }

    @Step("Search {0}")
    @Override
    public void search(String search) {
        // Find the text input element by its name
        WebElement element = getDriver().findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        makeScreenshot();
        // Enter something to search for
        element.sendKeys(search);
        makeScreenshot();

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();
        makeScreenshot();

        (new WebDriverWait(getDriver(), 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                String title = d.getTitle();
                title = title.replace("Amazon.com: ", "");
                return title.startsWith(search);
            }
        });
        makeScreenshot();

    }



    @Step("Search {0} with options {1}")
    @Override
    public void search(String search, String option) {

        //add options
        ISelect select = new Select(getDriver().findElement(By.id("searchDropdownBox")));
        select.selectByVisibleText(option);
        search(search);

    }
}

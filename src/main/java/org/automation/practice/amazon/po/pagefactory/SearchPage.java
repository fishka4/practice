package org.automation.practice.amazon.po.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by alexanderzaverukha on 3/5/17.
 */
public class SearchPage{

    SearchResultPage searchResultPage;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchType;

    WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
    }



    public void search(String search) {
        // Find the text input element by its name

        // Enter something to search for
        searchType.sendKeys(search);

        // Now submit the form. WebDriver will find the form for us from the element
        searchType.submit();

        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                String title = d.getTitle();
                title = title.replace("Amazon.com: ", "");
                return title.startsWith(search);
            }
        });
    }

    public SearchResultPage getSearchResultPage(){
        if(searchResultPage == null){
            searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        }

        return searchResultPage;
    }

    public  List<WebElement> getSearchResult(){
        return getSearchResultPage().getResult();
    }
}

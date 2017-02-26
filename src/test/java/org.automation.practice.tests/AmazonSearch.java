package org.automation.practice.tests;

import org.automation.practice.GoogleSheets;
import org.automation.practice.Searchable;
import org.automation.practice.TestBase;
import org.automation.practice.WebBase;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by alexanderzaverukha on 2/12/17.
 */
public class AmazonSearch extends TestBase{

    @DataProvider(name = "amazon-search-dataprovider", parallel = true)
    public Object[][] searchData() {
        return new Object[][] {
                { "Google", "Raspberry Pi 3", "Electronics"},
                { "Youtube","Raspberry Pi 3", "Electronics"},
                { "Amazon","Raspberry Pi 3", "Electronics"}

        };
    }

    @DataProvider(name = "google-sheet", parallel = true)
    public Object[][] googleSheetDP() throws IOException {
            String spreadsheetId = "1bYdMstIpN9n8SGQJsG030peb3TPoRC8XvmZMYPhejd4";
            String range = "Sheet1!A:B";
            return GoogleSheets.getData(spreadsheetId, range);
    }




    @Test(dataProvider = "amazon-search-dataprovider")
    public void myTest(String provider, String search, String option){
        ((Searchable)getProvider(provider)).search( search,  option);
        System.out.println("Page title is: " + WebBase.getDriver().getTitle());
    }
}

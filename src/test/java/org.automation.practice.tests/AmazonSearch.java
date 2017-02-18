package org.automation.practice.tests;

import org.automation.practice.Amazon;
import org.automation.practice.GoogleSheets;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by alexanderzaverukha on 2/12/17.
 */
public class AmazonSearch extends Amazon {

    @DataProvider(name = "amazon-search-dataprovider", parallel = false)
    public Object[][] searchData() {
        return new Object[][] {
                { "Raspberry Pi 3", "Electronics"}
        };
    }

    @DataProvider(name = "google-sheet", parallel = true)
    public Object[][] googleSheetDP() throws IOException {
            String spreadsheetId = "1bYdMstIpN9n8SGQJsG030peb3TPoRC8XvmZMYPhejd4";
            String range = "Sheet1!A:B";
            return GoogleSheets.getData(spreadsheetId, range);
    }




    @Test(dataProvider = "google-sheet")
    public void myTest(String search, String option){
        search( search,  option);
        System.out.println("Page title is: " + getDriver().getTitle());
    }
}

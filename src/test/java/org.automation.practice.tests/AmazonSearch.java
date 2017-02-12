package org.automation.practice.tests;

import org.automation.practice.Amazon;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by alexanderzaverukha on 2/12/17.
 */
public class AmazonSearch extends Amazon {

    @DataProvider(name = "amazon-search-dataprovider", parallel = false)
    public Object[][] searchData() {
        return new Object[][] {
                { "Raspberry Pi 3", "Electronics", "3"}
        };
    }


    @Test(dataProvider = "amazon-search-dataprovider")
    public void myTest(String search, String option, String count){

        search( search,  option);
        System.out.println("Page title is: " + getDriver().getTitle());
        Assert.assertTrue(false, "Dummy fail");
    }
}

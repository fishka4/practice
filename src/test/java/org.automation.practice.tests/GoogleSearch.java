package org.automation.practice.tests;

import org.automation.practice.Amazon;
import org.automation.practice.Google;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Step;

import java.lang.reflect.Method;

/**
 * Created by alexanderzaverukha on 1/28/17.
 */
public class GoogleSearch extends Google {

    @Test
    public void myTest(){
        // And now use this to visit Google

        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");
        search("Cheese!");

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + getDriver().getTitle());
    }




}

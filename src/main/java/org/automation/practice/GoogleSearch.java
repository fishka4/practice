package org.automation.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.lang.reflect.Method;

/**
 * Created by alexanderzaverukha on 1/28/17.
 */
public class GoogleSearch extends Google {


    @Test
    public void myTest7() throws InterruptedException {
        Thread.sleep(5000);

    }

    @Test
    public void myTest6() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Test
    public void myTest5() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Test
    public void myTest4() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Test
    public void myTest3() throws InterruptedException {
        Thread.sleep(5000);
    }

    @Test
    public void myTest2() throws InterruptedException {
        Thread.sleep(5000);
    }

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

package org.automation.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

/**
 * Created by alexanderzaverukha on 1/29/17.
 */
public abstract class WebBase {
   private ThreadLocal<RemoteWebDriver>  driver = new ThreadLocal<>();

   @BeforeMethod
   public void beforeMethod(){
       RemoteWebDriver driver = (RemoteWebDriver)createDriver(System.getProperty("selenium.browser", "chrome"));
       this.driver.set(driver);
       openApp();
   }

   protected abstract void  openApp();

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {

    }

    private WebDriver createDriver(String browser){
        WebDriver driver = null;
        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new Error("Not supported browser type: " + browser);


        }
        return driver;

    }

    protected RemoteWebDriver getDriver(){
        return driver.get();
    }

    @AfterMethod
    public void afterMethod(){
        if(driver != null){
            driver.get().quit();
        }

    }


    @AfterSuite
    public void afterSuite(){

    }


}

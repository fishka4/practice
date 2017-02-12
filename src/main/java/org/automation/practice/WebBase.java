package org.automation.practice;

import org.automation.practice.listeners.TestListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Attachment;

/**
 * Created by alexanderzaverukha on 1/29/17.
 */
@Listeners(value = {TestListener.class})
public abstract class WebBase {
    static public ThreadLocal<RemoteWebDriver>  driver = new ThreadLocal<>();

   @BeforeMethod(alwaysRun = true)
   public void beforeMethod(){
       RemoteWebDriver driver = (RemoteWebDriver)createDriver(System.getProperty("selenium.browser", "chrome"));
       this.driver.set(driver);
       getDriver().get(getAppURL());
   }

   protected abstract String getAppURL();

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

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        if(driver != null){
            driver.get().quit();
        }

    }

//    @Attachment
//    public String performedActions(ActionSequence actionSequence) {
//        return actionSequence.toString();
//    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
    }


    @AfterSuite(alwaysRun = true)
    public void afterSuite(){

    }


}

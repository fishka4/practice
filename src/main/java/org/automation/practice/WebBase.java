package org.automation.practice;

import org.apache.xpath.operations.Bool;
import org.automation.practice.listeners.TestListener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

/**
 * Created by alexanderzaverukha on 1/29/17.
 */

public abstract class WebBase implements AutoCloseable {
    Logger logger = LoggerFactory.getLogger(WebBase.class);
    static public ThreadLocal<RemoteWebDriver>  driver = new ThreadLocal<>();

    public WebBase(){
        RemoteWebDriver driver = (RemoteWebDriver)createDriver(System.getProperty("selenium.browser", "chrome"));
        this.driver.set(driver);
        getDriver().get(getAppURL());
    }

   protected abstract String getAppURL();



    private WebDriver createDriver(String browser) {
        boolean isRemote = Boolean.valueOf(System.getProperty("selenium.remote", "false"));
        WebDriver driver = null;
        switch (browser){
            case "chrome":
                try {
                    if(isRemote){
                        String remoteUrl = System.getProperty("selenium.remote.url", "");
                        if(!remoteUrl.isEmpty()){
                            driver = new RemoteWebDriver(new URL("http://" + remoteUrl + "/wd/hub"), DesiredCapabilities.chrome());
                        }else {
                            logger.error("\"selenium.remote.url\" config parameter is empty. Example: 192.168.75.135:4444");
                            throw new RuntimeException("Error configuration: \"selenium.remote.url\" config parameter is empty. Example: 192.168.75.135:4444");
                        }
                    }else {
                        driver = new ChromeDriver();
                    }

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new Error("Not supported browser type: " + browser);


        }
        return driver;

    }

    public static RemoteWebDriver getDriver(){
        return driver.get();
    }

    public void close(){
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

package org.automation.practice.listeners;

import net.sf.cglib.core.Local;
import org.automation.practice.WebBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.lang.reflect.Method;

/**
 * Created by alexanderzaverukha on 2/12/17.
 */
public class TestListener implements ITestListener {
    Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult iTestResult) {
        log("onTestStart");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log("onTestSuccess");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Method method = TestListener.class.getEnclosingMethod();
        log("onTestFailure");
        makeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        log("onTestSkipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        log("onTestFailedButWithinSuccessPercentage");
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Method method = TestListener.class.getEnclosingMethod();
        log("onStart");
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        log("onFinish");
    }

    private void log(String method){
        logger.info("Method name: " + method);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] makeScreenshot() {
        return ((TakesScreenshot) WebBase.driver.get()).getScreenshotAs(OutputType.BYTES);
    }


}

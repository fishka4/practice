package org.automation.practice;

import org.automation.practice.listeners.TestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Properties;

/**
 * Created by alexanderzaverukha on 2/26/17.
 */
@Listeners(value = {TestListener.class})
public class TestBase {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        initConfig();


    }

    private void initConfig() {
        boolean configEnabled = Boolean.valueOf(System.getProperty("config.enabled", "true"));
        if(!configEnabled) {
            return;
        }

        Properties properties = new Properties();
        String configPath = System.getProperty("config.path", "");
        if(configPath.isEmpty()){
            String path = WebBase.class.getClass().getResource("/").toString().replaceAll("target.*", "");
            configPath = path + "config.properties";
        }
        try(FileInputStream fileInputStream = new FileInputStream(new File(new URI(configPath)))){
            properties.load(fileInputStream);

            for(Map.Entry<Object, Object> values : properties.entrySet()){
                String key = (String) values.getKey();
                String value = (String) values.getValue();
                System.setProperty(key, value);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }


    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(){

    }

    public WebBase getProvider(String provider){
        WebBase result;
        switch (provider){
            case "Google":
                result = getGoogle();
                break;
            case "Youtube":
                result = getYouTube();
                break;
            case "Amazon":
                result = getAmazon();
                break;
            default:
                throw new RuntimeException(String.format("Provider '%s' not found"));
        }
        return result;
    }

    @AfterMethod(alwaysRun = true)
    public void close(){
       if(amazon.get() != null){
           amazon.get().close();
           amazon.set(null);;
       }

        if(google.get() != null){
            google.get().close();
            google.set(null);;
        }

        if(youTube.get() != null){
            youTube.get().close();
            youTube.set(null);;
        }

    }

    public Amazon getAmazon() {
        if(amazon.get() == null){
            this.amazon.set(new Amazon());
        }
        return amazon.get();
    }

    ThreadLocal<Amazon> amazon = new ThreadLocal<>();

    public Google getGoogle() {
        if(google.get() == null){
            this.google.set(new Google());
        }
        return google.get();
    }

    ThreadLocal<Google> google = new ThreadLocal<>();

    public YouTube getYouTube() {
        if(youTube.get() == null){
            this.youTube.set(new YouTube());
        }
        return youTube.get();
    }

    ThreadLocal<YouTube> youTube = new ThreadLocal<>();



}

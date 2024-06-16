package driver;

import base.AppData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import net.bytebuddy.implementation.bytecode.Throw;
import org.testng.SkipException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class AppFactory {
    static AppiumDriver driver;
    static HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();

    private static HashMap<String, Object> getBrowserstackOptions(){
        browserstackOptions.put("userName","sunilpatro1");
        browserstackOptions.put("accessKey","DnNLxup5pnCdArXtxkiX");
        browserstackOptions.put("appiumVersion", "2.4.1");
        return browserstackOptions;
    }

    private static void android_launchApp() throws MalformedURLException {

        //browserstackOptions = getBrowserstackOptions();

        UiAutomator2Options options = new UiAutomator2Options();

        if(AppData.isCloud.contains("false")){
            options.setDeviceName("emulator-5554")
                    .setPlatformVersion("13.0")
                    .setAppPackage("com.saucelabs.mydemoapp.rn")
                    .setAppActivity(".MainActivity");
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        }else { //browserstack
            /*options.setDeviceName("Google Pixel 6")
                    .setPlatformVersion("12.0")
                    .setAppPackage("com.saucelabs.mydemoapp.rn")
                    .setAppActivity(".MainActivity")
                    .setApp("bs://28fda560def4f1ddf391fd6991413407c7972982")
                    .setCapability("bstack:options", browserstackOptions);*/
            driver = new AndroidDriver(new URL("http://hub-cloud.browserstack.com/wd/hub"), options);

        }

        AppDriver.setDriver(driver);
        System.out.println("AndroidDriver is set");
    }

    private static void ios_launchApp() throws MalformedURLException, MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        //browserstackOptions = getBrowserstackOptions();

        if(AppData.isCloud.contains("false")){
            options.setDeviceName("iPhone 15")
                    .setPlatformVersion("17.2")
                    .setBundleId("com.saucelabs.mydemoapp.rn");
            driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        }else { //browserstack
            /*options.setDeviceName("iPhone 15")
                    .setPlatformVersion("17")
                    .setBundleId("com.saucelabs.mydemoapp.rn")
                    .setApp("bs://22aa9fadc1e95af6304472c4e1bdf437e0bd10f3")
                    .setCapability("bstack:options", browserstackOptions);*/
            driver = new IOSDriver(new URL("http://hub-cloud.browserstack.com/wd/hub"), options);
        }

        AppDriver.setDriver(driver);
        System.out.println("IOSDriver is set");
    }

    public static void launchApp() throws MalformedURLException {
        System.out.println("entering into launchapp");
        if(AppData.platform.contains("ios")){
            ios_launchApp();
            System.out.println("iOS launched...");
        }else
            if(AppData.platform.contains("android")){
                android_launchApp();
                System.out.println("Android launched...");
            }else
                throw new SkipException("Enter valid platform value, android/ios");
    }



}

/*
Info -
https://www.browserstack.com/docs/automate/selenium/browserstack-sdk/sdk-faq#Generic
mvn test -P sample-test -Dbrowserstack.config="customConfig.yml"

 */
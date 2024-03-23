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

public class AppFactory {
    static AppiumDriver driver;

    private static void android_launchApp() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554")
                .setPlatformVersion("13.0")
                .setAppPackage("com.saucelabs.mydemoapp.rn")
                .setAppActivity(".MainActivity");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
        AppDriver.setDriver(driver);
        System.out.println("AndroidDriver is set");
    }

    private static void ios_launchApp() throws MalformedURLException, MalformedURLException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 15")
                .setPlatformVersion("17.2")
                .setBundleId("com.saucelabs.mydemoapp.rn");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        AppDriver.setDriver(driver);
        System.out.println("IOSDriver is set");
    }

    public static void launchApp() throws MalformedURLException {
        System.out.println("entering into launchapp");
        if(AppData.platform.contains("ios")){
            ios_launchApp();
        }else
            if(AppData.platform.contains("android")){
                android_launchApp();
                System.out.println("Android launched...");
            }else
                throw new SkipException("Enter valid platform value, android/ios");
    }



}

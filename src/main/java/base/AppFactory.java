package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.management.Descriptor;
import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {

    public static AppiumDriver<MobileElement> driver;
    public static DesiredCapabilities cap;

    public static void Android_LaunchApp() throws MalformedURLException {
        cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("automationName", "UiAutomator2");
        //cap.setCapability("appPackage", "com.android.calculator2");
        //cap.setCapability("appActivity", ".Calculator");
        cap.setCapability("appPackage", "com.google.android.dialer");
        cap.setCapability("appActivity", ".DialtactsActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        AppDriver.setDriver(driver);
    }

    public static void iOS_LaunchApp() throws MalformedURLException {
        cap = new DesiredCapabilities();
        cap.setCapability("platformName", "iOS");
        cap.setCapability("deviceName", "iPhone 11 Pro Max");
        cap.setCapability("automationName", "XCUITest");
        cap.setCapability("platformVersion", "13.3");
        //cap.setCapability("bundleId", "com.SamadiPour.SimpleCalculator");
        cap.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        AppDriver.setDriver(driver);

    }

    public static void closeApp(){
        driver.quit();
    }

}

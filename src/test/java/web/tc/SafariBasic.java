package web.tc;

import base.AppDriver;
import base.Util;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


public class SafariBasic {

    static DesiredCapabilities cap;
    static IOSDriver driver;

    public static void main(String []args) throws MalformedURLException, InterruptedException, MalformedURLException {
        cap = new DesiredCapabilities();
        cap.setCapability("platformName", "iOS");
        cap.setCapability("deviceName", "iPadSKP");
        cap.setCapability("udid", "XXXXXXX");
        //cap.setCapability("xcodeOrgId", "XXXXXXXXX");
        //cap.setCapability("xcodeSigningId", "iPhone Developer");
        cap.setCapability("updatedWDABundleId", "com.qavbox.WebDriverAgentRunner");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.5.1");
        cap.setCapability("automationName", "XCUITest");
        cap.setCapability("browserName", "safari");
        cap.setCapability("safariAllowPopups", true);

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        AppDriver.setDriver(driver);

        driver.get("https://qavalidation.com/demo/");
        //driver.get("https://qavalidation.com/demo/");

        By FullName = By.id("username");
        By Email = By.id("email");

        Util.sendKeys(FullName, "qavbox");
        Util.sendKeys(Email, "qavbox@gmail.com");

        String context = driver.getContext();
        System.out.println(getDate() + "webview context " + context);

        driver.findElement(By.id("submit")).click();

        System.out.println(getDate() + " -- switching to native app");
        driver.context("NATIVE_APP");
        Thread.sleep(1000);

        driver.findElement(By.name("Close")).click();
        System.out.println(getDate() + " Clicked on Close button");

        System.out.println(getDate() + " -- navigating to webview context");
        driver.context(context);
        System.out.println(getDate() + " -- navigated to webview context");

        System.out.println(getDate() + " " + driver.getCurrentUrl());

        Thread.sleep(2000);
        AppDriver.getDriver().quit();
    }

    static String getDate(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }
}






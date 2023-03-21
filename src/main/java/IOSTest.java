import base.AppDriver;
import base.Util;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IOSTest {

    public static AppiumDriver driver;
    public static DesiredCapabilities cap;

    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        /*cap = new DesiredCapabilities();
        cap.setCapability("platformName", "iOS");
        cap.setCapability("deviceName", "iPhone 11");
        cap.setCapability("automationName", "XCUITest");
        cap.setCapability("platformVersion", "13.5");
        //cap.setCapability("bundleId", "com.SamadiPour.SimpleCalculator");
        //cap.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
        cap.setCapability("bundleId", "org.reactjs.native.example.SwagLabsMobileApp");


        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);*/
        XCUITestOptions options = new XCUITestOptions()
                .setDeviceName("iPhone SE (3rd generation)")
                .setPlatformVersion("16.2")
                .setBundleId("com.saucelabs.mydemoapp.rn");
        //.setApp(System.getProperty("user.dir") + "/VodQA.apk")
        driver = new IOSDriver(new URL("http://0.0.0.0:4723"), options);

        AppDriver.setDriver(driver);


        driver.findElement(AppiumBy.accessibilityId("tab bar option menu")).click();
        //Thread.sleep(1000);

        By menuIcon = AppiumBy.accessibilityId("menu item log in");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(menuIcon)).click();

        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
        driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
        driver.findElement(AppiumBy.accessibilityId("Login button")).click();

        /*driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Action Sheets']")).click();
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Okay / Cancel']")).click();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='OK']")).click();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='UICatalog']")).click();*/

        Thread.sleep(2000);

        //Util.scrollTo("$7.99");
        Util.scroll(Util.ScrollDirection.DOWN, 0.7);


        Thread.sleep(2000);
        driver.quit();
    }
}




















/*
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Action Sheets']")).click();
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Okay / Cancel']")).click();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='OK']")).click();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='UICatalog']")).click();
        Thread.sleep(3000);
 */
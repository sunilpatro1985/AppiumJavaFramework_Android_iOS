import base.AppDriver;
import base.Util;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSTest {

    public static AppiumDriver<MobileElement> driver;
    public static DesiredCapabilities cap;

    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        cap = new DesiredCapabilities();
        cap.setCapability("platformName", "iOS");
        cap.setCapability("deviceName", "iPhone 11");
        cap.setCapability("automationName", "XCUITest");
        cap.setCapability("platformVersion", "13.5");
        //cap.setCapability("bundleId", "com.SamadiPour.SimpleCalculator");
        //cap.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
        cap.setCapability("bundleId", "org.reactjs.native.example.SwagLabsMobileApp");


        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        AppDriver.setDriver(driver);

        Thread.sleep(1000);
        driver.findElement(By.id("test-Username")).sendKeys("standard_user");
        driver.findElement(By.id("test-Password")).sendKeys("secret_sauce");
        driver.findElement(By.id("test-LOGIN")).click();

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
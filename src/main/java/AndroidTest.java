import base.AppDriver;
import base.Util;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class AndroidTest {

    public static AppiumDriver driver;
    public static DesiredCapabilities cap;

    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        /*cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("automationName", "UiAutomator2");
        //cap.setCapability("appPackage", "com.android.calculator2");
        //cap.setCapability("appActivity", ".Calculator");
        //cap.setCapability("appPackage", "com.google.android.dialer");
        //cap.setCapability("appActivity", ".DialtactsActivity");
        cap.setCapability("appPackage", "com.swaglabsmobileapp");
        cap.setCapability("appActivity", ".MainActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);*/

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554")
                .setPlatformVersion("11.0")
                .setAppPackage("io.cloudgrey.the_app")
                .setAppActivity(".MainActivity");

        //.setApp("")
        //.setNoReset(true) //not install the app if it's already insatlled

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        AppDriver.setDriver(driver);
        Thread.sleep(1000);

        driver.findElement(AppiumBy.accessibilityId("test-Username")).sendKeys("standard_user");
        driver.findElement(AppiumBy.accessibilityId("test-Password")).sendKeys("secret_sauce");
        driver.findElement(AppiumBy.accessibilityId("test-LOGIN")).click();

        /*driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Contacts tab.']")).click();
        Thread.sleep(500);
        List<MobileElement> contacts = driver.findElements(By.id("com.google.android.dialer:id/contact_name"));
        contacts.get(0).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Welcome");
        driver.findElement(By.id("com.android.contacts:id/editor_menu_save_button")).click();*/

        Thread.sleep(2000);

        //Util.scrollTo("$7.99");

        Util.scroll(Util.ScrollDirection.DOWN, 0.7);

        Thread.sleep(2000);

        driver.quit();
    }
}



























/*
driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Contacts tab.']")).click();
        Thread.sleep(1000);
        List<MobileElement> contacts = driver.findElements(By.id("com.google.android.dialer:id/contact_name"));
        contacts.get(0).click();
        driver.findElement(By.xpath("//android.widget.EditText[@text='First name']")).sendKeys("qavBox1");
        driver.findElement(By.id("com.android.contacts:id/editor_menu_save_button")).click();
        Thread.sleep(3000);
 */
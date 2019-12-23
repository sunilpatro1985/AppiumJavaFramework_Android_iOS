import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class AndroidTest {

    public static AppiumDriver<MobileElement> driver;
    public static DesiredCapabilities cap;

    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("automationName", "UiAutomator2");
        //cap.setCapability("appPackage", "com.android.calculator2");
        //cap.setCapability("appActivity", ".Calculator");
        cap.setCapability("appPackage", "com.google.android.dialer");
        cap.setCapability("appActivity", ".DialtactsActivity");

        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        Thread.sleep(1000);

        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='Contacts tab.']")).click();
        Thread.sleep(500);
        List<MobileElement> contacts = driver.findElements(By.id("com.google.android.dialer:id/contact_name"));
        contacts.get(0).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Welcome");
        driver.findElement(By.id("com.android.contacts:id/editor_menu_save_button")).click();
        Thread.sleep(3000);
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
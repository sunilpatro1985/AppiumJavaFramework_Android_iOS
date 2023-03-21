package web.tc;

import base.AppDriver;
import base.Util;
//import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import web.po.ChromePage;
import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTest {

    static DesiredCapabilities cap;
    static AndroidDriver driver;

    public static void main(String []args) throws MalformedURLException, InterruptedException, MalformedURLException {
        cap = new DesiredCapabilities();
        cap.setCapability("platformName", "Android");
        cap.setCapability("deviceName", "emulator-5554");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("browserName", "chrome");
        //cap.setCapability("chromedriverExecutable", System.getProperty("user.dir")+"/drivers/chromedriver");
        cap.setCapability("chromedriverExecutableDir", System.getProperty("user.dir")+"/drivers/");

        //appium --allow-insecure chromedriver_autodownload

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        AppDriver.setDriver(driver);

        driver.get("https://qavbox.github.io/demo/signup/");
        Thread.sleep(1000);

        ChromePage chromePage = new ChromePage();
        chromePage.userName.sendKeys("qavbox");
        chromePage.email.sendKeys("qavbox@gmail.com");


/*
        JavascriptExecutor js = (JavascriptExecutor) AppDriver.getDriver();
        js.executeScript("window.scrollBy(0,1250)", "");*/

        Util.scrollNClick(new ChromePage().submit);
        Thread.sleep(2000);
        AppDriver.getDriver().switchTo().alert().accept();

        Thread.sleep(2000);
        AppDriver.getDriver().quit();
    }
}



//https://chromedriver.chromium.org/downloads
//https://chromedriver.storage.googleapis.com/index.html

//http://appium.io/docs/en/writing-running-appium/web/mobile-web/

package web.tc;

import base.AppDriver;
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


public class SafariTest {

    static DesiredCapabilities cap;
    static IOSDriver driver;

    public static void main(String []args) throws MalformedURLException, InterruptedException, MalformedURLException {
        cap = new DesiredCapabilities();
        cap.setCapability("platformName", "iOS");
        cap.setCapability("deviceName", "iPhone 11 Pro Max");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
        cap.setCapability("automationName", "XCUITest");
        cap.setCapability("browserName", "safari");
        cap.setCapability("safariAllowPopups", true);

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        AppDriver.setDriver(driver);



        driver.get("https://qavbox.github.io/demo/signup/");
        //driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //Thread.sleep(5000);
        //driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
        Thread.sleep(5000);
        //driver.context("NATIVE_APP");
        //driver.findElement(By.id("Close")).click();

        //System.out.println(driver.getPageSource());
        String context = driver.getContext();
        System.out.println("webview context " + context);

        driver.findElement(By.id("submit")).click();

        System.out.println(getDate() + " -- switching to native app");
        driver.context("NATIVE_APP");
        Thread.sleep(1000);
        //Set<String> contextNames = driver.getContextHandles();
        //System.out.println(contextNames.size());


        /*for(String context : contextNames){
            System.out.println(context);
        }*/


        //System.out.println("Current context " + driver.getContext());
        //System.out.println(getDate() + " -- Navigating to Native app context");
        //driver.context("NATIVE_APP");
        driver.findElement(By.name("Close")).click();
        System.out.println("Clicked on Close button");

        System.out.println(getDate() + " -- navigating to webview context");
        driver.context(context);
        System.out.println(getDate() + " -- navigated to webview context");

        System.out.println(driver.getCurrentUrl());
        /*driver.switchTo().alert().accept();
        System.out.println("After alert");
        System.out.println(driver.getPageSource());*/
        /*ChromePage chromePage = new ChromePage();
        chromePage.userName.sendKeys("qavbox");
        chromePage.email.sendKeys("qavbox@gmail.com");*/

        /*JavascriptExecutor js = (JavascriptExecutor) AppDriver.getDriver();
        js.executeScript("window.scrollBy(0,1250)", "");*/

        //Util.scrollNClick(new ChromePage().tutorials);
        //Thread.sleep(2000);
        //AppDriver.getDriver().switchTo().alert();
        //System.out.println("Close count -" + new ChromePage().close.size());

        /*
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }*/

        /*
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        HashMap<String, String> options = new HashMap<>();
        options.put("action", "accept");
        //options.put("buttonLabel", buttonLabel);
        driver.executeScript("mobile: alert", options);*/

        Thread.sleep(2000);
        AppDriver.getDriver().quit();
    }

    static String getDate(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        //System.out.println(formatter.format(date));
        return formatter.format(date);
    }
}





//http://appium.io/docs/en/writing-running-appium/web/mobile-web/


package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
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
        //cap.setCapability("appPackage", "com.android.dialer");
        //cap.setCapability("appActivity", ".app.DialtactsActivity");
        //cap.setCapability("appPackage", "com.example.hello_layouts");
        //cap.setCapability("appActivity", ".MainActivity");
        cap.setCapability("appPackage", "io.cloudgrey.the_app");
        cap.setCapability("appActivity", ".MainActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);

        AppDriver.setDriver(driver);
        System.out.println("Android driver is set");

    }

    public static void iOS_LaunchApp() throws MalformedURLException {
        cap = new DesiredCapabilities();
        cap.setCapability("platformName", "iOS");
        cap.setCapability("deviceName", "iPhone 11");
        cap.setCapability("automationName", "XCUITest");
        cap.setCapability("platformVersion", "13.5");
        //cap.setCapability("usePrebuiltWDA", true);
        //cap.setCapability("bundleId", "com.SamadiPour.SimpleCalculator");
        //cap.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
        //cap.setCapability("bundleId", "com.apple.MobileAddressBook");
        cap.setCapability("bundleId", "io.cloudgrey.the-app");
        driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        AppDriver.setDriver(driver);
        System.out.println("iOS driver is set");

    }

    public static void closeApp(){
        driver.quit();
    }

}








/*
    static AppiumDriverLocalService service;

    public static void main(String []args){
        System.setProperty(AppiumServiceBuilder.NODE_PATH , "/usr/local/bin/node");
        System.setProperty(AppiumServiceBuilder.APPIUM_PATH , "/usr/local/lib/node_modules/appium/build/lib/main.js");
        //service = AppiumDriverLocalService.buildDefaultService();
        //service.start();

        service = new AppiumServiceBuilder().usingPort(4723).build();
        service.start();
        System.out.println(service.getUrl());
    }

    or

    public static void start() {
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder
        .withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
        .usingDriverExecutable(new File("/usr/local/bin/node"))
        .withIPAddress("127.0.0.1").usingPort(4723)
        .withLogFile(new File("AppiumLogFile.txt"));

		if(service == null) {
			service = builder.build();
			service.start();
		}

		 System.out.println("Appium server started at - " + service.getUrl().toString());
	}
 */
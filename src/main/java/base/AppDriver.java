package base;

import org.openqa.selenium.WebDriver;

public class AppDriver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driver.get();
    }

    static void setDriver(WebDriver Driver){
        driver.set(Driver);
    }
}

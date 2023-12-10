package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class ProductsPage extends BasePage{

    private By productsHeader;
    public ProductsPage(){
        if(AppDriver.getCurrentDriver() instanceof AndroidDriver){
            productsHeader = AppiumBy.accessibilityId("open menu");
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            productsHeader = AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Products\"]");
        }
    }

    public void waitForProductPage(){
        waitForEl(productsHeader);
    }


}

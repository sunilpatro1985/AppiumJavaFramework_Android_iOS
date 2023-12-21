package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class ProductPage extends BasePage{

    //@AndroidFindBy
      By productPage = AppiumBy.accessibilityId("container header");

    /*public ProductPage(){
        if(AppDriver.getCurrentDriver() instanceof AndroidDriver){
            productPage = AppiumBy.accessibilityId("container header");
        }else if(AppDriver.getCurrentDriver() instanceof IOSDriver){
            productPage = AppiumBy.accessibilityId("container header");
        }
    }*/

    public boolean waitForProductText(){
        return waitForEl(productPage).isDisplayed();
    }






}

package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage{
    private By openMenu;
    public MenuPage(){
        if(AppDriver.getCurrentDriver() instanceof AndroidDriver){
            openMenu = AppiumBy.accessibilityId("open menu");
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            openMenu = AppiumBy.accessibilityId("tab bar option menu");
        }
    }

    @AndroidFindBy(accessibility = "menu item log in")
    @iOSXCUITFindBy(accessibility = "menu item log in")
    private WebElement menuLogin;

    public void navigateToLogin(){
        waitNclick(openMenu);
        menuLogin.click();
    }


}

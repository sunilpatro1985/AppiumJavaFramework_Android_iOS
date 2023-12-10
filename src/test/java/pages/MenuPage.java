package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage{

    //@iOSBy(accessibility = "tab bar option menu")
    //@AndroidBy(accessibility = "open menu")
    //By menuBar;
    By menuBar = AppiumBy.accessibilityId("open menu");


    @AndroidFindBy(accessibility = "menu item log in")
    @iOSXCUITFindBy(accessibility = "menu item log in")
    By menuLogin;



}

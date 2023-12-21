package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

    private By userName;

    public LoginPage(){
        if(AppDriver.getCurrentDriver() instanceof AndroidDriver){
            userName = AppiumBy.accessibilityId("Username input field");
        }else if(AppDriver.getCurrentDriver() instanceof IOSDriver){
            userName = AppiumBy.accessibilityId("Username input field");
        }
    }

    @AndroidFindBy(accessibility = "Password input field")
    @iOSXCUITFindBy(accessibility = "Password input field")
    private WebElement Password;

    @AndroidFindBy(accessibility = "Login button")
    @iOSXCUITFindBy(accessibility = "Login button")
    private WebElement btnLogin;
    MenuPage menupage = new MenuPage();

    public void login(String username, String password){
        //menupage.navigateToLogin();
        waitNtype(userName, username);
        Password.sendKeys(password);
        btnLogin.click();
    }



}

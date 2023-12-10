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

import javax.xml.xpath.XPath;

public class LoginPage extends BasePage{
    public By userName;
    public By errorText;
    public LoginPage(){
        if(AppDriver.getCurrentDriver() instanceof AndroidDriver){
            userName = AppiumBy.accessibilityId("user-name");
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            userName = AppiumBy.accessibilityId("Username input field");
        }
    }
    @AndroidFindBy(accessibility = "password")
    @iOSXCUITFindBy(accessibility = "Password input field")
    public WebElement password;

    @AndroidFindBy(accessibility = "login-button")
    @iOSXCUITFindBy(accessibility = "Login button")
    public WebElement signIn;
    MenuPage mp = new MenuPage();
    ProductsPage pg = new ProductsPage();

    public void signIn(String username, String Password){
        mp.navigateToLogin();
        waitForEl(userName).sendKeys(username);
        password.sendKeys(Password);
        signIn.click();
        pg.waitForProductPage();
    }


}

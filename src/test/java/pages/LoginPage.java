package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class LoginPage extends BasePage{

    @AndroidBy(accessibility = "Username input field")
    //@iOSBy(accessibility = "user-name")
    By userName = AppiumBy.accessibilityId("Username input field");

    @AndroidFindBy(accessibility = "Password input field")
    @iOSXCUITFindBy(accessibility = "password")
    By password;

    @AndroidFindBy(accessibility = "Login button")
    @iOSXCUITFindBy(accessibility = "login-button")
    By signIn;

    MenuPage mp = new MenuPage();
    public void signIn(String username, String Password){
        click(mp.menuBar);
        click(mp.menuLogin);
        waitForEl(userName);
        type(userName, username);
        type(password, Password);
        click(signIn);
    }


}

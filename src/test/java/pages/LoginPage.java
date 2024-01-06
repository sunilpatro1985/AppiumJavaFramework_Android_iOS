package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By userName;
    private By userNameErrorText;
    private By passwordErrorText;
    private By credentialsErrorText;

    public LoginPage() {
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            userName = AppiumBy.accessibilityId("Username input field");
            userNameErrorText = By.xpath("//android.view.ViewGroup[@content-desc='Username-error-message']/android.widget.TextView");
            passwordErrorText = By.xpath("//android.view.ViewGroup[@content-desc='Password-error-message']/android.widget.TextView");
            credentialsErrorText = By.xpath("//android.view.ViewGroup[@content-desc='generic-error-message']/android.widget.TextView");
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            userName = AppiumBy.accessibilityId("Username input field");
            userNameErrorText = By.xpath("//XCUIElementTypeOther[@name='Username-error-message']/XCUIElementTypeStaticText");
            passwordErrorText = By.xpath("//XCUIElementTypeOther[@name='Password-error-message']/XCUIElementTypeStaticText");
            credentialsErrorText = By.xpath("//XCUIElementTypeOther[@name='generic-error-message']/XCUIElementTypeStaticText");
        }
    }

    @AndroidFindBy(accessibility = "Password input field")
    @iOSXCUITFindBy(accessibility = "Password input field")
    private WebElement Password;

    @AndroidFindBy(accessibility = "Login button")
    @iOSXCUITFindBy(accessibility = "Login button")
    private WebElement btnLogin;
    MenuPage menupage = new MenuPage();

    public void login(String username, String password) {
        //menupage.navigateToLogin();
        waitNtype(userName, username);
        Password.clear();
        Password.sendKeys(password);
        btnLogin.click();
    }

    public String getUserNameErrorText() {
       return getText(userNameErrorText);
    }

    public String getPasswordErrorText() {
        return getText(passwordErrorText);
    }

    public String getCredentialsErrorText() {
        return getText(credentialsErrorText);
    }





}

package findBy.po;

import base.AppDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends Pages{

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='Echo Box']")
    @iOSXCUITFindBy(accessibility = "Echo Box")
    public WebElement echoBox;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@name='messageInput']")
    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc='messageInput']") //text - Say something
    public WebElement echoTextBox;

    @iOSXCUITFindBy(accessibility = "messageSaveBtn")
    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='messageSaveBtn']")
    public WebElement echoSave;

    @iOSXCUITFindBy(accessibility = "The App")
    @AndroidFindBy(xpath = "//android.widget.ImageButton")
    public WebElement echoBack;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='savedMessage']")
    public WebElement echoSavedText;

    public void navigateToEchoBox(){
        echoBox.click();
    }

    public void enterSomething(String txt){
        echoTextBox.sendKeys(txt);
    }

    public void saveText() throws InterruptedException {
        echoSave.click();
        Thread.sleep(3000);
    }

    public void verifySavedText(String input) {
        String platform = (String)((RemoteWebDriver) AppDriver.getDriver())
                .getCapabilities()
                .getCapability("platformName");

        if(platform.equalsIgnoreCase("android")){
            Assert.assertTrue(AppDriver.getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc='"+input+"']")).isDisplayed());
        }else
        if(platform.equalsIgnoreCase("ios")){
            Assert.assertEquals(echoSavedText.getAttribute("value"), input);
        }
    }
}

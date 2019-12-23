package android.po;

import base.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @FindBy(id = "com.google.android.dialer:id/contacts_tab")
    public WebElement ContactTab;

    @FindBy(id = "com.google.android.dialer:id/empty_list_view_action")
    public WebElement AddContact;

    @FindBy(xpath = "//android.widget.EditText[@text='First name']")
    public WebElement FirstName;

    @FindBy(id = "com.android.contacts:id/editor_menu_save_button")
    public WebElement SaveBtn;

    By by_Contactnames = By.id("com.google.android.dialer:id/empty_list_view_action");
    By by_FirstName = By.xpath("//android.widget.EditText[@text='First name']");

    public void save_Contact() throws InterruptedException {
        Thread.sleep(500);
        ContactTab.click();
        new WebDriverWait(AppDriver.getDriver(), 20).until(ExpectedConditions.presenceOfElementLocated(by_Contactnames));
        AddContact.click();
        new WebDriverWait(AppDriver.getDriver(), 20).until(ExpectedConditions.presenceOfElementLocated(by_FirstName));
        FirstName.sendKeys("Welcome11");
        SaveBtn.click();
    }

}

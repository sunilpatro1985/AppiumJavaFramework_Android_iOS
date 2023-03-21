package findBy.android.po;

import base.AppDriver;
import base.Util;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ContactsPage {

   /* public ContactsPage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='Zebra']")
    public WebElement Submit;

    public By by_names = By.id("com.google.android.dialer:id/contact_name");*/

    By contactTab = By.id("com.google.android.dialer:id/contacts_tab");

    By Add = By.xpath("//android.widget.TextView[@text='Create new contact']");

    By firstName = By.xpath("//android.widget.EditText[@text='First name']");

    By newContactScreen = By.xpath("//android.widget.TextView[@text='Create new contact']");

    By Save = By.id("com.android.contacts:id/editor_menu_save_button");
    By contactNameSaved = By.id("com.android.contacts:id/large_title");

    //back

    public void saveContact() throws InterruptedException {
        String name = "Brad Pitt";
        Util.click(contactTab);
        Util.click(Add);
        Util.waitForEl(newContactScreen);
        Util.sendKeys(firstName, name);
        Thread.sleep(1000);
        Util.click(Save);
        Thread.sleep(1000);
        Util.waitForEl(contactNameSaved);
        Thread.sleep(1000);
        AppDriver.getDriver().navigate().back();
        Thread.sleep(1000);
    }
}

package findBy.ios.po;

import base.AppDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PickerWheel {

    public PickerWheel(){
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @FindBy(id = "AAPLPickerViewController")
    public WebElement PickerWheelItem;

    @FindBy(id = "Red color component value")
    public WebElement WheelOptions;

}

package web.po;

import base.AppDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ChromePage {

    public ChromePage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }


    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "email")
    public WebElement email;


    @FindBy(id = "submit")
    public WebElement submit;

    @FindBy(name = "Close")
    public WebElement close;

    @FindBy(linkText = "Tutorials!")
    public WebElement tutorials;


}

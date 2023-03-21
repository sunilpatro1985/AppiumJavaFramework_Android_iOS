package findBy.ios.po;

import base.AppDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getDriver()), this);
    }

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Action Sheets']")
    public WebElement ActionSheet;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Okay / Cancel']")
    public WebElement OkayCancel;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='OK']")
    public WebElement OkBtn;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='UICatalog']")
    public WebElement UiCatalog;


    public void Validate_ActionSheet() throws InterruptedException {
        Thread.sleep(500);
        ActionSheet.click();
        //new WebDriverWait(AppDriver.getDriver(), 20).until(ExpectedConditions.presenceOfElementLocated(by_Contactnames));
        OkayCancel.click();
        //new WebDriverWait(AppDriver.getDriver(), 20).until(ExpectedConditions.presenceOfElementLocated(by_FirstName));
        OkBtn.click();
        UiCatalog.click();
    }

}

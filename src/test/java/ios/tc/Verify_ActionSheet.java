package ios.tc;

import base.AppDriver;
import ios.po.BasePage;
import ios.po.PickerWheel;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Verify_ActionSheet {

    /*@BeforeTest
    public void Setup() throws MalformedURLException {
        AppFactory.iOS_LaunchApp();
    }*/
    BasePage basePage = new BasePage();
    PickerWheel pickerWheel = new PickerWheel();

    //@Test
    public void Test_Verify_ActionSheet() throws InterruptedException {

        Thread.sleep(500);
        basePage.Validate_ActionSheet();
        Thread.sleep(2000);
    }

    @Test
    public void pickerWheelTest() throws InterruptedException {
        Thread.sleep(3000);
        new WebDriverWait(AppDriver.getDriver(), 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("AAPLPickerViewController"))).click();
        //pickerWheel.PickerWheelItem.click();
        System.out.println(new WebDriverWait(AppDriver.getDriver(), 30)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("Red color component value"))).getAttribute("value"));
    }

    /*@AfterTest
    public void tearDown(){
        AppFactory.closeApp();
    }*/

    public static class ScrollDown {

    }
}

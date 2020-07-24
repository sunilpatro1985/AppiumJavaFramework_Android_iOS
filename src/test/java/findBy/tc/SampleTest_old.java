package findBy.tc;

import base.AppDriver;
import findBy.po.HomePage_old;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest_old {
    @Test
    public void theApptest() throws InterruptedException {
        String input = "qavbox";
        System.out.println("Just testing the app");
        Thread.sleep(3000);
        HomePage_old homePageOld = new HomePage_old();
        homePageOld.echoBox.click();
        homePageOld.echoTextBox.sendKeys(input);
        homePageOld.echoSave.click();

        String platform = (String) ((RemoteWebDriver) AppDriver.getDriver())
                .getCapabilities()
                .getCapability("platformName");

        if (platform.equalsIgnoreCase("android")) {
            Assert.assertTrue(AppDriver.getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc='" + input + "']")).isDisplayed());
        } else if (platform.equalsIgnoreCase("ios")) {
            Assert.assertEquals(homePageOld.echoSavedText.getAttribute("value"), input);
        }
    }
}

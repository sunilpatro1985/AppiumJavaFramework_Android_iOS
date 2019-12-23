package ios.tc;

import ios.po.BasePage;
import base.AppFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Verify_ActionSheet {

    @BeforeTest()
    public void Setup() throws MalformedURLException {
        AppFactory.iOS_LaunchApp();
    }

    @Test
    public void Test_Verify_ActionSheet() throws InterruptedException {
        BasePage basePage = new BasePage();
        Thread.sleep(500);
        basePage.Validate_ActionSheet();
        Thread.sleep(2000);
    }

    @AfterTest
    public void tearDown(){
        AppFactory.closeApp();
    }

}

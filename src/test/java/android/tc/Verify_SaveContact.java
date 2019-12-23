package android.tc;

import android.po.BasePage;
import base.AppFactory;
import org.aspectj.lang.annotation.Before;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Verify_SaveContact {

    @BeforeTest
    public void Setup() throws MalformedURLException {
        AppFactory.Android_LaunchApp();
    }

    @Test
    public void Test_SaveContact() throws InterruptedException {
        BasePage basePage = new BasePage();
        basePage.save_Contact();
        Thread.sleep(2000);
    }

    @AfterTest
    public void tearDown(){
        AppFactory.closeApp();
    }

}

package android.tc;

import android.po.BasePage;
import android.po.ContactsPage;
import base.AppDriver;
import base.Util;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import web.po.ChromePage;

import java.net.MalformedURLException;
import java.net.URL;

public class Verify_SaveContact {

    /*@BeforeTest
    public void Setup() throws MalformedURLException {
        AppFactory.Android_LaunchApp();
    }*/

    @Test
    public void Test_SaveContact_Android() throws InterruptedException {
        /*BasePage basePage = new BasePage();
        basePage.save_Contact();
        Thread.sleep(2000);*/
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.saveContact();
        Thread.sleep(2000);
    }

    /*@AfterTest
    public void tearDown(){
        AppFactory.closeApp();
    }*/



}

package base;

import driver.AppDriver;
import driver.AppFactory;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.MalformedURLException;

public class BaseTest {

    @BeforeClass
    public void launchApp() throws MalformedURLException {
        System.out.println("before method");
        AppFactory.launchApp();
        //base.AppiumServer.start();
    }

    @AfterMethod
    public void closeApp(ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE){
            Util.getScreenshot(result.getTestName());
        }
        //AppDriver.getCurrentDriver().quit();
        //base.AppiumServer.stop();
    }

    @BeforeSuite
    public void serverStart(){
        System.out.println("before suite");
        if(AppData.isCloud.contains("false")){
            base.AppiumServer.start();
        }
    }

    @AfterSuite
    public void serverStop(){
        base.AppiumServer.stop();
    }
}

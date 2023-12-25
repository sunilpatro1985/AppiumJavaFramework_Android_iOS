package tests;

import base.BaseTest;
import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductPage;

public class LoginTest extends BaseTest {
    MenuPage menupage;
    LoginPage loginPage;
    ProductPage prodPage;
    @BeforeClass
    public void setup(){
         menupage = new MenuPage();
         loginPage = new LoginPage();
         prodPage = new ProductPage();

        menupage.navigateToLogin();
    }

    @Test
    public void blankUserNameTest(){
        loginPage.login("", "1234");
        Assert.assertEquals(loginPage.getUserNameErrorText(),"Username is required");
    }
    @Test
    public void blankPasswordTest(){
        loginPage.login("bob@example.com", "");
        Assert.assertEquals(loginPage.getPasswordErrorText(),"Password is required");
    }

    @Test(dataProvider = "invalid-login-dataProvider")
    public void invalidLoginTest(String userName, String password, String errorText){

        loginPage.login(userName, password);
        Assert.assertEquals(loginPage.getCredentialErrorText(),errorText);
    }
    @Test
    public void validLoginTest(){
            MenuPage menupage = new MenuPage();
            LoginPage loginPage = new LoginPage();
            ProductPage prodPage = new ProductPage();

            menupage.navigateToLogin();
            loginPage.login("bob@example.com", "10203040");
            Assert.assertTrue(prodPage.waitForProductText());
    }

    @DataProvider(name = "invalid-login-dataProvider")
    public Object[][] dataProviderArr() {
        //Create 2 dimensional array
        //can even take the data from an excel sheet or from a Map
        //and put it into this array variable
        Object object[][] = { { "bob@example.com", "1234" ,"Provided credentials do not match any user in this service."},
                              { "bob@example", "10203040", "Provided credentials do not match any user in this service." },
                            };
        return object;
    }
}

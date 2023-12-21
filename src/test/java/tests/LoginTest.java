package tests;

import base.BaseTest;
import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest(){
            MenuPage menupage = new MenuPage();
            LoginPage loginPage = new LoginPage();
            ProductPage prodPage = new ProductPage();

            menupage.navigateToLogin();
            loginPage.login("bob@example.com", "10203040");
            Assert.assertTrue(prodPage.waitForProductText());
    }
}

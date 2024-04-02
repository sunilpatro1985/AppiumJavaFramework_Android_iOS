package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductsPage;

public class LoginTest extends BaseTest {
    MenuPage menupage;
    LoginPage loginPage;
    ProductsPage prodPage;
    @BeforeClass
    public void setup(){
         menupage = new MenuPage();
         loginPage = new LoginPage();
         prodPage = new ProductsPage();
        menupage.navigateToLogin();
    }

    @Test(priority = 4)
    public void validLoginTest(){
            loginPage.login("bob@example.com", "10203040");
            Assert.assertTrue(prodPage.waitForProductText());
    }

    //@Test(priority = 1)
    public void invalidLogin_emptyUserNameTest(){
        loginPage.login("", "10203040");
        Assert.assertEquals(loginPage.getUserNameErrorText(), "Username is required");
    }

    //@Test(priority = 2)
    public void invalidLogin_emptyPasswordTest(){
        loginPage.login("bob@example.com", "");
        Assert.assertEquals(loginPage.getPasswordErrorText(), "Password is required");
    }

    //@Test(dataProvider = "invalid-login-dataProvider", priority = 3)
    public void invalidLogin_Test(String uName, String password, String errorText){
        loginPage.login(uName, password);
        Assert.assertEquals(loginPage.getCredentialsErrorText(), errorText);
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

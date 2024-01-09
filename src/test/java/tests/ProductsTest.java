package tests;

import base.BaseTest;
import base.Util;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {
    MenuPage menupage;
    LoginPage loginPage;
    ProductsPage prodPage;
    @BeforeClass
    public void setup(){
        menupage = new MenuPage();
        loginPage = new LoginPage();
        prodPage = new ProductsPage();
        //menupage.navigateToLogin();
    }

    @Test
    public void ProductsTest() throws InterruptedException {
        //loginPage.login("bob@example.com", "10203040");
        //Assert.assertTrue(prodPage.waitForProductText());

        Assert.assertEquals(prodPage.getItemsCount(), 6);

        prodPage.sortBy(ProductsPage.sortByOptions.nameAsc);
        Thread.sleep(1000);
        System.out.println(prodPage.getFirstProductName());
        Assert.assertEquals(prodPage.getFirstProductName(),"Sauce Labs Backpack");
        Assert.assertEquals(prodPage.getFirstProductPrice(),"$29.99");

    }

}

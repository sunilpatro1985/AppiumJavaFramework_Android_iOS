package tests;

import base.BaseTest;
import base.Util;
import fileUtil.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    MenuPage menupage;
    LoginPage loginPage;
    ProductsPage prodPage;

    @Test
    public void ProductsValidateTest() throws Exception {
        menupage = new MenuPage();
        loginPage = new LoginPage();
        prodPage = new ProductsPage();

        SoftAssert sAssert = new SoftAssert();
        sAssert.assertEquals(prodPage.getItemsCount(), 6);


        ExcelReader XR = new ExcelReader().setExcelFile("./testData.xlsx", "prodsort");
        Object obj[][]  = XR.to2DArray();
        for (int i = 0; i < obj.length; i++) {
            prodPage.selectSort(obj[i][2].toString());
            sAssert.assertEquals(prodPage.getFirstProductPrice(), obj[i][1].toString());
            sAssert.assertEquals(prodPage.getFirstProductName(), obj[i][0].toString());
        }

        sAssert.assertAll();


        /*
        prodPage.sortBy();
        Thread.sleep(1000);
        Assert.assertEquals(prodPage.getFirstProductPrice(), "$29.99");
        Assert.assertEquals(prodPage.getFirstProductName(), "Sauce Labs Backpack");
        */
    }
}

package pages;

import base.Util;
import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ProductsPage extends BasePage{

    //private By productsHeader;
    private By sortByOption = AppiumBy.accessibilityId("sort button");
    private By nameAsc = AppiumBy.accessibilityId("nameAsc");
    private By nameDesc = AppiumBy.accessibilityId("nameDesc");
    private By priceAsc = AppiumBy.accessibilityId("priceAsc");
    private By priceDesc = AppiumBy.accessibilityId("priceDesc");

    //@AndroidFindBy
    private By productPage = AppiumBy.accessibilityId("container header");

    private By first_itemName;
    private By first_itemPrice;
    private By itemsName;

    public ProductsPage(){
        if(AppDriver.getCurrentDriver() instanceof AndroidDriver){
            //productPage = AppiumBy.accessibilityId("container header");
            itemsName = AppiumBy.xpath("//android.widget.TextView[@content-desc='store item text']");
            first_itemName = AppiumBy.xpath("//android.widget.TextView[@content-desc='store item text'][1]");
            first_itemPrice = AppiumBy.xpath("//android.widget.TextView[@content-desc='store item price'][1]");
        }else if(AppDriver.getCurrentDriver() instanceof IOSDriver){
            //productPage = AppiumBy.accessibilityId("container header");
            itemsName = AppiumBy.xpath("//XCUIElementTypeStaticText[@name='store item text']");
            first_itemName = AppiumBy.xpath("//XCUIElementTypeStaticText[@name='store item text'][1]");
            first_itemPrice = AppiumBy.xpath("//XCUIElementTypeStaticText[@name='store item price'][1]");
        }
    }

    public boolean waitForProductText(){
        return waitForEl(productPage).isDisplayed();
    }
    public enum sortByOptions  {nameAsc, nameDesc, priceAsc, priceDesc};
    public ProductsPage sortBy(sortByOptions sB) throws InterruptedException {
        Thread.sleep(500);
        click(sortByOption);
        waitForEl(nameAsc);
        if(sB == sortByOptions.nameAsc){
            click(nameAsc);
        }else if(sB == sortByOptions.nameDesc){
            click(nameDesc);
        }else if(sB == sortByOptions.priceAsc){
            click(priceAsc);
        }else if(sB == sortByOptions.priceDesc){
            click(priceDesc);
        }
        Thread.sleep(500);
        return this;
    }

    public String getFirstProductName(){
        return getText(first_itemName);
    }
    public String getFirstProductPrice(){
        return getText(first_itemPrice);
    }

    public int getItemsCount() throws InterruptedException {
        int count = Util.getItems(itemsName).size();
        System.out.println(count);
        Util.scrollToTop();
        return count;
    }

}

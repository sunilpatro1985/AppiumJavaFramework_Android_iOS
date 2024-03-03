package pages;

import base.Util;
import driver.AppDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

import java.util.List;

public class ProductsPage extends BasePage{

    //@AndroidFindBy
      By productPage = AppiumBy.accessibilityId("container header");
      By itemNames;
      private By sortByOption = AppiumBy.accessibilityId("sort button");
    private By nameAsc = AppiumBy.accessibilityId("nameAsc");
    private By nameDesc = AppiumBy.accessibilityId("nameDesc");
    private By priceAsc = AppiumBy.accessibilityId("priceAsc");
    private By priceDesc = AppiumBy.accessibilityId("priceDesc");
    private By first_itemName;
    private By first_itemPrice;

    public By footer = By.xpath("//XCUIElementTypeStaticText[@name='© 2024 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy.']");

    public ProductsPage(){
        if(AppDriver.getCurrentDriver() instanceof AndroidDriver){
            //productPage = AppiumBy.accessibilityId("container header");
            itemNames = AppiumBy.xpath("//android.widget.TextView[@content-desc='store item text']");
            first_itemName = AppiumBy.xpath("(//android.widget.TextView[@content-desc='store item text'])[1]");
            first_itemPrice = AppiumBy.xpath("(//android.widget.TextView[@content-desc='store item price'])[1]");
        }else if(AppDriver.getCurrentDriver() instanceof IOSDriver){
            //productPage = AppiumBy.accessibilityId("container header");
            itemNames = AppiumBy.xpath("//XCUIElementTypeStaticText[@name='store item text']");
            first_itemName = AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='store item text'])[1]");
            first_itemPrice = AppiumBy.xpath("(//XCUIElementTypeStaticText[@name='store item price'])[1]");
        }
    }

    public boolean waitForProductText(){
        return waitForEl(productPage).isDisplayed();
    }

    public String getFirstProductName(){
        return getText(first_itemName);
    }
    public String getFirstProductPrice(){
        return getText(first_itemPrice);
    }

    public int getItemsCount() throws InterruptedException {
        int count = Util.getItems(itemNames).size();
        System.out.println(count);
        //Util.scrollToTop();
        return count;
    }

    public void sortBy(){
        waitNclick(sortByOption);
        waitNclick(nameAsc);
    }

    public void selectSort(String sortOption){
        waitNclick(sortByOption);
        switch (sortOption){
            case "nameAsc":
                waitNclick(nameAsc);
                break;
            case "nameDesc":
                waitNclick(nameDesc);
                break;
            case "priceAsc":
                waitNclick(priceAsc);
                break;
            case "priceDesc":
                waitNclick(priceDesc);
                break;
        }
    }

}

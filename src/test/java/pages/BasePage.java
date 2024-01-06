package pages;

import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getCurrentDriver()), this);
    }
    WebDriverWait wait = new WebDriverWait(AppDriver.getCurrentDriver(), Duration.ofSeconds(30));

    protected WebElement waitForEl(By byLocator){
       return wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }

    protected WebElement getEl(By byLocator){
        return AppDriver.getCurrentDriver().findElement(byLocator);
    }

    protected List<WebElement> getEls(By byLocator){
        return AppDriver.getCurrentDriver().findElements(byLocator);
    }

    protected void click(By byLocator){
        getEl(byLocator).click();
    }

    protected void type(By byLocator, String text){
        getEl(byLocator).sendKeys(text);
    }

    protected void waitNtype(By byLocator, String text){
        waitForEl(byLocator);
        getEl(byLocator).clear();
                getEl(byLocator).sendKeys(text);
    }

    protected void waitNclick(By byLocator){
        waitForEl(byLocator).click();
    }

    protected int size(By byLocator){
        return getEls(byLocator).size();
    }

    protected int size(List<WebElement> els){
        return els.size();
    }

    protected String getText(By byLocator){
        String str = "";
        if (AppDriver.getCurrentDriver() instanceof AndroidDriver) {
            str = getEl(byLocator).getText();
        } else if (AppDriver.getCurrentDriver() instanceof IOSDriver) {
            str =  getAttribute(byLocator, "value");
        }
        return str;
    }

    protected String getAttribute(By byLocator, String attr){
        return waitForEl(byLocator).getAttribute(attr);
    }

    protected boolean isListItemsContain(List<WebElement> items, String text){
        boolean flag = false;

        for(WebElement el: items){
            if(el.getText().contains(text)){
                flag= true;
                break;
            }
        }
        return flag;
    }

    protected boolean isTextMatches(WebElement el, String text){
        return el.getText().equalsIgnoreCase(text);
    }
    protected boolean isTextContains(WebElement el, String text){
        return el.getText().contains(text);
    }

    /*
    FindBy(id = "some")
        private WebElement login;
    isTextContains(login, "login")


    By login = by.id(login)
    isTextContains(getEl(login), "login")
    */


    protected Set<String> getContexts(){
        return ((SupportsContextSwitching)AppDriver.getCurrentDriver()).getContextHandles();
    }

    protected String getCurrentContext(){
        return ((SupportsContextSwitching)AppDriver.getCurrentDriver()).getContext();
    }

    private Select getDropDownElement(By byLocator) {
        return new Select(AppDriver.getCurrentDriver().findElement(byLocator));
    }
    private Select getDropDownElement(WebElement el) {
        return new Select(el);
    }

    public void selectDropDownByOption(WebElement el, String option){
        getDropDownElement(el).selectByVisibleText(option);
    }

    protected List<WebElement> getDropDownOptions(WebElement el) {
        return getDropDownElement(el).getOptions();
    }

    protected List<WebElement> getDropDownAllSelectedOptions(WebElement el) {
        return getDropDownElement(el).getAllSelectedOptions();
    }

    protected WebElement getDropDownSelectedOption(WebElement el) {
        return getDropDownElement(el).getFirstSelectedOption();
    }

    protected boolean isDropDownItemscontain(WebElement element, String text){
        boolean flag = false;
        List<WebElement> els = getDropDownElement(element).getOptions();
        for(WebElement el: els){
            if(el.getText().contains(text)){
                flag = true;
                break;
            }
        }
        return flag;
    }



}

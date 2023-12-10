package pages;

import driver.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Set;

public class BasePage {

    BasePage() {
        PageFactory.initElements(new AppiumFieldDecorator(AppDriver.getCurrentDriver()), this);
    }

    WebDriverWait wait = new WebDriverWait(AppDriver.getCurrentDriver(), Duration.ofSeconds(10));

    public void waitForEl(By byLocator){
        wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }

    public List<WebElement> getEls(By byLocator){
        return AppDriver.getCurrentDriver()
                .findElements(byLocator);
    }

    public WebElement getEl(By byLocator){
        return AppDriver.getCurrentDriver()
                .findElement(byLocator);
    }

    public void click(By byLocator){
        //waitForEl(byLocator);
        getEl(byLocator).click();
    }
    public void waitNclick(By byLocator){
        wait.until(ExpectedConditions.elementToBeClickable(byLocator)).click();
    }

    public static void tap(int x, int y){
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence clickPosition = new Sequence(finger, 1);
        clickPosition.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) AppDriver.getCurrentDriver()).perform(Arrays.asList(clickPosition));
    }

    //optional
    public void type(By byLocator, String text){
        getEl(byLocator).sendKeys(text);
    }

    public int size(By byLocator){
        return getEls(byLocator).size();
    }

    public String getText(By byLocator){
        return getEl(byLocator).getText();
    }

    public String getValue(By byLocator){
        return getEl(byLocator).getAttribute("value");
    }

    protected boolean isSelected(By byLocator) {
        return getEl(byLocator).isSelected();
    }
    //optional end - only needed when using by locator

    private Select getDropDownElement(By byLocator) {
        return new Select(AppDriver.getCurrentDriver().findElement(byLocator));
    }
    private Select getDropDownElement(WebElement el) {
        return new Select(el);
    }

    public void selectDropDownByOption(By byLocator, String option){
        getDropDownElement(byLocator).selectByVisibleText(option);
    }

    protected List<WebElement> getDropDownOptions(By byLocator) {
        return getDropDownElement(byLocator).getOptions();
    }

    protected List<WebElement> getDropDownAllSelectedOptions(By byLocator) {
        return getDropDownElement(byLocator).getAllSelectedOptions();
    }

    protected WebElement getDropDownSelectedOption(By byLocator) {
        return getDropDownElement(byLocator).getFirstSelectedOption();
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

    protected boolean isTextMatches(WebElement element, String text){
        return element.getText().equalsIgnoreCase(text);
    }

    protected boolean isTextContains(WebElement element, String text){
        return element.getText().contains(text);
    }

    protected boolean isListItemscontain(List<WebElement> items, String text){
        boolean flag = false;
        for(WebElement el: items){
            if(el.getText().contains(text)){
                flag = true;
                break;
            }
        }
        return flag;
    }

    protected Set<String> getAppContexts(){
        return ((SupportsContextSwitching) AppDriver.getCurrentDriver()).getContextHandles();
    }
    //AppiumDriver doesn't have the context method implemented, it's present in Android/IOS driver only

    protected String getCurrentAppContext(){
        return ((SupportsContextSwitching) AppDriver.getCurrentDriver()).getContext();
    }

}

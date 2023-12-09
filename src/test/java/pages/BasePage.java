package pages;

import driver.AppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {


    WebDriverWait wait = new WebDriverWait(AppDriver.getCurrentDriver(), Duration.ofSeconds(30));

    protected WebElement getEl(By byLocator){
         return AppDriver.getCurrentDriver().findElement(byLocator);
    }

    protected List<WebElement> getEls(By byLocator){
        return AppDriver.getCurrentDriver().findElements(byLocator);
    }

    protected int size(By byLocator){
        return getEls(byLocator).size();
    }

    protected void click(By byLocator){
        getEl(byLocator).click();
    }

    protected void type(By byLocator, String text){
        getEl(byLocator).sendKeys(text);
    }

    protected void waitForEl(By byLocator){
        wait.until(ExpectedConditions.presenceOfElementLocated(byLocator));
    }

    protected void waitNcLick(By byLocator){
        wait.until(ExpectedConditions.elementToBeClickable(byLocator)).click();
        //click();
    }

    protected String getText(By byLocator){
        return getEl(byLocator).getText();
    }

    protected String getValue(By byLocator){
        return getEl(byLocator).getAttribute("value");
    }

    protected boolean isTextMatches(By byLocator, String text){
        return getEl(byLocator).getText().equalsIgnoreCase(text);
    }

    protected boolean isTextContains(By byLocator, String text){
        return getEl(byLocator).getText().contains(text);
    }

    protected boolean isSelected(By byLocator, String text){
        return getEl(byLocator).isSelected();
    }

    protected Select getDropDownElement(By byLocator){
        return new Select(getEl(byLocator));
    }

    protected WebElement getSelectedOption(By byLocator){
        return getDropDownElement(byLocator).getFirstSelectedOption();
    }

    protected List<WebElement> getDropDownOptions(By byLocator){
        return getDropDownElement(byLocator).getOptions();
    }

    protected void selectByText(By byLocator, String Text){
        getDropDownElement(byLocator).selectByVisibleText(Text);
    }

    protected Set<String> getContexts(){
        return ((SupportsContextSwitching)AppDriver.getCurrentDriver()).getContextHandles();
    }

    protected String getCurrentContext(){
        return ((SupportsContextSwitching)AppDriver.getCurrentDriver()).getContext();
    }

}

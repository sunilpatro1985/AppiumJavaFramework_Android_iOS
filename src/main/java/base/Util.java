package base;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import driver.AppDriver;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Util {
    static double SCROLL_RATIO = 0.5;
    static Duration SCROLL_DUR = Duration.ofMillis(500);

    public static Set<WebElement> getItems(By listItems) throws InterruptedException {
        String prevPageSource = "";
        Set<WebElement> items = new HashSet<WebElement>();

        if(AppDriver.getCurrentDriver() instanceof AndroidDriver){
            while (!isEndOfPage(prevPageSource)) {
                prevPageSource = AppDriver.getCurrentDriver().getPageSource();
                for (WebElement el : AppDriver.getCurrentDriver().findElements(listItems)) {
                    items.add(el);
                }
                scroll(ScrollDirection.DOWN, Util.SCROLL_RATIO);
                Thread.sleep(1000);
            }
            Util.scrollToTop();
        }else if(AppDriver.getCurrentDriver() instanceof IOSDriver){
            items = AppDriver.getCurrentDriver().findElements(listItems).stream().collect(Collectors.toSet());
        }
        return items;
    }

    public static void scrollToTop() throws InterruptedException {
        String prevPageSource = "";
        while (!isEndOfPage(prevPageSource)) {
            prevPageSource = AppDriver.getCurrentDriver().getPageSource();
            scroll(ScrollDirection.UP, Util.SCROLL_RATIO);
            Thread.sleep(100);
        }
    }

    public static void scrollToBottom() throws InterruptedException {
        String prevPageSource = "";
        while (!isEndOfPage(prevPageSource)) {
            prevPageSource = AppDriver.getCurrentDriver().getPageSource();
            scroll(ScrollDirection.DOWN, 0.4);
            Thread.sleep(100);
        }
    }

    public static void scrollTo(WebElement el) throws InterruptedException {
        String prevPageSource = "";
        while (!el.isDisplayed()) {
            //prevPageSource = AppDriver.getCurrentDriver().getPageSource();
            scroll(ScrollDirection.DOWN, 0.2);
            Thread.sleep(100);
        }
    }


    public static void scrollNclick(By listItems, String attrName, String text) throws InterruptedException {
        String prevPageSource = "";
        boolean flag = false;

        while (!isEndOfPage(prevPageSource)) {
            prevPageSource = AppDriver.getCurrentDriver().getPageSource();

            for (WebElement el : AppDriver.getCurrentDriver().findElements(listItems)) {

                if (el.getAttribute(attrName).equalsIgnoreCase(text)) {
                    el.click();
                    flag = true; //come out of the for loop
                    break;
                }
            }
            if (flag)
                break; //come out of the while loop
            else {
                scroll(ScrollDirection.DOWN, Util.SCROLL_RATIO);
                Thread.sleep(1000);
            }

        }

    }

    public static void scrollNclick(By byEl) {
        String prevPageSource = "";
        boolean flag = false;

        while (!isEndOfPage(prevPageSource)) {
            prevPageSource = AppDriver.getCurrentDriver().getPageSource();

            try {
                AppDriver.getCurrentDriver().findElement(byEl).click();
            } catch (org.openqa.selenium.NoSuchElementException e) {
                scroll(ScrollDirection.DOWN, Util.SCROLL_RATIO);
            }
        }

    }

    public static boolean isEndOfPage(String pageSource) {
        return pageSource.equals(AppDriver.getCurrentDriver().getPageSource());
    }

    public enum ScrollDirection {
        UP, DOWN, LEFT, RIGHT
    }

    public static void scroll(ScrollDirection dir, double scrollRatio) {

        if (scrollRatio < 0 || scrollRatio > 1) {
            throw new Error("Scroll distance must be between 0 and 1");
        }
        Dimension size = AppDriver.getCurrentDriver().manage().window().getSize();
        System.out.println(size);
        Point midPoint = new Point((int) (size.width * 0.5), (int) (size.height * 0.5));
        int bottom = midPoint.y + (int) (midPoint.y * scrollRatio);
        int top = midPoint.y - (int) (midPoint.y * scrollRatio);
        //Point Start = new Point(midPoint.x, bottom );
        //Point End = new Point(midPoint.x, top );
        int left = midPoint.x - (int) (midPoint.x * scrollRatio);
        int right = midPoint.x + (int) (midPoint.x * scrollRatio);

        if (dir == ScrollDirection.UP) {
            swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
        } else if (dir == ScrollDirection.DOWN) {
            swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
        } else if (dir == ScrollDirection.LEFT) {
            swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
        } else {
            swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
        }
    }

    protected static void swipe(Point start, Point end, Duration duration) {

        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        /*if (isAndroid) {
            duration = duration.dividedBy(ANDROID_SCROLL_DIVISOR);
        } else {
            swipe.addAction(new Pause(input, duration));
            duration = Duration.ZERO;
        }*/
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) AppDriver.getCurrentDriver()).perform(ImmutableList.of(swipe));
    }

    public static void longPress(WebElement el) {
        Point location = el.getLocation();
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x, location.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(input.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), location.x, location.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) AppDriver.getCurrentDriver()).perform(ImmutableList.of(swipe));
    }

    public static void longPress_gesturePlugin(WebElement el) {
        ((JavascriptExecutor) AppDriver.getCurrentDriver()).executeScript("gesture: longPress", ImmutableMap.of("elementId", ((RemoteWebElement) el).getId(), "pressure", 0.5, "duration", 800));
    }

    public static void swipe_gesturePlugin(WebElement el, String direction) {
        ((JavascriptExecutor) AppDriver.getCurrentDriver()).executeScript("gesture: swipe", ImmutableMap.of("elementId", ((RemoteWebElement) el).getId(), "percentage", 50, "direction", direction));
    }

    private static Point getCenter(WebElement el) {
        Point location = el.getLocation();
        Dimension size = el.getSize();
        return new Point(location.x + size.getWidth() / 2, location.y + size.getHeight() / 2);
    }

    public static void dragNDrop(WebElement source, WebElement target) {
        Point pSourcce = getCenter(source);
        Point pTarget = getCenter(target);
        swipe(pSourcce, pTarget, SCROLL_DUR);
    }

    public static void dragNDrop_gesture(WebElement source, WebElement target) {
        ((JavascriptExecutor) AppDriver.getCurrentDriver()).executeScript("gesture: dragAndDrop", ImmutableMap.of("sourceId", ((RemoteWebElement) source).getId(), "destinationId", ((RemoteWebElement) target).getId()));
    }

    public static void Drawing(WebElement drawPanel) {

        Point location = drawPanel.getLocation();
        Dimension size = drawPanel.getSize();

        Point pSource = new Point(location.x + size.getWidth() / 2
                , location.y + 10);
        Point pDest = new Point(location.x + size.getWidth() / 2
                , location.y + size.getHeight() - 10);

        //The same way, try to identify the Points for horigental drawing
        swipe(pSource, pDest, SCROLL_DUR);
    }

    public static void captureScreenShotOf(WebElement el, String fileName){
        File newImg = el.getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(newImg, new File("./screenshot/"+fileName+".jpg"));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void captureFullPageShot(String fileName){
        File newImg = ((FirefoxDriver) AppDriver.getCurrentDriver()).getFullPageScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(newImg, new File("./screenshot/"+ fileName+ ".jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getScreenshot(String imagename) throws IOException, IOException {
        TakesScreenshot ts = (TakesScreenshot) AppDriver.getCurrentDriver();
        File f = ts.getScreenshotAs(OutputType.FILE);
        String filePath = "./screenshot/"+imagename+".jpg";
        FileUtils.copyFile(f, new File(filePath));
        return filePath;
    }

    public static String convertImg_Base64(String screenshotPath) throws IOException {
        byte[] file = FileUtils.readFileToByteArray(new File(screenshotPath));
        String base64Img = Base64.getEncoder().encodeToString(file);
        return  base64Img;
    }

    public static void tap(int x, int y) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence tap = new Sequence(input, 1);
        tap.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        tap.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) AppDriver.getCurrentDriver()).perform(Arrays.asList(tap));


    }

    }

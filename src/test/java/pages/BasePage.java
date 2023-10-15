package pages;

import driver.AppDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class BasePage {
    //applicable for all browser, but takes screnshot only the visible portion of the browser
    public static String getScreenshot(String imagename) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) AppDriver.getCurrentDriver();
        File f = ts.getScreenshotAs(OutputType.FILE);
        String filePath = "./screenshot/"+imagename+".jpg";
        FileUtils.copyFile(f, new File(filePath));
        return filePath;
    }

    public static String convertImg_Base64(String screenshotPath) throws IOException {
           /*File f = new File(screenshotPath);
            FileInputStream fis = new FileInputStream(f);
            byte[] bytes = new byte[(int)f.length()];
            fis.read(bytes);
            String base64Img =
                    new String(Base64.encodeBase64(bytes), StandardCharsets.UTF_8);
            */
        byte[] file = FileUtils.readFileToByteArray(new File(screenshotPath));
        String base64Img = Base64.getEncoder().encodeToString(file);
        return  base64Img;
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
            FileUtils.copyFile(newImg, new File("./screenshot/"+fileName+".jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void click(int x, int y){

    }

    public static void click(By locator){

    }


}

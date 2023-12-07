package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class LoginPage extends BasePage{

    @AndroidFindBy(accessibility = "user-name")
    By userName;

    @AndroidFindBy(accessibility = "password")
    By password;

    @AndroidFindBy(accessibility = "login-button")
    By signIn;

    MenuPage mp = new MenuPage();
    public void signIn(String username, String Password){
        click(mp.menuBar);
        click(mp.menuLogin);
        waitForEl(userName);
        type(userName, username);
        type(password, Password);
        click(signIn);
    }


}

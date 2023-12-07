package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class MenuPage extends BasePage{

    @AndroidFindBy(accessibility = "tab bar option menu")
    By menuBar;

    @AndroidFindBy(accessibility = "menu item log in\n")
    By menuLogin;



}

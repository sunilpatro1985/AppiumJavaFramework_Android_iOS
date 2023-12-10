package tests.android;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        LoginPage lp = new LoginPage();
        lp.signIn("bob@example.com", "10203040");
    }
}

package findBy.tc;

import findBy.po.HomePage;
import org.testng.annotations.Test;

public class SampleTest {

    @Test
    public void Test_EchoTest() throws InterruptedException {
        String input = "qavbox";
        System.out.println("Just testing the app");
        Thread.sleep(3000);
        HomePage homePage = new HomePage();

        homePage.navigateToEchoBox();
        homePage.enterSomething(input);
        homePage.saveText();
        homePage.verifySavedText(input);
    }

}

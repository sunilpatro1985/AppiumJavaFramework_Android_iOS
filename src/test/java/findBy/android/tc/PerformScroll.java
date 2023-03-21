package findBy.android.tc;

import findBy.android.po.BasePage;
import findBy.android.po.ContactsPage;
import base.Util;
import org.testng.annotations.Test;

public class PerformScroll {

    @Test
    public void Test_SaveContact() throws InterruptedException {
        BasePage basePage = new BasePage();
        ContactsPage cp = new ContactsPage();
        basePage.ContactTab.click();
        Thread.sleep(500);
        //Util.scrollNClick(cp.by_names, "Zebra");
        //Util.scrollNClick(cp.Submit);
        Util.scrollIntoView("Zebra");
        Thread.sleep(2000);
    }
}

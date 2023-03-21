package findBy.ios.tc;

import findBy.ios.po.ContactsPage_iOS;
import org.testng.annotations.Test;

public class verify_iOS_SaveContact {

    @Test
    public void Test_SaveContact_iOS() throws InterruptedException {
        Thread.sleep(2000);
        ContactsPage_iOS contactsPage_ios = new ContactsPage_iOS();
        contactsPage_ios.save_Contact_iOS();
        Thread.sleep(2000);
    }

}

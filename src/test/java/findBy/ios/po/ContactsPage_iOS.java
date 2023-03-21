package findBy.ios.po;

import base.Util;
import org.openqa.selenium.By;

public class ContactsPage_iOS {

    By contactsScreen = By.name("Contacts");

    By addContact = By.id("Add");

    By newContactScreen = By.name("New Contact");

    By fName = By.id("First name");
    By lName = By.id("Last name");
    By Done = By.id("Done");

    By backToContact = By.name("Contacts");

    public void save_Contact_iOS() throws InterruptedException {
        Util.waitForEl(contactsScreen);
        Util.click(addContact);
        Util.waitForEl(newContactScreen);
        Util.sendKeys(fName, "Brad");
        Thread.sleep(1000);
        Util.sendKeys(lName, "Pitt");
        Thread.sleep(1000);
        Util.click(Done);
        Thread.sleep(2000);
        Util.click(backToContact);

    }

}

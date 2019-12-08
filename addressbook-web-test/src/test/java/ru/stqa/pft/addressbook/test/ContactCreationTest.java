package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

    @Test
    public void contactCreationTest() {

        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("test1", null, null, null, null, null, null, null, null, null, null, null, null, null, null, "Group1"), true);
        app.getContactHelper().submitContactCreation();
    }

}

package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactCreationData;

public class ContactCreationTest extends TestBase {

    @Test
    public void contactCreationTest() {

        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactCreationData("test1", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
        app.getContactHelper().submitContactCreation();
    }

}

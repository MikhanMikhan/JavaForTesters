package ru.stqa.pft.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.group().list().size() ==0) {
            app.contact().create(new ContactData("test1", null, null,null));
        }
    }
    @Test
    public void testContactModification(){
        app.contact().selectContact();
        app.contact().editContact();
        app.contact().fillContactForm(new ContactData("test1", "test1", "test",null), false);
        app.contact().submitContactEdit();
        app.goTo().homePage();
    }
}

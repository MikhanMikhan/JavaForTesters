package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactCreationData;

public class ContactModificationTest extends TestBase {
    @Test
    public void testContactModification(){
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactCreationData("test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test@test.ru", "test", "test2@test.ru", "test3@test.ru", "homepage","test1"));

    }
}

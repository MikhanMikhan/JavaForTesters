package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {
    @Test
    public void testContactModification(){
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().selectContact();
        app.getContactHelper().editContact();
        app.getContactHelper().fillContactForm(new ContactData("test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test@test.ru", "test", "test2@test.ru", "test3@test.ru", "homepage","group1"), false);

    }
}

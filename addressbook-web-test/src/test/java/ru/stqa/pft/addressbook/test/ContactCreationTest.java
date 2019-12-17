package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class ContactCreationTest extends TestBase {

    @Test
    public void contactCreationTest() {
        app.goTo().homePage();
        List<ContactData> before = app.contact().list();
        GroupData group = new GroupData("test1",null,null);
        app.contact().create(new ContactData("test1", null, null,null));
        List<ContactData> after = app.contact().list();
    }

}

package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase {

    @Test
    public void contactCreationTest() {
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().contactCreation(new ContactData("test1", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null));
    }

}

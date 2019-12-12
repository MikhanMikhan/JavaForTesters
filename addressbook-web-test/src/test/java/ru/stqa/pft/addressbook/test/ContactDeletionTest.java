package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {
    @Test
    public void testContactDeletion(){
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().contactCreation(new ContactData("test1", null, null,null));
        }
        app.getContactHelper().selectContact();
        app.getContactHelper().deleteContact();
        
    }
}

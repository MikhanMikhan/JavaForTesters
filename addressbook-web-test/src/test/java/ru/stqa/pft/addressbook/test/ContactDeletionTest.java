package ru.stqa.pft.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.group().list().size() ==0) {
            app.contact().create(new ContactData("test1", null, null,null));
        }
    }
    @Test
    public void testContactDeletion(){
        app.contact().selectContact();
        app.contact().deleteContact();
        
    }
}

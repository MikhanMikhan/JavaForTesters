package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactDeletionTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {
        app.goTo().homePage();
        if (app.contact().list().size() ==0) {
            app.contact().create(new ContactData().withFirstname("test1").withLastname("test1"));
        }
    }
    @Test
    public void testContactDeletion(){
        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().selectContact();
        app.contact().deleteContact();
        app.goTo().homePage();
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(before.size(), after.size() + 1);
        before.remove(index);

        Comparator<? super ContactData> byId = (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before,after);
    }
}

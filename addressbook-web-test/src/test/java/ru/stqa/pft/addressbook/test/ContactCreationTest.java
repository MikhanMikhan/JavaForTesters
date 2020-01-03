package ru.stqa.pft.addressbook.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase {

    @Test
    public void contactCreationTest() {
        app.goTo().homePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("test1").withLastname("test1");
        app.contact().create(contact);
        app.goTo().homePage();
        Contacts after = app.contact().all();
        Assert.assertEquals(after.size(), before.size() + 1);
        assertThat(after, equalTo(before.withAdded(contact.withId
                (after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}

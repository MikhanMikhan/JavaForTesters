package ru.stqa.pft.addressbook.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactAddToGroupTest extends TestBase {

    private int contactId;

    @BeforeMethod
    public void ensurePreconditions() {
        Random random = new Random();
        int g = random.nextInt();
        Groups groups = app.db().groups();
        Contacts contacts = app.db().contacts();
        if (groups.size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName(String.format("group%s", g)).withHeader("header").withFooter("footer"));
            app.goTo().homePage();
        }
        if (contacts.size() == 0) {
            app.contact().create(new ContactData().withFirstname("Name1").withLastname("LastName1").
                    withMobilePhone("+78005553535").withEmail("1@mail.com").withMiddlename("Petrovich1").
                    withAddress("ulica").withEmail2("email2").withEmail3("email3").
                    withHomePhone("homephone").withWorkPhone("workphone"));
            app.goTo().homePage();
            contactId = app.db().selectContactWithMaxId().getId();
        } else {
            for (ContactData contact : contacts) {
                if (!contact.getGroups().equals(groups)) {
                    contactId = contact.getId();
                    break;
                }

            }
            if (contactId == 0) {
                app.contact().create(new ContactData().withFirstname("Name1").withLastname("LastName1").
                        withMobilePhone("+78005553535").withEmail("1@mail.com").withMiddlename("Petrovich1").
                        withAddress("ulica").withEmail2("email2").withEmail3("email3").
                        withHomePhone("homephone").withWorkPhone("workphone"));
                app.goTo().homePage();
                contactId = app.db().selectContactWithMaxId().getId();
            }
        }
    }

    @Test
    public void testContactAdditionToGroup() {
        ContactData contact = app.db().selectContactById(contactId);
        Groups before = contact.getGroups();
        app.contact().selectContactById(contactId);
        Groups groups = app.db().groups();
        groups.removeAll(contact.getGroups());
        GroupData group = groups.iterator().next();
        app.contact().addToGroupById(group.getId());
        Groups after = app.db().selectContactById(contactId).getGroups();

        assertThat(after, equalTo(before.withAdded(group)));
    }
}
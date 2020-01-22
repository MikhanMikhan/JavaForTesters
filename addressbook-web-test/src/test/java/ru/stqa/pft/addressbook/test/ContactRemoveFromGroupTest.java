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

public class ContactRemoveFromGroupTest extends TestBase {

    Random random = new Random();
    int g = random.nextInt();
    private int contactId;
    private int groupId;
    private boolean contactInGroupIsFound = false;

    @BeforeMethod
    public void ensurePreconditions() {
        Groups groups = app.db().groups();
        Contacts contacts = app.db().contacts();
        if (groups.size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName(String.format("group%s", g)).withHeader("header").withFooter("footer"));
            app.goTo().homePage();
            groupId = app.db().selectGroupWithMaxId().getId();
            if (contacts.size() == 0) {
                app.contact().create(new ContactData().withFirstname("Name1").withLastname("LastName1").
                        withMobilePhone("+78005553535").withEmail("1@mail.com").withMiddlename("Petrovich1").
                        withAddress("ulica").withEmail2("email2").withEmail3("email3").
                        withHomePhone("homephone").withWorkPhone("workphone"));
                contactId = app.db().selectContactWithMaxId().getId();
                app.goTo().homePage();
                app.contact().selectContactById(contactId);
                app.contact().addToGroupById(groupId);
                contacts = app.db().contacts();
                contactInGroupIsFound = true;
            }
        }
        if (contacts.size() == 0 && !contactInGroupIsFound) {
            app.contact().create(new ContactData().withFirstname("Name1").withLastname("LastName1").
                    withMobilePhone("+78005553535").withEmail("1@mail.com").withMiddlename("Petrovich1").
                    withAddress("ulica").withEmail2("email2").withEmail3("email3").
                    withHomePhone("homephone").withWorkPhone("workphone"));
            contactId = app.db().selectContactWithMaxId().getId();
            groupId = app.db().selectGroupWithMaxId().getId();
            app.goTo().homePage();
            app.contact().selectContactById(contactId);
            app.contact().addToGroupById(groupId);
        } else {
            for (ContactData contact : contacts) {
                if (contact.getGroups().size() > 0) {
                    contactId = contact.getId();
                    groupId = contact.getGroups().iterator().next().getId();
                    break;
                }
            }
        }
    }


    @Test
    public void testContactRemovalFromGroup() {
        Groups before = app.db().selectContactById(contactId).getGroups();
        app.contact().filterContactsByGroupId(groupId);
        app.contact().selectContactById(contactId);
        app.contact().removeContactFromGroup();
        Groups after = app.db().selectContactById(contactId).getGroups();
        GroupData group = app.db().selectGroupById(groupId);

        assertThat(after, equalTo(before.without(group)));
    }
}
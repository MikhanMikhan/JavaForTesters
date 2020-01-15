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

    @BeforeMethod
    public void ensurePreconditions() {
        Random random = new Random();
        int g = random.nextInt();
        Groups groups = app.db().groups();
        Contacts contacts = app.db().contacts();
        if (contacts.size() == 0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstname("Name").withLastname("LastName").
                    withMobilePhone("+78005553535").withEmail("1@mail.com").withMiddlename("Petrovich").
                    withAddress("ulica").withEmail2("email2").withEmail3("email3").
                    withHomePhone("homephone").withWorkPhone("workphone"));
        }
        ContactData contact = app.db().contacts().iterator().next();
        if (groups.size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName(String.format("group%s",g)).withHeader("header").withFooter("footer"));
            return;
        }
        String group=app.db().groups().iterator().next().getName();
        int count=0;
        for (ContactData con: contacts) {
            if (con.getGroups().size() == 0) {
                count++;
            }
        }
        if (count==contacts.size()) {
            app.goTo().homePage();
            app.contact().addContactToGroup(contact, group);
        }

    }

    @Test
    public void testContactRemoveFromGroup() {
        Groups groups = app.db().groups();
        GroupData removedGroup = groups.iterator().next();// String removedGroupName = removedGroup.getName();
        int removedGroupId = removedGroup.getId();
        Contacts before = app.db().contacts();
        ContactData addedToGroupContact = before.stream().max((o1, o2) -> Integer.compare(o1.getGroups().size(), o2.getGroups().size())).get();
        for (ContactData c: before) {
            int i=0;
            if (c.getGroups().size()>0){
                addedToGroupContact = c;
                i++;
            } if (i>0){
                break;
            }
        }

        Groups beforeGroups = addedToGroupContact.getGroups();
        app.goTo().homePage();
        app.contact().removeContactFromGroup(addedToGroupContact, removedGroupId);
        Contacts after = app.db().contacts();
        for (ContactData d: after) {
            if(d.getId()==addedToGroupContact.getId()){
                addedToGroupContact=d;
            }
        }
        Groups afterGroups = addedToGroupContact.getGroups();
        assertThat(afterGroups, equalTo((beforeGroups).without(removedGroup)));
    }
}
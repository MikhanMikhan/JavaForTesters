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

        if (groups.size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName(String.format("group%s",g)).withHeader("header").withFooter("footer"));
            return;
        }
        int count=0;
        for (ContactData contact: contacts) {
            if (contact.getGroups().size()<groups.size()){
                count++;
            }
        }
        if (count==0) {
            app.goTo().groupPage();
            app.group().create(new GroupData().withName(String.format("group%s",g)).withHeader("header").withFooter("footer"));
        }
        }


    @Test
    public void testContactAddToGroup() {

        Groups groups = app.db().groups();
        GroupData addedGroup = new GroupData().withId(groups.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId()).withName(groups.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getName());
        String addedGroupName = addedGroup.getName();
        Contacts before = app.db().contacts();
        ContactData addedToGroupContact = before.stream().min((o1, o2) -> Integer.compare(o1.getGroups().size(), o2.getGroups().size())).get();
        for (ContactData contact: before) {
            int i=0;
            if (contact.getGroups().size()<groups.size()){
                addedToGroupContact = contact;
                i++;
            } if (i>0){
                break;
            }
        }

        Groups beforeGroups = addedToGroupContact.getGroups();
        app.goTo().homePage();
        app.contact().addContactToGroup(addedToGroupContact, addedGroupName);
        Contacts after = app.db().contacts();
        for (ContactData contact: after) {
            if(contact.getId()==addedToGroupContact.getId()){
                addedToGroupContact=contact;
            }
        }
        Groups afterGroups = addedToGroupContact.getGroups();
        assertThat(afterGroups, equalTo(beforeGroups.withAdded(addedGroup)));}}

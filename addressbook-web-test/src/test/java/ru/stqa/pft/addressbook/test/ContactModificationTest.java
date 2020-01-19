package ru.stqa.pft.addressbook.test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {
    @BeforeMethod
    public void ensurePreconditions() {

        if (app.db().contacts().size() ==0) {
            app.goTo().homePage();
            app.contact().create(new ContactData().withFirstname("Name1").withLastname("LastName1").
                    withMobilePhone("+78005553535").withEmail("1@mail.com").withMiddlename("Petrovich1").
                    withAddress("ulica").withEmail2("email2").withEmail3("email3").
                    withHomePhone("homephone").withWorkPhone("workphone"));
        }
        app.goTo().homePage();
    }
    @Test
    public void testContactModification(){
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withFirstname("Name").withLastname("LastName").
                withMobilePhone("+78005553535").withEmail("1@mail.com").withMiddlename("Petrovich").
                withAddress("ulica").withEmail2("email2").withEmail3("email3").
                withHomePhone("homephone").withWorkPhone("workphone").withId(modifiedContact.getId());
        app.contact().modify(contact);
        app.goTo().homePage();
        Contacts after = app.db().contacts();
        assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }
}
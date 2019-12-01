package ru.stqa.pft.addressbook.test;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactCreationData;

public class ContactCreationTest extends TestBase {

    @Test
    public void contactCreationTest() {

        app.initContactCreation();
        app.fillContactForm(new ContactCreationData("test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test@test.ru", "test", "test2@test.ru", "test3@test.ru", "homepage"));
        app.submitContactCreation();
    }

}

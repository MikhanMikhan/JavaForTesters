package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

    @Test
    public void contactCreationTest() {

        initContactCreation();
        fillContactForm(new ContactCreationData("test", "test", "test", "test", "test", "test", "test", "test", "test", "test", "test@test.ru", "test", "test2@test.ru", "test3@test.ru", "homepage"));
        submitContactCreation();
    }

}

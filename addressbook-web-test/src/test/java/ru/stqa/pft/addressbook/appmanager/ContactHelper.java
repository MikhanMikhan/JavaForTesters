package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.ContactCreationData;

public class ContactHelper extends HelperBase {
    public ContactHelper(ChromeDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactCreationData contactCreationData) {
        type(By.name("firstname"), "Name");
        type(By.name("lastname"), "Lastname");
        type(By.name("middlename"), "Middlename");
        type(By.name("nickname"), "Nick");
        type(By.name("title"), "Title");
        type(By.name("company"),"Company");
        type(By.name("address"),"address");
        type(By.name("home"),"Home");
        type(By.name("mobile"),"7777777777");
        type(By.name("work"),"Work");
        type(By.name("email"),"Email@mail.com");
        type(By.name("fax"),"Fax 556677");
        type(By.name("email2"),"Mail@mail.com");
        type(By.name("email3"),"Mail@mail.net");
        type(By.name("homepage"),"localhost");

    }

}

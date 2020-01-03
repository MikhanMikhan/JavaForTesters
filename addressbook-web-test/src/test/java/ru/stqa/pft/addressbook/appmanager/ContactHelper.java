package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void initContactCreation() {
        click(By.xpath("//a[contains(text(),\'add new\')]"));
    }

    public void submitContactEdit() {
        click(By.name("update"));
    }

    public boolean isThereAContact() {
        return (isElementPresent(By.name("selected[]")));
    }

    public void create(ContactData contact) {
        initContactCreation();
        fillContactForm(contact, true);
        submitContactCreation();
    }

    public void fillContactForm(ContactData contactCreationData, boolean creation) {
        type(By.name("firstname"), contactCreationData.getFirstname());
        type(By.name("lastname"), contactCreationData.getLastname());
        type(By.name("middlename"), contactCreationData.getMiddlename());
//        type(By.name("nickname"), "Nick");
//        type(By.name("title"), "Title");
//        type(By.name("company"), "Company");
//        type(By.name("address"), "address");
//        type(By.name("home"), "Home");
//        type(By.name("mobile"), "7777777777");
//        type(By.name("work"), "Work");
//        type(By.name("email"), "Email@mail.com");
//        type(By.name("fax"), "Fax 556677");
//        type(By.name("email2"), "Mail@mail.com");
//        type(By.name("email3"), "Mail@mail.net");
//        type(By.name("homepage"), "localhost");
        if (creation) {
            if (contactCreationData.getGroup() != null) {
                new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactCreationData.getGroup());
            }
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));

        }
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void deleteContact() {
        click(By.xpath("//input[@value=\'Delete\']"));
        wd.switchTo().alert().accept();
    }

    public void editContact() {
        click(By.xpath("(//img[@alt=\'Edit\'])"));
    }

    public void modify(ContactData contact) {
        selectContact();
        editContact();
        fillContactForm(contact, false);
        submitContactEdit();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<ContactData>();
        List<WebElement> elements = wd.findElements(By.name("entry"));

        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstName = cells.get(2).getText();
            String lastName = cells.get(1).getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            ContactData contact = new ContactData().withFirstname(firstName).withLastname(lastName);
            contacts.add(contact);
        }
        return contacts;
    }

    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));

        for (WebElement element : elements) {
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstName = cells.get(2).getText();
            String lastName = cells.get(1).getText();
            String id = element.findElement(By.tagName("input")).getAttribute("value");
            ContactData contact = new ContactData().withFirstname(firstName).withLastname(lastName);
            contacts.add(contact);
        }
        return contacts;
    }
}
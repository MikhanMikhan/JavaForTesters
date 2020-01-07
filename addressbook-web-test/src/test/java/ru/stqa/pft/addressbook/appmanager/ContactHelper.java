package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
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

    public void returnToHomePage() {
        click(By.linkText("home"));
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
        type(By.name("address"), "address");
        type(By.name("home"), "Home");
        type(By.name("mobile"), "7777777777");
        type(By.name("email"), "Email@mail.com");
        type(By.name("email2"), "Mail@mail.com");
        type(By.name("email3"), "Mail@mail.net");
//        type(By.name("homepage"), "localhost");
//        type(By.name("nickname"), "Nick");
//        type(By.name("title"), "Title");
//        type(By.name("company"), "Company");
//        type(By.name("work"), "Work");
//        type(By.name("fax"), "Fax 556677");


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
        initEditContactById(contact.getId());
        fillContactForm((contact), false);
        submitContactEdit();
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteContact();
        returnToHomePage();
    }

    private void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void initEditContactById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
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
        List<WebElement> rows = wd.findElements(By.name("entry"));

        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            String firstName = cells.get(2).getText();
            String lastName = cells.get(1).getText();
            String allPhones = cells.get(5).getText();
            String allEmails = cells.get(4).getText();
            String address = cells.get(3).getText();
            int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
            contacts.add(new ContactData().withFirstname(firstName).withLastname(lastName).withId(id).
                    withAllPhones(allPhones).withAllEmails(allEmails).withAddress(address));
        }
        return contacts;
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactMOdificationById(contact.getId());
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getAttribute("value");

        return new ContactData().withFirstname(firstName).withId(contact.getId()).withLastname(lastName).
                withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withEmail(email)
                .withEmail2(email2).withEmail3(email3).withAddress(address);
    }

    private void initContactMOdificationById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();
    }
}
package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "addressbook")
public class ContactData {
    @Expose
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "firstname")
    private String firstname;
    @Expose
    @Column(name = "lastname")
    private String lastname;
    @Expose
    @Column(name = "middlename")
    private String middlename;
//    private String nickname;
//    private String title;
//    private String company;
    @Expose
    @Column(name = "address")
    @Type(type = "text")
    private String address;
    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String home;
    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private String mobile;
    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private String work;

    @Expose
    @Column(name = "email")
    @Type(type = "text")
    private String email;
    @Expose
    @Column(name = "email2")
    @Type(type = "text")
    private String email2;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(middlename, that.middlename) &&
                Objects.equals(address, that.address) &&
                Objects.equals(home, that.home) &&
                Objects.equals(mobile, that.mobile) &&
                Objects.equals(work, that.work) &&
                Objects.equals(email, that.email) &&
                Objects.equals(email2, that.email2) &&
                Objects.equals(email3, that.email3) &&
                Objects.equals(group, that.group) &&
                Objects.equals(allPhones, that.allPhones) &&
                Objects.equals(allEmails, that.allEmails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, middlename, address, home, mobile, work, email, email2, email3, group, allPhones, allEmails);
    }

    @Expose
    @Column(name = "email3")
    @Type(type = "text")
    private String email3;
//    @Expose
//    @Column(name = "homepage")
//    private String homepage;

    @Transient
    private String group;
//    private String fax;
    @Transient
    private String allPhones;
    @Transient
    private String allEmails;

//    private Set<GroupData> groups = new HashSet<GroupData>();

//        public Groups getGroups() { return new Groups(groups);}

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

//    public String getNickname() {
//        return nickname;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getCompany() {
//        return company;
//    }

    public String getAddress() {
        return address;
    }

    public String getHomePhone() {
        return home;
    }

    public String getMobilePhone() {
        return mobile;
    }

    public String getWorkPhone() {
        return work;
    }

    public String getEmail() {
        return email;
    }

//    public String getFax() {
//        return fax;
//    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

//    public String getHomepage() {
//        return homepage;
//    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

//    public ContactData withNickname(String nickname) {
//        this.nickname = nickname;
//        return this;
//    }
//
//    public ContactData withTitle(String title) {
//        this.title = title;
//        return this;
//    }
//
//    public ContactData withCompany(String company) {
//        this.company = company;
//        return this;
//    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHomePhone(String home) {
        this.home = home;
        return this;
    }

    public ContactData withMobilePhone(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withWorkPhone(String work) {
        this.work = work;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

//    public ContactData withFax(String fax) {
//        this.fax = fax;
//        return this;
//    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

//    public ContactData withHomepage(String homepage) {
//        this.homepage = homepage;
//        return this;
//    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public String getGroup() {
        return group;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", middlename='" + middlename + '\'' +
                ", group='" + group + '\'' +
                ", id=" + id +
                '}';
    }

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getAllEmails() {
        return allEmails;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }
}


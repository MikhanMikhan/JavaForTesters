package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private String firstname;
    private String lastname;
    private String middlename;
    private String nickname;
    private String title;
    private String company;
    private String address;
    private String home;
    private String mobile;
    private String work;
    private String email;
    private String fax;
    private String email2;
    private String email3;
    private String homepage;
    private String group;
    private int id;



    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }

    public String getEmail() {
        return email;
    }

    public String getFax() {
        return fax;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getHomepage() { return homepage; }

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

    public ContactData withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public ContactData withHome(String home) {
        this.home = home;
        return this;
    }

    public ContactData withMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }

    public ContactData withWork(String work) {
        this.work = work;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withFax(String fax) {
        this.fax = fax;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withHomepage(String homepage) {
        this.homepage = homepage;
        return this;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, id);
    }

    public int getId() { return id;  }
}


package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String middlename;
    private final String nickname;
    private final String title;
    private final String company;
    private final String address;
    private final String home;
    private final String mobile;
    private final String work;
    private final String email;
    private final String fax;
    private final String email2;
    private final String email3;
    private final String homepage;
    private final String group;

    public ContactData(String firstname, String lastname, String middlename, String nickname, String title, String company, String address, String home, String mobile, String work, String email, String fax, String email2, String email3, String homepage, String group) {
        this.group = group;
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.home = home;
        this.mobile = mobile;
        this.work = work;
        this.email = email;
        this.fax = fax;
        this.email2 = email2;
        this.email3 = email3;
        this.homepage = homepage;
    }

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

    public String getGroup() { return group;}
}


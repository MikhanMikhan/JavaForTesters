package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class SessionHelper extends HelperBase {

    public SessionHelper(ChromeDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        type(By.name("user"),"admin");
        type(By.name("pass"),"secret");
        click(By.xpath("//input[3]"));
    }
}

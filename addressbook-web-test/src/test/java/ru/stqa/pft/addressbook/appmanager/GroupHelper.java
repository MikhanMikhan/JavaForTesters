package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupHelper extends HelperBase {

    public GroupHelper(ChromeDriver wd) {
        super(wd);
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }


    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }
    public void selectGroup(){
        click(By.name("selected[]"));
    }
    public void deleteGroup(){
        click(By.name("delete"));
    }
    public void editGroup(){
        click(By.name("edit"));
    }
    public void submitGroupedit(){
        click(By.name("update"));
    }

}
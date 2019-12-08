package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
    protected WebDriver wd;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    protected void click(By locator) {
        wd.findElement(locator).click();
    }

    protected void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existText = wd.findElement(locator).getAttribute("value");
            if (!text.equals(existText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }

    public boolean isAllertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
      try { wd.findElement(locator);
          return true;}
      catch (NoSuchElementException ex) {
          return false;
      }
    }

        public void selectContact(){
        click(By.name("selected[]"));
    }
    public void deleteContact(){
        click(By.xpath("//input[@value=\'Delete\']"));
        wd.switchTo().alert().accept();
    }
    public void editContact(){
        click(By.xpath("(//img[@alt=\'Edit\'])[2]"));
    }

}


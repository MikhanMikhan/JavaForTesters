package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ContactCreationTest {
    private WebDriver wd;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\javafortesters\\JavaForTesters\\chromedriver.exe");
        wd = new ChromeDriver();
        wd.get("http://localhost/addressbook/");
        login("admin", "secret");
    }

    private void login(String username, String password) {
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//input[3]")).click();
    }

    @AfterMethod
    public void tearDown() {

        wd.quit();
    }
    @Test
    public void newtest() {

        wd.findElement(By.linkText("add new")).click();
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).sendKeys("test");
        wd.findElement(By.name("middlename")).sendKeys("test");
        wd.findElement(By.name("lastname")).sendKeys("test");
        wd.findElement(By.name("nickname")).sendKeys("test");
        wd.findElement(By.name("title")).sendKeys("test");
        wd.findElement(By.name("company")).sendKeys("test");
        wd.findElement(By.name("address")).sendKeys("test");
        wd.findElement(By.name("home")).sendKeys("test");
        wd.findElement(By.name("mobile")).sendKeys("test");
        wd.findElement(By.name("work")).sendKeys("test");
        wd.findElement(By.name("fax")).click();
        wd.findElement(By.name("fax")).sendKeys("test");
        wd.findElement(By.name("email")).sendKeys("test@test.ru");
        wd.findElement(By.name("email2")).sendKeys("test2@test.ru");
        wd.findElement(By.name("email3")).sendKeys("test3@test.ru");
        wd.findElement(By.name("homepage")).click();
        wd.findElement(By.name("homepage")).sendKeys("test");
        wd.findElement(By.name("bday")).click();
        wd.findElement(By.name("bmonth")).click();
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).sendKeys("2000");
        wd.findElement(By.cssSelector("input:nth-child(87)")).click();
        wd.findElement(By.linkText("add new")).click();
    }
}

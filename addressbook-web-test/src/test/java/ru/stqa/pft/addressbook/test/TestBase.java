package ru.stqa.pft.addressbook.test;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

    protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\javafortesters\\JavaForTesters\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:\\javafortesters\\JavaForTesters\\geckodriver.exe");
        app.init();

    }

    @AfterMethod
    public void tearDown() {

        app.stop();
    }

}

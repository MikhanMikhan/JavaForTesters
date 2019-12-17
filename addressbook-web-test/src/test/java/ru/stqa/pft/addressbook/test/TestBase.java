package ru.stqa.pft.addressbook.test;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.addressbook.appmanager.ApplicationManager;

public class TestBase {

    protected static final ApplicationManager app = new ApplicationManager(BrowserType.CHROME);

    @BeforeSuite
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\javafortesters\\JavaForTesters\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "D:\\javafortesters\\JavaForTesters\\geckodriver.exe");
        app.init();

    }

    @AfterSuite
    public void tearDown() {

        app.stop();
    }

}

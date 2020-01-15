package ru.stqa.pft.mantis.test;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.mantis.appmanager.ApplicationManager;
import static org.hamcrest.Matchers.equalTo;

public class TestBase {
//    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static final ApplicationManager app = new ApplicationManager(
            System.getProperty("browser", BrowserType.CHROME));

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

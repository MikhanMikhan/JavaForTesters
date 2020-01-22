package ru.stqa.pft.mantis.test;

import ru.stqa.pft.mantis.appmanager.HttpSession;
import org.testng.annotations.Test;
import java.io.IOException;

import static org.testng.Assert.assertTrue;

public class LoginTest extends TestBase {
    @Test

    public void testLogin(){
        HttpSession session = app.newSession();
        try {
            assertTrue(session.login("administrator","root"));
            assertTrue((session.isLoggedInAs("administrator")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

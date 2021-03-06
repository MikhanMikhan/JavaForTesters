package ru.stqa.pft.mantis.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.lanwen.verbalregex.VerbalExpression;
import ru.stqa.pft.mantis.model.MailMessage;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertTrue;

public class RegistrationTest extends TestBase {
    @BeforeMethod
    public void startMailServer() {
        app.mail().start();
    }

    @Test
    public void testRegistration() throws IOException, MessagingException {
        Random random = new Random();
        int rand = random.nextInt();
        String email = String.format("user%s@localhost.localdomain", rand);
        String user = String.format("user%s", rand);
        String password = "password";
        app.registration().start(user, email);
        List<MailMessage> mailMessages = app.mail().waitForMail(2, 5000);
        String confirmationLink = findConfirmationLink(mailMessages, email);
        app.registration().finish(confirmationLink, password);
        assertTrue(app.newSession().login(user, password));
    }

    private String findConfirmationLink(List<MailMessage> mailMessages, String email) {
        MailMessage mailMessage = mailMessages.stream().filter((m) -> m.to.equals(email)).findFirst().get();
        VerbalExpression regex = VerbalExpression.regex().find("http://").nonSpace().oneOrMore().build();
        return regex.getText(mailMessage.text);
    }

    @AfterMethod(alwaysRun = true)
    public void stopMailServer() {
        app.mail().stop();
    }
}

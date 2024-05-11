package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.Random;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void preConditions() {
        //if SignOut is present -----> logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }

    }

    @Test
    public void registrationSuccess(){

        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        System.out.println(i);

        //***************** option 2 *********************************

        System.out.println(System.currentTimeMillis());
        int z = (int) (System.currentTimeMillis()/1000)%3600;
        System.out.println(z);

        User user = new User()
                .setFirstName("Lisa")
                .setLastName("Snow")
                .setEmail("snow"+z+"@gmail.com")
                .setPassword("Ssnow123456$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"You are logged in success");

    }









    @AfterMethod
    public void postCondition(){

        app.getHelperUser().clickOKButton();

    }


}

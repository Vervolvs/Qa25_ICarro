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


    @Test
    public void registrationEmptyName(){



        User user = new User()
                .setFirstName("")
                .setLastName("Snow")
                .setEmail("snow@gmail.com")
                .setPassword("Ssnow123456$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(),"Name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }


    @Test
    public void registrationEmptyLastName(){
        User user = new User()
                .setFirstName("Lisa")
                .setLastName("")
                .setEmail("snow@gmail.com")
                .setPassword("Ssnow123456$");

        app.getHelperUser().openRegistrationForm();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().checkPolicy();
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getErrorText(),"Last name is required");
        Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

    }







        @Test
        public void registrationWrongEmail(){
            User user = new User()
                    .setFirstName("Lisa")
                    .setLastName("Snow")
                    .setEmail("a@a.")
                    .setPassword("Ssnow123456$");

            app.getHelperUser().openRegistrationForm();
            app.getHelperUser().fillRegistrationForm(user);
            app.getHelperUser().checkPolicy();
            app.getHelperUser().submit();

            Assert.assertTrue(app.getHelperUser().getErrorText().contains("Wrong email format"));
            Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());


        }


     @Test
     public void registrationWrongPassword(){
         User user = new User()
                 .setFirstName("Lisa")
                 .setLastName("Snow")
                 .setEmail("snow@gmail.com")
                 .setPassword("Ssnow123456");

         app.getHelperUser().openRegistrationForm();
         app.getHelperUser().fillRegistrationForm(user);
         app.getHelperUser().checkPolicy();
         app.getHelperUser().submit();

         Assert.assertEquals(app.getHelperUser().getErrorText(),"Password must contain 1 uppercase letter, 1 lowercase letter, 1 number and one special symbol of [@$#^&*!]");
         Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());

     }






    @AfterMethod
    public void postCondition(){

        app.getHelperUser().clickOKButton();

    }


}

package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preConditions() {
        //if SignOut is present -----> logout
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }

    }




        @Test
    public void loginSuccess(){

    app.getHelperUser().openLoginForm();
    app.getHelperUser().fillLoginForm("object_raw@mail.ru","D07i03m95a!");
    app.getHelperUser().submitLogin();
    app.getHelperUser().pause(2000);

    //Assert
    Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");


   // app.getHelperUser().clickOKButton();

    }


    @Test
    public void loginSuccess1(){
        User user = new User().setEmail("object_raw@mail.ru").setPassword("D07i03m95a!");
        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(2000);

        //Assert
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");


       //  app.getHelperUser().clickOKButton();

    }




    @Test
    public void loginSuccessModel(){

        app.getHelperUser().openLoginForm();
        app.getHelperUser().fillLoginForm("object_raw@mail.ru","D07i03m95a!");
        app.getHelperUser().submitLogin();
        app.getHelperUser().pause(2000);

        //Assert
        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");


      //  app.getHelperUser().clickOKButton();

    }


  @Test
  public void loginWrongEmail(){
      app.getHelperUser().openLoginForm();
      app.getHelperUser().fillLoginForm("object_rawmail.ru","D07i03m95a!");
      app.getHelperUser().submitLogin();
      Assert.assertEquals(app.getHelperUser().getErrorText(),"It'snot look like email");
      Assert.assertTrue(app.getHelperUser().isYallaButtonNotActive());
  }

  @Test
    public void loginWrongPassword(){
      app.getHelperUser().openLoginForm();
      app.getHelperUser().fillLoginForm("object_raw@mail.ru","7a");
      app.getHelperUser().submitLogin();
      app.getHelperUser().pause(2000);
      Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");

    }

  @Test
 public void loginUnregisteredUser(){
      app.getHelperUser().openLoginForm();
      app.getHelperUser().fillLoginForm("objecaw@mail.ru","D7703m95a!");
      app.getHelperUser().submitLogin();
      Assert.assertEquals(app.getHelperUser().getMessage(),"\"Login or Password incorrect\"");
 }


    @AfterMethod
    public void postCondition(){

        app.getHelperUser().clickOKButton();

    }


}

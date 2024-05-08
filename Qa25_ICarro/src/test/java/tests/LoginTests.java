package tests;

import org.testng.Assert;
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

    //Assert
    Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");


    app.getHelperUser().clickOKButton();

    }








}

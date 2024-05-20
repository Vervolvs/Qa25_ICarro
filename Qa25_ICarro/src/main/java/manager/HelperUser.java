package manager;

import models.User;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class HelperUser extends HelperBase {


    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm(){

        WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login?url=%2Fsearch']"));
        loginTab.click();



    }

    public void fillLoginForm(String email, String password) {

        //    WebElement emailInput = wd.findElement(By.name("email"));
        //   emailInput.click();
        //   emailInput.clear();
        //    emailInput.sendKeys(email);

        type(By.id("email"),email);

        //   WebElement passwordInput = wd.findElement(By.xpath("//input[last()]"));
        //   passwordInput.click();
        //   passwordInput.clear();
        //   passwordInput.sendKeys(password);

        type(By.id("password"),password);



    }
    //overloading
    public void fillLoginForm(User user) {

        //    WebElement emailInput = wd.findElement(By.name("email"));
        //   emailInput.click();
        //   emailInput.clear();
        //    emailInput.sendKeys(email);

        type(By.id("email"),user.getEmail());

        //   WebElement passwordInput = wd.findElement(By.xpath("//input[last()]"));
        //   passwordInput.click();
        //   passwordInput.clear();
        //   passwordInput.sendKeys(password);

        type(By.id("password"), user.getPassword());



    }


    public void submit(){
        click(By.xpath("//button[@type='submit']"));


    }


    public boolean isLogged() {
        return isElementPresent(By.xpath("//*[text()=' Logout ']"));
    }

    public void logout() {

        click(By.xpath("//*[text()=' Logout ']"));



    }


    public String getMessage() {

     // WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
     // String text = element.getText();
    //  return text;

     //   pause(2000);
     return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();

    }

    public void clickOKButton() {
        if(isElementPresent(By.xpath("//button[text()='Ok']")))
        click(By.xpath("//button[text()='Ok']"));
    }

    public String getErrorText() {
        return wd.findElement(By.cssSelector("div.error")).getText();
    }

    public boolean isYallaButtonNotActive() {
       boolean res = isElementPresent(By.cssSelector("button[disabled]"));

       WebElement element = wd.findElement(By.cssSelector("button[type='submit']"));
       boolean result = element.isEnabled();

       return res && !result;
    }




    //******************************REGISTRATION*********************************


    public void openRegistrationForm() {

     click(By.xpath("//a[text()=' Sign up ']"));

    }

    public void fillRegistrationForm(User user) {
        type(By.id("name"),user.getFirstName());
        type(By.id("lastName"),user.getLastName());
        type(By.id("email"),user.getEmail());
        type(By.id("password"),user.getPassword());

    }

    public void checkPolicy() {
     //   click(By.id("terms-of-use")); 0*0

    //  click(By.cssSelector("label[for='terms-of-use']")); It does not work on all screen resolutions

    //option 2
        if(!wd.findElement(By.id("terms-of-use")).isSelected()) {


            JavascriptExecutor js = (JavascriptExecutor) wd;
            js.executeScript("document.querySelector('#terms-of-use').click()");

        }
    }

    public void checkPolicyXY(){
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rectangle = label.getRect();
        int w = rectangle.getWidth();
        int XOffSet = -w/2;
        //Dimension size = wd.manage().window().getSize();


        Actions actions = new Actions(wd);
        actions.moveToElement(label, XOffSet, 0).click().release().perform();


    }


    public void login(User user) {

        openLoginForm();
        fillLoginForm(user);
        submit();
        clickOKButton();
        


    }
}

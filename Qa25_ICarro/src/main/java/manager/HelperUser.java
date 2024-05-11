package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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


    public void submitLogin(){
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
}

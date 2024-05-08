package manager;

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


    public void submitLogin(){
        click(By.xpath("//button[@type='submit']"));


    }


    public boolean isLogged() {
        return isElementPresent(By.xpath("//button[text()='Sign Out']"));
    }

    public void logout() {

        click(By.xpath("//button[text()='SignOut']"));



    }


    public String getMessage() {

     // WebElement element = wd.findElement(By.cssSelector(".dialog-container>h2"));
     // String text = element.getText();
    //  return text;

     //   pause(2000);
     return wd.findElement(By.cssSelector(".dialog-container>h2")).getText();

    }

    public void clickOKButton() {
        click(By.xpath("//button[text()='Ok']"));
    }
}

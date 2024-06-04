package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;


public class HelperCar extends HelperBase {


    public HelperCar(WebDriver wd) {
        super(wd);
    }


    public void openCarForm() {
        pause(1500);
        click(By.xpath("//a[text()=' Let the car work ']"));



    }

    public void fillCarForm(Car car) {

        typeLocation(car.getLocation());
        type(By.id("make"),car.getManufacture());
        type(By.cssSelector("#model"),car.getModel());
        type(By.xpath("//input[@id='year']"),car.getYear());
        select(By.id("fuel"),car.getFuel());
        type(By.id("seats"),String.valueOf(car.getSeats()));
        type(By.id("class"),car.getCarClass());
        type(By.id("serialNumber"),car.getCarRegNumber());
        // type(By.id("price"),String.valueOf(car.getPrice()));
        type(By.id("price"),car.getPrice()+"");
        type(By.id("about"),car.getAbout());

    }

    private void select(By locator, String options) {
        Select select = new Select(wd.findElement(locator));
        select.selectByValue(options);
        //gas
       // select.selectByIndex(5);
       // select.selectByVisibleText(" Gas ");
      //  select.selectByValue("Gas");

    }

    private void typeLocation(String location) {

       type(By.id("pickUpPlace"),location);
       click(By.cssSelector("div.pac-item"));

    }


    public void attachPhoto(String link) {


       wd.findElement(By.cssSelector("#photos")).sendKeys(link);




    }

    public void returnToHome() {

        click(By.xpath("//button[text()='Search cars']"));

    }

 //   public void searchCurrentMonth(String city, String dateFrom, String dateTo) {

  //      typeCity(city);
  //      click(By.id("dates"));
   //     String[] from = dateFrom.split("/"); //["5"]["30"]["2024"] 5/30/2024

   //     String locatorFrom = "//div[text()=' "+from[1]+" ']";
   //     click(By.xpath(locatorFrom));


   //     String[] to = dateTo.split("/");


   //     String locatorTo = "//div[text()=' "+to[1]+" ']";
   //     click(By.xpath(locatorTo));

 //   }


    public void searchCurrentMonth(String city, String dateFrom, String dateTo) {
        typeCity(city);
        click(By.id("dates"));
        // "5/30/2024", "5/31/2024"  30  31
        String[] from = dateFrom.split("/");//["5"]["30"]["2024"]

        String locatorFrom = "//div[text()=' "+from[1]+" ']";
        click(By.xpath(locatorFrom));


        String[]to = dateTo.split("/");
        String locatorTo = "//div[text()=' "+to[1]+" ']";

        click(By.xpath(locatorTo));

    }











    private void typeCity(String city) {
        type(By.id("city"),city);
        click(By.cssSelector("div.pac-item"));
        
    }

    public boolean isListOfCarsAppeared() {

        return isElementPresent(By.cssSelector("a.car-container"));
    }
}

package manager;

import models.Car;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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
        clearTextBox(By.id("dates"));
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

    public void searchCurrentYear(String city, String dateFrom, String dateTo) {

        typeCity(city);
        clearTextBox(By.id("dates"));
        click(By.id("dates"));


      LocalDate now = LocalDate.now();
      System.out.println(now);
      int year = now.getYear();
      int month = now.getMonthValue();
      int day = now.getDayOfMonth();
      LocalDate from = LocalDate.parse(dateFrom, DateTimeFormatter.ofPattern("M/d/yyyy"));
      LocalDate to = LocalDate.parse(dateTo,DateTimeFormatter.ofPattern("M/d/yyyy"));
    //  LocalDate from1 = LocalDate.parse("2024:23/5",DateTimeFormatter.ofPattern("yyyy:dd/M"));

      int diffMonth = from.getMonthValue() - month;
      if(diffMonth>0){

          clickNextMonthBtn(diffMonth);

      }
        click(By.xpath("//div[text()=' "+from.getDayOfMonth()+" ']"));

      diffMonth = to.getMonthValue()-from.getMonthValue();
      if(diffMonth>0){

          clickNextMonthBtn(diffMonth);

      }
        click(By.xpath("//div[text()=' "+to.getDayOfMonth()+" ']"));
        //String locator = String.format("//div[text()=' %s ']",to.getDayOfMonth());
        //click(By.xpath(locator));

    }

    private void clickNextMonthBtn(int diffMonth) {

        for (int i = 0; i < diffMonth ; i++) {

            click(By.cssSelector("button[aria-label='Next month']"));
        }

    }

    public void searchAnyPeriod(String city, String dateFrom, String dateTo) {

        typeCity(city);
        clearTextBox(By.id("dates"));
        click(By.id("dates"));
        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.parse(dateFrom,DateTimeFormatter.ofPattern("M/d/yyyy"));
        LocalDate to = LocalDate.parse(dateTo,DateTimeFormatter.ofPattern("M/d/yyyy"));

        int diffYear;
        int diffMonth;

        diffYear = from.getYear()-now.getYear();

        if (diffYear==0){ //2024=2024

            diffMonth=from.getMonthValue()-now.getMonthValue(); //10-6=4


        }else { //2024!=2025 --->12-6+2 = 8
            diffMonth=12-now.getMonthValue()+from.getMonthValue();
        }

        clickNextMonthBtn(diffMonth);
        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));


        diffYear = to.getYear()- from.getYear();
        if (diffYear==0){

            diffMonth= to.getMonthValue() - from.getMonthValue();



        }else {

            diffMonth = 12 - from.getMonthValue() + to.getMonthValue();

        }

        clickNextMonthBtn(diffMonth);
        locator = String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));

    }


    public void navigateByLogo() {


        click(By.cssSelector("a.logo"));




    }

    public void searchNotValidPeriod(String cyty, String dateFrom, String dateTo) {

        typeCity(cyty);
        clearTextBox(By.id("dates"));
        type(By.id("dates"),dateFrom+" - "+dateTo);
        click(By.cssSelector("div.cdk-overlay-backdrop"));



    }

    public boolean isYallaButtonNotActive() {
        boolean res = isElementPresent(By.cssSelector("button[disabled]"));

        WebElement element = wd.findElement(By.cssSelector("button[type='submit']"));
        boolean result = element.isEnabled();

        return res && !result;
    }



}

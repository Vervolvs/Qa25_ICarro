package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase {


    @BeforeMethod
    public void preCondition(){

        app.getHelperCar().navigateByLogo();

    }




    @Test
    public void searchCurrentMonthSuccess(){

        app.getHelperCar().searchCurrentMonth("Tel Aviv, Israel","6/10/2024","6/25/2024");
        app.getHelperCar().pause(1500);
        app.getHelperCar().getScreen("src/test/screenshots/curMonth.png");
        app.getHelperCar().submit();
        app.getHelperCar().pause(1500);
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());






    }



    @Test
    public void searchCurrentYearSuccess(){

        app.getHelperCar().searchCurrentYear("Tel Aviv, Israel","8/15/2024","10/11/2024");
        app.getHelperCar().pause(1500);
        app.getHelperCar().getScreen("src/test/screenshots/curYear.png");
        app.getHelperCar().submit();
        app.getHelperCar().pause(1500);
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());



    }


    @Test
    public void searchAnyPeriodSuccess(){

        app.getHelperCar().searchAnyPeriod("Tel Aviv, Israel","8/15/2024","5/20/2025");
        app.getHelperCar().getScreen("src/test/screenshots/any.png");
        app.getHelperCar().submit();
        app.getHelperCar().pause(500);
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());


    }


    @Test
    public void negativeSearch(){

        app.getHelperCar().searchNotValidPeriod("Tel Aviv, Israel","1/10/2023","7/16/2024");
        
    }








}

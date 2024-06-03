package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchCarTests extends TestBase {


    @Test
    public void searchCurrentMonthSuccess(){

        app.getHelperCar().searchCurrentMonth("Tel Aviv, Israel","5/30/2024","5/31/2024");
        app.getHelperCar().submit();
        Assert.assertTrue(app.getHelperCar().isListOfCarsAppeared());






    }


















}

package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewCarTests extends TestBase {

    @BeforeClass
    public void preCondition(){
        if(!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("object_raw@mail.ru").setPassword("D07i03m95a!"));
        }


    }





    @Test
    public void addNewCarSuccessAll() {
        int i = new Random().nextInt(1000)+1000;
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2023")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-900-"+i)
                .price(50)
                .about("Very nice car")
                .build();

            app.getHelperCar().openCarForm();
            app.getHelperCar().fillCarForm(car);
            app.getHelperCar().attachPhoto("C:\\Users\\Objec\\OneDrive\\Документы\\GitHub\\Qa25_ICarro\\Qa25_ICarro\\2023-lamborghini-huracan.jpg");
            app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessage(),car.getManufacture()+" "+car.getModel()+" added successful");

    }

    @Test
    public void addNewCarSuccess() {
        int i = new Random().nextInt(1000)+1000;
        Car car = Car.builder()
                .location("Tel Aviv, Israel")
                .manufacture("Mazda")
                .model("M3")
                .year("2020")
                .fuel("Petrol")
                .seats(4)
                .carClass("C")
                .carRegNumber("678-900-"+i)
                .price(50)
                .build();

        app.getHelperCar().openCarForm();
        app.getHelperCar().fillCarForm(car);
        app.getHelperCar().submit();

        Assert.assertTrue(app.getHelperCar().getMessage().contains("added successful"));
        Assert.assertEquals(app.getHelperCar().getMessage(),car.getManufacture()+" "+car.getModel()+" added successful");

    }














    @AfterMethod
    public void postCondition(){

         app.getHelperCar().returnToHome();


    }




}

package api_rest;

import config.CarController;
import dto.CarDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

import static helper.RandomUtils.generatePhone;

public class ApiAddNewCarTests extends CarController {

    @Test
    public void addNewCarPositiveTest(){
        CarDTO car = CarDTO.builder()
                .serialNumber("num-"+generatePhone(10))
                .manufacture("Volvo")
                .model("100")
                .city("Haifa")
                .pricePerDay(1000.10)
                .carClass("C")
                .fuel("Gas")
                .year("1999")
                .seats(5)
                .about("best of the best car volvo")
                .build();
        login();
        Response response = addUserCar(car, tokenDto.getAccessToken());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
    @Test
    public void addCarWithoutSerialNumberTest() {
        CarDTO car = CarDTO.builder()
                .manufacture("BMW")
                .model("M5")
                .city("Eilat")
                .pricePerDay(1200.00)
                .carClass("A")
                .fuel("Petrol")
                .year("2022")
                .seats(4)
                .about("Luxury car")
                .build();  // Нет serialNumber

        login();
        Response response = addUserCar(car, tokenDto.getAccessToken());

        Assert.assertNotEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getStatusCode(), 400);
    }
}
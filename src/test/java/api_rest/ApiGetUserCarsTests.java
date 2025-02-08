package api_rest;

import config.CarController;
import helper.BaseApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ApiGetUserCarsTests extends CarController implements BaseApi {

    @Test
    public void getUserCarsPositiveTest(){
        login();
        Response response = getUserCars(tokenDto.getAccessToken());
        System.out.println("--> "+response.getStatusCode());
    }
    @Test
    public void getUserCarsListNotEmptyTest(){
        login();
        Response response = getUserCars(tokenDto.getAccessToken());

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertTrue(response.getBody().asString().contains("serialNumber"));
    }
    @Test
    public void getUserCarsWithoutTokenTest(){
        Response response = getUserCars(""); // Пустой токен

        Assert.assertEquals(response.getStatusCode(), 403);
    }

}
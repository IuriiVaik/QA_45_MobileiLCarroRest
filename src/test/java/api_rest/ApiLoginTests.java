package api_rest;

import config.AuthenticationController;
import dto.UserDTO;
import helper.BaseApi;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApiLoginTests extends AuthenticationController implements BaseApi {

    @Test
    public void LoginPositiveTest(){
        UserDTO user = UserDTO.builder()
                .username("0bagginsbob@mail.com")
                .password("Qwerty123!")
                .build();

        Response response = requestRegLogin(user, LOGIN);
        System.out.println(response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void LoginNegativeTest_wrongEmail(){
        UserDTO user = UserDTO.builder()
                .username("0bagginsbob@mail")
                .password("Qwerty123!")
                .build();

        Response response = requestRegLogin(user, LOGIN);
        System.out.println(response.getStatusCode());

    }
    @Test
    public void loginNegativeTest_wrongPassword(){
        UserDTO user = UserDTO.builder()
                .username("0bagginsbob@mail.com")
                .password("WrongPass123!")
                .build();

        Response response = requestRegLogin(user, LOGIN);

        Assert.assertNotEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getStatusCode(), 401);
    }
    @Test
    public void loginNegativeTest_emptyFields(){
        UserDTO user = UserDTO.builder()
                .username("")
                .password("")
                .build();

        Response response = requestRegLogin(user, LOGIN);

        Assert.assertNotEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getStatusCode(), 401);
    }
    @Test
    public void loginNegativeTest_unregisteredUser(){
        UserDTO user = UserDTO.builder()
                .username("nonexistent@mail.com")
                .password("SomePass123!")
                .build();

        Response response = requestRegLogin(user, LOGIN);

        Assert.assertNotEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getStatusCode(), 401);
    }
}

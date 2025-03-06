package apiModules;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class ApiTests {

    // Teste para verificar a resposta da API quando uma requisição GET é feita para um user que não existe
    @Test
    public void validarUsuarioInexistente() {
        Response response = RestAssured.get("https://reqres.in/api/users/0");
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 404);
    }

    // Teste para verificar a resposta da API quando uma requisição GET é feita para um user existe
    @Test
    public void validarRetornoUsuario() {
        Response response = RestAssured.get("https://reqres.in/api/users/11");
        int statusCode = response.getStatusCode();

        Assert.assertEquals(statusCode, 200);
    }
}

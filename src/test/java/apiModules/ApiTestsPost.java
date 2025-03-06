package apiModules;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ApiTestsPost {

    // Teste para verificar a resposta da API quando um usuário realiza o login
    @Test
    public void validarLogin() {

        Map<String, Object> map = new HashMap<String,Object>();

        JSONObject request = new JSONObject(map);

        map.put("email","eve.holt@reqres.in");
        map.put("password","pistol");

        baseURI = "https://reqres.in/api";
        given().
          header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                body(request.toJSONString()).
          when().
                post("/login").
                then().
                statusCode(200).
                log().all();
    }

    // Teste para verificar a resposta da API quando um usuário realiza um login invalido
    @Test
    public void loginInvalido() {
        Map<String, Object> map = new HashMap<String,Object>();

        JSONObject request = new JSONObject(map);

        map.put("email","peter@klaven");

        baseURI = "https://reqres.in/api";
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("/login").
                then().
                statusCode(400).
                log().all();
    }

    // Teste para verificar a resposta da API quando se tenta deletar um usuário
    @Test
    public void deletarUsuario () {
        Map<String, Object> map = new HashMap<String,Object>();

        JSONObject request = new JSONObject(map);


        baseURI = "https://reqres.in/api";
        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                body(request.toJSONString()).
                when().
                delete("/users/9").
                then().
                statusCode(204).
                log().all();
    }
}
